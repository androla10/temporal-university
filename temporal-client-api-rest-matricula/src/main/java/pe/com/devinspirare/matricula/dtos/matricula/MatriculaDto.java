package pe.com.devinspirare.matricula.dtos.matricula;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MatriculaDto {
    private Long id;
    private List<MatriculaDetalleDto> detalle;
}
