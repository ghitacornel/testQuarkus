package org.example;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DummyBadApplicationScoped {

    public String invoke() {
        return "badApplicationScoped";
    }

}
