package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um período com disciplinas que serão 
 * cursadas por um determinado aluno.
 */
public class Periodo {
	
	//CREATOR:
			//Periodo requer informações de disciplina para criar um novo período.
			//Perido contém disciplinas.
	
	private List<Disciplina> disciplinas;
	private boolean limiteMaximo;
	
	static final int minimo_de_creditos = 14;
	static final int maximo_de_creditos = 32;
	
	/**
	 * Gera um objeto período.
	 */
	public Periodo() {
		disciplinas = new ArrayList<Disciplina>();
	}
	
	/**
	 * Recupera a lista de disciplinas do período.
	 * 
	 * @return
	 * 			Uma lista contendo as disciplinas do período.
	 */
	public List<Disciplina> getDisciplinas() {
		return this.disciplinas;
	}
	
	/**
	 * Adiciona uma disciplina ao período.
	 * 
	 * @param disciplina
	 * 			Disciplina que será adicionada.
	 */
	public void addDisciplina(Disciplina disciplina) {
		verificaDisciplina(disciplina);
	}

	/**
	 * Recupera a quantidade de créditos do período. 
	 * 
	 * @return
	 * 			A quantidade de créditos do período.
	 */
	public int getCreditos() {
		int total = 0;
		for(Disciplina disciplina : disciplinas)
			total += disciplina.getCreditos();
		return total;
	}
	
	/**
	 * Verifica se uma disciplina pode ser adicionada ao período. Para isto, a quantidade de 
	 * créditos não pode ultrapassar 32.
	 * 
	 * @param disciplina
	 * 			Disciplina que será verificada.
	 * @return
	 * 			Se a disciplina pode ser adicionada ou não.
	 */
	private boolean verificaDisciplina(Disciplina disciplina) {
		if(!disciplinas.contains(disciplina)){
			if((getCreditos()) <= Periodo.maximo_de_creditos){
				limiteMaximo = false;
				return disciplinas.add(disciplina);
			}
		}else{
			limiteMaximo = true;
		}
		return false;
	}
	
	/**
	 * Remove uma disciplina do período.
	 * 
	 * @param disciplina
	 * 			A disciplina que será removida do período.
	 */
	public void removeDisciplina(Disciplina disciplina){
		disciplinas.remove(disciplina);
	}
	

}
