package okble.bluetooth_hook;

import android.bluetooth.IBluetoothGattCallback;
import android.os.Build;
import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static okble.bluetooth_hook.OkBluetoothHook.supportHiddenApi;

/**
 * author: okbean
 * date:   On 2020/10/01
 * email: okbean020@163.com
 * description:IBluetoothGatt服务代理类，拦截BluetoothGatt的一些操作，比如读写特征值，读写描述符，设置MTU等
 */
public final class BluetoothGattServiceHook implements InvocationHandler {

    private final static String TAG = BluetoothGattServiceHook.class.getSimpleName();

    private final Object mTarget;
    public BluetoothGattServiceHook(final Object target){
        this.mTarget = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        final String methodName = method.getName();
        Log.i(TAG, "invoke method:" + methodName);
        if("registerClient".equals(method.getName())){
            if(Build.VERSION.SDK_INT  < 28 || supportHiddenApi()){
                final Object obj = args[1];
                final Object newObj  = hookRegisterClient(obj);
                if(newObj != null){
                    final Object[] newArgs = new Object[2];
                    newArgs[0] = args[0];
                    newArgs[1] = newObj;
                    return method.invoke(mTarget, newArgs);
                }
            }
        }else if("writeDescriptor".equals(method.getName())){
            for(Object obj : args){
                if(obj instanceof byte[]){
                    Log.i(TAG, "writeDescriptor data:(0x)" + Hex.toString((byte[])obj, '-'));
                    break;
                }
            }
        }else if("writeCharacteristic".equals(method.getName())){
            for(Object obj : args){
                if(obj instanceof byte[]){
                    Log.i(TAG, "writeCharacteristic data:(0x)" + Hex.toString((byte[])obj, '-'));
                    break;
                }
            }
        }
        return method.invoke(mTarget, args);
    }



    private Object hookRegisterClient(Object obj){
        Object val = null;
        try{
            if(obj != null && obj instanceof IBluetoothGattCallback.Stub){
                val = new BluetoothGattCallbackHook((IBluetoothGattCallback)(obj));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return val;
    }



//    private Object hookRegisterClient(Object bluetoothGattCallbackObj){
//        Object val = null;
//        try{
//            final String clazzName = "android.bluetooth.IBluetoothGattCallback";
//            final Class<?> clazz = ReflectUtils.getClass(clazzName);
//            final Class<?>[] interfaces = new Class<?>[]{IBinder.class, IInterface.class, clazz};
//            final ClassLoader loader = mTarget.getClass().getClassLoader();
//            final InvocationHandler handler = new BluetoothGattCallbackHookOld(bluetoothGattCallbackObj);
//            val = Proxy.newProxyInstance(loader,interfaces, handler);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return val;
//    }



}
