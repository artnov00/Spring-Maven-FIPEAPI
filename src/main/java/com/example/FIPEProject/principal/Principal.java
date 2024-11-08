package com.example.FIPEProject.principal;

import com.example.FIPEProject.model.*;
import com.example.FIPEProject.service.ConsumoAPI;
import com.example.FIPEProject.service.ConverteDados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";
    private ConsumoAPI consumidor = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();

    public void exibeMenu() {
        System.out.println("""
                ******************OPÇÕES******************
                Carros
                Motos
                Caminhões
                
                Digite uma das opções para consultar:
                """);

        var tipoDeVeiculo = leitura.nextLine().toLowerCase();
        if (tipoDeVeiculo.contains("carro")) {
            tipoDeVeiculo = "carros";
        } else if (tipoDeVeiculo.contains("caminhoe")) {
            tipoDeVeiculo = "caminhoes";
        } else if (tipoDeVeiculo.contains("mot")) {
            tipoDeVeiculo = "motos";
        }

        var json = consumidor.obterDados(ENDERECO + tipoDeVeiculo + "/marcas");
        List<Dados> listaMarcas = conversor.obterDadosLista(json, Dados.class);
        listaMarcas.stream().forEach(System.out::println);

        System.out.println("Digite o código da marca:");
        var marca = leitura.nextInt();
        leitura.nextLine();
        json = consumidor.obterDados(ENDERECO + tipoDeVeiculo + "/marcas/" + marca + "/modelos");
        List<DadosModelos> listaModelos = Collections.singletonList(conversor.obterDados(json, DadosModelos.class));
        List<Dados> listaModelosModelos = listaModelos.stream()
                .flatMap(m -> m.modelos().stream())
                .toList();
        listaModelosModelos.stream().forEach(System.out::println);

        System.out.println("Digite um trecho do veículo desejado:");
        var trechoVeiculo = leitura.nextLine();
        listaModelosModelos.stream()
                .filter(mm -> mm.nome().toLowerCase().contains(trechoVeiculo.toLowerCase()))
                .forEach(System.out::println);

        System.out.println("Digite o código do modelo para consultar os valores:");
        var modelo = leitura.nextInt();
        leitura.nextLine();

        json = consumidor.obterDados(ENDERECO + tipoDeVeiculo + "/marcas/" + marca + "/modelos/" + modelo + "/anos");
        List<Dados> listaDadosAnos = conversor.obterDadosLista(json, Dados.class);
        List<DadosVeiculo> listaVeiculos = new ArrayList<>();

        for (int i = 0; i < listaDadosAnos.size(); i++) {
            json = consumidor.obterDados(ENDERECO + tipoDeVeiculo + "/marcas/" + marca + "/modelos/" + modelo + "/anos/" + listaDadosAnos.get(i).codigo());
            DadosVeiculo veiculo = conversor.obterDados(json, DadosVeiculo.class);
            listaVeiculos.add(veiculo);
        }
        System.out.println("Todos os veiculos filtrados com preços por anos:");
        listaVeiculos.stream().forEach(System.out::println);
    }
}