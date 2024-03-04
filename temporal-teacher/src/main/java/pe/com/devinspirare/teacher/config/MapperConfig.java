package pe.com.devinspirare.teacher.config;

import io.quarkus.arc.DefaultBean;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import org.mapstruct.factory.Mappers;
import pe.com.devinspirare.teacher.mapper.TeacherMapper;

@Dependent
public class MapperConfig {

    @DefaultBean
    @Produces
    public TeacherMapper teacherMapper() {
        return Mappers.getMapper(TeacherMapper.class);
    }
}
