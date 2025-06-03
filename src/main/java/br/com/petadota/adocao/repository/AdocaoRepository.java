package br.com.petadota.adocao.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.petadota.adocao.model.Adocao;


@Repository
public interface AdocaoRepository extends JpaRepository<Adocao, Long>
	{
	}