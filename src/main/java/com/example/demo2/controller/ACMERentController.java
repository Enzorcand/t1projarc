package com.example.demo2.controller;


import com.example.demo2.model.ACMERent;
import com.example.demo2.model.Automovel;
import com.example.demo2.model.Cliente;
import com.example.demo2.model.Locacao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/acmerent")
@RestController
public class ACMERentController {


    private ACMERent system;


    public ACMERentController() {
        system = new ACMERent();
    }

    @GetMapping("/listaautomoveis")
    public List<Automovel> listarAutomoveis() {
        return system.getTodosAutomoveis();
    }

    @GetMapping("/listaclientes")
    public List<Cliente> listarClientes() {
        return system.getTodosClientes();
    }

    @GetMapping("/listalocacoes")
    public List<Locacao> listarLocacoes() {
        return system.getTodasLocacoes();
    }

    @GetMapping("/consultacliente")
    public Cliente consultarCliente(@RequestParam String cpf) {
        return system.consultarCliente(cpf);
    }


}
