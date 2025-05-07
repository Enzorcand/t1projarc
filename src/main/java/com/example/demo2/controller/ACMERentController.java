package com.example.demo2.controller;


import com.example.demo2.dto.LocacaoRequest;
import com.example.demo2.dto.PlacaDTO;
import com.example.demo2.model.ACMERent;
import com.example.demo2.model.Automovel;
import com.example.demo2.model.Cliente;
import com.example.demo2.model.Locacao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Cliente consultarCliente(@RequestParam(value = "codigo") String cpf) {
        return system.consultarCliente(cpf);
    }

    @PostMapping("/validaautomovel")
    public ResponseEntity<Boolean> validaAutomovel(@RequestBody PlacaDTO placaDTO) {
        //boolean disponivel = false;

        String placa = placaDTO.getPlaca();

        Automovel resp = system.getTodosAutomoveis().stream()
                .filter(automovel -> automovel.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);

        if (resp == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(resp.isDisponivel());
    }
    @PostMapping("/atendimento/cadlocacao")
    public ResponseEntity<Boolean> cadastrarLocacao(@RequestBody LocacaoRequest locacaoRequest) {
        boolean sucesso = system.cadastrarLocacao(
                locacaoRequest.getCpf(),
                locacaoRequest.getPlaca(),
                locacaoRequest.getDataInicio(),
                locacaoRequest.getDias()
        ) != null;
        return ResponseEntity.ok(sucesso);
    }

    @PostMapping("/atendimento/atualizaautomovel/{id}/estado/{status}")
    public ResponseEntity<Automovel> atualizaStatusAutomovel (@PathVariable(value = "id") String id, @PathVariable
            (value = "status") Boolean status) {

        Automovel resp = system.getTodosAutomoveis().stream()
                .filter(Automovel -> Automovel.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (resp == null) {
            return ResponseEntity.notFound().build();
        }
        resp.setDisponivel(status);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resp);
    }

    @PostMapping("atendimento/finalizalocacao")
    public ResponseEntity<Boolean> finalizaLocacao(@RequestBody final String codigo) {
        Locacao resp = system.getTodasLocacoes().stream()
                .filter(Locacao -> Locacao.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
        if (resp == null) {
            return ResponseEntity.notFound().build();
        }
        resp.finalizar();
        system.getTodasLocacoes().remove(resp);
        return ResponseEntity.ok(true);
    }
}
