package com.example.andrea.prova.marprotocol.autenticazione;

import com.android.volley.Response;
import com.example.andrea.prova.marprotocol.MARMethod;
import com.example.andrea.prova.marprotocol.response.MARResponse;

import org.xmlpull.v1.XmlPullParser;

import javax.xml.transform.ErrorListener;

/**
 * Created by andrea on 09/11/14.
 */
public class Accedi extends MARMethod {

    private static final String METHOD_URL ="http://muovi.roma.it/ws/xml/autenticazione/1";
    private static final String METHOD_NAME ="autenticazione.Accedi";

    public static Accedi CreateAccedi(AccediRequest request, Response.ErrorListener errorListener, Response.Listener<AccediResponse> listener) {
        return new Accedi(request, errorListener, listener);
    }

    protected Accedi(AccediRequest request, Response.ErrorListener errorListener, final Response.Listener<AccediResponse> listener) {
        super(METHOD_NAME, METHOD_URL, request, errorListener,
                new Response.Listener<MARResponse>() {
                    @Override
                    public void onResponse(MARResponse marResponse) {
                        listener.onResponse((AccediResponse)marResponse);
                    }
                });

    }

    @Override
    protected MARResponse GetResponse(XmlPullParser response) {
        return new AccediResponse(response);
    }

}
