package okble.bluetooth_hook.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import okble.bluetooth_hook.OkBluetoothHook;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OkBluetoothHook.inject(getApplication());
    }
}