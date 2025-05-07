package com.example.demo2.model;

public class Atendente implements IBasicServices {
    @Override
    public Cliente consultarCliente(String cpf) {
        return sistema.consultarCliente(cpf);
    }

    @Override
    public Automovel consultarAutomovel(String placa) {
        return sistema.consultarAutomovel(placa);
    }

    @Override
    public Locacao cadastrarLocacao(String cpf, String placa, String dataInicio, int dias) {
        return sistema.cadastrarLocacao(cpf, placa, dataInicio, dias);
    }

    @Override
    public void finalizarLocacao(String codigo) {
        sistema.finalizarLocacao(codigo);
    }
}

