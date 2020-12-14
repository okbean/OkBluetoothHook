package okble.bluetooth_hook;

import android.bluetooth.IBluetooth;
import android.bluetooth.IBluetoothManagerCallback;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * author: okbean
 * date:   On 2020/10/01
 * email: okbean020@163.com
 * description:BluetoothManagerCallback服务代理类
 */
public class BluetoothManagerCallbackHook extends IBluetoothManagerCallback.Stub{

    public final static String TAG = BluetoothManagerCallbackHook.class.getSimpleName();

    private final IBluetoothManagerCallback mDelegate;

    public BluetoothManagerCallbackHook(final IBluetoothManagerCallback delegate){
        this.mDelegate = delegate;
    }


    @Override
    public void onBluetoothServiceUp(IBluetooth bluetoothService) throws RemoteException {
        final String msg = "onBluetoothServiceUp";
        Log.d(TAG, msg);
        final Object newObj = hookBluetoothService(bluetoothService);
        if(newObj != null && newObj instanceof IBluetooth){
            mDelegate.onBluetoothServiceUp((IBluetooth)newObj);
            return;
        }
        mDelegate.onBluetoothServiceUp(bluetoothService);
    }


    @Override
    public void onBluetoothServiceDown() throws RemoteException {
        final String msg = "onBluetoothServiceDown";
        Log.d(TAG, msg);
        mDelegate.onBluetoothServiceDown();
    }


    @Override
    public void onBrEdrDown() throws RemoteException {
        final String msg = "onBrEdrDown";
        Log.d(TAG, msg);
        mDelegate.onBrEdrDown();
    }


    private static Object hookBluetoothService(Object obj){
        Object val = null;
        try{
            final String className = "android.bluetooth.IBluetooth";
            final Class<?> clazz = ReflectUtils.getClass(className);
            final Class<?>[] interfaces = new Class<?>[]{IBinder.class, IInterface.class, clazz};
            final ClassLoader loader = clazz.getClassLoader();
            final InvocationHandler handler = new BluetoothServiceHook(obj);
            val = Proxy.newProxyInstance(loader,interfaces, handler);
        }catch (Exception e){
            e.printStackTrace();
        }
        return val;
    }


}