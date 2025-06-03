package br.com.petadota.adocao.model;


// Criando a classe Adocao
public class Adocao {
	
	// Atributos	
    public Long id;
    public String nome;
    public String tipo;
    public Integer idade;
    public String raca;
    public StatusAdocao status;
    public String descricao;
    public String imagemUrl;

	// Construtor
	public Adocao(Long id, String nome, String tipo, Integer idade, String raca, StatusAdocao status, String descricao, String imagemUrl) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.idade = idade;
		this.raca = raca;
		this.status = status;
		this.descricao = descricao;
		this.imagemUrl = imagemUrl;
	}
	
}