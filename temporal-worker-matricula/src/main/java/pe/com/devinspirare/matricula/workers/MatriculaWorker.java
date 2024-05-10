package pe.com.devinspirare.matricula.workers;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.modelmapper.ModelMapper;
import pe.com.devinspirare.course.api.CourseControllerApi;
import pe.com.devinspirare.matricula.activities.impl.CursoActivityImpl;
import pe.com.devinspirare.matricula.activities.impl.MatriculaActivityImpl;
import pe.com.devinspirare.matricula.activities.impl.ProfesorActivityImpl;
import pe.com.devinspirare.matricula.workflows.impl.MatriculaWorkflowImpl;
import pe.com.devinspirare.teacher.api.TeacherControllerApi;

@ApplicationScoped
@Slf4j
public class MatriculaWorker {

    private WorkerFactory factory;

    @Inject
    ModelMapper modelMapper;

    @RestClient
    @Inject
    TeacherControllerApi teacherControllerApi;

    @RestClient
    @Inject
    CourseControllerApi courseControllerApi;

    public void onStart(@Observes StartupEvent ev) {
        log.info("Matricula iniciando");
        // Generate the gRPC stubs
        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();

        // Initialize the Temporal Client, passing in the gRPC stubs
        WorkflowClient client = WorkflowClient.newInstance(service);

        // Initialize a WorkerFactory, passing in the Temporal Client (WorkflowClient)
        factory = WorkerFactory.newInstance(client);

        // Create a new Worker
        Worker worker = factory.newWorker("worker-matricula-task-queue-local");

        // Register the Workflow by passing in the class to the worker
        worker.registerWorkflowImplementationTypes(MatriculaWorkflowImpl.class);

        // Register the Activities by passing in an Activities object used for execution
        worker.registerActivitiesImplementations(new CursoActivityImpl(courseControllerApi),
                                                 new ProfesorActivityImpl(teacherControllerApi, modelMapper),
                                                 new MatriculaActivityImpl());

        // Start the Worker
        factory.start();
    }

    void onStop(@Observes ShutdownEvent ev) {
        factory.shutdown();
        log.info("Matricula finalizando");
    }
}

