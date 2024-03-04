package pe.com.devinspirare.teacher.repository.impl;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import pe.com.devinspirare.teacher.model.Teacher;

@ApplicationScoped
public class TeacherRepositoryImpl implements PanacheRepository<Teacher> {
}
