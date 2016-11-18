package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnderecoDAO {
	
	  private Conexao conexao;
	  private PreparedStatement prepararSQL;
	  ResultSet resultado;
	   
	  public EnderecoDAO() throws SQLException {
		  this.conexao = new Conexao();
	  }
	  
	  public Endereco buscarEndereco(int cep) throws SQLException {
		  String sql = "SELECT * FROM enderecoview where cep = ?";
		  prepararSQL = this.conexao.getConexao().prepareStatement(sql);
		  prepararSQL.setInt(1, cep);
		  resultado = prepararSQL.executeQuery();
		  resultado.next();
		  Logradouro logradouro = new Logradouro();
		  logradouro.setCep(Integer.parseInt(resultado.getString("cep")));
		  logradouro.setId(Integer.parseInt(resultado.getString("id")));
		  logradouro.setNome(resultado.getString("logradouro"));
		  Endereco endereco = new Endereco();
		  endereco.setLogradouro(logradouro);
		  endereco.setBairro(resultado.getString("bairro"));
		  endereco.setCidade(resultado.getString("cidade"));
		  endereco.setUf(resultado.getString("uf"));
		  		  
		  return endereco;
	  }

}
