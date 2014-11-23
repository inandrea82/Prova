package com.example.andrea.prova.marprotocol;


import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.example.andrea.prova.marprotocol.request.MARRequest;
import com.example.andrea.prova.marprotocol.response.MARResponse;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.zip.GZIPInputStream;

/**
 * Created by andrea on 09/11/14.
 */
public abstract class MARMethod extends Request<MARResponse> {
    protected String methodName;
    protected MARRequest request;
    private Response.Listener<MARResponse> listener;

    protected MARMethod(String methodName, String url, MARRequest request, Response.ErrorListener errorListener, Response.Listener<MARResponse> listener) {
        super(Method.POST, url, errorListener);
        this.request = request;
        this.listener = listener;
        this.methodName = methodName;

    }

    @Override
    protected Response<MARResponse> parseNetworkResponse(NetworkResponse networkResponse) {
        MARResponse parsed = ParseRequest(new ByteArrayInputStream(networkResponse.data));

        return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(networkResponse));
    }

    @Override
    protected void deliverResponse(MARResponse response) {
        listener.onResponse(response);
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
//        try {
//            GZIPInputStream out =
//                    new GZIPInputStream(
//                            new ByteArrayInputStream(
//                                    request.GetXml(methodName).getBytes()));
//            return ;
//        }
//        catch (Exception e) {
//            return null;
//        }
        String xml = request.GetXml(methodName);
        Log.d("Request: ", xml);
        return xml.getBytes();
    }

    @Override
    public String toString() {
        return request.GetXml(methodName);
    }

    public MARResponse ParseRequest(InputStream rsp) {
        try {
            //DEBUG
            BufferedReader r = new BufferedReader(new InputStreamReader(rsp));
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                total.append(line);
            }
            line=total.toString();
            Log.d("Response:", line);
            rsp = new ByteArrayInputStream(line.getBytes());
            //END DEBUG
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(rsp , null);
            return GetResponse(xpp);
        }
        catch (Exception e) {
            return null;
        }
    }

    protected abstract MARResponse GetResponse(XmlPullParser response);
}
