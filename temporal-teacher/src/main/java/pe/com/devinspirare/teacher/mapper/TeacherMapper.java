package pe.com.devinspirare.teacher.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.com.devinspirare.teacher.dtos.TeacherDto;
import pe.com.devinspirare.teacher.model.Teacher;

@Mapper(componentModel = "cdi")
public interface TeacherMapper {
    @Mapping(target = "name", source = "name")
    TeacherDto teacherToDto(Teacher teacher);
    @Mapping(target = "name", source = "name")
    Teacher teacherDtoToEntity(TeacherDto teacher);

}
