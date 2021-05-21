package com.classes;

import java.util.List;

public class Controlador {


	protected Persistencias persistencia;
	
	public Controlador (Persistencias persistencia) {
		this.persistencia = persistencia;
	}
	
	public boolean gerarPersistencia(List<Aluno> aluno) {
		return this.persistencia.gerarArquivo(aluno);
	}
}
