package pe.com.devinspirare.teacher.services.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import pe.com.devinspirare.teacher.dtos.TeacherDto;
import pe.com.devinspirare.teacher.mapper.TeacherMapper;
import pe.com.devinspirare.teacher.model.Teacher;
import pe.com.devinspirare.teacher.repository.impl.TeacherRepositoryImpl;
import pe.com.devinspirare.teacher.services.TeacherService;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class TeacherServiceImpl implements TeacherService {

    @Inject
    TeacherRepositoryImpl repository;

    @Inject
    TeacherMapper mapper;

    @Override
    @Transactional
    public void add(TeacherDto teacherDto) {
        Teacher teacher = mapper.teacherDtoToEntity(teacherDto);
        repository.persist(teacher);
    }

    @Override
    @Transactional
    public void delete(long id) {
        Teacher teacher = repository.findById(id);
        repository.delete(teacher);
    }

    @Override
    @Transactional
    public List<TeacherDto> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::teacherToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDto get(long id) {
        return mapper.teacherToDto(repository.findById(id));
    }
}
