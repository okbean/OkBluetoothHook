package okble.bluetooth_hook.demo;

import android.app.Application;

import okble.bluetooth_hook.OkBluetoothHook;

public class OkBluetoothHookDemoApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        OkBluetoothHook.inject(this);
    }

}
