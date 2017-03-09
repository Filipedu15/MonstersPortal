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
@Table(name = "funcionario")
public class Funcionario {

	@Id //Chave Primaria /*
	@GeneratedValue
	private Long id_funcionario;
	
	@NotNull
	@Size(min=5, message = "O campo nome deve ter no mínimo 5 caracteres")
	@Column(name = "fun_nome")
	private String nome_funcionario;
	
	@NotNull
	@Column(name = "fun_rg")
	private String rg_funcionario;
	
	@NotNull
	@Column(name = "fun_cpf")
	private String cpf_funcionario;
	
	@NotNull
	@Column(name = "fun_bloqueado")
	private boolean bloqueado_funcionario;
	
	@NotNull
	@Column(name = "fun_foto")
	private String foto_funcionario;
	
	@NotNull
	@Column(name = "fun_cep")
	private String cep_funcionario;
	
	@NotNull
	@Column(name = "fun_estado")
	private String estado_funcionario;
	
	@NotNull
	@Column(name = "fun_cidade")
	private String cidade_funcionario;
	
	@NotNull
	@Column(name = "fun_endereco")
	private String endereco_funcionario;
	
	@NotNull
	@Column(name = "fun_numero")
	private String numero_funcionario;
	
	@Column(name = "fun_complemento")
	private String complemento_funcionario;
	
	@NotNull
	@Column(name = "fun_residencial")
	private String residencial_funcionario;
	
	@NotNull
	@Column(name = "fun_celular")
	private String celular_funcionario;
	
	@NotNull
	@Column(name = "fun_email")
	private String email_funcionario;

	@NotNull
	@Column(name = "fun_usuario")
	private String usuario_funcionario;
	
	@NotNull
	@Column(name = "fun_senha")
	private String senha_funcionario;

	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */

	@ManyToOne
	@JoinColumn(name = "cargo_id_cargo")
	private Cargo cargo;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Long getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(Long id_funcionario) {
		this.id_funcionario = id_funcionario;
	}


	public String getNome_funcionario() {
		return nome_funcionario;
	}

	public void setNome_funcionario(String nome_funcionario) {
		this.nome_funcionario = nome_funcionario;
	}

	public String getRg_funcionario() {
		return rg_funcionario;
	}

	public void setRg_funcionario(String rg_funcionario) {
		this.rg_funcionario = rg_funcionario;
	}

	public String getCpf_funcionario() {
		return cpf_funcionario;
	}

	public void setCpf_funcionario(String cpf_funcionario) {
		this.cpf_funcionario = cpf_funcionario;
	}

	public boolean isBloqueado_funcionario() {
		return bloqueado_funcionario;
	}

	public void setBloqueado_funcionario(boolean bloqueado_funcionario) {
		this.bloqueado_funcionario = bloqueado_funcionario;
	}

	public String getFoto_funcionario() {
		return foto_funcionario;
	}

	public void setFoto_funcionario(String foto_funcionario) {
		this.foto_funcionario = foto_funcionario;
	}

	public String getCep_funcionario() {
		return cep_funcionario;
	}

	public void setCep_funcionario(String cep_funcionario) {
		this.cep_funcionario = cep_funcionario;
	}

	public String getEstado_funcionario() {
		return estado_funcionario;
	}

	public void setEstado_funcionario(String estado_funcionario) {
		this.estado_funcionario = estado_funcionario;
	}

	public String getCidade_funcionario() {
		return cidade_funcionario;
	}

	public void setCidade_funcionario(String cidade_funcionario) {
		this.cidade_funcionario = cidade_funcionario;
	}

	public String getEndereco_funcionario() {
		return endereco_funcionario;
	}

	public void setEndereco_funcionario(String endereco_funcionario) {
		this.endereco_funcionario = endereco_funcionario;
	}

	public String getNumero_funcionario() {
		return numero_funcionario;
	}

	public void setNumero_funcionario(String numero_funcionario) {
		this.numero_funcionario = numero_funcionario;
	}

	public String getComplemento_funcionario() {
		return complemento_funcionario;
	}

	public void setComplemento_funcionario(String complemento_funcionario) {
		this.complemento_funcionario = complemento_funcionario;
	}

	public String getResidencial_funcionario() {
		return residencial_funcionario;
	}

	public void setResidencial_funcionario(String residencial_funcionario) {
		this.residencial_funcionario = residencial_funcionario;
	}

	public String getCelular_funcionario() {
		return celular_funcionario;
	}

	public void setCelular_funcionario(String celular_funcionario) {
		this.celular_funcionario = celular_funcionario;
	}

	public String getEmail_funcionario() {
		return email_funcionario;
	}

	public void setEmail_funcionario(String email_funcionario) {
		this.email_funcionario = email_funcionario;
	}
	
	public String getUsuario_funcionario() {
		return usuario_funcionario;
	}

	public void setUsuario_funcionario(String usuario_funcionario) {
		this.usuario_funcionario = usuario_funcionario;
	}

	public String getSenha_funcionario() {
		return senha_funcionario;
	}

	public void setSenha_funcionario(String senha_funcionario) {
		this.senha_funcionario = senha_funcionario;
	}
}
