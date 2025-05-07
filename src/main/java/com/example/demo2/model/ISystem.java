package com.example.demo2.model;

import java.util.List;

public interface ISystem {

    Cliente consultarCliente(String cpf);
    Automovel consultarAutomovel(String placa);
    Locacao cadastrarLocacao(String cpf, String placa, String dataInicio, int dias);
    void finalizarLocacao(String codigo);
    void cadastrarCliente(Cliente cliente);
    void cadastrarAutomovel(Automovel automovel);
    List<Automovel> getTodosAutomoveis();
    List<Cliente> getTodosClientes();
    List<Locacao> getTodasLocacoes();
    void alterarSituacaoAutomovel(String placa);
}
