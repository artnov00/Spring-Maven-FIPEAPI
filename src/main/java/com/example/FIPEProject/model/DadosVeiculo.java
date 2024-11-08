package com.example.FIPEProject.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosVeiculo(@JsonAlias("TipoVeiculo")Integer tipoVeiculo,
                           @JsonAlias("Valor")String valor,
                           @JsonAlias("Marca")String marca,
                           @JsonAlias("Modelo")String modelo,
                           @JsonAlias("AnoModelo")Integer anoModelo,
                           @JsonAlias("Combustivel")String combustivel,
                           @JsonAlias("CodigoFipe")String codigoFipe,
                           @JsonAlias("MesReferencia")String mesReferencia,
                           @JsonAlias("SiglaCombustivel")String siglaCombustivel) {

    @Override
    public String toString() {
        return "dadosVeiculo{" +
                "tipoVeiculo=" + tipoVeiculo +
                ", valor='" + valor + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anoModelo=" + anoModelo +
                ", combustivel='" + combustivel + '\'' +
                ", codigoFipe='" + codigoFipe + '\'' +
                ", mesReferencia='" + mesReferencia + '\'' +
                ", siglaCombustivel='" + siglaCombustivel + '\'' +
                '}';
    }
}
