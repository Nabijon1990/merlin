package com.novoda.merlin;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class Register<T extends Registerable> {

    private final CopyOnWriteArrayList<T> registerables;

    Register() {
        registerables = new CopyOnWriteArrayList<>();
    }

    void register(T registerable) {
        if (!registerables.contains(registerable)) {
            registerables.add(registerable);
        }
    }

    List<T> registerables() {
        return registerables;
    }

    void clear() {
        registerables.clear();
    }
}
