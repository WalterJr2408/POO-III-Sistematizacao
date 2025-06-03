package br.com.petadota.adocao.controller;

import br.com.petadota.adocao.model.Adocao;
import br.com.petadota.adocao.service.AdocaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/adocoes")
public class AdocaoController {
    private final AdocaoService service;

    public AdocaoController(AdocaoService service) {
        this.service = service;
    }

    // 1) LISTAGEM
    @GetMapping
    public String listar(Model m) {
        m.addAttribute("lista", service.listarTodas());
        return "adocoes";
    }

    // 2) FORMULÁRIO PARA NOVA
    @GetMapping("/novo")
    public String novo(Model m) {
        m.addAttribute("adocao", new Adocao());
        return "adocao-form";
    }

    // 3) SALVAR (CREATE e UPDATE)
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Adocao a) {
        service.salvar(a);
        return "redirect:/adocoes";
    }

    // 4) EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model m) {
        service.buscarPorId(id).ifPresent(a -> m.addAttribute("adocao", a));
        return "adocao-form";
    }

    // 5) DELETAR
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Integer id) {
        service.deletar(id);
        return "redirect:/adocoes";
    }
}
