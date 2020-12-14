package android.bluetooth;

import android.os.ParcelUuid;

public interface IBluetoothGattCallback extends android.os.IInterface {
    public void onClientRegistered(int status, int clientIf) throws android.os.RemoteException;

    public void onClientConnectionState(int status, int clientIf, boolean connected, String address) throws android.os.RemoteException;

    public void onPhyUpdate(String address, int txPhy, int rxPhy, int status) throws android.os.RemoteException;

    public void onPhyRead(String address, int txPhy, int rxPhy, int status) throws android.os.RemoteException;

    public void onSearchComplete(String address, java.util.List<BluetoothGattService> services, int status) throws android.os.RemoteException;

    public void onCharacteristicRead(String address, int status, int handle, byte[] value) throws android.os.RemoteException;

    public void onCharacteristicWrite(String address, int status, int handle) throws android.os.RemoteException;

    public void onExecuteWrite(String address, int status) throws android.os.RemoteException;

    public void onDescriptorRead(String address, int status, int handle, byte[] value) throws android.os.RemoteException;

    public void onDescriptorWrite(String address, int status, int handle) throws android.os.RemoteException;

    public void onNotify(String address, int handle, byte[] value) throws android.os.RemoteException;

    public void onReadRemoteRssi(String address, int rssi, int status) throws android.os.RemoteException;

    public void onConfigureMTU(String address, int mtu, int status) throws android.os.RemoteException;

    public void onConnectionUpdated(String address, int interval, int latency, int timeout, int status) throws android.os.RemoteException;

    public void onScanResult(android.bluetooth.le.ScanResult scanResult) throws android.os.RemoteException;

    public void onBatchScanResults(java.util.List<android.bluetooth.le.ScanResult> batchResults) throws android.os.RemoteException;

    public void onMultiAdvertiseCallback(int status, boolean isStart, android.bluetooth.le.AdvertiseSettings advertiseSettings) throws android.os.RemoteException;

    public void onScanManagerErrorCallback(int errorCode) throws android.os.RemoteException;

    public void onFoundOrLost(boolean onFound, android.bluetooth.le.ScanResult scanResult) throws android.os.RemoteException;

    public void onGetService(String address, int srvcType, int srvcInstId, ParcelUuid srvcUuid) throws android.os.RemoteException;

    public void onGetIncludedService(String address, int srvcType, int srvcInstId, ParcelUuid srvcUuid, int inclSrvcType, int inclSrvcInstId, ParcelUuid inclSrvcUuid) throws android.os.RemoteException;

    public void onGetCharacteristic(String address, int srvcType, int srvcInstId, ParcelUuid srvcUuid, int charInstId, ParcelUuid charUuid, int charProps) throws android.os.RemoteException;

    public void onGetDescriptor(String address, int srvcType, int srvcInstId, ParcelUuid srvcUuid, int charInstId, ParcelUuid charUuid, int descrInstId, ParcelUuid descrUuid) throws android.os.RemoteException;

    public void onSearchComplete(String address, int status) throws android.os.RemoteException;

    public void onCharacteristicRead(String address, int status, int srvcType, int srvcInstId, ParcelUuid srvcUuid, int charInstId, ParcelUuid charUuid, byte[] value) throws android.os.RemoteException;

    public void onCharacteristicWrite(String address, int status, int srvcType, int srvcInstId, ParcelUuid srvcUuid, int charInstId, ParcelUuid charUuid) throws android.os.RemoteException;

    public void onDescriptorRead(String address, int status, int srvcType, int srvcInstId, ParcelUuid srvcUuid, int charInstId, ParcelUuid charUuid, int descrInstId, ParcelUuid descrUuid, byte[] value) throws android.os.RemoteException;

    public void onDescriptorWrite(String address, int status, int srvcType, int srvcInstId, ParcelUuid srvcUuid, int charInstId, ParcelUuid charUuid, int descrInstId, ParcelUuid descrUuid) throws android.os.RemoteException;

    public void onNotify(String address, int srvcType, int srvcInstId, ParcelUuid srvcUuid, int charInstId, ParcelUuid charUuid, byte[] value) throws android.os.RemoteException;

    public void onClientConnParamsChanged(String address, int interval, int status) throws android.os.RemoteException;

    /**
     *╭∩╮( －_－ )╭∩╮
     *
     *╭∩╮( －_－ )╭∩╮
     * /
    /**
     * Local-side IPC implementation stub class.
     *
     */
    public static abstract class Stub extends android.os.Binder implements IBluetoothGattCallback {
        static final int TRANSACTION_onClientRegistered = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_onClientConnectionState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
        static final int TRANSACTION_onPhyUpdate = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
        static final int TRANSACTION_onPhyRead = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
        static final int TRANSACTION_onSearchComplete = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
        static final int TRANSACTION_onCharacteristicRead = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
        static final int TRANSACTION_onCharacteristicWrite = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
        static final int TRANSACTION_onExecuteWrite = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
        static final int TRANSACTION_onDescriptorRead = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
        static final int TRANSACTION_onDescriptorWrite = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
        static final int TRANSACTION_onNotify = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
        static final int TRANSACTION_onReadRemoteRssi = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
        static final int TRANSACTION_onConfigureMTU = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
        static final int TRANSACTION_onConnectionUpdated = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
        static final int TRANSACTION_onScanResult = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
        static final int TRANSACTION_onBatchScanResults = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
        static final int TRANSACTION_onMultiAdvertiseCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
        static final int TRANSACTION_onScanManagerErrorCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
        static final int TRANSACTION_onFoundOrLost = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
        private static final String DESCRIPTOR = "android.bluetooth.IBluetoothGattCallback";

        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         *
         * Cast an IBinder object into an android.bluetooth.IBluetoothGattCallback interface,
         * generating a proxy if needed.
         */
        public static IBluetoothGattCallback asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof IBluetoothGattCallback))) {
                return ((IBluetoothGattCallback) iin);
            }
            return new Proxy(obj);
        }

        @Override
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException {
            String descriptor = DESCRIPTOR;
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(descriptor);
                    return true;
                }
                case TRANSACTION_onClientRegistered: {
                    data.enforceInterface(descriptor);
                    int _arg0;
                    _arg0 = data.readInt();
                    int _arg1;
                    _arg1 = data.readInt();
                    this.onClientRegistered(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_onClientConnectionState: {
                    data.enforceInterface(descriptor);
                    int _arg0;
                    _arg0 = data.readInt();
                    int _arg1;
                    _arg1 = data.readInt();
                    boolean _arg2;
                    _arg2 = (0 != data.readInt());
                    String _arg3;
                    _arg3 = data.readString();
                    this.onClientConnectionState(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_onPhyUpdate: {
                    data.enforceInterface(descriptor);
                    String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    int _arg2;
                    _arg2 = data.readInt();
                    int _arg3;
                    _arg3 = data.readInt();
                    this.onPhyUpdate(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_onPhyRead: {
                    data.enforceInterface(descriptor);
                    String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    int _arg2;
                    _arg2 = data.readInt();
                    int _arg3;
                    _arg3 = data.readInt();
                    this.onPhyRead(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_onSearchComplete: {
                    data.enforceInterface(descriptor);
                    String _arg0;
                    _arg0 = data.readString();
                    java.util.List<BluetoothGattService> _arg1;
                    _arg1 = data.createTypedArrayList(null);
                    int _arg2;
                    _arg2 = data.readInt();
                    this.onSearchComplete(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_onCharacteristicRead: {
                    data.enforceInterface(descriptor);
                    String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    int _arg2;
                    _arg2 = data.readInt();
                    byte[] _arg3;
                    _arg3 = data.createByteArray();
                    this.onCharacteristicRead(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_onCharacteristicWrite: {
                    data.enforceInterface(descriptor);
                    String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    int _arg2;
                    _arg2 = data.readInt();
                    this.onCharacteristicWrite(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_onExecuteWrite: {
                    data.enforceInterface(descriptor);
                    String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    this.onExecuteWrite(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_onDescriptorRead: {
                    data.enforceInterface(descriptor);
                    String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    int _arg2;
                    _arg2 = data.readInt();
                    byte[] _arg3;
                    _arg3 = data.createByteArray();
                    this.onDescriptorRead(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_onDescriptorWrite: {
                    data.enforceInterface(descriptor);
                    String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    int _arg2;
                    _arg2 = data.readInt();
                    this.onDescriptorWrite(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_onNotify: {
                    data.enforceInterface(descriptor);
                    String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    byte[] _arg2;
                    _arg2 = data.createByteArray();
                    this.onNotify(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_onReadRemoteRssi: {
                    data.enforceInterface(descriptor);
                    String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    int _arg2;
                    _arg2 = data.readInt();
                    this.onReadRemoteRssi(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_onConfigureMTU: {
                    data.enforceInterface(descriptor);
                    String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    int _arg2;
                    _arg2 = data.readInt();
                    this.onConfigureMTU(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_onConnectionUpdated: {
                    data.enforceInterface(descriptor);
                    String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    int _arg2;
                    _arg2 = data.readInt();
                    int _arg3;
                    _arg3 = data.readInt();
                    int _arg4;
                    _arg4 = data.readInt();
                    this.onConnectionUpdated(_arg0, _arg1, _arg2, _arg3, _arg4);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_onScanResult: {
                    data.enforceInterface(descriptor);
                    android.bluetooth.le.ScanResult _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = android.bluetooth.le.ScanResult.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    this.onScanResult(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_onBatchScanResults: {
                    data.enforceInterface(descriptor);
                    java.util.List<android.bluetooth.le.ScanResult> _arg0;
                    _arg0 = data.createTypedArrayList(android.bluetooth.le.ScanResult.CREATOR);
                    this.onBatchScanResults(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_onMultiAdvertiseCallback: {
                    data.enforceInterface(descriptor);
                    int _arg0;
                    _arg0 = data.readInt();
                    boolean _arg1;
                    _arg1 = (0 != data.readInt());
                    android.bluetooth.le.AdvertiseSettings _arg2;
                    if ((0 != data.readInt())) {
                        _arg2 = android.bluetooth.le.AdvertiseSettings.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    this.onMultiAdvertiseCallback(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_onScanManagerErrorCallback: {
                    data.enforceInterface(descriptor);
                    int _arg0;
                    _arg0 = data.readInt();
                    this.onScanManagerErrorCallback(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_onFoundOrLost: {
                    data.enforceInterface(descriptor);
                    boolean _arg0;
                    _arg0 = (0 != data.readInt());
                    android.bluetooth.le.ScanResult _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.bluetooth.le.ScanResult.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    this.onFoundOrLost(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }

        private static class Proxy implements IBluetoothGattCallback {
            private android.os.IBinder mRemote;

            Proxy(android.os.IBinder remote) {
                mRemote = remote;
            }

            @Override
            public android.os.IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            @Override
            public void onClientRegistered(int status, int clientIf) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(status);
                    _data.writeInt(clientIf);
                    mRemote.transact(Stub.TRANSACTION_onClientRegistered, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void onClientConnectionState(int status, int clientIf, boolean connected, String address) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(status);
                    _data.writeInt(clientIf);
                    _data.writeInt(((connected) ? (1) : (0)));
                    _data.writeString(address);
                    mRemote.transact(Stub.TRANSACTION_onClientConnectionState, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void onPhyUpdate(String address, int txPhy, int rxPhy, int status) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(address);
                    _data.writeInt(txPhy);
                    _data.writeInt(rxPhy);
                    _data.writeInt(status);
                    mRemote.transact(Stub.TRANSACTION_onPhyUpdate, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void onPhyRead(String address, int txPhy, int rxPhy, int status) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(address);
                    _data.writeInt(txPhy);
                    _data.writeInt(rxPhy);
                    _data.writeInt(status);
                    mRemote.transact(Stub.TRANSACTION_onPhyRead, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void onSearchComplete(String address, java.util.List<BluetoothGattService> services, int status) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(address);
                    _data.writeTypedList(services);
                    _data.writeInt(status);
                    mRemote.transact(Stub.TRANSACTION_onSearchComplete, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void onCharacteristicRead(String address, int status, int handle, byte[] value) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(address);
                    _data.writeInt(status);
                    _data.writeInt(handle);
                    _data.writeByteArray(value);
                    mRemote.transact(Stub.TRANSACTION_onCharacteristicRead, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void onCharacteristicWrite(String address, int status, int handle) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(address);
                    _data.writeInt(status);
                    _data.writeInt(handle);
                    mRemote.transact(Stub.TRANSACTION_onCharacteristicWrite, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void onExecuteWrite(String address, int status) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(address);
                    _data.writeInt(status);
                    mRemote.transact(Stub.TRANSACTION_onExecuteWrite, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void onDescriptorRead(String address, int status, int handle, byte[] value) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(address);
                    _data.writeInt(status);
                    _data.writeInt(handle);
                    _data.writeByteArray(value);
                    mRemote.transact(Stub.TRANSACTION_onDescriptorRead, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void onDescriptorWrite(String address, int status, int handle) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(address);
                    _data.writeInt(status);
                    _data.writeInt(handle);
                    mRemote.transact(Stub.TRANSACTION_onDescriptorWrite, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void onNotify(String address, int handle, byte[] value) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(address);
                    _data.writeInt(handle);
                    _data.writeByteArray(value);
                    mRemote.transact(Stub.TRANSACTION_onNotify, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void onReadRemoteRssi(String address, int rssi, int status) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(address);
                    _data.writeInt(rssi);
                    _data.writeInt(status);
                    mRemote.transact(Stub.TRANSACTION_onReadRemoteRssi, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void onConfigureMTU(String address, int mtu, int status) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(address);
                    _data.writeInt(mtu);
                    _data.writeInt(status);
                    mRemote.transact(Stub.TRANSACTION_onConfigureMTU, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void onConnectionUpdated(String address, int interval, int latency, int timeout, int status) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(address);
                    _data.writeInt(interval);
                    _data.writeInt(latency);
                    _data.writeInt(timeout);
                    _data.writeInt(status);
                    mRemote.transact(Stub.TRANSACTION_onConnectionUpdated, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void onScanResult(android.bluetooth.le.ScanResult scanResult) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((scanResult != null)) {
                        _data.writeInt(1);
                        scanResult.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_onScanResult, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void onBatchScanResults(java.util.List<android.bluetooth.le.ScanResult> batchResults) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeTypedList(batchResults);
                    mRemote.transact(Stub.TRANSACTION_onBatchScanResults, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void onMultiAdvertiseCallback(int status, boolean isStart, android.bluetooth.le.AdvertiseSettings advertiseSettings) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(status);
                    _data.writeInt(((isStart) ? (1) : (0)));
                    if ((advertiseSettings != null)) {
                        _data.writeInt(1);
                        advertiseSettings.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_onMultiAdvertiseCallback, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void onScanManagerErrorCallback(int errorCode) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(errorCode);
                    mRemote.transact(Stub.TRANSACTION_onScanManagerErrorCallback, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void onFoundOrLost(boolean onFound, android.bluetooth.le.ScanResult scanResult) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(((onFound) ? (1) : (0)));
                    if ((scanResult != null)) {
                        _data.writeInt(1);
                        scanResult.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_onFoundOrLost, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }



            public void onGetService(String address, int srvcType, int srvcInstId, ParcelUuid srvcUuid) throws android.os.RemoteException {

            }


            public void onGetIncludedService(String address, int srvcType, int srvcInstId, ParcelUuid srvcUuid, int inclSrvcType, int inclSrvcInstId, ParcelUuid inclSrvcUuid) throws android.os.RemoteException {

            }


            public void onGetCharacteristic(String address, int srvcType, int srvcInstId, ParcelUuid srvcUuid, int charInstId, ParcelUuid charUuid, int charProps) throws android.os.RemoteException {

            }


            public void onGetDescriptor(String address, int srvcType, int srvcInstId, ParcelUuid srvcUuid, int charInstId, ParcelUuid charUuid, int descrInstId, ParcelUuid descrUuid) throws android.os.RemoteException {

            }


            public void onSearchComplete(String address, int status) throws android.os.RemoteException {

            }


            public void onCharacteristicRead(String address, int status, int srvcType, int srvcInstId, ParcelUuid srvcUuid, int charInstId, ParcelUuid charUuid, byte[] value) throws android.os.RemoteException {

            }


            public void onCharacteristicWrite(String address, int status, int srvcType, int srvcInstId, ParcelUuid srvcUuid, int charInstId, ParcelUuid charUuid) throws android.os.RemoteException {

            }


            public void onDescriptorRead(String address, int status, int srvcType, int srvcInstId, ParcelUuid srvcUuid, int charInstId, ParcelUuid charUuid, int descrInstId, ParcelUuid descrUuid, byte[] value) throws android.os.RemoteException {

            }


            public void onDescriptorWrite(String address, int status, int srvcType, int srvcInstId, ParcelUuid srvcUuid, int charInstId, ParcelUuid charUuid, int descrInstId, ParcelUuid descrUuid) throws android.os.RemoteException {

            }


            public void onNotify(String address, int srvcType, int srvcInstId, ParcelUuid srvcUuid, int charInstId, ParcelUuid charUuid, byte[] value) throws android.os.RemoteException {

            }


            public void onClientConnParamsChanged(String address, int interval, int status) throws android.os.RemoteException{

            }

        }
    }

}