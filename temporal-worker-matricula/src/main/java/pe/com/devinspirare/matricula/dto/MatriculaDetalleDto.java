package pe.com.devinspirare.matricula.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.devinspirare.course.model.CourseDto;
import pe.com.devinspirare.teacher.model.TeacherDto;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MatriculaDetalleDto {
    private CourseDto course;
    private TeacherDto teacher;
}
