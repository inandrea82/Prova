package com.example.andrea.prova.marprotocol.palina;

import org.xmlpull.v1.XmlPullParser;

/**
 * Created by andrea on 15/11/14.
 */
public class PrevisioniRequest extends PalinaRequest {
    int id_palina;
    String lingua;

    public PrevisioniRequest(String token, int id_palina, String lingua) {
        super(token);
        this.id_palina = id_palina;
        this.lingua = lingua;
    }

    public int getId_palina() {
        return id_palina;
    }

    public String getLingua() {
        return lingua;
    }

    @Override
    protected void GetOtherParameter(StringBuilder par) {
        par.append("<param>\n<value><int>");
        par.append(id_palina);
        par.append("</int></value>\n</param>\n<param>\n<value><string>");
        par.append(lingua);
        par.append("</string></value>\n</param>");
    }
}
