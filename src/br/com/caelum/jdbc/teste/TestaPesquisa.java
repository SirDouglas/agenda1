package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaPesquisa {
public static void main(String[] args) {
	ContatoDao dao = new ContatoDao();
	
	Contato contato = dao.pesquisa(1);
	System.out.println(contato.getId());
	System.out.println(contato.getNome());
	System.out.println(contato.getEmail());
	System.out.println(contato.getEndereco());
	SimpleDateFormat dateFormat = new SimpleDateFormat("D/M/Y");
	System.out.println(dateFormat.format(contato.getDataNascimento().getTime()));
}
}
