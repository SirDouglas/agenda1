package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.exception.DaoException;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {
private Connection connection;
public ContatoDao() {
		this.connection = new ConnectionFactory().getConnetion();
}

public ContatoDao(Connection connection) {
	this.connection = connection;
}
public void adiciona(Contato contato) {
	String sql = "insert into contatos "
			+ "(nome,email,endereco,dataNascimento)"
			+ "values (?,?,?,?)";
	try {
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
		
		stmt.execute();
		stmt.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new DaoException(e); 
		 
	}
	
	
}

public List<Contato> getLista() {
	List<Contato> contatos = new ArrayList<>();
	try {
		PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Contato contato = new Contato();
			contato.setId(rs.getLong("id"));
			contato.setNome(rs.getString("nome"));
			contato.setEmail(rs.getString("email"));
			contato.setEndereco(rs.getString("endereco"));
			
			Calendar instance = Calendar.getInstance();
			instance.setTime(rs.getDate("dataNascimento"));
			contato.setDataNascimento(instance);
			contatos.add(contato);
			
		}
		
		rs.close();
		stmt.close();
		return contatos;	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new DaoException(e); 
	}
	
	
}

public Contato pesquisa(long id) {
	Contato contato = new Contato();
	try {
		PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where id =?");
		stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			contato.setId(rs.getLong("id"));
			contato.setNome(rs.getString("nome"));
		contato.setEmail(rs.getString("email"));
		contato.setEndereco(rs.getString("endereco"));
		
		Calendar data = Calendar.getInstance();
		data.setTime(rs.getDate("dataNascimento"));
		contato.setDataNascimento(data);
					
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new DaoException(e);
	}
	return contato;
	
}

public void altera(Contato contato) {
	String sql = "update contatos set nome=?, email=?,"
			+ "endereco=?,dataNascimento=? where id=?";
	try {
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
		stmt.setLong(5, contato.getId());
		stmt.execute();
		stmt.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
	 throw new RuntimeException(e);
	}
}

public void remove(Contato contato) {
	String sql = "delete from contatos where id=?";
	try {
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setLong(1, contato.getId());
		stmt.execute();
		stmt.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new RuntimeException(e);
	}
}

}
