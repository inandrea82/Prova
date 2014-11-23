package com.example.andrea.prova.RPCParser;

/**
 * Created by utente1 on 18/11/2014.
 */
public class RPCValue implements RPCObject {
    public static final String TAG_NAME = "value";

    private Object object;

    public RPCValue(Object object) {
        this.object = object;
    }

    public Object getValue() {
        return object;
    }

    @Override
    public RPCTypeEnum GetType() {
        return RPCTypeEnum.VALUE;
    }

    @Override
    public String toString() {
        return object.toString();
    }
}
