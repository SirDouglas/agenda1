package br.com.caelum.mvc.logica;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class AlteraContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		long id = 0;
		if (id == 0) {
		id = Long.parseLong(req.getParameter("id"));
		}
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		Calendar dataNascimento = Calendar.getInstance();
		Date date = new SimpleDateFormat("dd/mm/yyyy").parse(req.getParameter("dataNascimento"));
		dataNascimento.setTime(date);
		ContatoDao dao = new ContatoDao();
		Contato contato = dao.pesquisa(id);
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		if (id == 0) {
		dao.adiciona(contato);
		 } else {
			contato.setId(id);
			dao.altera(contato);
		}
		return "mvc?logica=ListaContatosLogic";
	}
	

}
