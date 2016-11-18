package model;


public class Endereco {
	
	private Logradouro logradouro;
	private String uf, cidade, bairro;
	
	public Endereco(){
		
	}
	
	public Endereco(Logradouro logradouro, String uf, String cidade, String bairro) {
		this.logradouro = logradouro;
		this.uf = uf;
		this.cidade = cidade;
		this.bairro = bairro;
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	

}
