package com.example.FIPEProject.service;

import java.util.List;

public interface IConverteDadosLista<T> {
    List<T> obterDadosLista (String json, Class<T> classe);
}
