package pe.com.devinspirare.course.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import pe.com.devinspirare.course.dtos.CourseDto;
import pe.com.devinspirare.course.services.CourseService;

import java.util.List;
import java.util.Set;

@Path("/course")
public class CourseController {

    @Inject
    CourseService courseService;

    @GET
    public List<CourseDto> getAll() {
        return courseService.getAll();
    }

    @POST
    public CourseDto create(CourseDto courseDto) {
        courseService.add(courseDto);
        return courseDto;
    }

    @GET
    @Path("/{id}")
    public CourseDto getById(@PathParam("id") Long id) {
        return courseService.get(id);
    }

    @DELETE
    @Path("/{id}")
    public CourseDto deleteById(@PathParam("id") Long id) {
        return courseService.get(id);
    }
}
