package pe.com.devinspirare.matricula.activities.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import pe.com.devinspirare.matricula.activities.ProfesorActivity;
import pe.com.devinspirare.teacher.api.TeacherControllerApi;
import pe.com.devinspirare.teacher.model.TeacherDto;

@RequiredArgsConstructor
public class ProfesorActivityImpl implements ProfesorActivity {

    private final TeacherControllerApi teacherControllerApi;
    private final ModelMapper modelMapper;

    @Override
    public TeacherDto obtenerPorCodigo(Long codigo) {
        return teacherControllerApi.apiTeachersIdGet(codigo);
    }
}
