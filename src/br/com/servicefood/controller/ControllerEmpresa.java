package br.com.servicefood.controller;

import javax.faces.bean.ManagedBean;

import br.com.servicefood.model.Empresa;
import br.com.servicefood.model.Endereco;
import br.com.servicefood.model.Login;

@SuppressWarnings("deprecation")
@ManagedBean
public class ControllerEmpresa {
	
	private Empresa empresa = new Empresa();
	private Endereco endereco = new Endereco();
	private Login login = new Login();
	private String response = "";
	
	public String save() {
		empresa.setEndereco(endereco);
		empresa.setLogin(login);
		if(empresa.save()) 
			response = "Empresa cadastrada com sucesso";
		else
			response = "ERRO: Não foi possivel realizar o cadastro";
		
		return "cadastro";
		
		
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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
	
	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
}
