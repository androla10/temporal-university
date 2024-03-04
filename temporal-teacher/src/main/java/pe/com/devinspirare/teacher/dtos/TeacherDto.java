package pe.com.devinspirare.teacher.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TeacherDto {
    private Long id;
    private String name;
    private String dateOfBirthday;
    private String lastName;
}
