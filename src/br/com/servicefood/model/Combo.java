package br.com.servicefood.model;

import java.util.ArrayList;

import br.com.servicefood.DAO.ComboDAO;

public class Combo extends ComboDAO{
	
	private long id;
	private String nome;
	private String descricao;
	private long valorUnitario;
	private long empresa;
	
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
	
	public long getEmpresa() {
		return empresa;
	}
	public void setEmpresa(long empresa) {
		this.empresa = empresa;
	}
	public ArrayList<Combo> listarAll(long id) {	
		return super.listarAll(id);
	}
	public boolean save() {
		return super.save(this);
	}
	
	
}
