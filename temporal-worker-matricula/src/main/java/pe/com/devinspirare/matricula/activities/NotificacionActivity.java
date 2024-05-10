package pe.com.devinspirare.matricula.activities;

import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface NotificacionActivity {
    void viaEmail(String email);

    void viaTelefonoMsg(String nroTelefono);
}
