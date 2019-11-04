package br.com.servicefood.controller;



import javax.faces.bean.ManagedBean;

import br.com.servicefood.model.Cliente;
import br.com.servicefood.model.Endereco;
import br.com.servicefood.model.Login;

@SuppressWarnings("deprecation")
@ManagedBean
public class ControllerCliente {

	private String tipoCliente;
	private String tipoEmpresa;
	private Cliente cliente = new Cliente();
	private Endereco endereco = new Endereco();
	private Login login = new Login();
	private String response = "";

	public String save() {
		response = "";
		cliente.setEndereco(endereco);
		cliente.setLogin(login);
		if(cliente.save())
			response = "Cadastro realizado com sucesso!!";
		else
			response = "Erro ao cadastrar o usário tente novamente!!";
		return "cadastro";
	}
	
	public String montarTelaPerfil(long id) {
		Cliente clienteDB = new Cliente();
		cliente = clienteDB.find(id);
		return "";
	}
	
	public String editar() {
		return "";
	}
	
	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getTipoEmpresa() {
		return tipoEmpresa;
	}

	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
