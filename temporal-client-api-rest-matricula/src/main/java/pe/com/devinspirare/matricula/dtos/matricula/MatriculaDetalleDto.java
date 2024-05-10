package pe.com.devinspirare.matricula.dtos.matricula;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.devinspirare.matricula.dto.CursoDto;
import pe.com.devinspirare.teacher.model.TeacherDto;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MatriculaDetalleDto {
    private CursoDto course;
    private TeacherDto teacher;
}
