package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.FuncionarioDao;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestaPesquisaFuncionario {
public static void main(String[] args) {
	Funcionario funcionario = new Funcionario();
	FuncionarioDao dao = new FuncionarioDao();
	funcionario = dao.pesquisa(2L);
	System.out.println(funcionario.getId());
	System.out.println(funcionario.getNome());
	System.out.println(funcionario.getUsuario());
	System.out.println(funcionario.getSenha());
	
	
}
}
