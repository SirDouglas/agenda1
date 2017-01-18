package br.com.caelum.mvc.logica;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class AdicionaContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String data = req.getParameter("data");
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(calendar);
		ContatoDao contatoDao = new ContatoDao();
		contatoDao.adiciona(contato);
		return "mvc?logica=ListaContatosLogic";
	}

}
