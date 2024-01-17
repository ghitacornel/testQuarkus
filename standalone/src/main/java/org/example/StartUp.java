package org.example;

import io.quarkus.runtime.Startup;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StartUp {

    @Startup
    public void startingUp() {
        System.out.println(this + " component is started");
    }

}
