package org.example;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DummyApplicationScoped {

    public String invoke() {
        return "applicationScoped";
    }

}
