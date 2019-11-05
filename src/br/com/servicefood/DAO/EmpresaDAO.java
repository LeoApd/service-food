package br.com.servicefood.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.servicefood.connection.Conexao;
import br.com.servicefood.model.Empresa;
import br.com.servicefood.model.Endereco;
import br.com.servicefood.model.Login;

public class EmpresaDAO {
	
	private static final String INSERT = "INSERT INTO EMPRESA (ID_EMPRESA, RAZAO_SOCIAL, CNPJ, LOGIN, SENHA, CEP, RUA, COMPLEMENTO, BAIRRO, CIDADE, UF, NUMERO)" 
			 +"VALUES(SQ_EMPRESA.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SELECT_ID = "SELECT * FROM EMPRESA WHERE ID_EMPRESA = ?";
	private static final String UPDATE = "UPDATE EMPRESA SET RAZAO_SOCIAL = ?, CNPJ = ?, LOGIN = ?, SENHA = ?, CEP = ?, RUA = ?, COMPLEMENTO = ?, BAIRRO = ?, CIDADE = ?, UF = ?, NUMERO = ? WHERE ID_EMPRESA = ?";
	private static final String SELECT_ALL = "SELECT * FROM EMPRESA";
	
	Connection conn = null;
	
	public EmpresaDAO(){
		
	}
	
	public boolean save(Empresa empresa) {
		PreparedStatement stmt = null;
		conn = Conexao.getConnection();
		try {
			stmt = conn.prepareStatement(INSERT);
			stmt.setString(1, empresa.getRazaoSocial());
			stmt.setString(2, empresa.getCnpj());
			stmt.setString(3, empresa.getLogin().getLogin());
			stmt.setString(4, empresa.getLogin().getSenha());
			stmt.setString(5, empresa.getEndereco().getCep());
			stmt.setString(6, empresa.getEndereco().getRua());
			stmt.setString(7, empresa.getEndereco().getComplemento());
			stmt.setString(8, empresa.getEndereco().getBairro());
			stmt.setString(9, empresa.getEndereco().getCidade());
			stmt.setString(10, empresa.getEndereco().getUf());
			stmt.setString(11, empresa.getEndereco().getNumero());
			
			stmt.executeQuery();
			
			return true;
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}finally {
			Conexao.closeConnection(conn, stmt);
		}
		
	}

	public Empresa find(long id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Empresa empresa = null;
		Login login = null;
		Endereco endereco = null;
		try {
			conn = Conexao.getConnection();
			stmt = conn.prepareStatement(SELECT_ID);
			stmt.setLong(1, id);
			
			rs = stmt.executeQuery();
		
			if(rs.next()) {
				empresa = new Empresa();
				empresa.setId(rs.getLong("ID_EMPRESA"));
				empresa.setRazaoSocial(rs.getString("RAZAO_SOCIAL"));
				empresa.setCnpj(rs.getString("CNPJ"));
				
				endereco = new Endereco();
				endereco.setUf(rs.getString("UF"));
				endereco.setBairro(rs.getString("BAIRRO"));
				endereco.setCidade(rs.getString("CIDADE"));
				endereco.setCep(rs.getString("CEP"));
				endereco.setNumero(rs.getString("NUMERO"));
				endereco.setComplemento(rs.getString("COMPLEMENTO"));
				empresa.setEndereco(endereco);
				
				login = new Login();
				login.setLogin(rs.getString("LOGIN"));
				login.setSenha(rs.getString("SENHA"));
				empresa.setLogin(login);
				
				return empresa;
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}

	public boolean update(Empresa empresa) {
		conn = Conexao.getConnection();
		PreparedStatement stmt = null;
		try {
	
			stmt = conn.prepareStatement(UPDATE);
			stmt.setString(1, empresa.getRazaoSocial());
			stmt.setString(2, empresa.getCnpj());
			stmt.setString(3, empresa.getLogin().getLogin());
			stmt.setString(4, empresa.getLogin().getSenha());
			stmt.setString(5, empresa.getEndereco().getCep());
			stmt.setString(6, empresa.getEndereco().getRua());
			stmt.setString(7, empresa.getEndereco().getComplemento());
			stmt.setString(8, empresa.getEndereco().getBairro());
			stmt.setString(9, empresa.getEndereco().getCidade());
			stmt.setString(10, empresa.getEndereco().getUf());
			stmt.setString(11, empresa.getEndereco().getNumero());
			stmt.setLong(12, empresa.getId());
			
			stmt.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}finally {
			Conexao.closeConnection(conn, stmt);
		}
	}

	public ArrayList<Empresa> listarAll() {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Empresa> empresas = new ArrayList<Empresa>();
		Empresa empresa = null;
		try {
			conn = Conexao.getConnection();
			stmt = conn.prepareStatement(SELECT_ALL);
			rs = stmt.executeQuery();
			while(rs.next()) {
				empresa = new Empresa();
				empresa.setId(rs.getLong("ID_EMPRESA"));
				empresa.setRazaoSocial(rs.getString("RAZAO_SOCIAL"));
				empresa.setCnpj(rs.getString("CNPJ"));
				
				empresas.add(empresa);
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return empresas;
	}
	
}
