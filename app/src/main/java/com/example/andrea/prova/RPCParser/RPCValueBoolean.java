package com.example.andrea.prova.RPCParser;

/**
 * Created by utente1 on 18/11/2014.
 */
public class RPCValueBoolean  extends RPCValue {
    public static final String SUB_TAG_NAME = "boolean";
    public static final String TAG_NAME = "value";

    public RPCValueBoolean(Boolean boolValue) {
        super(boolValue);
    }

    public boolean getBoolValue() {
        return (Boolean)super.getValue();
    }

    @Override
    public RPCTypeEnum GetType() {
        return RPCTypeEnum.VALUE_BOOLEAN;
    }
}
