package com.example.andrea.prova.marprotocol.autenticazione;

import com.example.andrea.prova.marprotocol.request.MARRequest;

/**
 * Created by andrea on 09/11/14.
 */
public class AccediRequest extends MARRequest {
    private String chiave_sviluppatore;
    private String id_utente;

    public String getChiave_sviluppatore() {
        return chiave_sviluppatore;
    }

    public void setChiave_sviluppatore(String chiave_sviluppatore) {
        this.chiave_sviluppatore = chiave_sviluppatore;
    }

    public String getId_utente() {
        return id_utente;
    }

    public void setId_utente(String id_utente) {
        this.id_utente = id_utente;
    }

    public AccediRequest(String chiave_sviluppatore) {
        this(chiave_sviluppatore, "");
    }

    public AccediRequest(String chiave_sviluppatore, String id_utente) {
        this.chiave_sviluppatore = chiave_sviluppatore;
        this.id_utente = id_utente;
    }

    @Override
    protected void GetParamerer(StringBuilder xmlr) {
        xmlr.append("<param>\n<value><string>")
                .append(chiave_sviluppatore)
                .append("</string></value>\n</param>\n <param>\n<value><string>")
                .append(id_utente)
                .append("</string></value>\n</param>");
    }
}
