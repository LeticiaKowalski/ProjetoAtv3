package com.classes;

import java.util.ArrayList;
import java.util.List;

public class Lista {
	
	List<Aluno> lista = new ArrayList<Aluno>();
	
	public List<Aluno> getLista() {
		return lista;
	}
	
	public boolean inserir(Aluno aluno) {
		return(lista.add(aluno));
	}
}
