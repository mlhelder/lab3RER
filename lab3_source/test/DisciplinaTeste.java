import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import models.Disciplina;

import org.junit.Before;
import org.junit.Test;


public class DisciplinaTeste {

	Disciplina disciplina1;
	Disciplina disciplina2;
	Disciplina disciplina3;
	
	@Before
	public void setUp() throws Exception {
		String[] prerequisitos1 = {"0"};
		disciplina1 = new Disciplina("1", "CALCULO I", 4, prerequisitos1, true);
		disciplina2 = new Disciplina("2", "VETORIAL", 4, prerequisitos1, true);
		
		String[] prerequisitos2 = {"1","2"};
		disciplina3 = new Disciplina("3", "FUNDAMENTOS DA FISICA CLASSICA", 4, prerequisitos2, false);
	}
	
	@Test
	public void testEstaAlocada() {
		assertTrue(disciplina1.estaAlocada());
		assertTrue(disciplina2.estaAlocada());
		assertFalse(disciplina3.estaAlocada());
		
		//alocando uma disciplina
		disciplina3.alocar();
		assertTrue(disciplina3.estaAlocada());
	}
	
	@Test
	public void testAlocar() {
		assertFalse(disciplina3.estaAlocada());
		disciplina3.alocar();
		assertTrue(disciplina3.estaAlocada());
	}
	
	@Test
	public void testDesalocar() {
		assertTrue(disciplina1.estaAlocada());
		disciplina1.desalocar();
		assertFalse(disciplina1.estaAlocada());
	}

}
