package pe.com.devinspirare.matricula.workflows;

import io.temporal.workflow.QueryMethod;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;
import pe.com.devinspirare.matricula.dto.MatriculaDto;

@WorkflowInterface
public interface MatriculaWorkflow {

    @WorkflowMethod
    String registrar(MatriculaDto matricula);

    @QueryMethod
    String estado();
}
