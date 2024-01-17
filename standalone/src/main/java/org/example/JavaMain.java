package org.example;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import io.quarkus.runtime.Quarkus;

@QuarkusMain
public class JavaMain implements QuarkusApplication {

    public static void main(String... args) {
        Quarkus.run(JavaMain.class, args);
    }

    @Override
    public int run(String... args) throws Exception {
        System.out.println("Running main method");
        return 0;
    }
}