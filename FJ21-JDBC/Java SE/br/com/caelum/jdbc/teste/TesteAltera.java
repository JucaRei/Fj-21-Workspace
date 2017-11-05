package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TesteAltera {

	public static void main(String[] args) {

		Contato contato = new Contato();
		contato.setNome("Reinaldo");
		contato.setEmail("blabla@caelum.com.br");
		contato.setEndereco("R. Vergueiro 3185 cj57");
		contato.setDataNascimento(Calendar.getInstance());
		contato.setId((long)14);
		//altere nessa conexão!!!
		ContatoDao dao = new ContatoDao();
		
		//metodo elegante
		dao.altera(contato);
		
		System.out.println("Alterado!");
	}

}
