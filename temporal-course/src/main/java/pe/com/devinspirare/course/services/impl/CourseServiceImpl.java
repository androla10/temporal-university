package pe.com.devinspirare.course.services.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import pe.com.devinspirare.course.dtos.CourseDto;
import pe.com.devinspirare.course.mapper.CourseMapper;
import pe.com.devinspirare.course.model.Course;
import pe.com.devinspirare.course.repository.impl.CourseRepositoryImpl;
import pe.com.devinspirare.course.services.CourseService;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CourseServiceImpl implements CourseService {

    @Inject
    CourseRepositoryImpl repository;

    @Inject
    CourseMapper mapper;


    @Override
    @Transactional
    public void add(CourseDto courseDto) {
        Course course = mapper.courseDtoToEntity(courseDto);
        repository.persist(course);
    }

    @Override
    @Transactional
    public void delete(long id) {
        Course course = repository.findById(id);
        repository.delete(course);
    }

    @Override
    public List<CourseDto> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::courseToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDto get(long id) {
        return mapper.courseToDto(repository.findById(id));
    }
}
