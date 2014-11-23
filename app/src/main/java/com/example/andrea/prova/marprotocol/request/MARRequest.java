package com.example.andrea.prova.marprotocol.request;


/**
 * Created by andrea on 09/11/14.
 */
public abstract class MARRequest {
    protected StringBuilder xml;

    protected MARRequest() {
        this.xml = new StringBuilder();
    }

    public final String GetXml(String methodName) {
        xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\"?>\n<methodCall>\n<methodName>")
            .append(methodName)
            .append("</methodName>\n<params>");
        GetParamerer(xml);
            xml.append("</params>\n</methodCall>");
        return xml.toString();
    }

    protected abstract void GetParamerer(StringBuilder par);
}
