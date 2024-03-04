package pe.com.devinspirare.teacher.services;

import pe.com.devinspirare.teacher.dtos.TeacherDto;

import java.util.List;

public interface TeacherService {
    void add(TeacherDto teacher);
    void delete(long id);
    List<TeacherDto> getAll();
    TeacherDto get(long id);
}
