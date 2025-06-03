package br.com.petadota.adocao.controller;

import br.com.petadota.adocao.model.Adocao;
import br.com.petadota.adocao.service.AdocaoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;


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
    // Atualize o método Salvar para tratar o carregamento do arquivo
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Adocao a, @RequestParam("imagem") MultipartFile imagemFile, HttpServletRequest request) {
        if (!imagemFile.isEmpty()) {
            try {
                // Defina a pasta onde a imagem será armazenada.
                // Para desenvolvimento, podemos salvar em uploaded-files/img
                String uploadDir = "uploaded-files/img/";
                Path uploadPath = Paths.get(uploadDir);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                // Limpa e gera um nome único para o arquivo
                String fileName = System.currentTimeMillis() + "_" + a.getNome().strip() + ".jpg"; // Supondo que a imagem seja JPG

                // Copia o arquivo para o diretório destino
                try (InputStream inputStream = imagemFile.getInputStream()) {
                    Path filePath = uploadPath.resolve(fileName);
                    Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                }

                // Construa a URL completa usando os dados da requisição
                String baseUrl = request.getScheme() + "://" +
                                 request.getServerName() + ":" +
                                 request.getServerPort() +
                                 request.getContextPath();
                // A imagem estará disponível em /img/<nomeDoArquivo>
                String imagemURLCompleta = baseUrl + "/img/" + fileName;
                a.setImagemUrl(imagemURLCompleta);

            } catch (IOException e) {
                e.printStackTrace();
                // Você pode adicionar um tratamento adequado para erros de upload aqui (mensagem para o usuário, etc.)
            }
        }
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
