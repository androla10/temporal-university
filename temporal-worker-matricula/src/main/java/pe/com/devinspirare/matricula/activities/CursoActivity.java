package pe.com.devinspirare.matricula.activities;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;
import pe.com.devinspirare.matricula.model.CursoDTO;

@ActivityInterface
public interface CursoActivity {

    @ActivityMethod
    CursoDTO obtenerPorCodigo(Long codigo);
}
