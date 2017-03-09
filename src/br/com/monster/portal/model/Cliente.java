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

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue
	private Long id_cliente;
	
	@NotNull(message="{cliente.nome.NotEmpty}")
	@Size(min=5, max=200, message = "{cliente.nome.Size}")
	@Column(name = "cli_nome")			
	private String nome_cliente;
	
	@Column(name = "cli_razao")
	private String razao_cliente;
	
	@Column(name = "cli_objetivo")
	private String objetivo_cliente;
	
	@Column (name = "cli_cpf")
	private String cpf_cliente;
	
	@Column(name = "cli_cnpj")
	private String cnpj_cliente;
	
	@Column(name = "cli_sexo")
	private String sexo_cliente;
	
	@NotNull
	@Column(name = "cli_ativo")
	private boolean ativo_cliente;
	
	@NotNull(message="{cliente.usuario.NotEmpty}")
	@Size(min=4, max=255, message = "{cliente.usuario.Size}")
	@Column(name = "cli_usuario")
	private String usuario_cliente;
	
	@NotNull(message="{cliente.senha.NotEmpty}")
	@Size(min=6, max=255, message = "{cliente.senha.Size}")
	@Column(name = "cli_senha")
	private String senha_cliente;
	
	@NotNull
	@Column(name = "cli_news_letter")
	private boolean news_letter_cliente;
	
	@NotNull(message="{cliente.cep.NotEmpty}")
	@Size(max=9, message = "{cliente.cep.Size}")
	@Column(name = "cli_cep")
	private String cep_cliente;
	
	@NotNull(message="{cliente.estado.NotEmpty}")
	@Size(min=2, max=20, message = "{cliente.estado.Size}")
	@Column(name = "cli_estado")
	private String estado_cliente;
	
	@NotNull(message="{cliente.cidade.NotEmpty}")
	@Size(min=3, max=50, message = "{cliente.cidade.Size}")
	@Column(name = "cli_cidade")
	private String cidade_cliente;
	
	@NotNull(message="{cliente.endereco.NotEmpty}")
	@Size(min=3, max=50, message = "{cliente.endereco.Size}")
	@Column(name = "cli_endereco")
	private String endereco_cliente;
	
	@NotNull(message="{cliente.numero.NotEmpty}")
	@Size(min=1, max=10, message = "{cliente.numero.Size}")
	@Column(name = "cli_numero")
	private String numero_cliente;
	
	@Column(name = "cli_complemento")
	private String complemento_cliente;
	
	@NotNull(message="{cliente.residencial.NotEmpty}")
	@Size(min=10, max=15, message = "{cliente.residencial.Size}")
	@Column(name = "cli_residencial")
	private String residencial_cliente;
	
	@Size(min=8, max=15, message = "{cliente.celular.Size}")
	@Column(name = "cli_celular")
	private String celular_cliente;
	
	@NotNull(message="{cliente.email.NotEmpty}")
	@Size(min=10, max=255, message = "{cliente.email.Size}")
	@Column(name = "cli_email")
	private String email_cliente;
	
	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="cliente", fetch=FetchType.EAGER)
	private Set<Acessos> acessos;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/
	
	public Set<Acessos> getAcessos() {
		return acessos;
	}

	public void setAcessos(Set<Acessos> acessos) {
		this.acessos = acessos;
	}

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getRazao_cliente() {
		return razao_cliente;
	}

	public void setRazao_cliente(String razao_cliente) {
		this.razao_cliente = razao_cliente;
	}

	public String getObjetivo_cliente() {
		return objetivo_cliente;
	}

	public void setObjetivo_cliente(String objetivo_cliente) {
		this.objetivo_cliente = objetivo_cliente;
	}

	public String getCpf_cliente() {
		return cpf_cliente;
	}

	public void setCpf_cliente(String cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}

	public String getCnpj_cliente() {
		return cnpj_cliente;
	}

	public void setCnpj_cliente(String cnpj_cliente) {
		this.cnpj_cliente = cnpj_cliente;
	}

	public String getSexo_cliente() {
		return sexo_cliente;
	}

	public void setSexo_cliente(String sexo_cliente) {
		this.sexo_cliente = sexo_cliente;
	}

	public boolean isAtivo_cliente() {
		return ativo_cliente;
	}

	public void setAtivo_cliente(boolean ativo_cliente) {
		this.ativo_cliente = ativo_cliente;
	}

	public String getUsuario_cliente() {
		return usuario_cliente;
	}

	public void setUsuario_cliente(String usuario_cliente) {
		this.usuario_cliente = usuario_cliente;
	}

	public String getSenha_cliente() {
		return senha_cliente;
	}

	public void setSenha_cliente(String senha_cliente) {
		this.senha_cliente = senha_cliente;
	}

	public boolean isNews_letter_cliente() {
		return news_letter_cliente;
	}

	public void setNews_letter_cliente(boolean news_letter_cliente) {
		this.news_letter_cliente = news_letter_cliente;
	}

	public String getCep_cliente() {
		return cep_cliente;
	}

	public void setCep_cliente(String cep_cliente) {
		this.cep_cliente = cep_cliente;
	}

	public String getEstado_cliente() {
		return estado_cliente;
	}

	public void setEstado_cliente(String estado_cliente) {
		this.estado_cliente = estado_cliente;
	}

	public String getCidade_cliente() {
		return cidade_cliente;
	}

	public void setCidade_cliente(String cidade_cliente) {
		this.cidade_cliente = cidade_cliente;
	}

	public String getEndereco_cliente() {
		return endereco_cliente;
	}

	public void setEndereco_cliente(String endereco_cliente) {
		this.endereco_cliente = endereco_cliente;
	}

	public String getNumero_cliente() {
		return numero_cliente;
	}

	public void setNumero_cliente(String numero_cliente) {
		this.numero_cliente = numero_cliente;
	}

	public String getComplemento_cliente() {
		return complemento_cliente;
	}

	public void setComplemento_cliente(String complemento_cliente) {
		this.complemento_cliente = complemento_cliente;
	}

	public String getResidencial_cliente() {
		return residencial_cliente;
	}

	public void setResidencial_cliente(String residencial_cliente) {
		this.residencial_cliente = residencial_cliente;
	}

	public String getCelular_cliente() {
		return celular_cliente;
	}

	public void setCelular_cliente(String celular_cliente) {
		this.celular_cliente = celular_cliente;
	}

	public String getEmail_cliente() {
		return email_cliente;
	}

	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}
	
	
}
