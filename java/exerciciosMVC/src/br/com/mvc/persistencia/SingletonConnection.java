package br.com.mvc.persistencia;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class SingletonConnection {
	private String driver = "com.mysql.jdbc.Driver";
	 private String url = "jdbc:mysql://localhost:3306/agenda";
	 private String usuario = "root";
	 private String senha = "";
	 private Connection conexao = null;

	public Connection getConnection() {
		if (conexao == null) {
			try {
				Class.forName(driver);
				conexao = (Connection)DriverManager.getConnection(url, usuario,	senha);
			 } catch (SQLException e) {
				 throw new RuntimeException(e);
			 } catch (ClassNotFoundException e) {
				 e.printStackTrace();
			}
		}
		return conexao;
	}
}
