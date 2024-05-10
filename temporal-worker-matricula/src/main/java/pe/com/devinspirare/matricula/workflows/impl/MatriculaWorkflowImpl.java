package pe.com.devinspirare.matricula.workflows.impl;

import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.workflow.Saga;
import io.temporal.workflow.Workflow;
import lombok.extern.slf4j.Slf4j;
import pe.com.devinspirare.course.model.CourseDto;
import pe.com.devinspirare.matricula.activities.CursoActivity;
import pe.com.devinspirare.matricula.activities.MatriculaActivity;
import pe.com.devinspirare.matricula.activities.NotificacionActivity;
import pe.com.devinspirare.matricula.activities.ProfesorActivity;
import pe.com.devinspirare.matricula.dto.MatriculaDto;
import pe.com.devinspirare.matricula.utis.ActivityOptionsUtils;
import pe.com.devinspirare.matricula.workflows.MatriculaWorkflow;
import pe.com.devinspirare.teacher.model.TeacherDto;

import java.time.Duration;

@Slf4j
public class MatriculaWorkflowImpl implements MatriculaWorkflow {

    ActivityOptions options = ActivityOptions.newBuilder()
            .setStartToCloseTimeout(Duration.ofSeconds(10))
            .setRetryOptions(RetryOptions.newBuilder()
                        .setInitialInterval(Duration.ofSeconds(2))
            .setMaximumAttempts(10).build())
            .build();
    private final CursoActivity cursoActivity =
            Workflow.newActivityStub(CursoActivity.class, options);

    private final ProfesorActivity profesorActivity =
            Workflow.newActivityStub(ProfesorActivity.class, options);
    private final MatriculaActivity matriculaActivity =
            Workflow.newActivityStub(MatriculaActivity.class, options);

    String status;
    @Override
    public String registrar(MatriculaDto matricula) {
        log.info("Comenzamos el proceso de registro de matricula");

        log.info("Seteo de datos....");
        MatriculaDto newMatricula = MatriculaDto.builder()
                                                .ciclo(matricula.getCiclo())
                                                .estudiante(matricula.getEstudiante())
                                                .id(matricula.getId())
                                                .build();

        status = "Complentando información asignación de asignaturas.";
        log.info("Proceso de iteracion de asignaturas");
        matricula.getDetalle().stream().map(x -> {
            CourseDto courseDto = cursoActivity.obtenerPorCodigo(x.getCourse().getId());
            TeacherDto teacherDto = profesorActivity.obtenerPorCodigo(x.getTeacher().getId());
            x.setCourse(courseDto);
            x.setTeacher(teacherDto);

            return x;
        }).forEach(x -> newMatricula.getDetalle().add(x));

        log.info("Ejecutando actividad de guardado de matricula");
        status = "Guardando matricula" + newMatricula.getEstudiante().getNombre();
        this.matriculaActivity.guardar(newMatricula);
        status = "Proceso terminado de matricula";

        log.info("Terminando el proceso del Workflow");
        return "Matricula realizada";
    }

    @Override
    public String estado() {
        return this.status;
    }
}
