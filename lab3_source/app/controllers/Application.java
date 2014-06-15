package controllers;

import java.util.List;

import models.Periodo;
import play.*;
import play.data.DynamicForm;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

	public static CoursePlanningSystem sistema = new CoursePlanningSystem();

	public static Result index() {
		List<Periodo> periodos = sistema.getPeriodos();
		return ok(index.render(periodos));
	}

	public static Result alocarDisciplina() {
		DynamicForm formDisciplina = new DynamicForm();
		final DynamicForm form = formDisciplina.bindFromRequest();
		
		final int periodo = Integer.parseInt(form.get("periodo"));

		
		final int numero = Integer.parseInt(form.get("numeroDisciplina"));

		sistema.alocarDisciplina(periodo, numero);
		return index();
	}

	public static Result desalocarDisciplina() {
		DynamicForm formDisciplina = new DynamicForm();
		final DynamicForm form = formDisciplina.bindFromRequest();
		final int numero = Integer.parseInt(form.get("numeroDisciplina"));
		final int periodo = Integer.parseInt(form.get("periodo"));
		sistema.desalocarDisciplina(numero,periodo);

		return index();
	}

	public static Result reiniciar() {
		sistema = new CoursePlanningSystem();

		return index();
	}

}
