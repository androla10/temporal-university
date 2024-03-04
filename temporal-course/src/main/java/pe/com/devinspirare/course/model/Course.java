package pe.com.devinspirare.course.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Course {
    private Long code;
    private String name;
    private Long[] schedules;
}
