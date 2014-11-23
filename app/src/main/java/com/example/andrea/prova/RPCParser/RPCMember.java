package com.example.andrea.prova.RPCParser;

/**
 * Created by utente1 on 17/11/2014.
 */
public class RPCMember implements RPCObject {
    private String name;
    private RPCValue value;
    public static final String TAG_NAME = "member";

    public RPCMember(String name, RPCValue value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public RPCValue getValue() {
        return value;
    }

    @Override
    public RPCTypeEnum GetType() {
        return RPCTypeEnum.MEMBER;
    }

    @Override
    public String toString() {
        return name;
    }
}
