package pe.com.devinspirare.matricula.activities.impl;

import lombok.extern.slf4j.Slf4j;
import pe.com.devinspirare.matricula.activities.MatriculaActivity;
import pe.com.devinspirare.matricula.dto.MatriculaDto;

@Slf4j
public class MatriculaActivityImpl implements MatriculaActivity {
    @Override
    public void guardar(MatriculaDto matriculaDto) {
        log.info("Guardando matricula...");
        this.guardarDataBase(matriculaDto);
    }

    private void guardarDataBase(MatriculaDto matriculaDto) {
        log.info("Matricula Guardada");
    }
}
