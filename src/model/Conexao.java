package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private Connection conexao; //classe Connection � encarregada de fazer conex�o com Banco de Dados.
	
	public Conexao() throws SQLException{
		this.conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/comemore?useSSL=false","julio","juju");//Driver Manager � o interpretadordo do Banco de Dados
		
	}

	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}

}


//jdbc:mysql://localhost:3306/demo?useSSL=false