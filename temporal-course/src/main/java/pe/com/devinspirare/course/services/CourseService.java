package pe.com.devinspirare.course.services;

import pe.com.devinspirare.course.model.Course;

import java.util.Set;

public interface CourseService {
    void add(Course course);

    void delete(long id);

    Set<Course> getAll();

    Course get(long id);
}
