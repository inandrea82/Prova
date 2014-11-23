package com.example.andrea.prova.marprotocol.palina;

import com.example.andrea.prova.RPCParser.Parser;
import com.example.andrea.prova.RPCParser.RPCMember;
import com.example.andrea.prova.RPCParser.RPCObject;
import com.example.andrea.prova.marprotocol.response.MARResponse;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created by andrea on 14/11/14.
 */
public abstract class PalinaResponse extends MARResponse {

    private long id_richiesta;

    private PalinaRisposta risposta;

    public long getId_richiesta() {
        return id_richiesta;
    }

    public PalinaRisposta getRisposta() {
        return risposta;
    }

    public PalinaResponse(XmlPullParser xml) {
        super(xml);
    }

    @Override
    protected final void GenerateResponse() {
//        id_richiesta = Long.parseLong(MARResponse.GetStringParameter("id_richiesta", xml), 16);
//        try {
//            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
//            factory.setNamespaceAware(true);
//            XmlPullParser xpp = factory.newPullParser();
//            InputStream is = new ByteArrayInputStream(MARResponse.GetParameterValue("risposta", xml).getBytes());
//            xpp.setInput(is, null);
//            super.xml = xpp;
//        }
//        catch (Exception e) {
//
//        }
        Parser p = new Parser(new Parser.RPCObjectFoundListener<RPCMember>(RPCObject.RPCTypeEnum.MEMBER,"id_richiesta"){


        });
    }

    protected abstract void GenerateOtherResponse();
}
