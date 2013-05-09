Merlin
======

####*"An ok name for a library"*


Merlin aims to simplify network monitoring by providing 3 registerable callbacks. 
`onConnect()` , `onDisconnect()` and `onMerlinBind(NetworkStatus networkStatus)`.


##Usecases##

####`onConnect()`####

**When** the network state changes from disconnected to connected and a successful host ping has completed.

**Because** you have just aquired a valid network connection, time to update stale data!

####`onDisconnect()`####

**When** the network state changes from connected to disconnected.

**Because** you probably want to tell the user he's now offline! or disable certain functionality until connectivity is available again.

####`onMerlinBind(NetworkStatus networkStatus)`####

**When** the MerlinService has binded, the current NetworkStatus is provided, although this is without pinging a host. 

**Because** you may need to know the current state of the network before a network change occurs. 


##Setup

You'll need to add a few things to your manifest :

These permissions (if you don't already have them)

    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

this service

    <service android:exported="false" android:name="com.novoda.merlin.service.MerlinService" />

and this receiver

    <receiver android:name="com.novoda.merlin.receiver.ConnectivityReceiver">
      <intent-filter>
        <action android:name="android.net.conn.CONNECTIVITY_CHANGE" />
      </intent-filter>
    </receiver>

##Simple usage

Create Merlin (using Merlin.Builder())

    merlin = new Merlin.Builder().withConnectableCallbacks().build(context);

Bind and unbind the service in your activity

    @Override
    protected void onResume() {
        super.onResume();
        merlin.bind();
    }

    @Override
    protected void onPause() {
        super.onPause();
        merlin.unbind();
    }

Register for callbacks

    merlin.registerConnectable(new Connectable() {
            @Override
            public void onConnect() {
                // Do something!
            }
    });
    
The [MerlinActivity](https://github.com/novoda/merlin/blob/master/demo/src/com/novoda/demo/presentation/base/MerlinActivity.java) within the demo shows a simple way to declutter Merlin from your main application code.    