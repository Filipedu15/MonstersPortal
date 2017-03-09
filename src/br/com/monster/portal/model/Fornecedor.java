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
@Table(name = "fornecedor")

public class Fornecedor {
	@Id //Chave Primaria /*
	@GeneratedValue
	private Long id_fornecedor;
	
	@NotNull(message="{fornecedor.nome.NotEmpty}")
	@Size(min=5, max=200, message = "{fornecedor.nome.Size}")
	@Column(name = "for_nome")			
	private String nome_fornecedor;
	
	@NotNull(message="{fornecedor.cnpj.NotEmpty}")
	@Size(min=18, max=18, message = "{fornecedor.cnpj.Size}")
	@Column(name = "for_cnpj")
	private String cnpj_fornecedor;
	
	@NotNull(message="{fornecedor.razao.NotEmpty}")
	@Size(min=5, max=50, message = "{fornecedor.razao.Size}")
	@Column(name = "for_razao")
	private String razao_fornecedor;
	
	@NotNull(message="{fornecedor.objetivo.NotEmpty}")
	@Size(min=5, max=100, message = "{fornecedor.objetivo.Size}")
	@Column (name = "for_objetivo")
	private String objetivo_fornecedor;
	
	@NotNull(message="{fornecedor.logo.NotEmpty}")
	@Size(min=5, max=100, message = "{fornecedor.logo.Size}")
	@Column(name = "for_logo")
	private String logo_fornecedor;
	
	@NotNull(message="{fornecedor.cep.NotEmpty}")
	@Size(min=9, max=9, message = "{fornecedor.cep.Size}")
	@Column(name = "for_cep")
	private String cep_fornecedor;
	
	@NotNull(message="{fornecedor.estado.NotEmpty}")
	@Size(min=2, max=20, message = "{fornecedor.estado.Size}")
	@Column(name = "for_estado")
	private String estado_fornecedor;
	
	@NotNull(message="{fornecedor.cidade.NotEmpty}")
	@Size(min=5, max=50, message = "{fornecedor.cidade.Size}")
	@Column(name = "for_cidade")
	private String cidade_fornecedor;
	
	@NotNull(message="{fornecedor.endereco.NotEmpty}")
	@Size(min=3, max=50, message = "{fornecedor.endereco.Size}")
	@Column(name = "for_endereco")
	private String endereco_fornecedor;
	
	@NotNull(message="{fornecedor.numero.NotEmpty}")
	@Size(min=1, max=10, message = "{fornecedor.numero.Size}")
	@Column(name = "for_numero")
	private String numero_fornecedor;
	
	@Column(name = "for_complemento")
	private String complemento_fornecedor;
	
	@NotNull(message="{fornecedor.residencial.NotEmpty}")
	@Size(min=10, max=15, message = "{fornecedor.residencial.Size}")
	@Column(name = "for_residencial")
	private String residencial_fornecedor;
	
	@NotNull(message="{fornecedor.celular.NotEmpty}")
	@Size(min=10, max=15, message = "{fornecedor.celular.Size}")
	@Column(name = "for_celular")
	private String celular_fornecedor;
	
	@NotNull(message="{fornecedor.email.NotEmpty}")
	@Size(min=10, max=255, message = "{fornecedor.email.Size}")
	@Column(name = "for_email")
	private String email_fornecedor;
	
	@NotNull(message="{fornecedor.comercial.NotEmpty}")
	@Size(min=10, max=15, message = "{fornecedor.comercial.Size}")
	@Column(name = "for_comercial")
	private String comercial_fornecedor;

	public Long getId_fornecedor() {
		return id_fornecedor;
	}
	
	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */

	
	// MUITOS Banners tem UM Produto
	@ManyToOne
	@JoinColumn(name = "produto_id_produto", insertable=true, updatable=true)
	private Produto produto;
	
	// ENVIA
	//@ManyToMany(fetch = FetchType.LAZY, mappedBy = "fornecedor")
	//private Set<Produto> produto;
	
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	public void setId_fornecedor(Long id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}

	public String getNome_fornecedor() {
		return nome_fornecedor;
	}

	public void setNome_fornecedor(String nome_fornecedor) {
		this.nome_fornecedor = nome_fornecedor;
	}

	public String getCnpj_fornecedor() {
		return cnpj_fornecedor;
	}

	public void setCnpj_fornecedor(String cnpj_fornecedor) {
		this.cnpj_fornecedor = cnpj_fornecedor;
	}

	public String getRazao_fornecedor() {
		return razao_fornecedor;
	}

	public void setRazao_fornecedor(String razao_fornecedor) {
		this.razao_fornecedor = razao_fornecedor;
	}

	public String getObjetivo_fornecedor() {
		return objetivo_fornecedor;
	}

	public void setObjetivo_fornecedor(String objetivo_fornecedor) {
		this.objetivo_fornecedor = objetivo_fornecedor;
	}

	public String getLogo_fornecedor() {
		return logo_fornecedor;
	}

	public void setLogo_fornecedor(String logo_fornecedor) {
		this.logo_fornecedor = logo_fornecedor;
	}

	public String getCep_fornecedor() {
		return cep_fornecedor;
	}

	public void setCep_fornecedor(String cep_fornecedor) {
		this.cep_fornecedor = cep_fornecedor;
	}

	public String getEstado_fornecedor() {
		return estado_fornecedor;
	}

	public void setEstado_fornecedor(String estado_fornecedor) {
		this.estado_fornecedor = estado_fornecedor;
	}

	public String getCidade_fornecedor() {
		return cidade_fornecedor;
	}

	public void setCidade_fornecedor(String cidade_fornecedor) {
		this.cidade_fornecedor = cidade_fornecedor;
	}

	public String getEndereco_fornecedor() {
		return endereco_fornecedor;
	}

	public void setEndereco_fornecedor(String endereco_fornecedor) {
		this.endereco_fornecedor = endereco_fornecedor;
	}

	public String getNumero_fornecedor() {
		return numero_fornecedor;
	}

	public void setNumero_fornecedor(String numero_fornecedor) {
		this.numero_fornecedor = numero_fornecedor;
	}

	public String getComplemento_fornecedor() {
		return complemento_fornecedor;
	}

	public void setComplemento_fornecedor(String complemento_fornecedor) {
		this.complemento_fornecedor = complemento_fornecedor;
	}

	public String getResidencial_fornecedor() {
		return residencial_fornecedor;
	}

	public void setResidencial_fornecedor(String residencial_fornecedor) {
		this.residencial_fornecedor = residencial_fornecedor;
	}

	public String getCelular_fornecedor() {
		return celular_fornecedor;
	}

	public void setCelular_fornecedor(String celular_fornecedor) {
		this.celular_fornecedor = celular_fornecedor;
	}

	public String getEmail_fornecedor() {
		return email_fornecedor;
	}

	public void setEmail_fornecedor(String email_fornecedor) {
		this.email_fornecedor = email_fornecedor;
	}

	public String getComercial_fornecedor() {
		return comercial_fornecedor;
	}

	public void setComercial_fornecedor(String comercial_fornecedor) {
		this.comercial_fornecedor = comercial_fornecedor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
}
