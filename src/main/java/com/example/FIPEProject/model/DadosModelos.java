package com.example.FIPEProject.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record DadosModelos(List<Dados> anos, List<Dados> modelos) {
}
