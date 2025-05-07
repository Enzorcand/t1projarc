package com.example.demo2.model;

public interface IBasicServices {
    ACMERent sistema = new ACMERent();

    Cliente consultarCliente(String cpf);
    Automovel consultarAutomovel(String placa);
    Locacao cadastrarLocacao(String cpf, String placa, String dataInicio, int dias);
    void finalizarLocacao(String codigo);
}