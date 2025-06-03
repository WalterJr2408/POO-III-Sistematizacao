package br.com.petadota.adocao.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;


@Entity
@Table(name = "Adocoes")
public class Adocao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String tipo;

    @Column(nullable = false)
    private Integer idade;

    @Column(nullable = false, length = 100)
    private String raca;

    @Column(nullable = false, length = 100)
    private String statusAdocao;

    @Column(nullable = false, length = 255)
    private String descricao;

    @Column(nullable = false, length = 255)
    private String imagemUrl;

    // Construtores, getters e setters
    
    public Adocao() {}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @return the idade
	 */
	public Integer getIdade() {
		return idade;
	}

	/**
	 * @return the raca
	 */
	public String getRaca() {
		return raca;
	}

	/**
	 * @return the statusAdocao
	 */
	public String getStatusAdocao() {
		return statusAdocao;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @return the imagemUrl
	 */
	public String getImagemUrl() {
		return imagemUrl;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @param idade the idade to set
	 */
	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	/**
	 * @param raca the raca to set
	 */
	public void setRaca(String raca) {
		this.raca = raca;
	}

	/**
	 * @param statusAdocao the statusAdocao to set
	 */
	public void setStatusAdocao(String statusAdocao) {
		this.statusAdocao = statusAdocao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @param imagemUrl the imagemUrl to set
	 */
	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}

}