package com.example.andrea.prova.RPCParser;

/**
 * Created by utente1 on 18/11/2014.
 */
public class RPCValueString extends RPCValue {
    public static final String SUB_TAG_NAME = "string";
    //public static final String TAG_NAME = "value";

    public RPCValueString(String stringValue) { super(stringValue); }

    public String getStringValue() {
        return (String)super.getValue();
    }

    @Override
    public RPCTypeEnum GetType() {
        return RPCTypeEnum.VALUE_STRING;
    }
}
