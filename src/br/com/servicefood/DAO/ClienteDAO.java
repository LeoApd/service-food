package br.com.servicefood.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.servicefood.connection.Conexao;
import br.com.servicefood.model.Cliente;

public class ClienteDAO{
	
	private static final String INSERT = "INSERT INTO CLIENTE (ID_CLIENTE, NOME, SOBRENOME, CPF, RG, EMAIL, LOGIN, SENHA, CEP, RUA, COMPLEMENTO, BAIRRO, CIDADE, UF, NUMERO)" + 
										 " VALUES(SQ_CLIENTE.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
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
	
}
