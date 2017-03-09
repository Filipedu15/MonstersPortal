package br.com.monster.portal.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.monster.portal.model.Produto;

@Entity
@Table(name = "categoria")
public class Categoria {
		
	@Id //Chave Primaria /*
	@GeneratedValue
	private Long id_categoria;
		
	@NotNull
	@NotEmpty(message="{categoria.nome.NotEmpty}")
	@Size(min=5, max=100, message = "{categoria.nome.Size}")
	@Column(name = "cat_nome")
	private String nome_categoria;
	
	@NotNull
	@Column (name = "cat_hierarquia")
	private String hierarquia_categoria;
	
	@NotNull
	@Column (name = "cat_conf_pro")
	private boolean conf_pro_categoria;
	
	@NotNull
	@Column (name = "cat_conf_quantidade")
	private long conf_quantidade_categoria;
	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */

	// ENVIA 
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy="categoria", fetch=FetchType.EAGER, orphanRemoval=true)
	private Set<Produto> produto;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/
	
	public Long getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Long id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getNome_categoria() {
		return nome_categoria;
	}

	public void setNome_categoria(String nome_categoria) {
		this.nome_categoria = nome_categoria;
	}

	public String getHierarquia_categoria() {
		return hierarquia_categoria;
	}

	public void setHierarquia_categoria(String hierarquia_categoria) {
		this.hierarquia_categoria = hierarquia_categoria;
	}

	public boolean isConf_pro_categoria() {
		return conf_pro_categoria;
	}

	public void setConf_pro_categoria(boolean conf_pro_categoria) {
		this.conf_pro_categoria = conf_pro_categoria;
	}

	public long getConf_quantidade_categoria() {
		return conf_quantidade_categoria;
	}

	public void setConf_quantidade_categoria(long conf_quantidade_categoria) {
		this.conf_quantidade_categoria = conf_quantidade_categoria;
	}

	public Set<Produto> getProduto() {
		return produto;
	}

	public void setProduto(Set<Produto> produto) {
		this.produto = produto;
	}
	
}
	
	
	
	
	
	
	
	
	
		
		
		
		
		