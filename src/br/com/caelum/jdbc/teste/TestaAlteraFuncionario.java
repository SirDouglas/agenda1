package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.FuncionarioDao;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestaAlteraFuncionario {
public static void main(String[] args) {
	Funcionario funcionario = new Funcionario();
	FuncionarioDao dao = new FuncionarioDao();
	funcionario.setId(2L);
	funcionario.setNome("Bruno Marques Xavier");
	funcionario.setUsuario("Bruno");
	funcionario.setSenha("4050");
	dao.altera(funcionario);
	System.out.println("Funcionario Alterado");
}
}
