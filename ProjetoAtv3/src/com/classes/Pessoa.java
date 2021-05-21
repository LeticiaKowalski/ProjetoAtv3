package com.classes;

public class Pessoa {
	
	private String nome;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome) {
		setNome(nome);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome.length() > 0) {
			this.nome = nome;
		}
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n- Nome: ");
		builder.append(nome);
		return builder.toString();
	}
}
