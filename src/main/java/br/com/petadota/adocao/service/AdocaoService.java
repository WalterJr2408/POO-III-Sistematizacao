package br.com.petadota.adocao.service;


import br.com.petadota.adocao.model.Adocao;
import br.com.petadota.adocao.repository.AdocaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdocaoService {
    private final AdocaoRepository repo;

    public AdocaoService(AdocaoRepository repo) {
        this.repo = repo;
    }

    public List<Adocao> listarTodas() {
        return repo.findAll();
    }

    public Optional<Adocao> buscarPorId(Integer id) {
        return repo.findById(id);
    }

    public Adocao salvar(Adocao a) {
        return repo.save(a);
    }

    public void deletar(Integer id) {
        repo.deleteById(id);
    }
}