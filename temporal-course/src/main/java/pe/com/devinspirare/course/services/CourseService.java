package pe.com.devinspirare.course.services;

import pe.com.devinspirare.course.dtos.CourseDto;

import java.util.List;

public interface CourseService {
    void add(CourseDto course);

    void delete(long id);

    List<CourseDto> getAll();

    CourseDto get(long id);
}
