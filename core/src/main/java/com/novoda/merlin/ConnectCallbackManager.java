package com.novoda.merlin;

import java.util.Iterator;

class ConnectCallbackManager extends MerlinCallbackManager<Connectable> {

    ConnectCallbackManager(Register<Connectable> register) {
        super(register);
    }

    void onConnect() {
        Logger.d("onConnect");
        for (Iterator<Connectable> iter = registerables().iterator(); iter.hasNext();) {
            Connectable connectable = iter.next();
            connectable.onConnect();
        }
    }

}
