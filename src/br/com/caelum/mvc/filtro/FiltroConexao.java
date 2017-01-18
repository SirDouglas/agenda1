package br.com.caelum.mvc.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.caelum.jdbc.ConnectionFactory;

@WebFilter("/*")
public class FiltroConexao implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		try {
		Connection connetion = new ConnectionFactory().getConnetion();
		
		req.setAttribute("conexao", connetion);
		
		chain.doFilter(req, resp);
		
		connetion.close();
		} catch (SQLException e) {
			throw new ServletException(e);
		
		}
	}

}
