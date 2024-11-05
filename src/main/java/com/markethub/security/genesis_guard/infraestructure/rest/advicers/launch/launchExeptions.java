package com.markethub.security.genesis_guard.infraestructure.rest.advicers.launch;

import java.util.function.Supplier;

public class launchExeptions {
    public static <T extends Exception> void launchExeption(Supplier<T> supplier) throws T {
        throw supplier.get();
    }
}
