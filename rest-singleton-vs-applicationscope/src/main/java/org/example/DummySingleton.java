package org.example;

import jakarta.inject.Singleton;

@Singleton
public class DummySingleton {

    public String invoke() {
        return "singleton";
    }

}
