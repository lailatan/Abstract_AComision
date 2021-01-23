package ada.java;

import java.util.ArrayList;
import java.util.List;

public class Empleado extends Persona{
    private List<Tarea> tareasEjecutadas;


    public Empleado(String nombre) {
        super(nombre);
        tareasEjecutadas=new ArrayList<>();
    }

    public List<Tarea> getTareasEjecutadas() {
        return tareasEjecutadas;
    }

    private void agregarTareaEjecutadas(Tarea tarea) {
        tareasEjecutadas.add(tarea);
    }

    @Override
    public Integer calcularSalario() {
        return tareasEjecutadas.size()*150;
    }

    public void ejecutar(Tarea tarea){
        agregarTareaEjecutadas(tarea);
        super.eliminarTareaPendiente(tarea);
    };

}
