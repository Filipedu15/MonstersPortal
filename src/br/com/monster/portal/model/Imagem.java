package br.com.monster.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "imagem")

public class Imagem {
	
	@Id
	@GeneratedValue
	private long id_imagem;

	@NotNull(message="{imagem.arquivo.NotEmpty}")
	@Size(min=5, max=100, message = "{imagem.arquivo.Size}")
	@Column(name = "ima_arquivo")
	private String arquivo_imagem;

	@NotNull
	@Column(name = "ima_ordem")
	private String ordem_imagem;
	
	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */

	@ManyToOne
	@JoinColumn(name = "produto_id_produto", insertable=true, updatable=true)
	private Produto produto;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/
	
	public String getOrdem_imagem() {
		return ordem_imagem;
	}

	public void setOrdem_imagem(String ordem_imagem) {
		this.ordem_imagem = ordem_imagem;
	}

	public void setId_imagem(long id_imagem) {
		this.id_imagem = id_imagem;
	}

	public long getId_imagem() {
		return id_imagem;
	}

	public void setId_imagem(Long id_imagem) {
		this.id_imagem = id_imagem;
	}

	public String getArquivo_imagem() {
		return arquivo_imagem;
	}

	public void setArquivo_imagem(String arquivo_imagem) {
		this.arquivo_imagem = arquivo_imagem;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}