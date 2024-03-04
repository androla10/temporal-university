package pe.com.devinspirare.matricula.workflows.impl;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;
import pe.com.devinspirare.matricula.activities.CursoActivity;
import pe.com.devinspirare.matricula.activities.ProfesorActivity;
import pe.com.devinspirare.matricula.model.CursoDTO;
import pe.com.devinspirare.matricula.model.ProfesorDTO;
import pe.com.devinspirare.matricula.workflows.MatriculaWorkflow;

import java.time.Duration;

public class MatriculaWorkflowImpl implements MatriculaWorkflow {

    ActivityOptions options = ActivityOptions.newBuilder()
            .setStartToCloseTimeout(Duration.ofSeconds(5))
            .build();

    private final CursoActivity cursoActivity =
            Workflow.newActivityStub(CursoActivity.class, options);

    private final ProfesorActivity profesorActivity =
            Workflow.newActivityStub(ProfesorActivity.class, options);

    @Override
    public String registrar() {
        //Obtener curso
        CursoDTO curso = cursoActivity.obtenerPorCodigo(100L);

        ProfesorDTO profesor = profesorActivity.obtenerPorCodigo(100L);

        return null;
    }
}
