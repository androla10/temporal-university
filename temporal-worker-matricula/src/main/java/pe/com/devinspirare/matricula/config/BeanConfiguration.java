package pe.com.devinspirare.matricula.config;

import io.quarkus.arc.DefaultBean;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import org.modelmapper.ModelMapper;

@Dependent
public class BeanConfiguration {

    @Produces
    @DefaultBean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
