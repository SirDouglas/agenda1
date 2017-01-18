package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.caelum.jdbc.ConnectionFactory;

public class TestaConexao {
public static void main(String[] args) throws SQLException {
	Connection conexao = new ConnectionFactory().getConnetion();
	System.out.println("Conexao Aberta");
		conexao.close();
	
	
	
}
}
