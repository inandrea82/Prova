package com.example.andrea.prova.marprotocol.palina;

/**
 * Created by andrea on 09/11/14.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrevisioniRisposta implements PalinaRisposta {

    private List<InArrivo> arrivi = new ArrayList<InArrivo>();
    private List<PrimiPerPalina> primiPerPallina = new ArrayList<PrimiPerPalina>();
    private String collocazione;
    private String nome;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The arrivi
     */
    public List<InArrivo> getArrivi() {
        return arrivi;
    }

    /**
     *
     * @param arrivi
     * The arrivi
     */
    public void setArrivi(List<InArrivo> arrivi) {
        this.arrivi = arrivi;
    }

    /**
     *
     * @return
     * The primiPerPalina
     */
    public List<PrimiPerPalina> getPrimiPerPalina() {
        return primiPerPallina;
    }

    /**
     *
     * @param primiPerPalina
     * The primi_per_palina
     */
    public void setPrimiPerPalina(List<PrimiPerPalina> primiPerPalina) {
        this.primiPerPallina = primiPerPalina;
    }

    /**
     *
     * @return
     * The collocazione
     */
    public String getCollocazione() {
        return collocazione;
    }

    /**
     *
     * @param collocazione
     * The collocazione
     */
    public void setCollocazione(String collocazione) {
        this.collocazione = collocazione;
    }

    /**
     *
     * @return
     * The nome
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     * The nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

}
