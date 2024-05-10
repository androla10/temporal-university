package pe.com.devinspirare.matricula.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MatriculaDto {
    private Long id;
    private String ciclo;
    private EstudianteDto estudiante;
    @Builder.Default
    private List<MatriculaDetalleDto> detalle = new ArrayList<>();
}
