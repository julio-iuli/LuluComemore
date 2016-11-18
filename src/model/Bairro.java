package model;

public class Bairro {
	
	private int id;
	private String nome;
	protected Cidade cidade;
	
	public Bairro(){}

	public int getId() {
		return id;
		//teste eduardo branch
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	
}
