package br.com.caelum.jdbc.exception;

import java.sql.SQLException;

public class DaoException  extends RuntimeException{

	public DaoException(SQLException e) {
		System.out.println("Ocorreu um erro " + e);
	}
	

}
