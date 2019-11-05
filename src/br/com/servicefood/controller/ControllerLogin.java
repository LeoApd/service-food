package br.com.servicefood.controller;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.servicefood.model.CurrentUser;
import br.com.servicefood.model.Login;


@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class ControllerLogin {
	
	private static final String EMPRESA = "empresa";
	private static final String CLIENTE = "cliente";
	
	private Login login = new Login();
	private CurrentUser currentUser = new CurrentUser();
	private boolean isLoggerIn;
	private String tipoLogin;
	FacesContext context = null;
	
	public String login() {
		context = FacesContext.getCurrentInstance();
		if(tipoLogin != null) {
			if(tipoLogin.equalsIgnoreCase(CLIENTE)) {
				CurrentUser user = new CurrentUser();
				user = currentUser.loginCliente(login);
				if(user == null) {
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou senha incorretos",""));
					//salvar a mensagem no scopo flash para colocar na tela
					context.getExternalContext().getFlash().setKeepMessages(true);
					return "/login/login.xhtml";
				}else {
					currentUser.setId(user.getId());
					currentUser.setNome(user.getNome());
					isLoggerIn = true;
					return "/restricted/template/indexClienteAuth.xhtml?faces-redirect=true";
				}
			}
			
			if(tipoLogin.equalsIgnoreCase(EMPRESA)) {
				CurrentUser user = new CurrentUser();
				user = currentUser.loginEmpresa(login);
				if(user == null) {
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou senha incorretos",""));
					//salvar a mensagem no scopo flash para colocar na tela
					context.getExternalContext().getFlash().setKeepMessages(true);
					return "/login/login.xhtml";
				}else {
					currentUser.setId(user.getId());
					currentUser.setNome(user.getNome());
					isLoggerIn = true;
					return "/restricted/template/indexEmpresaAuth.xhtml?faces-redirect=true";
				}
			}
		}
		
		return null;
	}
	
	
	public String deslogar() {
		isLoggerIn = false;
		login = null;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession)context.getExternalContext().getSession(false);
		session.invalidate();
		return "/login/login.xthml?faces-redirect=true&amp";
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public boolean isLoggerIn() {
		return isLoggerIn;
	}

	public void setLoggerIn(boolean isLoggerIn) {
		this.isLoggerIn = isLoggerIn;
	}

	public String getTipoLogin() {
		return tipoLogin;
	}

	public void setTipoLogin(String tipoLogin) {
		this.tipoLogin = tipoLogin;
	}
	
	public CurrentUser getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(CurrentUser currentUser) {
		this.currentUser = currentUser;
	}
	
	
}
