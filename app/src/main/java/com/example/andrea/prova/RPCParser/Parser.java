package com.example.andrea.prova.RPCParser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by utente1 on 17/11/2014.
 */
public class Parser {

    public static abstract class RPCObjectFoundListener<T extends RPCObject> {
        RPCObject.RPCTypeEnum type;
        String name;

        protected RPCObjectFoundListener(RPCObject.RPCTypeEnum type, String name) {
            this.type = type;
            this.name = name;
        }

        abstract void onRPCObjectFound(T t);
    }

    private RPCObjectFoundListener rPCObjectFoundListener;
    //private final static String resp = "<?xml version='1.0'?><methodResponse><params><param><value><struct><member><name>id_richiesta</name><value><string>1a8cbbd3ba83e580d93d5d6395eb006c</string></value></member><member><name>risposta</name><value><struct><member><name>arrivi</name><value><array><data><value><struct><member><name>aria</name><value><int>1</int></value></member><member><name>disabilitata</name><value><boolean>0</boolean></value></member><member><name>tempo_attesa</name><value><int>10</int></value></member><member><name>distanza_fermate</name><value><string>7</string></value></member><member><name>id_palina</name><value><string>73681</string></value></member><member><name>in_arrivo</name><value><int>0</int></value></member><member><name>a_capolinea</name><value><int>0</int></value></member><member><name>nome_palina</name><value><string>GROTTA PERFETTA/P. MIRANDOLA</string></value></member><member><name>annuncio</name><value><string>7 Fermate (10')</string></value></member><member><name>capolinea</name><value><string>Staz. Trastevere (FS)</string></value></member><member><name>moby</name><value><int>1</int></value></member><member><name>prossima_partenza</name><value><string></string></value></member><member><name>meb</name><value><int>0</int></value></member><member><name>tempo_attesa_secondi</name><value><int>603</int></value></member><member><name>carteggi</name><value><string></string></value></member><member><name>banda</name><value><int>0</int></value></member><member><name>id_veicolo</name><value><string>3049</string></value></member><member><name>id_percorso</name><value><string>5404</string></value></member><member><name>carteggi_dec</name><value><string></string></value></member><member><name>destinazione</name><value><string>Staz. Trastevere (FS)</string></value></member><member><name>pedana</name><value><int>1</int></value></member><member><name>linea</name><value><string>766</string></value></member></struct></value></data></array></value></member><member><name>primi_per_palina</name><value><array><data><value><struct><member><name>nome_palina</name><value><string>GROTTA PERFETTA/P. MIRANDOLA</string></value></member><member><name>id_palina</name><value><string>73681</string></value></member><member><name>arrivi</name><value><array><data><value><struct><member><name>aria</name><value><int>1</int></value></member><member><name>disabilitata</name><value><boolean>0</boolean></value></member><member><name>tempo_attesa</name><value><int>10</int></value></member><member><name>distanza_fermate</name><value><string>7</string></value></member><member><name>id_palina</name><value><string>73681</string></value></member><member><name>in_arrivo</name><value><int>0</int></value></member><member><name>a_capolinea</name><value><int>0</int></value></member><member><name>nome_palina</name><value><string>GROTTA PERFETTA/P. MIRANDOLA</string></value></member><member><name>annuncio</name><value><string>7 Fermate (10')</string></value></member><member><name>capolinea</name><value><string>Staz. Trastevere (FS)</string></value></member><member><name>moby</name><value><int>1</int></value></member><member><name>prossima_partenza</name><value><string></string></value></member><member><name>meb</name><value><int>0</int></value></member><member><name>tempo_attesa_secondi</name><value><int>603</int></value></member><member><name>carteggi</name><value><string></string></value></member><member><name>banda</name><value><int>0</int></value></member><member><name>id_veicolo</name><value><string>3049</string></value></member><member><name>id_percorso</name><value><string>5404</string></value></member><member><name>carteggi_dec</name><value><string></string></value></member><member><name>destinazione</name><value><string>Staz. Trastevere (FS)</string></value></member><member><name>pedana</name><value><int>1</int></value></member><member><name>linea</name><value><string>766</string></value></member></struct></value><value><struct><member><name>nome_palina</name><value><string>GROTTA PERFETTA/P. MIRANDOLA</string></value></member><member><name>meb</name><value><boolean>0</boolean></value></member><member><name>aria</name><value><boolean>0</boolean></value></member><member><name>nessun_autobus</name><value><boolean>1</boolean></value></member><member><name>moby</name><value><boolean>0</boolean></value></member><member><name>id_palina</name><value><string>73681</string></value></member><member><name>pedana</name><value><boolean>0</boolean></value></member><member><name>linea</name><value><string>769</string></value></member></struct></value><value><struct><member><name>non_monitorata</name><value><boolean>1</boolean></value></member><member><name>nome_palina</name><value><string>GROTTA PERFETTA/P. MIRANDOLA</string></value></member><member><name>meb</name><value><boolean>0</boolean></value></member><member><name>aria</name><value><boolean>0</boolean></value></member><member><name>moby</name><value><boolean>0</boolean></value></member><member><name>id_news</name><value><int>-1</int></value></member><member><name>id_palina</name><value><string>73681</string></value></member><member><name>pedana</name><value><boolean>0</boolean></value></member><member><name>linea</name><value><string>N9</string></value></member></struct></value></data></array></value></member></struct></value></data></array></value></member><member><name>collocazione</name><value><string>VIA DI GROTTA PERFETTA, 25 M. DOPO VIA POGGIO AMENO PRIMA CIVICO 315</string></value></member><member><name>nome</name><value><string>GROTTA PERFETTA/P. MIRANDOLA</string></value></member></struct></value></member></struct></value></param></params></methodResponse>";


    public Parser(RPCObjectFoundListener objectFoundListener) throws XmlPullParserException, IOException {
        rPCObjectFoundListener = objectFoundListener;
//        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
//        factory.setNamespaceAware(true);
//        XmlPullParser xmlPullParser = factory.newPullParser();
//        xmlPullParser.setInput(new StringReader(resp));
//        Parse(xmlPullParser);
    }



    public RPCObject ParseRpcRequest(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String tagName = null;
        RPCObject value = null;
        int eventType = xmlPullParser.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    break;
                case XmlPullParser.START_TAG:
                    tagName = xmlPullParser.getName();
                    if (tagName.equals(RPCStruct.TAG_NAME))
                        value = ParseStruct(xmlPullParser);
                    else if (tagName.equals(RPCMember.TAG_NAME))
                        value = ParseMember(xmlPullParser);
                    break;
                case XmlPullParser.END_TAG:
                    break;
                case XmlPullParser.TEXT:
                    break;
                default:
                    break;
            }
            xmlPullParser.next();
            eventType = xmlPullParser.getEventType();
        }
        return value;
    }

    private void RaiseRPCObjectFoundListener(RPCObject o) {
        if (rPCObjectFoundListener == null)
            return;

        if (rPCObjectFoundListener.type == o.GetType()
                && (rPCObjectFoundListener.name.equals(o.toString())))
            rPCObjectFoundListener.onRPCObjectFound(o);
    }

    private RPCMember ParseMember(XmlPullParser xmlPullParser)  throws XmlPullParserException, IOException {
        String name = null;
        RPCValue value = null;
        if (!xmlPullParser.getName().equals(RPCMember.TAG_NAME))
            return null;
        xmlPullParser.next();
        xmlPullParser.next();
        name = xmlPullParser.getText();
        xmlPullParser.next();
        xmlPullParser.next();
        value = GetValue(xmlPullParser);
        xmlPullParser.next();
        String c = xmlPullParser.getName();
        RPCMember m = new RPCMember(name, value);
        RaiseRPCObjectFoundListener(m);
        return m;
    }

    private RPCValue GetValue(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        RPCValue value = null;
        xmlPullParser.next();
        if (xmlPullParser.getName().equals(RPCValueInt.SUB_TAG_NAME))  {
            xmlPullParser.next();
            value = new RPCValueInt(Integer.parseInt(xmlPullParser.getText()));
        }
        else if (xmlPullParser.getName().equals(RPCValueBoolean.SUB_TAG_NAME))  {
            xmlPullParser.next();
            value = new RPCValueBoolean(Boolean.parseBoolean(xmlPullParser.getText()));
        }
        else if (xmlPullParser.getName().equals(RPCValueString.SUB_TAG_NAME))  {
            xmlPullParser.next();
            value = new RPCValueString(xmlPullParser.getText());
        }
        else if (xmlPullParser.getName().equals(RPCStruct.TAG_NAME))
            value = new RPCValue(ParseStruct(xmlPullParser));
        else if (xmlPullParser.getName().equals(RPCArray.TAG_NAME))
            value = new RPCValue(ParseArray(xmlPullParser));


        while (xmlPullParser.getEventType() != XmlPullParser.END_TAG
                    || !xmlPullParser.getName().equals(RPCValue.TAG_NAME)) {
            xmlPullParser.next();
            String c = xmlPullParser.getName();
        }

        return value;
    }

    private RPCArray ParseArray(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException  {
        List<RPCValue> values = new ArrayList<RPCValue>();

        xmlPullParser.next(); //data
        xmlPullParser.next(); //value
        while (xmlPullParser.getName().equals(RPCValue.TAG_NAME)) {
            values.add(GetValue(xmlPullParser));
            xmlPullParser.next();
        }
        return new RPCArray(values);
    }

    private RPCStruct ParseStruct(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException  {
        List<RPCMember> values = new ArrayList<RPCMember>();
        String c = xmlPullParser.getName();
        xmlPullParser.next(); //data
        c = xmlPullParser.getName();
        while (xmlPullParser.getName().equals(RPCMember.TAG_NAME)) {
            values.add(ParseMember(xmlPullParser));
            c = xmlPullParser.getName();
            xmlPullParser.next();
            c = xmlPullParser.getName();
        }
        return new RPCStruct(values);
    }
}
