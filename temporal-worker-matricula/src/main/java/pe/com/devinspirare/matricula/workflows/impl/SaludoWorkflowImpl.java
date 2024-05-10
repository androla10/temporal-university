package pe.com.devinspirare.matricula.workflows.impl;

import pe.com.devinspirare.matricula.workflows.SaludoWorkflow;

public class SaludoWorkflowImpl implements SaludoWorkflow {
    @Override
    public String saludar(String nombre) {
        return "Hola " + nombre;
    }
}
