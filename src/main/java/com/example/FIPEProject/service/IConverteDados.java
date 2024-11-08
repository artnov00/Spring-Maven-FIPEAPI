package com.example.FIPEProject.service;

public interface IConverteDados {
    <T> T obterDados (String json, Class<T> classe);
}
