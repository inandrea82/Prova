package com.example.andrea.prova.RPCParser;

import java.util.List;

/**
 * Created by utente1 on 17/11/2014.
 */
public class RPCStruct implements RPCObject {
    private List<RPCMember> members;
    public static final String TAG_NAME = "struct";

    public RPCStruct(List<RPCMember> members) {
        this.members = members;
    }

    public List<RPCMember> getMembers() {
        return members;
    }

    @Override
    public RPCTypeEnum GetType() {
        return RPCTypeEnum.STRUCT;
    }

}
