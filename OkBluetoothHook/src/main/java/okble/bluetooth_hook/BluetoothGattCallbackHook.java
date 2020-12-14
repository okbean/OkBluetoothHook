package okble.bluetooth_hook;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.IBluetoothGattCallback;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.ScanResult;
import android.os.ParcelUuid;
import android.util.Log;

import java.util.List;

/**
 * author: okbean
 * date:   On 2020/10/01
 * email: okbean020@163.com
 * description:BluetoothGattCallback服务代理类，该类主要拦截所有BluetoothGatt操作的回调
 */
public final class BluetoothGattCallbackHook extends IBluetoothGattCallback.Stub{

    public final static String TAG = BluetoothGattCallbackHook.class.getSimpleName();

    private final IBluetoothGattCallback mDelegate;

    public BluetoothGattCallbackHook(final IBluetoothGattCallback delegate){
        this.mDelegate = delegate;
    }

    @Override
    public void onClientRegistered(int status, int clientIf)  throws android.os.RemoteException   {
        final String msg = "onClientRegistered. status:%d , clientIf:%d";
        Log.d(TAG, String.format(msg, status, clientIf));
        mDelegate.onClientRegistered(status, clientIf);
    }

    @Override
    public void onClientConnectionState(int status, int clientIf, boolean connected, String address)  throws android.os.RemoteException   {
        final String msg = "onClientConnectionState. status:%d , clientIf:%d , connected:%b , address:%s";
        Log.d(TAG, String.format(msg, status, clientIf, connected, address));
        mDelegate.onClientConnectionState(status,   clientIf,   connected,   address);
    }

    @Override
    public void onPhyUpdate(String address, int txPhy, int rxPhy, int status)  throws android.os.RemoteException   {
        final String msg = "onPhyUpdate. status:%d , txPhy:%d , rxPhy:%d , address:%s";
        Log.d(TAG, String.format(msg, status, txPhy, rxPhy, address));
        mDelegate.onPhyUpdate(address, txPhy, rxPhy, status);
    }

    @Override
    public void onPhyRead(String address, int txPhy, int rxPhy, int status)  throws android.os.RemoteException   {
        final String msg = "onPhyRead. status:%d , txPhy:%d , rxPhy:%d , address:%s";
        Log.d(TAG, String.format(msg, status, txPhy, rxPhy, address));
        mDelegate.onPhyRead(address, txPhy, rxPhy, status);
    }

    @Override
    public void onSearchComplete(String address, List<BluetoothGattService> services, int status)  throws android.os.RemoteException   {
        final String msg = "onSearchComplete. status:%d , address:%s";
        Log.d(TAG, String.format(msg, status, address));
        mDelegate.onSearchComplete(address, services, status);
    }

    @Override
    public void onCharacteristicRead(String address, int status, int handle, byte[] value)  throws android.os.RemoteException   {
        final String msg = "onCharacteristicRead. status:%d , value:(0x)%s , address:%s";
        Log.d(TAG, String.format(msg, status, Hex.toString(value, '-'), address));
        mDelegate.onCharacteristicRead(  address,   status,   handle,   value);
    }

    @Override
    public void onCharacteristicWrite(String address, int status, int handle)  throws android.os.RemoteException   {
        final String msg = "onCharacteristicWrite. status:%d , address:%s";
        Log.d(TAG, String.format(msg, status, address));
        mDelegate.onCharacteristicWrite(address, status, handle);
    }

    @Override
    public void onExecuteWrite(String address, int status)  throws android.os.RemoteException   {
        final String msg = "onExecuteWrite. status:%d, address:%s";
        Log.d(TAG, String.format(msg, status, address));
        mDelegate.onExecuteWrite(  address,   status);
    }

    @Override
    public void onDescriptorRead(String address, int status, int handle, byte[] value)  throws android.os.RemoteException   {
        final String msg = "onDescriptorRead. status:%d , value:(0x)%s , address:%s";
        Log.d(TAG, String.format(msg, status, Hex.toString(value, '-'), address));
        mDelegate.onDescriptorRead(  address,   status,   handle,   value);
    }

    @Override
    public void onDescriptorWrite(String address, int status, int handle)  throws android.os.RemoteException   {
        final String msg = "onDescriptorWrite. status:%d, address:%s";
        Log.d(TAG, String.format(msg, status, address));
        mDelegate.onDescriptorWrite(  address,   status,   handle);
    }

    @Override
    public void onNotify(String address, int handle, byte[] value)  throws android.os.RemoteException   {
        final String msg = "onNotify. value:(0x)%s, address:%s";
        Log.d(TAG, String.format(msg, Hex.toString(value, '-'), address));
        mDelegate.onNotify(address, handle, value);
    }

    @Override
    public void onReadRemoteRssi(String address, int rssi, int status)  throws android.os.RemoteException   {
        final String msg = "onReadRemoteRssi. status:%d , rssi:%d, address:%s";
        Log.d(TAG, String.format(msg, status, rssi, address));
        mDelegate.onReadRemoteRssi(address, rssi, status);
    }

    @Override
    public void onConfigureMTU(String address, int mtu, int status)  throws android.os.RemoteException   {
        final String msg = "onConfigureMTU. status:%d , mtu:%d, address:%s";
        Log.d(TAG, String.format(msg, status, mtu, address));
        mDelegate.onConfigureMTU(address, mtu, status);
    }

    @Override
    public void onConnectionUpdated(String address, int interval, int latency, int timeout, int status)  throws android.os.RemoteException   {
        final String msg = "onConnectionUpdated. status:%d , interval:%d, latency:%d, timeout:%d , address:%s";
        Log.d(TAG, String.format(msg, status, interval, latency, timeout, address));
        mDelegate.onConnectionUpdated(address, interval, latency, timeout, status);
    }



    public void onScanResult(ScanResult scanResult)  throws android.os.RemoteException{
        final String msg = "onScanResult. address:%s , rssi:%d";
        final BluetoothDevice device = scanResult == null ? null : scanResult.getDevice();
        final int rssi = scanResult == null ? Integer.MAX_VALUE : scanResult.getRssi();
        Log.d(TAG, String.format(msg, device, rssi));
        mDelegate.onScanResult(scanResult);
    }



    public void onBatchScanResults(List<ScanResult> batchResults)  throws android.os.RemoteException{
        final String msg = "onBatchScanResults.";
        Log.d(TAG, msg);
        mDelegate.onBatchScanResults(batchResults);
    }


    public void onMultiAdvertiseCallback(int status, boolean isStart, AdvertiseSettings advertiseSettings)  throws android.os.RemoteException{
        final String msg = "onMultiAdvertiseCallback. status:%d";
        Log.d(TAG, String.format(msg, status));
        mDelegate.onMultiAdvertiseCallback(status, isStart, advertiseSettings);
    }


    public void onScanManagerErrorCallback(int errorCode)  throws android.os.RemoteException{
        final String msg = "onScanManagerErrorCallback. errorCode:%d";
        Log.d(TAG, String.format(msg, errorCode));
        mDelegate.onScanManagerErrorCallback(errorCode);
    }


    public void onFoundOrLost(boolean onFound, ScanResult scanResult)  throws android.os.RemoteException{
        final String msg = "onFoundOrLost. onFound:%b , address:%s , rssi:%d";
        final BluetoothDevice device = scanResult == null ? null : scanResult.getDevice();
        final int rssi = scanResult == null ? Integer.MAX_VALUE : scanResult.getRssi();
        Log.d(TAG, String.format(msg, onFound, device, rssi));
        mDelegate.onFoundOrLost(onFound, scanResult);
    }


    public void onGetService(String address, int srvcType, int srvcInstId, ParcelUuid srvcUuid)  throws android.os.RemoteException{
        final String msg = "onGetService. address:%s , uuid:%s";
        Log.d(TAG, String.format(msg, address, srvcUuid));
        mDelegate.onGetService(address, srvcType, srvcInstId, srvcUuid);
    }


    public void onGetIncludedService(String address, int srvcType, int srvcInstId, ParcelUuid srvcUuid, int inclSrvcType, int inclSrvcInstId, ParcelUuid inclSrvcUuid)  throws android.os.RemoteException{
        final String msg = "onGetIncludedService.  address:%s , uuid:%s";
        Log.d(TAG, String.format(msg, address, inclSrvcUuid));
        mDelegate.onGetIncludedService(  address,   srvcType,   srvcInstId,   srvcUuid,   inclSrvcType,   inclSrvcInstId,   inclSrvcUuid);
    }


    public void onGetCharacteristic(String address, int srvcType, int srvcInstId, ParcelUuid srvcUuid, int charInstId, ParcelUuid charUuid, int charProps)  throws android.os.RemoteException{
        final String msg = "onGetCharacteristic. address:%s , uuid:%s";
        Log.d(TAG, String.format(msg, address, charUuid));
        mDelegate.onGetCharacteristic(  address,   srvcType,   srvcInstId,   srvcUuid,   charInstId,   charUuid,   charProps);
    }


    public void onGetDescriptor(String address, int srvcType, int srvcInstId, ParcelUuid srvcUuid, int charInstId, ParcelUuid charUuid, int descrInstId, ParcelUuid descrUuid)  throws android.os.RemoteException{
        final String msg = "onGetDescriptor. address:%s , uuid:%s";
        Log.d(TAG, String.format(msg, address, descrUuid));
        mDelegate.onGetDescriptor(  address,   srvcType,   srvcInstId,   srvcUuid,   charInstId,   charUuid,   descrInstId,   descrUuid);
    }


    public void onSearchComplete(String address, int status)  throws android.os.RemoteException{
        final String msg = "onSearchComplete. status:%d , address:%s";
        Log.d(TAG, String.format(msg, status, address));
        mDelegate.onSearchComplete(address, status);
    }


    public void onCharacteristicRead(String address, int status, int srvcType, int srvcInstId, ParcelUuid srvcUuid, int charInstId, ParcelUuid charUuid, byte[] value)  throws android.os.RemoteException{
        final String msg = "onCharacteristicRead. status:%d , value:(0x)%s";
        Log.d(TAG, String.format(msg, status, Hex.toString(value, '-')));
        mDelegate.onCharacteristicRead(  address,   status,   srvcType,   srvcInstId,   srvcUuid,   charInstId,   charUuid,   value);
    }


    public void onCharacteristicWrite(String address, int status, int srvcType, int srvcInstId, ParcelUuid srvcUuid, int charInstId, ParcelUuid charUuid)  throws android.os.RemoteException{
        final String msg = "onCharacteristicWrite. status:%d";
        Log.d(TAG, String.format(msg, status));
        mDelegate.onCharacteristicWrite(  address,   status,   srvcType,   srvcInstId,   srvcUuid,   charInstId,   charUuid);
    }


    public void onDescriptorRead(String address, int status, int srvcType, int srvcInstId, ParcelUuid srvcUuid, int charInstId, ParcelUuid charUuid, int descrInstId, ParcelUuid descrUuid, byte[] value)  throws android.os.RemoteException{
        final String msg = "onDescriptorRead. status:%d , value:(0x)%s";
        Log.d(TAG, String.format(msg, status, Hex.toString(value, '-')));
        mDelegate.onDescriptorRead(  address,   status,   srvcType,   srvcInstId,   srvcUuid,   charInstId,   charUuid,   descrInstId,   descrUuid,   value);
    }


    public void onDescriptorWrite(String address, int status, int srvcType, int srvcInstId, ParcelUuid srvcUuid, int charInstId, ParcelUuid charUuid, int descrInstId, ParcelUuid descrUuid)  throws android.os.RemoteException{
        final String msg = "onCharacteristicWrite. status:%d";
        Log.d(TAG, String.format(msg, status));
        mDelegate.onDescriptorWrite(  address,   status,   srvcType,   srvcInstId,   srvcUuid,   charInstId,   charUuid,   descrInstId,   descrUuid);
    }


    public void onNotify(String address, int srvcType, int srvcInstId, ParcelUuid srvcUuid, int charInstId, ParcelUuid charUuid, byte[] value)  throws android.os.RemoteException{
        final String msg = "onNotify. value:(0x)%s";
        Log.d(TAG, String.format(msg, Hex.toString(value, '-')));
        mDelegate.onNotify(  address,   srvcType,   srvcInstId,   srvcUuid,   charInstId,   charUuid,   value);
    }


    public void onClientConnParamsChanged(String address, int interval, int status) throws android.os.RemoteException{
        final String msg = "onClientConnParamsChanged. status:%d , interval:%d";
        Log.d(TAG, String.format(msg, status, interval));
        mDelegate.onClientConnParamsChanged(address, interval, status);
    }

}
