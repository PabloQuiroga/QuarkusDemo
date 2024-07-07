package com.pabloquiroga.essentials;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Main {
    public static void main(String[] args) {
        Quarkus.run(FeServer.class, args);
    }

    public static class FeServer implements QuarkusApplication {
        @Override
        public int run(String... args) throws Exception {
            System.out.println("###############");
            System.out.println("# Starting up #");
            System.out.println("###############");
            Quarkus.waitForExit();
            return 0;
        }
    }
}
