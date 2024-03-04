package pe.com.devinspirare.matricula.workflows;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface MatriculaWorkflow {

    @WorkflowMethod
    public String registrar();
}
