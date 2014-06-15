import static org.junit.Assert.*;

import java.util.List;

import models.Disciplina;
import models.GeraCurriculo;
import models.Periodo;

import org.junit.Before;
import org.junit.Test;

import controllers.CoursePlanningSystem;


public class CoursePlanningSystemTeste {
	
	CoursePlanningSystem sistema;

	@Before
	public void setUp() throws Exception {
		sistema = new CoursePlanningSystem();
	}

	@Test
	public void testGetPeriodos() {
		List<Periodo> periodos = sistema.getPeriodos();
		assertEquals(10, periodos.size());
	}
	
	@Test
	public void testPreenchePrimeiroPeriodo() {
		Periodo periodo = sistema.getPeriodo(1);
		List<Disciplina> disciplinas = periodo.getDisciplinas();
		assertEquals(6, disciplinas.size());
	}
	
	@Test
	public void testGetCreditos() {
		assertEquals(24, sistema.getCreditos(0));
		assertEquals(0, sistema.getCreditos(1));
	}
	
	@Test
	public void testContemDisciplinaNoPeriodo() {
		Periodo segundoPeriodo = sistema.getPeriodo(2);
		Disciplina disciplina1 = sistema.getDisciplinaPeloNumero("7");
		assertFalse(sistema.contemDisciplinaNoPeriodo(segundoPeriodo, disciplina1));
		
		assertFalse(disciplina1.estaAlocada());
		sistema.alocarDisciplina(2, 7);
		assertTrue(disciplina1.estaAlocada());
		
		assertTrue(sistema.contemDisciplinaNoPeriodo(segundoPeriodo, disciplina1));
	}
	
	@Test
	public void testGetDisciplinaPeloNumero() {
		Disciplina disciplina1 = sistema.getDisciplinaPeloNumero("7");
		String nomeDisciplina1 = disciplina1.getNome();
		
		Disciplina disciplina2 = sistema.getDisciplinaPeloNumero("8");
		String nomeDisciplina2 = disciplina2.getNome();
		
		assertEquals("CALCULO II", nomeDisciplina1);
		assertEquals("PROGRAMACAO II", nomeDisciplina2);
	}
	
	@Test
	public void testAlocarDisciplina() {
		Periodo periodo = sistema.getPeriodo(2);
		Disciplina disciplina1 = sistema.getDisciplinaPeloNumero("7");
		
		assertFalse(disciplina1.estaAlocada());
		
		sistema.alocarDisciplina(2, 7);
		
		assertTrue(disciplina1.estaAlocada());
		
		assertTrue(sistema.contemDisciplinaNoPeriodo(periodo, disciplina1));
	}
	
	@Test
	public void testDesalocarDisciplina() {
		Periodo periodo = sistema.getPeriodo(2);
		Disciplina disciplina1 = sistema.getDisciplinaPeloNumero("7");
		
		assertFalse(disciplina1.estaAlocada());
		sistema.alocarDisciplina(2, 7);
		assertTrue(disciplina1.estaAlocada());
		assertTrue(sistema.contemDisciplinaNoPeriodo(periodo, disciplina1));
		
		sistema.desalocarDisciplina(7, 2);
		assertFalse(disciplina1.estaAlocada());
		assertFalse(sistema.contemDisciplinaNoPeriodo(periodo, disciplina1));
	}
	
}
