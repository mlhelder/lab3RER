package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import models.Disciplina;
import models.GeraCurriculo;
import models.Periodo;

/**
 * Gera um objeto CoursePlanningSystem que será importante para executar
 * diversas operações.
 */
public class CoursePlanningSystem {

    // CREATOR: CoursePlanningSystem armazena os períodos
    // Cria a grade que será usada para exibir todas as cadeiras disponíveis no
    // curso de CC

    private List<Periodo> periodos;
    private GeraCurriculo curriculo;
    private List<Disciplina> disciplinas;
    private List<Disciplina> disciplinasDisponiveis;
    private String[] Vazio = { "0" };

    /**
     * Cria um objeto CoursePlanningSystem.
     */
    public CoursePlanningSystem() {
        periodos = new ArrayList<Periodo>();
        curriculo = new GeraCurriculo();
        disciplinas = new ArrayList<Disciplina>();
        iniciaPeriodos();
        inicia();
    }

    /**
     * Recupera uma lista de períodos.
     * 
     * @return Lista de períodos.
     */
    public List<Periodo> getPeriodos() {
        return periodos;
    }

    /**
     * Recupera a quantidade de créditos de um determinado período.
     * 
     * @param index
     *            O índice referente a um determinado período.
     * @return A quantidade de créditos do período referente ao índice.
     */
    public int getCreditos(int index) {
        return periodos.get(index).getCreditos();
    }

    /**
     * Recupera um determinado período.
     * 
     * @param periodo
     *            O índice referente a um determinado período.
     * @return O período referente ao índice.
     */
    public Periodo getPeriodo(int periodo) {
        return periodos.get(periodo - 1);
    }

    /**
     * Inicia a lista de períodos.
     */
    public void iniciaPeriodos() {
        for (int i = 0; i < 10; i++) {
            periodos.add(new Periodo());
        }
    }

    // auxiliar para remover disciplina
    public boolean contemDisciplinaNoPeriodo(Periodo periodo, Disciplina disciplina) {
        if (periodo.getDisciplinas().contains(disciplina)) {
            return true;
        }

        return false;
    }

    /**
     * Recupera a lista de disciplinas disponíveis.
     * 
     * @return A lista de disciplinas disponíveis.
     */
    public List<Disciplina> retornaDisciplinas() {
        return disciplinasDisponiveis;

    }

    /**
     * Retorna uma determinada disciplina a partir do seu número.
     * 
     * @param numero
     *            Número da disciplina.
     * @return A disciplina referente ao número.
     */
    public Disciplina getDisciplinaPeloNumero(String numero) {
        return curriculo.getDisciplina(numero);
    }

    /**
     * Adiciona uma disciplina ao curriculo.
     * 
     * @param numero
     *            Número da disciplina.
     * @param nome
     *            Nome da disciplina.
     * @param numeroDeCreditos
     *            Número de crédito da disciplina.
     * @param numeroPrerequisitos
     *            Pré-requisitos da disciplina.
     * @param alocada
     *            Se a disciplina está alocada ou não.
     */
    public void adicionaDisciplina(String numero, String nome, int numeroDeCreditos, String[] numeroPrerequisitos, boolean alocada) {
        curriculo.geraDisciplina(numero, nome, numeroDeCreditos, numeroPrerequisitos, alocada);
    }

    /**
     * Inicia o sistema, preenchendo o primeiro período com suas disciplinas,
     * gerando os objetos de todas as outras disciplinas e criando uma lista de
     * disciplinas disponíveis.
     */
    public void inicia() {
        preenchePrimeiroPeriodo();
        disciplinas = curriculo.retornaListaDeDisciplinas();
        periodos.get(0).addDisciplina(disciplinas.get(0));
        periodos.get(0).addDisciplina(disciplinas.get(1));
        periodos.get(0).addDisciplina(disciplinas.get(2));
        periodos.get(0).addDisciplina(disciplinas.get(3));
        periodos.get(0).addDisciplina(disciplinas.get(4));
        periodos.get(0).addDisciplina(disciplinas.get(5));
        curriculo.retornaListaDeDisciplinas().clear();
        preencheDisciplinas();
        disciplinasDisponiveis = curriculo.retornaListaDeDisciplinas();

    }

    /**
     * Preenche o primeiro período com suas respectivas disciplinas.
     */
    public void preenchePrimeiroPeriodo() {
        adicionaDisciplina("1", "CALCULO I", 4, Vazio, true);
        adicionaDisciplina("2", "VETORIAL", 4, Vazio, true);
        adicionaDisciplina("3", "PROGRAMACAO I", 4, Vazio, true);
        adicionaDisciplina("4", "LAB PROG I", 4, Vazio, true);
        adicionaDisciplina("5", "IC", 4, Vazio, true);
        adicionaDisciplina("6", "LPT", 4, Vazio, true);
    }

    /**
     * Gera os objetos referentes as disciplinas.
     */
    public void preencheDisciplinas() {

        adicionaDisciplina("7", "CALCULO II", 4, new String[] { "1" }, false);
        adicionaDisciplina("8", "PROGRAMACAO II", 4, new String[] { "3", "4", "5" }, false);
        adicionaDisciplina("9", "LAB PROGRAMACAO II", 4, new String[] { "3", "4", "5" }, false);
        adicionaDisciplina("10", "MATEMATICA DISCRETA", 4, Vazio, false);
        adicionaDisciplina("11", "FUNDAMENTOS DA FISICA CLASSICA", 4, new String[] { "1", "2" }, false);
        adicionaDisciplina("12", "TEORIA DOS GRAFOS", 2, new String[] { "3", "4" }, false);
        adicionaDisciplina("13", "ALGEBRA LINEAR", 4, new String[] { "2" }, false);
        adicionaDisciplina("14", "PROBABILIDADE E ESTATÍSTICA", 4, new String[] { "7" }, false);
        adicionaDisciplina("15", "TEORIA DA COMPUTACAO", 4, new String[] { "10", "12", "5" }, false);
        adicionaDisciplina("16", "ESTRUTURA DE DADOS E ALGORITMOS", 4, new String[] { "12", "9", "8" }, false);
        adicionaDisciplina("17", "FUNDAMENTOS DA FISICA MODERNA", 4, new String[] { "11", "7" }, false);
        adicionaDisciplina("18", "GERENCIA DA INFORMACAO", 4, Vazio, false);
        adicionaDisciplina("19", "LAB DE ESTRUTURA DE DADOS", 4, new String[] { "12", "9", "8" }, false);
        adicionaDisciplina("20", "METODOLOGIA CIENTIFICA", 4, Vazio, false);
        adicionaDisciplina("21", "METODOS ESTATISTICOS", 4, new String[] { "14", "13" }, false);
        adicionaDisciplina("22", "PARADIGMAS DE LING DE PROGRAMACAO", 2, new String[] { "15", "16", "19" }, false);
        adicionaDisciplina("23", "LOGICA MATEMATICA", 4, new String[] { "15" }, false);
        adicionaDisciplina("24", "ORG E ARQ DE COMPUTADORES", 4, new String[] { "17", "16", "19" }, false);
        adicionaDisciplina("25", "LAB DE ORG E ARQ DE COMPUTADORES", 4, new String[] { "17", "16", "19" }, false);
        adicionaDisciplina("26", "ENGENHARIA DE SOFTWARE I", 4, new String[] { "8", "9", "14" }, false);
        adicionaDisciplina("27", "SISTEMAS DE INFORMACAO I", 4, new String[] { "18" }, false);
        adicionaDisciplina("28", "SISTEMAS DE INFORMACAO II", 4, new String[] { "27" }, false);
        adicionaDisciplina("29", "INFORMATICA E SOCIEDADE", 2, Vazio, false);
        adicionaDisciplina("30", "ANALISE E TECNICA DE ALGORITMOS", 4, new String[] { "16", "19", "7", "23" }, false);
        adicionaDisciplina("31", "COMPILADORES", 4, new String[] { "1" }, false);
        adicionaDisciplina("32", "REDES DE COMPUTADORES", 4, new String[] { "1" }, false);
        adicionaDisciplina("33", "BANCO DE DADOS I", 4, new String[] { "27" }, false);
        adicionaDisciplina("34", "LAB DE ENGENHARIA DE SOFT", 2, new String[] { "26" }, false);
        adicionaDisciplina("35", "DIREITO E CIDADANIA", 4, Vazio, false);
        adicionaDisciplina("36", "SISTEMAS OPERACIONAIS", 4, new String[] { "24", "25" }, false);
        adicionaDisciplina("37", "IRC", 2, new String[] { "32" }, false);
        adicionaDisciplina("38", "BANCO DE DADOS II", 4, new String[] { "33", "28" }, false);
        adicionaDisciplina("39", "INTELIGENCIA ARTIFICIAL", 4, new String[] { "30", "22", "21" }, false);
        adicionaDisciplina("40", "LIRC", 2, new String[] { "32" }, false);
        adicionaDisciplina("41", "TECC (DIDÁTICA EM CIÊNCIA DA COMPUTAÇÃO)", 2, Vazio, false);
        adicionaDisciplina("42", "TECC (ALGORITMOS AVANÇADOS II)", 2, new String[] { "3", "4" }, false);
        adicionaDisciplina("43", "MSN", 4, new String[] { "30", "13" }, false);
        adicionaDisciplina("44", "ADSD", 4, new String[] { "14" }, false);
        adicionaDisciplina("45", "PROJETO I", 4, new String[] { "34", "20" }, false);
        adicionaDisciplina("46", "PROJETO II", 4, new String[] { "45" }, false);
        adicionaDisciplina("47", "TECC (JOGOS DIGITAIS)", 4, new String[] { "16" }, false);
        adicionaDisciplina("48", "TECC (ADMINISTRAÇÃO DE SISTEMAS)", 4, Vazio, false);
        adicionaDisciplina("49", "TECC (ANÁLISE DE DADOS I)", 4, new String[] { "14" }, false);
        adicionaDisciplina("50", "TECC (ARQUITETURA DE SOFTWARE)", 6, new String[] { "27", "26" }, false);
        adicionaDisciplina("51", "ETICA", 4, Vazio, false);
        adicionaDisciplina("52", "FUNDA. DE CONTAB. E ORCAMENTO", 4, Vazio, false);
        adicionaDisciplina("53", "FUTSAL", 2, Vazio, false);
        adicionaDisciplina("54", "GESTAO DA QUALIDADE", 4, Vazio, false);
        adicionaDisciplina("55", "INGLES", 4, Vazio, false);
        adicionaDisciplina("56", "SEMINARIOS", 0, Vazio, false);
        adicionaDisciplina("57", "MATEMATICA FINANCEIRA", 4, Vazio, false);
        adicionaDisciplina("58", "RELACOES HUMANAS", 3, Vazio, false);
        adicionaDisciplina("59", "VOLEIBOL", 2, Vazio, false);
        adicionaDisciplina("60", "PRATICA DESPORTIVA", 2, Vazio, false);

    }

    // auxiliar para add disciplina
    public boolean temOsPreRequisitos(Disciplina disciplina) {
        int temTodosOsPreRequisitos = 0;
        if (disciplina.getPrerequisites()[0] == "0") {
            return true;
        } else {
            for (String idDisciplina : disciplina.getPrerequisites()) {
                for (Periodo periodoVerificacao : periodos) {
                    for (Disciplina disc : periodoVerificacao.getDisciplinas()) {
                        if (disc.getNumero().equals(idDisciplina)) {
                            temTodosOsPreRequisitos++;
                        }
                    }
                }
            }

        }

        return disciplina.getPrerequisites().length == temTodosOsPreRequisitos;
    }

    // Creator - O gerenciador do sistema que é responsável por esta ação
    /**
     * Aloca disciplina em um determinado período.
     * 
     * @param periodo
     *            Período onde será alocada a disciplina.
     * @param numero
     *            Número da disciplina que será alocada.    
     */
    public void alocarDisciplina(Integer periodo, Integer numero) {
        Disciplina disc = getDisciplinaPeloNumero(Integer.toString(numero));
        if ((periodos.get(periodo - 1).getCreditos() <= 32) && temOsPreRequisitos(disc) && ((periodos.get(periodo - 1).getCreditos() + disc.getCreditos()) <= 32)) {
            curriculo.getDisciplina(Integer.toString(numero)).alocar();
            disc.alocar();
            periodos.get(periodo - 1).addDisciplina(disc);
            disciplinasDisponiveis.remove(disc);
        } else {
            //ERROR
        }

    }

    // Creator - O gerenciador do sistema que é responsável por esta ação
    /**
     * Desaloca uma disciplina.
     * 
     * @param numeroDisciplina
     *            Número da disciplina que será desalocada.
     * @param periodo
     *            Número do período onde a disciplina será alocada.
     */
    public void desalocarDisciplina(Integer numeroDisciplina, Integer periodo) {
        for (Periodo periodoVerificacao : periodos) {
            if (periodos.indexOf(periodoVerificacao) != 0) {
                for (Disciplina disciplinaPRemover : periodoVerificacao.getDisciplinas()) {
                    if (disciplinaPRemover.getNumero().equals(Integer.toString(numeroDisciplina))) {
                        disciplinaPRemover.desalocar();
                        periodoVerificacao.removeDisciplina(disciplinaPRemover);
                        disciplinasDisponiveis.add(disciplinaPRemover);
                        removerDependentes(disciplinaPRemover, periodo);
                        break;
                    }
                }
            }
        }
    }

    // Creator - O gerenciador do sistema que é responsável por esta ação
    /**
     * Remove os dependentes de uma determinada disciplina.
     * 
     * @param disc
     *            Disciplina que terá os dependentes removidos.
     * @param periodo
     *            Período da disciplina.
     */
    public void removerDependentes(Disciplina disc, Integer periodo) {
        for (int i = periodo; i < this.periodos.size(); i++) {
            for (int j = 0; j < this.getPeriodo(i).getDisciplinas().size(); j++) {

                if (this.getPeriodo(i).getDisciplinas().get(j).getPrerequisites().toString().contains(disc.getNumero())) {
                    this.desalocarDisciplina(Integer.parseInt(this.getPeriodo(i).getDisciplinas().get(j).getNumero()), i);
                }
            }
        }

    }

}
