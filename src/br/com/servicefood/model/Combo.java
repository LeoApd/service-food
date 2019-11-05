package br.com.servicefood.model;

import br.com.servicefood.DAO.ComboDAO;

public class Combo extends ComboDAO{
	
	private long id;
	private String nome;
	private String descricao;
	private long valorUnitario;
	private Empresa empresa;
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public long getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(long valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
}
