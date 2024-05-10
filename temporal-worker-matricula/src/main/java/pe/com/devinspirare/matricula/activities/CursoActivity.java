package pe.com.devinspirare.matricula.activities;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;
import pe.com.devinspirare.course.model.CourseDto;

@ActivityInterface(namePrefix = "CursoActivities_")
public interface CursoActivity {

    @ActivityMethod
    CourseDto obtenerPorCodigo(Long codigo);
}
