package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaAdiciona {
public static void main(String[] args) {
	Contato contato = new Contato();
	contato.setNome("Carlos Eduardo");
	contato.setEmail("carlosEduardo@cont.com.br");
	contato.setEndereco("Rua Vergueira 100");
	contato.setDataNascimento(Calendar.getInstance());
	
	ContatoDao dao = new ContatoDao();
	dao.adiciona(contato);
	System.out.println("Adicionado");
}
}
