package br.com.servicefood.controller;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.servicefood.model.Combo;

@ManagedBean
public class ControllerCombo {
	
	private Combo combo = new Combo();

	private String response;

	public String enviarId(long id) {
		return "/restricted/produto/detalheComboEmpresa.xhtml?faces-redirect=true&amp;id="+id;
	}
	
	public ArrayList<Combo> listarAll(long id){
		try {
			
			ArrayList<Combo> combos = combo.listarAll(id);
			return combos;
			
		}catch(NullPointerException e) {
			
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Essa empresa não possui combo cadastrado",""));
			context.getExternalContext().getFlash().setKeepMessages(true);
			return null;
			
		}
	}
	
	public String save(long id) {
		combo.setEmpresa(id);
		if(combo.save()) 
			response = "Combo cadastrado com sucesso";
		else
			response = "ERRO: Não foi possivel realizar o cadastro";
		
		return "/restricted/produto/cadastrarCombo.xhtml?faces-redirect=true";
	}
	
	public Combo getCombo() {
		return combo;
	}

	public void setCombo(Combo combo) {
		this.combo = combo;
	}
	
	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

}
