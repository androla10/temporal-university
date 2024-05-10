package pe.com.devinspirare.matricula.activities.impl;

import lombok.RequiredArgsConstructor;
import pe.com.devinspirare.course.api.CourseControllerApi;
import pe.com.devinspirare.course.model.CourseDto;
import pe.com.devinspirare.matricula.activities.CursoActivity;

@RequiredArgsConstructor
public class CursoActivityImpl implements CursoActivity {

    private final CourseControllerApi courseApi;

    @Override
    public CourseDto obtenerPorCodigo(Long codigo) {
        sleep(5);
        return courseApi.apiCourseIdGet(codigo);
    }

    private void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException ee) {
            // Empty
        }
    }
}
