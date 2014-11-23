package com.example.andrea.prova.marprotocol.autenticazione;

import com.example.andrea.prova.marprotocol.response.MARResponse;

import org.xmlpull.v1.XmlPullParser;

/**
 * Created by andrea on 09/11/14.
 */
public class AccediResponse extends MARResponse {
    private String token;

    public String getToken() {
        return token;
    }

    public AccediResponse(XmlPullParser xml) {
        super(xml);
    }

    @Override
    protected void GenerateResponse() {
        try {
            int eventType = super.xml.getEventType();
            String currentTag = null;
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {
                    currentTag = super.xml.getName();
                } else if (eventType == XmlPullParser.TEXT) {
                    if ("string".equals(currentTag)) {
                        token = super.xml.getText();
                        return;
                    }
                }
                eventType = super.xml.next();
            }
        }
        catch (Exception e)
        {}
    }


}
