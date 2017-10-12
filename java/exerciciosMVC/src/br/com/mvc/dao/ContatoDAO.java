package br.com.mvc.dao;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.com.mvc.modelo.Contato;

public class ContatoDAO {
	
	private Connection conn;
	private PreparedStatement stmt;
	
	public ContatoDAO(Connection connection){
		this.conn = connection;
	}
	
	public void inserir(Contato contato) {
		try{
			stmt = conn.prepareStatement("insert into contato (nome, email, endereco, dataNascimento, rg) VALUES(?,?,?,?,?)");
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTime()));
			stmt.setString(5, contato.getRg());
			stmt.execute();
			stmt.close();			
		}catch(SQLException ex){
			System.out.println(ex);
		}
	}

	public List<Contato> BuscarContatos(){
		List<Contato> contatos = new ArrayList<Contato>();
		try{
			String sql = "SELECT * FROM contato";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				contatos.add(new Contato(
							rs.getLong("id"),
							rs.getString("nome"),
							rs.getString("rg"),
							rs.getString("endereco"),
							rs.getDate("dataNascimento"),
							rs.getString("email")
						));
			}
			rs.close();
			stmt.close();
		}catch(SQLException ex){
			System.out.println(ex);
		}		
		return contatos;
	}
	
	public Contato BuscaContato(long idMatricula){
		Contato contato = null;
		try{
			stmt = conn.prepareStatement("SELECT * FROM contato where id = ?");
			stmt.setLong(1, idMatricula);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				contato = new Contato(
							rs.getLong("id"),
							rs.getString("nome"),
							rs.getString("rg"),
							rs.getString("endereco"),
							rs.getDate("dataNascimento"),
							rs.getString("email")
						);
			}
			rs.close();
			stmt.close();
		}catch(SQLException ex){
			System.out.println(ex);
		}		
		return contato;
	}

	public void alterarContato(Contato contato){
		try{
			stmt = conn.prepareStatement(""
						+ "UPDATE contato "
						+ "SET nome = ?,"
						+ "email = ?,"
						+ "endereco = ?,"
						+ "dataNascimento = ?,"
						+ "rg = ? WHERE id = ?"
					);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTime()));
			stmt.setString(5, contato.getRg());
			stmt.setLong(6, contato.getMatricula());
			stmt.execute();
			stmt.close();			
		}catch(SQLException ex){
			System.out.println(ex);
		}
	}	
	
	public void removerContato(long idMatricula){
		try{
			stmt = conn.prepareStatement("DELETE FROM contato where id = ?");
			stmt.setLong(1, idMatricula);
			stmt.execute();
			stmt.close();			
		}catch(SQLException ex){
			System.out.println(ex);
		}
	}
	
}
