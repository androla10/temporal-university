package pe.com.devinspirare.course.repository.impl;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import pe.com.devinspirare.course.model.Course;

@ApplicationScoped
public class CourseRepositoryImpl implements PanacheRepository<Course> {
}
