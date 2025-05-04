package com.example.demo2.model;

import java.util.List;
public class Gerente implements IbasicServices {
    private ACMERent sistema;

    public Gerente(ACMERent sistema) {
        this.sistema = sistema;
    }

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


    public void cadastrarCliente(Cliente cliente) {
        sistema.cadastrarCliente(cliente);
    }

    public void cadastrarAutomovel(Automovel automovel, int anoAtual) {
        if (!automovel.deveSerRetirado(anoAtual)) {
            sistema.cadastrarAutomovel(automovel);
        }
    }

    public List<Cliente> getTodosClientes() {
        return sistema.getTodosClientes();
    }

    public List<Automovel> getTodosAutomoveis() {
        return sistema.getTodosAutomoveis();
    }

    public List<Locacao> getTodasLocacoes() {
        return sistema.getTodasLocacoes();
    }

    public void alterarSituacaoAutomovel(String placa, boolean novaSituacao) {
        sistema.alterarSituacaoAutomovel(placa, novaSituacao);
    }
}
