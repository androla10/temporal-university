package pe.com.devinspirare.matricula.utis;

import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;

import java.time.Duration;

public class ActivityOptionsUtils {

    public static ActivityOptions obtenerOpcionesCurso() {
        return ActivityOptions.newBuilder()
                .setStartToCloseTimeout(Duration.ofSeconds(10))
                .setRetryOptions(RetryOptions.newBuilder()
                        .setInitialInterval(Duration.ofSeconds(2))
                        .setMaximumAttempts(10).build())
                .build();
    }
    public static ActivityOptions obtenerOpcionesProfesor() {
        return ActivityOptions.newBuilder()
                .setRetryOptions(RetryOptions.newBuilder()
                        .setInitialInterval(Duration.ofSeconds(2))
                        .setMaximumAttempts(10).build())
                .build();
    }
    public static ActivityOptions obtenerOpcionesMatricula() {
        return ActivityOptions.newBuilder()
                .setRetryOptions(RetryOptions.newBuilder()
                        .setInitialInterval(Duration.ofSeconds(2))
                        .setMaximumAttempts(10).build())
                .build();
    }
    public static ActivityOptions obtenerOpcionesNotificacion() {
        return ActivityOptions.newBuilder()
                .setRetryOptions(RetryOptions.newBuilder()
                        .setInitialInterval(Duration.ofSeconds(2))
                        .setMaximumAttempts(10).build())
                .build();
    }
}
