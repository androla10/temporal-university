package pe.com.devinspirare.course.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import pe.com.devinspirare.course.model.Course;
import pe.com.devinspirare.course.services.CourseService;

import java.util.Set;

@Path("/course")
public class CourseController {

    @Inject
    CourseService teacherService;

    @GET
    public Set<Course> getAll() {
        return teacherService.getAll();
    }
}
