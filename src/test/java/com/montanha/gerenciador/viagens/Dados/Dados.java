package com.montanha.gerenciador.viagens.Dados;


import java.util.HashMap;
import java.util.Map;

public class Dados {

    public Map cadastrarViagem(){
        Map<String, Object> params =new HashMap<>();
        params.put("acompanhante","Fernanda");
        params.put("dataPartida","2021-08-09");
        params.put("dataRetorno","2021-08-13");
        params.put("localDestino","Gramado");
        params.put("regiao","Sul");


        return params;
    }
}
