package com.example.andrea.prova.RPCParser;

/**
 * Created by utente1 on 18/11/2014.
 */
public class RPCFault implements RPCObject {
    @Override
    public RPCTypeEnum GetType() {
        return RPCTypeEnum.FAULT;
    }

}
