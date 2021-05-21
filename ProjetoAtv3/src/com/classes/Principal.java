package com.classes;

import java.io.IOException;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class Principal {

	public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

	
		Lista lista = new Lista();
		Aluno aluno = new Aluno();
		
		
		Persistencias p1 = new Persistenciajson();
		Controlador c1 = new Controlador(p1);
		
		Persistencias p2 = new Persistenciaxml();
		Controlador c2 = new Controlador(p2);
		
		Persistencias p3 = new Persistenciacsv();
		Controlador c3 = new Controlador(p3);
	
		
		aluno.setNome("Letícia");
		aluno.setMatricula(2020006749);
		aluno.setCpf("111.111.111-11");
		aluno.setDataNascimento("12/02/2001");
		aluno.setEmail("lehh.kowalski@gmail.com");
		lista.inserir(aluno);
		
		aluno = new Aluno();
		aluno.setNome("Marcelo");
		aluno.setMatricula(2020006004);
		aluno.setCpf("222.222.222-22");
		aluno.setDataNascimento("23/11/2000");
		aluno.setEmail("marcelo@gmail.com");
		lista.inserir(aluno);

		
		c1.gerarPersistencia(lista.getLista());
		c2.gerarPersistencia(lista.getLista());
		c3.gerarPersistencia(lista.getLista());

		System.out.println(lista.getLista().toString());
	}
}

