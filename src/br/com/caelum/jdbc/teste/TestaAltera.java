package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaAltera {
public static void main(String[] args) {
	Contato contato = new Contato();
	ContatoDao dao = new ContatoDao();
	contato.setId(3);
	contato.setNome("Carlos");
	contato.setEndereco("Rua Vergueira 200");
	contato.setDataNascimento(Calendar.getInstance());
	contato.setEmail("carlos@uol.com.br");
 dao.altera(contato);
 System.out.println("Contato alterado");
}
}
