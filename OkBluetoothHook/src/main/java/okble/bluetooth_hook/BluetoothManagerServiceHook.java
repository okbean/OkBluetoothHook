package okble.bluetooth_hook;

import android.bluetooth.IBluetoothManagerCallback;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static okble.bluetooth_hook.OkBluetoothHook.supportHiddenApi;

/**
 * author: okbean
 * date:   On 2020/10/01
 * email: okbean020@163.com
 * description:android.bluetooth.IBluetoothManager$Stub 代理类，
 * 拦截getBluetoothGatt方法，返回IBluetoothGatt服务的代理类（动态代理），
 * 拦截registerAdapter方法，返回IBluetooth服务的代理类（动态代理），以及在拦截registerAdapter方法的
 * 同时，拦截BluetoothManagerCallback服务（静态代理）
 */
public final class BluetoothManagerServiceHook implements InvocationHandler {

    private final static String TAG = BluetoothManagerServiceHook.class.getSimpleName();

    private final Object mTarget;
    public BluetoothManagerServiceHook(final Object target){
        this.mTarget = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        final String methodName = method.getName();
        Log.i(TAG, "invoke method:" + methodName);
        if ("getBluetoothGatt".equals(methodName)) {
            final Object obj = method.invoke(mTarget, args);
            final Object newObj = hookGetBluetoothGatt(obj);
            if(newObj != null){
                return newObj;
            }else{
                return obj;
            }
        }else if("registerAdapter".equals(methodName)){
            Object[] newArgs = args;
            if(Build.VERSION.SDK_INT  < 28 || supportHiddenApi()){
                final Object argObj = args != null && args.length == 1 ? args[0] : null;
                final Object newArgObj = hookBluetoothManagerCallback(argObj);
                if(newArgObj != null){
                    newArgs = new Object[1];
                    newArgs[0] = newArgObj;
                }
            }
            final Object obj = method.invoke(mTarget, newArgs);
            final Object newObj = hookRegisterAdapter(obj);
            if(newObj != null){
                return newObj;
            }else{
                return obj;
            }
        }
        return method.invoke(mTarget, args);
    }


    private Object hookBluetoothManagerCallback(final Object obj){
        Object val = null;
        try{
            if(obj != null && obj instanceof IBluetoothManagerCallback.Stub){
                val = new BluetoothManagerCallbackHook((IBluetoothManagerCallback)(obj));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return val;
    }


    private Object hookRegisterAdapter(Object obj){
        Object val = null;
        try{
            final String className = "android.bluetooth.IBluetooth";
            final Class<?> clazz = ReflectUtils.getClass(className);
            final Class<?>[] interfaces = new Class<?>[]{IBinder.class, IInterface.class, clazz};
            final ClassLoader loader = mTarget.getClass().getClassLoader();
            final InvocationHandler handler = new BluetoothServiceHook(obj);
            val = Proxy.newProxyInstance(loader,interfaces, handler);
        }catch (Exception e){
            e.printStackTrace();
        }
        return val;
    }


    private Object hookGetBluetoothGatt(Object obj){
        Object val = null;
        try{
            final String className = "android.bluetooth.IBluetoothGatt";
            final Class<?> clazz = ReflectUtils.getClass(className);
            final Class<?>[] interfaces = new Class<?>[]{IBinder.class, IInterface.class, clazz};
            final ClassLoader loader = mTarget.getClass().getClassLoader();
            final InvocationHandler handler = new BluetoothGattServiceHook(obj);
            val = Proxy.newProxyInstance(loader,interfaces, handler);
        }catch (Exception e){
            e.printStackTrace();
        }
        return val;
    }

}