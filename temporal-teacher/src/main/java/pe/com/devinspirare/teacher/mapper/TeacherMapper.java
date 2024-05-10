package pe.com.devinspirare.teacher.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import pe.com.devinspirare.teacher.dtos.TeacherDto;
import pe.com.devinspirare.teacher.model.Teacher;

@ApplicationScoped
@RequiredArgsConstructor
public class TeacherMapper {

    private final ModelMapper modelMapper;

    public TeacherDto teacherToDto(Teacher teacher) {
        return this.modelMapper.map(teacher, TeacherDto.class);
    }

    public Teacher teacherDtoToEntity(TeacherDto teacher) {
        return this.modelMapper.map(teacher, Teacher.class);
    }
}
