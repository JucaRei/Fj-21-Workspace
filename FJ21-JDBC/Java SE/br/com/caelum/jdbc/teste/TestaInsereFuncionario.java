package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.FuncionarioDao;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestaInsereFuncionario {
	public static void main(String[] args) {
		
		Funcionario funcionario = new Funcionario();
		funcionario.setId(123l);
		funcionario.setNome("Juca");
		funcionario.setUsuario("jucax");
		funcionario.setSenha("200291");
		
		//grave nessa conexão!!!
		FuncionarioDao Dao = new FuncionarioDao();
				
				//metodo elegante
		Dao.adiciona(funcionario);
		
		System.out.println("Gravado!");
		
	}

}
