package com.nyrds.pixeldungeon.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class EntityIdSource {
    private static AtomicInteger lastUsedId = new AtomicInteger(1);
    public static final int INVALID_ID = -1;

    public static int getNextId() {
        return lastUsedId.getAndIncrement();
    }

    public static synchronized void setLastUsedId(int id) {
        lastUsedId.set(id);
    }
}
