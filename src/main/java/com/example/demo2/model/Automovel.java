package com.example.demo2.model;

public class Automovel {
    private String id;
    private String placa;
    private int ano;
    private double valorDiaria;
    private boolean disponivel;

    public Automovel(String placa, int ano, double valorDiaria) {
        this.placa = placa;
        this.ano = ano;
        this.valorDiaria = valorDiaria;
        this.disponivel = true;
    }

    public Automovel(String placa, int ano, double valorDiaria, boolean disponivel) {
        this.placa = placa;
        this.ano = ano;
        this.valorDiaria = valorDiaria;
        this.disponivel = disponivel;
    }

    public Automovel(String id, String placa, int ano, double valorDiaria, boolean disponivel) {
        this.id = id;
        this.placa = placa;
        this.ano = ano;
        this.valorDiaria = valorDiaria;
        this.disponivel = disponivel;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean deveSerRetirado(int anoAtual) {
        return (anoAtual - ano) > 5;
    }

    public String getPlaca() {
        return placa;
    }

    public int getAno() {
        return ano;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
