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
@Table(name = "banner")
public class Banner {
	
	@Id
	@GeneratedValue
	private Long id_banner;
	
	@NotNull(message="{banner.nome.NotEmpty}")
	@Size(min=5, max=255, message = "{banner.nome.Size}")
	@Column(name = "ban_nome")			//Nome real dentro do banco
	private String nome_banner;			//Nome do campo no sistema

	@NotNull
	@Column(name = "ban_arquivo")
	private String arquivo_banner;
	
	@NotNull
	@Column(name = "ban_ativo")
	private boolean ativo_banner;

	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */
	
	// MUITOS Banners tem UM Produto
	@ManyToOne
	@JoinColumn(name = "produto_id_produto", insertable=true, updatable=true)
	private Produto produto;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/
	
	public Long getId_banner() {
		return id_banner;
	}
	public void setId_banner(Long id_banner) {
		this.id_banner = id_banner;
	}
	public String getNome_banner() {
		return nome_banner;
	}
	public void setNome_banner(String nome_banner) {
		this.nome_banner = nome_banner;
	}
	public String getArquivo_banner() {
		return arquivo_banner;
	}
	public void setArquivo_banner(String arquivo_banner) {
		this.arquivo_banner = arquivo_banner;
	}
	public boolean isAtivo_banner() {
		return ativo_banner;
	}
	public void setAtivo_banner(boolean ativo_banner) {
		this.ativo_banner = ativo_banner;
	}
	public boolean getAtivo_banner() {
		// TODO Auto-generated method stub
		return false;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
