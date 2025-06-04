package br.com.petadota.adocao.controller;

import br.com.petadota.adocao.model.Adocao;
import br.com.petadota.adocao.service.AdocaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/adocoes")
public class AdocaoRestController {
    private final AdocaoService service;

    public AdocaoRestController(AdocaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Adocao> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Optional<Adocao> buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Adocao salvar(@RequestBody Adocao adocao) {
        return service.salvar(adocao);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        service.deletar(id);
    }
}
