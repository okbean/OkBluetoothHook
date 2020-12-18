package okble.bluetooth_hook;

import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * author: okbean
 * date:   On 2020/10/01
 * email: okbean020@163.com
 * description: 该类主要用来拦截IBluetoothManager里的queryLocalInterface函数，
 * 把返回结果替换成android.bluetooth.IBluetoothManager$Stub的代理类（使用动态代理方式）
 */
public final class BluetoothBinderHook implements InvocationHandler {

    private final static String TAG = BluetoothBinderHook.class.getSimpleName();

    private final IBinder mTarget;

    public BluetoothBinderHook(final IBinder target){
        this.mTarget = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        final String methodName = method.getName();
        Log.i(TAG, "invoke method:" + methodName);
        if ("queryLocalInterface".equals(method.getName())) {
            final Object obj = hookQueryLocalInterface();
            if(obj != null){
                return obj;
            }
        }
        return method.invoke(mTarget, args);
    }

    private Object hookQueryLocalInterface() {
        Object val = null;
        try{
            final String className = "android.bluetooth.IBluetoothManager";
            final Class<?> clazz = ReflectUtils.getClass(className);
            final Object obj = ReflectUtils.invokeMethod(
                    null,
                    "android.bluetooth.IBluetoothManager$Stub",
                    "asInterface",
                    new Class<?>[]{IBinder.class},
                    new Object[]{mTarget} );
            final Class<?>[] interfaces = new Class<?>[]{IBinder.class, IInterface.class, clazz};
            final ClassLoader loader = mTarget.getClass().getClassLoader();
            final InvocationHandler handler = new BluetoothManagerServiceHook(obj);
            val = Proxy.newProxyInstance(loader,interfaces, handler);
        }catch (Exception e){
            e.printStackTrace();
        }
        return val;
    }

}
