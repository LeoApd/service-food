package br.com.servicefood.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.servicefood.connection.Conexao;
import br.com.servicefood.model.Combo;

public class ComboDAO {
	
	Connection conn = null;
	
	private static final String SELECT_ID = "SELECT * FROM COMBO WHERE ID_EMPRESA = ?";
	private static final String INSERT = "INSERT INTO COMO (ID_COMBO, ID_EMPRESA, NOME, DESCRICAO, VALOR_UNITARIO) VALUES(SQ_COMBO.NEXTVAL, ?, ?, ? ,?)";
	
	public ArrayList<Combo> listarAll(long id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Combo> combos = new ArrayList<Combo>();
		Combo combo = null;
		try {
			conn = Conexao.getConnection();
			stmt = conn.prepareStatement(SELECT_ID);
			stmt.setLong(1, id);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				combo = new Combo();
				combo.setId(rs.getLong("ID_COMBO"));
				combo.setEmpresa(rs.getLong("ID_EMPRESA"));
				combo.setNome(rs.getString("NOME"));
				combo.setValorUnitario(rs.getLong("VALOR_UNITARIO"));
				combo.setDescricao(rs.getString("DESCRICAO"));
				
				combos.add(combo);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return combos;
	}

	public boolean save(Combo combo) {
		conn = Conexao.getConnection();
		PreparedStatement stmt = null;
		try {
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(INSERT);
			stmt.setLong(1, combo.getEmpresa());
			stmt.setString(2, combo.getNome());
			stmt.setString(3, combo.getDescricao());
			stmt.setLong(4, combo.getValorUnitario());
			
			stmt.executeUpdate();
			return true;
				
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}finally {
			Conexao.closeConnection(conn, stmt);
		}
	}
	
}
