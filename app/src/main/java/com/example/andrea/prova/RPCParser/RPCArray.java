package com.example.andrea.prova.RPCParser;

import java.util.List;

/**
 * Created by utente1 on 17/11/2014.
 */
public class RPCArray implements RPCObject {
    List<RPCValue> values;
    public static final String TAG_NAME = "array";

    public RPCArray(List<RPCValue> values) {
        this.values = values;
    }

    public List<RPCValue> getValues() {
        return values;
    }

    @Override
    public RPCTypeEnum GetType() {
        return RPCTypeEnum.ARRAY;
    }
}
