package pe.com.devinspirare.teacher.repository;

import pe.com.devinspirare.teacher.model.Teacher;

import java.util.Set;

public interface TeacherRepository {
    Set<Teacher> getAll();
}
