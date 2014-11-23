package com.example.andrea.prova.RPCParser;

/**
 * Created by utente1 on 18/11/2014.
 */
public interface RPCObject {
    public enum RPCTypeEnum {
        MEMBER,
        VALUE,
        VALUE_INT,
        VALUE_STRING,
        VALUE_BOOLEAN,
        ARRAY,
        STRUCT,
        FAULT
    }

    public RPCTypeEnum GetType();
}
