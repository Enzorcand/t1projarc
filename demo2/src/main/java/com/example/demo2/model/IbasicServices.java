package com.example.demo2.model;

public interface IbasicServices {
    Cliente consultarCliente(String cpf);
    Automovel consultarAutomovel(String placa);
    Locacao cadastrarLocacao(String cpf, String placa, String dataInicio, int dias);
    void finalizarLocacao(String codigo);
}

