# OkBluetoothHook
OkBluetoothHook
通过注入蓝牙相关服务，拦截APP所有关于蓝牙的操作（目前主要是BLE相关操作），比如gatt连接，发现服务，发送数据，接收数据，设置mtu大小等等。

整个注入过程不需要修改原APP的代码(即无侵入式)，仅需要在Application::onCreate方法里调用OkBluetoothHook::inject即可完成对蓝牙服务的注入。



本库涉及到几个知识点：
1/android aidl和binder机制

2/反射调用，android 9.0及更高版本突破对hide api调用的限制

3/代理模式，java动态代理和静态代理实现代码拦截

4/蓝牙相关的AIDL服务，比如IBluetoothManager， IBluetooth，IBluetoothGatt，IBluetoothGattCallback等