package pe.com.devinspirare.matricula.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EstudianteDto {
    private Long id;
    private String nombre;
    private String correo;
    private String telefono;
}
