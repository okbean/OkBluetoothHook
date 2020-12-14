package okble.bluetooth_hook;

import android.app.Application;
import android.os.Build;
import android.os.IBinder;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;


/**
 * author: okbean
 * date:   On 2020/10/01
 * email: okbean020@163.com
 * description: 该类主要提供模块注册入口，以及通过反射调用把系统缓存的
 * IBluetoothManager服务替换成IBluetoothManager服务代理(使用动态代理方式)。
 * 注册后可以无侵入原代码的方式来观察APP的所有关于蓝牙操作（目前主要是BLE），比如发送数据和接收数据
 */
public final class OkBluetoothHook {

    private static boolean sInjected = false;

    public static boolean inject(final Application app){
        if(!sInjected){
            sInjected = inject0();
        }

        if(!sSupportHiddenApi && Build.VERSION.SDK_INT >= 28){
            sSupportHiddenApi = makeSupportHiddenApi();
        }
        return sInjected;
    }


    public static boolean isInjected(){
        return sInjected;
    }

    private static boolean inject0(){
        try{
            final IBinder binder = getService();
            final Map<String, IBinder> cache = getServiceCache();
            final IBinder proxy = (IBinder) Proxy.newProxyInstance(binder.getClass().getClassLoader(),
                    new Class<?>[]{IBinder.class},
                    new BluetoothBinderHook(binder));
            //替换cache里的IBluetoothManager服务
            cache.put("bluetooth_manager", proxy);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }



    private static boolean sSupportHiddenApi = false;
    public static boolean supportHiddenApi(){
        return sSupportHiddenApi;
    }


    /**
     * SDK VERSION 大于28时需要通过反射调用让系统允许调用某些隐藏的(hide)API
     * @return
     */
    private static boolean makeSupportHiddenApi(){
        try {
            final Method forNameMethod = Class.class.getDeclaredMethod("forName", String.class);
            final Method getDeclaredMethodMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            final Class<?> vmRuntimeClass = (Class<?>) forNameMethod.invoke(null, "dalvik.system.VMRuntime");
            final Method getRuntimeMethod = (Method) getDeclaredMethodMethod.invoke(vmRuntimeClass, "getRuntime", null);
            final Method setHiddenApiExemptionsMethod = (Method) getDeclaredMethodMethod.invoke(vmRuntimeClass, "setHiddenApiExemptions", new Class[]{String[].class});
            final Object vmRuntimeObj = getRuntimeMethod.invoke(null);
            setHiddenApiExemptionsMethod.invoke(vmRuntimeObj, new Object[]{new String[]{"L"}});
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    private static Map<String, IBinder> getServiceCache(){
        Map<String, IBinder> val = null;
        try {
            final Object obj = ReflectUtils.getFieldValue(null,
                    "android.os.ServiceManager",
                    "sCache");
            if(obj != null){
                if(!(obj instanceof  Map)){
                    throw new IllegalStateException("sCache not a instance of Map!");
                }
                val = (Map<String, IBinder>)obj ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }


    private static IBinder getService(){
        IBinder val = null;
        try {
            final Object obj = ReflectUtils.invokeMethod(null,
                    "android.os.ServiceManager",
                    "getService",
                    new Class<?>[]{String.class},
                    new Object[]{"bluetooth_manager"} );
            val = (IBinder) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }

    private OkBluetoothHook(){throw new IllegalStateException();}
}