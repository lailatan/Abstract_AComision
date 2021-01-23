package ada.java;

import java.util.ArrayList;
import java.util.List;

public class Gerente extends Persona{
    private List<Tarea> tareasAsignadas;
    private List<Empleado> empleados;

    public Gerente(String nombre) {
        super(nombre);
        tareasAsignadas = new ArrayList<>();
    }

    public List<Tarea> getTareasAsignadas() {
        return tareasAsignadas;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    private void agregarTareaAsignada(Tarea tarea) {
        tareasAsignadas.add(tarea);
    }

    public void asignar(Tarea tarea, Empleado empleado){
        //manejo sus listas
        agregarTareaAsignada(tarea);
        super.eliminarTareaPendiente(tarea);

        //manejo Listas del Empleado
        empleado.agregarTareaPendiente(tarea);
    }

    @Override
    public Integer calcularSalario() {
        return tareasAsignadas.size()*75;
    }
}
