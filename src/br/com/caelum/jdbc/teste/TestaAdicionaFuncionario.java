package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.FuncionarioDao;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestaAdicionaFuncionario {
public static void main(String[] args) {
	Funcionario funcionario = new Funcionario();
	FuncionarioDao dao = new FuncionarioDao();
	funcionario.setNome("Diego Lopes Passos");
	funcionario.setUsuario("Diego");
	funcionario.setSenha("1030");
	dao.adiciona(funcionario);
	System.out.println("Funcionario Adicionado");
	
	
}
}
