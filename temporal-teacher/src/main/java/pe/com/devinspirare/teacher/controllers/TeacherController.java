package pe.com.devinspirare.teacher.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.annotations.Param;
import pe.com.devinspirare.teacher.dtos.TeacherDto;
import pe.com.devinspirare.teacher.services.TeacherService;

import java.util.List;

@Path("/teachers")
public class TeacherController {

    @Inject
    TeacherService teacherService;

    @GET
    public List<TeacherDto> getAll() {
        return teacherService.getAll();
    }

    @POST
    public TeacherDto create(TeacherDto teacherDto) {
        teacherService.add(teacherDto);
        return teacherDto;
    }

    @GET
    @Path("/{id}")
    public TeacherDto getById(@PathParam("id") Long id) {
        return teacherService.get(id);
    }
}
