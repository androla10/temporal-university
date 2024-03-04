package pe.com.devinspirare.teacher.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import pe.com.devinspirare.teacher.model.Teacher;
import pe.com.devinspirare.teacher.services.TeacherService;

import java.util.Set;

@Path("/teachers")
public class TeacherController {

    @Inject
    TeacherService teacherService;


    @GET
    public Set<Teacher> getAll() {
        return teacherService.getAll();
    }
}
