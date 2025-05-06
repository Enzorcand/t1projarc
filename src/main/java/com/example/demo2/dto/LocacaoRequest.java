package com.example.demo2.dto;

import lombok.Data;

@Data
public class LocacaoRequest {
    private String codigo;
    private String cpf;
    private String placa;
    private String dataInicio;
    private int dias;
}
