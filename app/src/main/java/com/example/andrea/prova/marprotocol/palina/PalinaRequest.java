package com.example.andrea.prova.marprotocol.palina;

import com.example.andrea.prova.marprotocol.request.MARRequest;
import com.example.andrea.prova.marprotocol.response.MARResponse;

import org.xmlpull.v1.XmlPullParser;

/**
 * Created by andrea on 15/11/14.
 */
public abstract class PalinaRequest extends MARRequest {
    private String token;

    public PalinaRequest(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    @Override
    protected void GetParamerer(StringBuilder par) {
        par.append("<param>\n<value><string>");
        par.append(token);
        par.append("</string></value>\n</param>");
        GetOtherParameter(par);
    }

    protected abstract void GetOtherParameter(StringBuilder par);

}
