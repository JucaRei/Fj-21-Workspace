package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {
	//conexão com o banco de dados
	private Connection connection;
	
	public ContatoDao(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato) {
		String sql = "insert into contatos " +
					 "(nome,email,endereco,dataNascimento)" +
					 "values (?, ?, ?, ?)";
		try {
			//preparedStatement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			//Setar valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(
					contato.getDataNascimento().getTimeInMillis()));
			
			//executa
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
					}

	}
	public void altera(Contato contato){
		String sql = "update contatos set nome=?, email=?," +
					"endereco=?, dataNascimento=? where id=?";
		try {
			
			PreparedStatement stmt1 = connection.prepareStatement(sql);
			stmt1.setString(1, contato.getNome());
			stmt1.setString(2, contato.getEmail());
			stmt1.setString(3, contato.getEndereco());
			stmt1.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt1.setLong(5, contato.getId());
			stmt1.execute();
			stmt1.close();
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Contato contato){
		
		try {
			PreparedStatement stmt = connection
					.prepareStatement("delete from contatos where id=?");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Contato> getLista(){

		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.
					prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()){
			
				//criando o objeto Contato
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				//montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				//adicionando o objeto a lista
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
