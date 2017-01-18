package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.FuncionarioDao;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestaRemoveFuncionario {
public static void main(String[] args) {
	Funcionario funcionario = new Funcionario();
	FuncionarioDao dao = new FuncionarioDao();
	funcionario.setId(4L);
	dao.remove(funcionario);
}
}
