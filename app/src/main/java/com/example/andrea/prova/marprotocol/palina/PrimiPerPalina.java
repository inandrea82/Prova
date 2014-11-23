package com.example.andrea.prova.marprotocol.palina;

/**
 * Created by andrea on 09/11/14.
 */


    import java.util.ArrayList;
    import java.util.List;

public class PrimiPerPalina {

        private String nomePalina;
        private String idPalina;
        private List<InArrivo> arrivi = new ArrayList<InArrivo>();

        /**
         *
         * @return
         * The nomePalina
         */
        public String getNomePalina() {
            return nomePalina;
        }

        /**
         *
         * @param nomePalina
         * The nome_palina
         */
        public void setNomePalina(String nomePalina) {
            this.nomePalina = nomePalina;
        }

        /**
         *
         * @return
         * The idPalina
         */
        public String getIdPalina() {
            return idPalina;
        }

        /**
         *
         * @param idPalina
         * The id_palina
         */
        public void setIdPalina(String idPalina) {
            this.idPalina = idPalina;
        }

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


    }

