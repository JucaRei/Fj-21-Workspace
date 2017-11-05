package br.com.caelum.jdbc.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Funcionario;

public class FuncionarioDao {
	
	private Connection connection;

	public FuncionarioDao(){
		this.connection = new ConnectionFactory().getConnection();
}

	public void adiciona(Funcionario funcionario) {
		String sql = "insert into contatos " +
				 "(nome,usuario,semha,id)" +
				 "values (?, ?, ?, ?)";
		try {
			//preparedStatement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
		
			//Setar valores
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.setLong(4, funcionario.getId());
			//executa
			stmt.execute();
			stmt.close();
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		}


	public void altera(Funcionario funcionario){
		String sql = "update funcionarios set nome=?, usuario=?," +
				"senha=?, where id=?";
		try {
		
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.setLong(4, funcionario.getId());
			stmt.execute();
			stmt.close();
	
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


		public void remove(Funcionario funcionario){
	
			try 	{
				PreparedStatement stmt = connection
						.prepareStatement("delete from funcionarios where id=?");
				stmt.setLong(1, funcionario.getId());
				stmt.execute();
				stmt.close();
		
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
