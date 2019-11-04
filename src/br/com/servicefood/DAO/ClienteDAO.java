package br.com.servicefood.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.servicefood.connection.Conexao;
import br.com.servicefood.model.Cliente;
import br.com.servicefood.model.Endereco;
import br.com.servicefood.model.Login;

public class ClienteDAO{
	
	private static final String INSERT = "INSERT INTO CLIENTE (ID_CLIENTE, NOME, SOBRENOME, CPF, RG, EMAIL, LOGIN, SENHA, CEP, RUA, COMPLEMENTO, BAIRRO, CIDADE, UF, NUMERO)" + 
										 " VALUES(SQ_CLIENTE.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SELECT_ID = "SELECT * FROM CLIENTE WHERE ID_CLIENTE = ?";
	Connection conn = null;
	
	public boolean save(Cliente cliente) {
		conn = Conexao.getConnection();
		PreparedStatement stmt = null;
		try {
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(INSERT);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getSobrenome());
			stmt.setString(3, cliente.getCpf());
			stmt.setString(4, cliente.getRg());
			stmt.setString(5, cliente.getEmail());
			stmt.setString(6, cliente.getLogin().getLogin());
			stmt.setString(7, cliente.getLogin().getSenha());
			stmt.setString(8, cliente.getEndereco().getCep());
			stmt.setString(9, cliente.getEndereco().getRua());
			stmt.setString(10, cliente.getEndereco().getComplemento());
			stmt.setString(11, cliente.getEndereco().getBairro());
			stmt.setString(12, cliente.getEndereco().getCidade());
			stmt.setString(13, cliente.getEndereco().getUf());
			stmt.setString(14, cliente.getEndereco().getNumero());
			
			if(stmt.executeUpdate() > 0) {
				conn.commit();
				return true;
			}else {
				conn.rollback();
				return false;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}finally {
			Conexao.closeConnection(conn, stmt);
		}
	}

	public Cliente find(long id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Cliente cliente = null;
		Login login = null;
		Endereco endereco = null;
		try {
			conn = Conexao.getConnection();
			stmt = conn.prepareStatement(SELECT_ID);
			stmt.setLong(1, id);
			
			rs = stmt.executeQuery();
		
			if(rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getLong("ID_CLIENTE"));
				cliente.setNome(rs.getString("NOME"));
				cliente.setCpf(rs.getString("CPF"));
				cliente.setEmail(rs.getString("EMAIL"));
				cliente.setRg(rs.getString("RG"));
				cliente.setSobrenome(rs.getString("SOBRENOME"));
				
				endereco = new Endereco();
				endereco.setUf(rs.getString("UF"));
				endereco.setBairro(rs.getString("BAIRRO"));
				endereco.setCidade(rs.getString("CIDADE"));
				endereco.setCep(rs.getString("CEP"));
				endereco.setNumero(rs.getString("NUMERO"));
				endereco.setComplemento(rs.getString("COMPLEMENTO"));
				cliente.setEndereco(endereco);
				
				login = new Login();
				login.setLogin(rs.getString("LOGIN"));
				login.setSenha(rs.getString("SENHA"));
				cliente.setLogin(login);
				
				return cliente;
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
}
