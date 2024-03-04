package pe.com.devinspirare.matricula.workers;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import pe.com.devinspirare.matricula.activities.impl.CursoActivityImpl;
import pe.com.devinspirare.matricula.activities.impl.ProfesorActivityImpl;
import pe.com.devinspirare.matricula.workflows.impl.MatriculaWorkflowImpl;

public class MatriculaWorker {

    public static void main(String[] args) {
        // Generate the gRPC stubs
        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();

        // Initialize the Temporal Client, passing in the gRPC stubs
        WorkflowClient client = WorkflowClient.newInstance(service);

        // Initialize a WorkerFactory, passing in the Temporal Client (WorkflowClient)
        WorkerFactory factory = WorkerFactory.newInstance(client);

        // Create a new Worker
        Worker worker = factory.newWorker("worker-matricula-task-queue-local");

        // Register the Workflow by passing in the class to the worker
        worker.registerWorkflowImplementationTypes(MatriculaWorkflowImpl.class);

        // Register the Activities by passing in an Activities object used for execution
        worker.registerActivitiesImplementations(new CursoActivityImpl(), new ProfesorActivityImpl());

        // Start the Worker
        factory.start();
    }
}
