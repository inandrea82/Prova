package com.example.andrea.prova.marprotocol.palina;

import com.android.volley.Response;
import com.example.andrea.prova.marprotocol.MARMethod;

import com.example.andrea.prova.marprotocol.request.MARRequest;
import com.example.andrea.prova.marprotocol.response.MARResponse;

import org.xmlpull.v1.XmlPullParser;

/**
 * Created by andrea on 09/11/14.
 */
public class Previsioni extends MARMethod {

    private static final String METHOD_URL ="http://muovi.roma.it/ws/xml/paline/7";
    private static final String METHOD_NAME ="paline.Previsioni";

    private PrevisioniResponse previsioniResponse;

    public Previsioni(PrevisioniRequest request, Response.ErrorListener errorListener
            , final Response.Listener<PrevisioniResponse> listener) {
        super(METHOD_NAME, METHOD_URL, request, errorListener,
                new Response.Listener<MARResponse>() {
                    @Override
                    public void onResponse(MARResponse marResponse) {
                        listener.onResponse((PrevisioniResponse)marResponse);
                    }
                });

    }



    @Override
    protected MARResponse GetResponse(XmlPullParser response) {
        return new PrevisioniResponse(response);
    }
}
