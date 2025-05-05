package com.example.demo2.model;

import lombok.Getter;

@Getter
public class Locacao {
    private static int contador = 1;
    final String codigo;
    private Cliente cliente;
    private Automovel automovel;
    final String dataInicio;
    private int dias;

    public Locacao(Cliente cliente, Automovel automovel, String dataInicio, int dias) {
        this.codigo = "LOC" + contador++;
        this.cliente = cliente;
        this.automovel = automovel;
        this.dataInicio = dataInicio;
        this.dias = dias;
        this.automovel.setDisponivel(false);
    }

    public double calcularValorTotal() {
        double valor = automovel.getValorDiaria() * dias;
        if (dias > 7) {
            valor *= 0.95;
        }
        return valor;
    }

    public void finalizar() {
        automovel.setDisponivel(true);
    }

}