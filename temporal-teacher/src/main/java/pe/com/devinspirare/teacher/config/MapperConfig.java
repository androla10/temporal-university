package pe.com.devinspirare.teacher.config;

import io.quarkus.arc.DefaultBean;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import org.modelmapper.ModelMapper;

@Dependent
public class MapperConfig {

    @Produces
    @DefaultBean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
