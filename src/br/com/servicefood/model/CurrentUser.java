package br.com.servicefood.model;

import br.com.servicefood.DAO.UserAuthDAO;

public class CurrentUser extends UserAuthDAO{
	
	private long id;
	private String nome;
	
	
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
	
	public CurrentUser loginCliente(Login login) {
		return super.loginCliente(login);
	}
	public CurrentUser loginEmpresa(Login login) {
		return super.loginEmpresa(login);
	}	
}
