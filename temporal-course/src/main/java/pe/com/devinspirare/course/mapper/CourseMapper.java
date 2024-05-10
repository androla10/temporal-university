package pe.com.devinspirare.course.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import pe.com.devinspirare.course.dtos.CourseDto;
import pe.com.devinspirare.course.model.Course;

@ApplicationScoped
@RequiredArgsConstructor
public class CourseMapper {

    private final ModelMapper modelMapper;

    public CourseDto courseToDto(Course course) {
        return this.modelMapper.map(course, CourseDto.class);
    }

    public Course courseDtoToEntity(CourseDto course) {
        return this.modelMapper.map(course, Course.class);
    }
}
