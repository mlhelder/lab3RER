package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma disciplina do curso de Ciências da Computação
 * da UFCG, estas disciplinas que são cursados pelos alunos
 * podem ser alocadas em períodos.
 */
public class Disciplina {
	private String idDaDisciplina;
	private String nome;
	private int numeroDeCreditos;
	private boolean alocada;
	
	//Information Expert: Contem os itens necessários para se criar uma disciplina.
	//Somente disciplina conheçe seus prerequisitos.
	private String[] prerequisitos;

	/**
	 * Gera um objeto disciplina a partir dos parâmetros informados.
	 * 
	 * @param numero
	 * 				Número da disciplina.
	 * @param nome
	 * 				Nome da disciplina.
	 * @param numeroDeCreditos
	 * 				Número de créditos da disciplina.
	 * @param preRequisitos
	 * 				Pré-requisitos para cursar esta disciplina.
	 * @param alocada
	 * 				Boolean para informar se a disciplina está alocada ou não.
	 */
	public Disciplina(String numero, String nome, int numeroDeCreditos, String[] preRequisitos, boolean alocada) {
		this.idDaDisciplina = numero;
		this.nome = nome;
		this.numeroDeCreditos = numeroDeCreditos;
		this.prerequisitos = preRequisitos;
		this.alocada = alocada;
	}

	/**
	 * Recupera o número da disciplina.
	 * 
	 * @return
	 * 			O número da disciplina.
	 */
	public String getNumero(){
		return idDaDisciplina;
	}
	
	/**
	 * Recupera o nome da disciplina.
	 * 
	 * @return
	 * 			O nome da disciplina.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Recupera a quantidade de créditos da disciplina.
	 * 
	 * @return
	 * 			A quantidade de créditos da disciplina.
	 */
	public int getCreditos() {
		return numeroDeCreditos;
	}

	/**
	 * Recupera os pré-requisitos da disciplina.
	 * 
	 * @return
	 * 			Os pré-requisitos da disciplina.
	 */
	public String[] getPrerequisites() {
		return prerequisitos;
	}
	
	/**
	 * Informa se a disciplina está alocada ou não.
	 * 
	 * @return
	 * 			Se a disciplina está alocada ou não.
	 */
	public boolean estaAlocada() {
		return alocada;
	}
	
	/**
	 * Aloca um disciplina.
	 */
	public void alocar() {
		alocada = true;
	}
	
	/**
	 * Desaloca uma disciplina.
	 */
	public void desalocar() {
		alocada = false;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Disciplina)) {
			return false;
		}
		return ((Disciplina) obj).getNome().equals(nome) 
				&& ((Disciplina) obj).getCreditos() == numeroDeCreditos;
	}


	@Override
	public String toString() {
		return "Disciplina [" + idDaDisciplina + ", Nome=" + nome + ", Creditos=" + numeroDeCreditos + ", Pre Requisitos=" + prerequisitos + "]";
	}
	
	
}
