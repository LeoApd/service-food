package br.com.servicefood.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.servicefood.connection.Conexao;
import br.com.servicefood.model.Empresa;

public class EmpresaDAO {
	
	private static final String INSERT = "INSERT INTO EMPRESA (ID_EMPRESA, RAZAO_SOCIAL, CNPJ, LOGIN, SENHA, CEP, RUA, COMPLEMENTO, BAIRRO, CIDADE, UF, NUMERO)" 
			 +"VALUES(SQ_EMPRESA.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
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
	
}
