package ada.java;

import java.util.ArrayList;
import java.util.List;

public abstract class Persona {
    private String nombre;
    private String dni;
    private String domicilio;
    private List<Tarea> tareasPendientes;

    public Persona(String nombre) {
        this.nombre = nombre;
        tareasPendientes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public List<Tarea> getTareasPendientes() {
        return tareasPendientes;
    }

    public Tarea getProximaTareaPendiente() {
        return (tareasPendientes.size()>0) ? tareasPendientes.get(0):null;
    }

    public void setTareasPendientes(List<Tarea> tareasPendientes) {
        this.tareasPendientes = tareasPendientes;
    }

    public void agregarTareaPendiente(Tarea tarea) {
        tareasPendientes.add(tarea);
    }

    protected void eliminarTareaPendiente(Tarea tarea) {
        tareasPendientes.remove(tarea);
    }

    public void mostrarTareas(List<Tarea> tareas){
        for (Tarea t : tareas)
            System.out.print( " / " + "Tarea N° " + t.getId()  );
        System.out.println(" / ");
    }

    public abstract Integer calcularSalario();
}