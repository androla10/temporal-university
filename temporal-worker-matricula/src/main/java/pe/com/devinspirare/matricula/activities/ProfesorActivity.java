package pe.com.devinspirare.matricula.activities;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;
import pe.com.devinspirare.matricula.model.ProfesorDTO;

@ActivityInterface(namePrefix = "ProfesorActivity_")
public interface ProfesorActivity {

    @ActivityMethod(name = "obtenerPorCodigo")
    ProfesorDTO obtenerPorCodigo(Long codigo);
}
