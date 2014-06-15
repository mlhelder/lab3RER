package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa o currículo, importante para armazenar as disciplinas.
 */
public class GeraCurriculo {

	private List<Disciplina> listDisciplinas;

	/**
	 * Gera um objeto GeraCurriculo.
	 */
	public GeraCurriculo() {
		listDisciplinas = new ArrayList<Disciplina>();
	}

	/**
	 * Gera uma disciplina a partir dos parâmetros.
	 * 
	 * @param numero
	 * 			Número da disciplina.
	 * @param nome
	 * 			Nome da disciplina.
	 * @param numeroDeCreditos
	 * 			Número de créditos da disciplina.
	 * @param prerequisitos
	 * 			Pré-requisitos da disciplina.
	 * @param alocada
	 * 			Se a disciplina está alocada ou não.
	 */
	public void geraDisciplina(String numero, String nome,int numeroDeCreditos, String[] prerequisitos, boolean alocada) {
		Disciplina novaDisciplina = new Disciplina(numero, nome,numeroDeCreditos, prerequisitos, alocada);
		listDisciplinas.add(novaDisciplina);
	}

	/**
	 * Recupera uma disciplina a partir do seu número.
	 * 
	 * @param numero
	 * 			Número da disciplina.
	 * @return
	 * 			A disciplina referente ao número.
	 */
	public Disciplina getDisciplina(String numero) {
		for (Disciplina disciplina : listDisciplinas) {
			if (disciplina.getNumero().equals(numero)) {
				return disciplina;
			}
		}
		return null;
	}

	/**
	 * Recupera a lista das disciplinas.
	 * 
	 * @return
	 * 			A lista das disciplinas.
	 */
	public List<Disciplina> retornaListaDeDisciplinas() {
		return listDisciplinas;

	}
}
