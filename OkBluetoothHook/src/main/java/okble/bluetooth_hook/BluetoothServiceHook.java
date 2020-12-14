package okble.bluetooth_hook;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * author: okbean
 * date:   On 2020/10/01
 * email: okbean020@163.com
 * description:IBluetoothGatt服务代理类
 */
public final class BluetoothServiceHook implements InvocationHandler {

    private final static String TAG = BluetoothServiceHook.class.getSimpleName();

    private final Object mTarget;

    public BluetoothServiceHook(final Object target){
        this.mTarget = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        final String methodName = method.getName();
        Log.i(TAG, "invoke method:" + methodName);
        return method.invoke(mTarget, args);
    }

}