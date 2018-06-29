package com.novoda.merlin;

import java.util.Iterator;

class DisconnectCallbackManager extends MerlinCallbackManager<Disconnectable> implements Disconnectable {

    DisconnectCallbackManager(Register<Disconnectable> register) {
        super(register);
    }

    @Override
    public void onDisconnect() {
        Logger.d("onDisconnect");
        for (Iterator<Disconnectable> iter = registerables().iterator(); iter.hasNext();) {
            Disconnectable disconnectable = iter.next();
            disconnectable.onDisconnect();
        }
    }
}
