package android.bluetooth;
public interface IBluetoothManagerCallback extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements IBluetoothManagerCallback
{
private static final String DESCRIPTOR = "android.bluetooth.IBluetoothManagerCallback";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an android.bluetooth.IBluetoothManagerCallback interface,
 * generating a proxy if needed.
 */
public static IBluetoothManagerCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof IBluetoothManagerCallback))) {
return ((IBluetoothManagerCallback)iin);
}
return new Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
String descriptor = DESCRIPTOR;
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(descriptor);
return true;
}
case TRANSACTION_onBluetoothServiceUp:
{
data.enforceInterface(descriptor);
IBluetooth _arg0;
_arg0 = IBluetooth.Stub.asInterface(data.readStrongBinder());
this.onBluetoothServiceUp(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onBluetoothServiceDown:
{
data.enforceInterface(descriptor);
this.onBluetoothServiceDown();
reply.writeNoException();
return true;
}
case TRANSACTION_onBrEdrDown:
{
data.enforceInterface(descriptor);
this.onBrEdrDown();
reply.writeNoException();
return true;
}
default:
{
return super.onTransact(code, data, reply, flags);
}
}
}
private static class Proxy implements IBluetoothManagerCallback
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void onBluetoothServiceUp(IBluetooth bluetoothService) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((bluetoothService!=null))?(bluetoothService.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_onBluetoothServiceUp, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onBluetoothServiceDown() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onBluetoothServiceDown, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onBrEdrDown() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onBrEdrDown, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_onBluetoothServiceUp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_onBluetoothServiceDown = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_onBrEdrDown = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
}
public void onBluetoothServiceUp(IBluetooth bluetoothService) throws android.os.RemoteException;
public void onBluetoothServiceDown() throws android.os.RemoteException;
public void onBrEdrDown() throws android.os.RemoteException;
}
