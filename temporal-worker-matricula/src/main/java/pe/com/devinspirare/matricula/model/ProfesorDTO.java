package pe.com.devinspirare.matricula.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ProfesorDTO {
    private Long codigo;
    private String nombre;
}
