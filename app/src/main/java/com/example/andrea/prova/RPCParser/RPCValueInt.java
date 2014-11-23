package com.example.andrea.prova.RPCParser;

/**
 * Created by utente1 on 18/11/2014.
 */
public class RPCValueInt extends RPCValue {
    public static final String SUB_TAG_NAME = "int";
    //public static final String TAG_NAME = "value";


    public RPCValueInt(Integer intValue) {
        super(intValue);
    }

    public int getIntValue() {
        return (Integer)super.getValue();
    }

    @Override
    public RPCTypeEnum GetType() {
        return RPCTypeEnum.VALUE_INT;
    }
}
