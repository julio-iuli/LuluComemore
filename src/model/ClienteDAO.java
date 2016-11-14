package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.util.Date;

public class ClienteDAO {
   private Conexao conexao;
   private PreparedStatement prepararSQL;
   
   public ClienteDAO() throws SQLException{
	   this.conexao = new Conexao();
   }

public void inserir (Cliente cliente) throws SQLException {
	String sql = "INSERT INTO cliente(nome,resddd,restel,celddd,celtel,rg,rgemissor,cpf,cnpj,pfpj,email,datanasc,complemento,idlogradouro,recomendacaonome,recomendacaodatanasc) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	prepararSQL = this.conexao.getConexao().prepareStatement(sql);
	
    prepararSQL.setString(1,cliente.getNome());
    prepararSQL.setInt(2,cliente.getResddd());
    prepararSQL.setInt(3,cliente.getRestel());
    prepararSQL.setInt(4,cliente.getCelddd());
    prepararSQL.setInt(5,cliente.getCeltel());
    prepararSQL.setInt(6,cliente.getRg());
    prepararSQL.setString(7,cliente.getRgemissor());
    prepararSQL.setInt(8,cliente.getCpf());
    prepararSQL.setInt(9,cliente.getCnpj());
    prepararSQL.setBoolean(10,cliente.getPfpj());
    prepararSQL.setString(11,cliente.getEmail());
    prepararSQL.setString(12,cliente.getDatanasc());
    prepararSQL.setString(13,cliente.getComplemento());
    prepararSQL.setInt(14,cliente.getIdlogradouro());
    prepararSQL.setString(15,cliente.getRecomendacaonome());
    prepararSQL.setString(16,cliente.getRecomendacaodatanasc());
    
    prepararSQL.execute ();
  }

}


//nome,resddd,restel,celddd,celtel,rg,rgemissor,cpf,cnpj,pfpj,email,datanasc,complemento,idlogradouro,recomendacaonome,recomendacaodatanasc