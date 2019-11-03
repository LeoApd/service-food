package br.com.servicefood.controller;

import javax.faces.bean.ManagedBean;

import br.com.servicefood.model.Login;

@SuppressWarnings("deprecation")
@ManagedBean
public class ControllerLogin {
	
	private Login login = new Login();

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	

}
