package br.com.caelum.jdbc.teste;

import java.util.List;

import br.com.caelum.jdbc.dao.FuncionarioDao;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestaListaFuncionario {
public static void main(String[] args) {
	FuncionarioDao dao = new FuncionarioDao();
	List<Funcionario> lista = dao.lista();
	for (Funcionario funcionario: lista) {
		System.out.println(funcionario.getId());
		System.out.println(funcionario.getNome());
		System.out.println(funcionario.getUsuario());
		System.out.println(funcionario.getSenha());
		
	}
	
}
}
