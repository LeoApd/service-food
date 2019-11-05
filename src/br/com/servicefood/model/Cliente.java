
package br.com.servicefood.model;

import br.com.servicefood.DAO.ClienteDAO;

public class Cliente extends ClienteDAO{
	
	private long id;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String rg;
	private String email;
	private Login login;
	private Endereco endereco;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public boolean save() {
		return super.save(this);
	}
	
	public Cliente find(long id) {
		Cliente cliente = super.find(id);
		return cliente;
	}
	public boolean update(Cliente cliente) {
		return super.update(cliente);	
	}
	
	
}
