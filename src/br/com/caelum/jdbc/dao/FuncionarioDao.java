package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Funcionario;

public class FuncionarioDao {
	private Connection connection;
public FuncionarioDao() {
 this.connection = new ConnectionFactory().getConnetion();
}

public void adiciona(Funcionario funcionario) {
	String sql = "insert into funcionarios "
			+ "(nome,usuario,senha) values (?,?,?)";
	try {
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, funcionario.getNome());
		stmt.setString(2, funcionario.getUsuario());
		stmt.setString(3, funcionario.getSenha());
		stmt.execute();
		stmt.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new RuntimeException(e);
	}
	
}

public List<Funcionario> lista() {
	String sql = "select * from funcionarios";
	List<Funcionario> funcionarios = new ArrayList<>();
	
	try {
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Funcionario funcionario = new Funcionario();
			funcionario.setId(rs.getLong("id"));
			funcionario.setNome(rs.getString("nome"));
			funcionario.setUsuario(rs.getString("usuario"));
			funcionario.setSenha(rs.getString("senha"));
			funcionarios.add(funcionario);
		}
		rs.close();
		stmt.close();
		return funcionarios;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new RuntimeException(e);
		
	}

}

public Funcionario pesquisa(Long id) {
	String sql = "select * from funcionarios where id=?";
	Funcionario funcionario = new Funcionario();
	try {
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			funcionario.setId(rs.getLong("id"));
			funcionario.setNome(rs.getString("nome"));
			funcionario.setUsuario(rs.getString("usuario"));
			funcionario.setSenha(rs.getString("senha"));
		}
		return funcionario;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new RuntimeException(e);
	}
	
	
	
}

public void altera(Funcionario funcionario) {
	String sql = "update funcionarios set nome=?,usuario=?,senha=?";
	try {
		PreparedStatement stmt = connection.prepareStatement(sql);
	     stmt.setString(1, funcionario.getNome());
	     stmt.setString(2, funcionario.getUsuario());
	     stmt.setString(3, funcionario.getSenha());
		stmt.execute();
		stmt.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new RuntimeException(e);
	}	
}

public void remove(Funcionario funcionario) {
	String sql = "delete from funcionarios where id=?";
	try {
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setLong(1, funcionario.getId());
		stmt.execute();
		stmt.close();
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
}



}
