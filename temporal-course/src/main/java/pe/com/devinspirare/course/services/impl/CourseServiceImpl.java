package pe.com.devinspirare.course.services.impl;

import jakarta.enterprise.context.ApplicationScoped;
import pe.com.devinspirare.course.model.Course;
import pe.com.devinspirare.course.services.CourseService;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
public class CourseServiceImpl implements CourseService {

    @Override
    public void add(Course course) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Set<Course> getAll() {
        return Stream.of(Course.builder()
                        .code(100L)
                        .name("Matematica 1")
                        .build())
                .collect(Collectors.toSet());
    }

    @Override
    public Course get(long id) {
        return null;
    }
}
