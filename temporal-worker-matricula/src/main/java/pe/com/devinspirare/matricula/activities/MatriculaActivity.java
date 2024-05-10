package pe.com.devinspirare.matricula.activities;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;
import pe.com.devinspirare.matricula.dto.MatriculaDto;

@ActivityInterface(namePrefix = "Matricula_")
public interface MatriculaActivity {

    @ActivityMethod
    void guardar(MatriculaDto matriculaDto);
}
