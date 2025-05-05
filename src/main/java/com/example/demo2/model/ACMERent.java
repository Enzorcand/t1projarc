package com.example.demo2.model;

import java.util.*;

public class ACMERent {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Automovel> automoveis = new ArrayList<>();
    private List<Locacao> locacoes = new ArrayList<>();


    public ACMERent() {
        // criar 10 carros diferentes e por na lista
        automoveis.add(new Automovel("ABC1234", 2010,  50.0, true));
        automoveis.add(new Automovel("DEF1234", 2015,  60.0, true));
        automoveis.add(new Automovel("GHI1234", 2017,  70.0, true));
        automoveis.add(new Automovel("JKL1234", 2020,  80.0, true));
        automoveis.add(new Automovel("MNO1234", 2021,  90.0, true));
        automoveis.add(new Automovel("PQR1234", 2022,  100.0, true));
        automoveis.add(new Automovel("STU1234", 2023,  110.0, true));
        automoveis.add(new Automovel("VWX1234", 2024,  120.0, true));
        automoveis.add(new Automovel("ABC5678", 2025,  130.0, true));
        automoveis.add(new Automovel("YZA1234", 2011,  55.0, true));

        //criar 3 clientes e por na lista
        clientes.add(new Cliente("John", "123456789", "55678657653"));
        clientes.add(new Cliente("Peter", "987654321", "55678657653"));
        clientes.add(new Cliente("Marst", "271780809", "55678657653"));

    }


    public Cliente consultarCliente(String cpf) {
        return clientes.stream().filter(c -> c.getCpf().equals(cpf)).findFirst().orElse(null);
    }

    public Automovel consultarAutomovel(String placa) {
        return automoveis.stream().filter(a -> a.getPlaca().equals(placa)).findFirst().orElse(null);
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void cadastrarAutomovel(Automovel automovel) {
        automoveis.add(automovel);
    }

    public Locacao cadastrarLocacao(String cpf, String placa, String dataInicio, int dias) {
        Cliente cliente = consultarCliente(cpf);
        Automovel automovel = consultarAutomovel(placa);
        if (cliente != null && automovel != null && automovel.isDisponivel()) {
            Locacao locacao = new Locacao(cliente, automovel, dataInicio, dias);
            locacoes.add(locacao);
            return locacao;
        }
        return null;
    }

    public void finalizarLocacao(String codigo) {
        for (Locacao locacao : locacoes) {
            if (locacao.getCodigo().equals(codigo)) {
                locacao.finalizar();
                break;
            }
        }
    }

    public List<Automovel> getTodosAutomoveis() {
        return automoveis;
    }

    public List<Cliente> getTodosClientes() {
        return clientes;
    }

    public List<Locacao> getTodasLocacoes() {
        return locacoes;
    }

    public void alterarSituacaoAutomovel(String placa, boolean novaSituacao) {
        Automovel automovel = consultarAutomovel(placa);
        if (automovel != null) {
            automovel.setDisponivel(novaSituacao);
        }
    }
}
