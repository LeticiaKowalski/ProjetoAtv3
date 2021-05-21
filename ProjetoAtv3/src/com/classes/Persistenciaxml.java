package com.classes;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class Persistenciaxml implements Persistencias {

	
	final static String NOMEDOARQUIVO = "alunos";
	final static String LOCALHOST = "xml/";
		
	
	public boolean gerarArquivo(List<Aluno> lista) {
		Element config = new Element("Alunos");
		Document documento = new Document(config);
			
		Element titulo = new Element("titulo");
		titulo.setText("Cadastro de Alunos");
			
		Element data = new Element("data");
		data.setText(Formatador.DataHoraForStringPadraoH(new Date()));
			
		config.addContent(titulo);
		config.addContent(data);
			
		for(int i = 0; i < lista.size(); i++) {
			Element aluno = new Element("aluno");
				
			aluno.setAttribute("matricula", String.valueOf(lista.get(i).getMatricula()));
				
			Element nome = new Element("nome");
			nome.setText(lista.get(i).getNome());
				
			Element cpf = new Element("cpf");
			cpf.setText(lista.get(i).getCpf());
				
			Element dataNascimento = new Element("datanascimento");
			dataNascimento.setText(lista.get(i).getDataNascimento());
				
			Element email = new Element("email");
			email.setText(lista.get(i).getEmail());
				
			aluno.addContent(nome);
			aluno.addContent(cpf);
			aluno.addContent(dataNascimento);
			aluno.addContent(email);
			
			config.addContent(aluno);
		}
			
		XMLOutputter xout = new XMLOutputter();
			
		try {
			
			BufferedWriter arquivo = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(LOCALHOST + NOMEDOARQUIVO + ".xml"), "UTF-8"));
			xout.output(documento, arquivo);
			return true;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("rawtypes")
	public List<Aluno> lerXML() {
		List<Aluno> lista_aluno = new ArrayList<Aluno>();
		Document documento = null;
		SAXBuilder builder = new SAXBuilder();
		
		try {
			documento = builder.build(LOCALHOST + NOMEDOARQUIVO + ".xml");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		Element config = documento.getRootElement();
		List lista = config.getChildren("aluno");
			
		for(Iterator iter = lista.iterator(); iter.hasNext();) {
			Element element = (Element) iter.next();
			Aluno aluno = new Aluno();
			aluno.setMatricula(Integer.parseInt(element.getAttributeValue("matricula")));
			aluno.setNome(element.getChildText("nome"));
			aluno.setDataNascimento(element.getChildText("datanascimento"));
			aluno.setCpf(element.getChildText("cpf"));
			aluno.setEmail(element.getChildText("email"));
			lista_aluno.add(aluno);
		}
		return lista_aluno;
	}
}

