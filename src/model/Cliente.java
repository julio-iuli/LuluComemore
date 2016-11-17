package model;

import java.time.LocalDate;

//import java.awt.Toolkit;
//import java.util.Date;

public class Cliente {

	private int id;
	private String nome;
	private int resddd;
	private int restel;
	private int celddd;
	private int celtel;
	private int rg;
	private String rgemissor;
	private int cpf;
	private int cnpj;
	private boolean pfpj;
	private String email;
	private LocalDate datanasc;
	private String complemento;
	private int idlogradouro;
	private String recomendacaonome;
	private LocalDate recomendacaodatanasc;
	
	public Cliente(){
		
	}
	public Cliente(int id, String nome, int resddd, int restel, int celddd, int celtel, int rg, String rgemissor,
					boolean pfpj, int cpf, int cnpj, String email, LocalDate datanasc, String complemento,
					int idlogradouro, String recomendacaonome, LocalDate recomendacaodatanasc){
		this.id = id;
		this.nome = nome;
		this.resddd = resddd;
		this.restel = restel;
		this.celddd = celddd;
		this.celtel = celtel;
		this.rg = rg;
		this.rgemissor = rgemissor;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.pfpj = pfpj;
		this.email = email;
		this.datanasc = datanasc;
		this.complemento = complemento;
		this.idlogradouro = idlogradouro;
		this.recomendacaonome = recomendacaonome;
		this.recomendacaodatanasc = recomendacaodatanasc;
				
	}
	
	
	
	public int getId() {
		return id;
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
	public int getResddd() {
		return resddd;
	}
	public void setResddd(int resddd) {
		this.resddd = resddd;
	}
	public int getRestel() {
		return restel;
	}
	public void setRestel(int restel) {
		this.restel = restel;
	}
	public int getCelddd() {
		return celddd;
	}
	public void setCelddd(int celddd) {
		this.celddd = celddd;
	}
	public int getCeltel() {
		return celtel;
	}
	public void setCeltel(int celtel) {
		this.celtel = celtel;
	}
	public int getRg() {
		return rg;
	}
	public void setRg(int rg) {
		this.rg = rg;
	}
	public String getRgemissor() {
		return rgemissor;
	}
	public void setRgemissor(String rgemissor) {
		this.rgemissor = rgemissor;
	}
//	public String getTipodoc(){
//		return tipodoc;
//	}
//	public void setTipoDoc(String tipodoc){
//		this.tipodoc. tipodoc
//	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getCnpj() {
		return cnpj;
	}
	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	public boolean getPfpj() {
		return pfpj;
	}
	public void setPfpj(boolean pfpj) {
		this.pfpj = pfpj;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDatanasc() {
		return datanasc;
	}
	public void setDataNasc(LocalDate datanasc) {
		this.datanasc = datanasc;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public int getIdlogradouro() {
		return idlogradouro;
	}
	public void setIdlogradouro(int idlogradouro) {
		this.idlogradouro = idlogradouro;
	}
	public String getRecomendacaonome() {
		return recomendacaonome;
	}
	public void setRecomendacaonome(String recomendacaonome) {
		this.recomendacaonome = recomendacaonome;
	}
	public LocalDate getRecomendacaodatanasc() {
		return recomendacaodatanasc;
	}
	public void setRecomendacaodatanasc(LocalDate recomendacaodatanasc) {
		this.recomendacaodatanasc = recomendacaodatanasc;
	}
	
}
