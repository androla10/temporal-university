package pe.com.devinspirare.matricula.activities;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;
import pe.com.devinspirare.teacher.model.TeacherDto;

@ActivityInterface(namePrefix = "ProfesorActivities_")
public interface ProfesorActivity {

    @ActivityMethod
    TeacherDto obtenerPorCodigo(Long codigo);
}
