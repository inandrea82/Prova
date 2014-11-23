package com.example.andrea.prova.marprotocol.palina;

import com.example.andrea.prova.marprotocol.response.MARResponse;

import org.xmlpull.v1.XmlPullParser;

/**
 * Created by andrea on 09/11/14.
 */
public class PrevisioniResponse extends PalinaResponse {
    private PrevisioniRisposta risposta;

    /**
     *
     * @return
     * The risposta
     */
    public PrevisioniRisposta getRisposta() {
        return risposta;
    }

    /**
     *
     * @param risposta
     * The risposta
     */
    public void setRisposta(PrevisioniRisposta risposta) {
        this.risposta = risposta;
    }

    public PrevisioniResponse(XmlPullParser xml) {
        super(xml);
    }

    @Override
    protected void GenerateOtherResponse() {

    }

}
