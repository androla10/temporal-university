package pe.com.devinspirare.matricula.controllers;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import pe.com.devinspirare.matricula.dto.MatriculaDto;
import pe.com.devinspirare.matricula.workflows.MatriculaWorkflow;

@Path("/matriculas")
@Slf4j
public class MatriculaController {

    @ConfigProperty(name = "matricula.task.queue")
    String taskQueue;

    @POST
    public String registrar(MatriculaDto matriculaDto) {
        log.info("Iniciando registro de matricula");
        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
        WorkflowClient client = WorkflowClient.newInstance(service);
        MatriculaWorkflow workflow = client.newWorkflowStub(MatriculaWorkflow.class, WorkflowOptions.newBuilder()
                .setWorkflowId(String.valueOf(matriculaDto.getId()))
                .setTaskQueue(taskQueue).build());
        return workflow.registrar(matriculaDto);
    }

    @GET
    @Path("/{id}")
    public String obtener(@PathParam("id") Long id) {
        log.info("Obtener estado de la matricula");
        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
        WorkflowClient client = WorkflowClient.newInstance(service);
        MatriculaWorkflow workflow = client.newWorkflowStub(MatriculaWorkflow.class, WorkflowOptions.newBuilder()
                .setWorkflowId(String.valueOf(id))
                .setTaskQueue(taskQueue).build());
        return workflow.estado();
    }
}
