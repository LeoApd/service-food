package br.com.servicefood.controller;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.servicefood.model.Cliente;
import br.com.servicefood.model.Empresa;
import br.com.servicefood.model.Endereco;
import br.com.servicefood.model.Login;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
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

	public String montarTelaPerfil(long id) {
		Empresa empresaDB = new Empresa();
		empresa = empresaDB.find(id);
		this.endereco = empresa.getEndereco();
		this.login = empresa.getLogin();
		this.empresa = empresa;
		return "/restricted/editarPerfil/perfilEmpresa.xhtml?faces-redirect=true";
	}
	
	public String update(long id) {
		empresa.setId(id);
		empresa.setEndereco(endereco);
		empresa.setLogin(login);
		if(empresa.update(empresa)) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário alterado com sucesso",""));
			context.getExternalContext().getFlash().setKeepMessages(true);
			return "/restricted/editarPerfil/perfilCliente.xhtml?faces-redirect=true";
		}
	
		return "/restricted/editarPerfil/perfilCliente.xhtml?faces-redirect=true";
	}
	
	public ArrayList<Empresa> listarAll(){
		Empresa empresaDB = new Empresa();
		ArrayList<Empresa> empresas = empresaDB.listarAll();
		if(empresas != null) {
			return empresas;
		}
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sem empresa cadastradas", ""));
		context.getExternalContext().getFlash().setKeepMessages(true);
		
		return null;
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
