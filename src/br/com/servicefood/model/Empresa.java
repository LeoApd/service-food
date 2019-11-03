package br.com.servicefood.model;

import br.com.servicefood.DAO.EmpresaDAO;

public class Empresa extends EmpresaDAO{

	private long id;
	private String razaoSocial;
	private String cnpj;
	private Endereco endereco;
	private Login login;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	
	public boolean save() {
		return super.save(this);
	}
	
	
	
}
