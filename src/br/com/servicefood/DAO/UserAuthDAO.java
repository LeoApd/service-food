package br.com.servicefood.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.servicefood.connection.Conexao;
import br.com.servicefood.model.CurrentUser;
import br.com.servicefood.model.Login;

public class UserAuthDAO {
	
	private static final String LOGIN_CLIENTE = "SELECT * FROM CLIENTE WHERE LOGIN = ? AND SENHA = ?";
	private static final String LOGIN_EMPRESA = "SELECT * FROM EMPRESA WHERE LOGIN = ? AND SENHA = ?";
	
	Connection conn = null;
	
	public CurrentUser loginCliente(Login login) {
		PreparedStatement stmt = null;
		CurrentUser currentUser = null;
		ResultSet rs = null;
		try {
			conn = Conexao.getConnection();
			stmt = conn.prepareStatement(LOGIN_CLIENTE);
			stmt.setString(1, login.getLogin());
			stmt.setString(2, login.getSenha());
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				currentUser = new CurrentUser();
				currentUser.setId(rs.getLong("ID_CLIENTE"));
				currentUser.setNome(rs.getString("NOME"));
				
				return currentUser;
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			Conexao.closeConnection(conn, stmt, rs);
		}
		return currentUser;
		
	}

	public CurrentUser loginEmpresa(Login login) {
		PreparedStatement stmt = null;
		CurrentUser currentUser = null;
		ResultSet rs = null;
		try {
			conn = Conexao.getConnection();
			stmt = conn.prepareStatement(LOGIN_EMPRESA);
			stmt.setString(1, login.getLogin());
			stmt.setString(2, login.getSenha());
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				currentUser = new CurrentUser();
				currentUser.setId(rs.getLong("ID_EMPRESA"));
				currentUser.setNome(rs.getString("RAZAO_SOCIAL"));
				
				return currentUser;
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			Conexao.closeConnection(conn, stmt, rs);
		}
		return currentUser;
	}
}
