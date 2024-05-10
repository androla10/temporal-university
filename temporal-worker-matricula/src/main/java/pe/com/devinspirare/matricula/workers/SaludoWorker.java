package pe.com.devinspirare.matricula.workers;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import lombok.extern.slf4j.Slf4j;
import pe.com.devinspirare.matricula.activities.impl.CursoActivityImpl;
import pe.com.devinspirare.matricula.activities.impl.ProfesorActivityImpl;
import pe.com.devinspirare.matricula.workflows.impl.MatriculaWorkflowImpl;
import pe.com.devinspirare.matricula.workflows.impl.SaludoWorkflowImpl;

@ApplicationScoped
@Slf4j
public class SaludoWorker {

    private WorkerFactory factory;

    public void onStart(@Observes StartupEvent ev) {
        log.info("Iniando Worker Saludo");
        // Generate the gRPC stubs
        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();

        // Initialize the Temporal Client, passing in the gRPC stubs
        WorkflowClient client = WorkflowClient.newInstance(service);

        // Initialize a WorkerFactory, passing in the Temporal Client (WorkflowClient)
        factory = WorkerFactory.newInstance(client);

        // Create a new Worker
        Worker worker = factory.newWorker("worker-saludo-task-queue-local");

        // Register the Workflow by passing in the class to the worker
        worker.registerWorkflowImplementationTypes(SaludoWorkflowImpl.class);

        // Start the Worker
        factory.start();
    }

    void onStop(@Observes ShutdownEvent ev) {
        factory.shutdown();
        log.info("Matricula finalizando");
    }
}
