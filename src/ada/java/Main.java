package ada.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Una empresa tiene empleados gerentes y otros que no son gerentes.
        De cada empleado se sabe el nombre, dni y domicilio.
        Los gerentes tienen una lista de tareas que pueden asignar a sus empleados.
        Los empleados tienen una lista de tareas a ejecutar y pueden ejecutarlas.
        Cuando un empleado ejecuta una tarea, se agrega a una lista de tareas ejecutadas.
        Cuando un gerente asigna una tarea, se agrega a una lista de tareas asignadas
        (y se quita de la lista de tareas pendientes).
        Cada empleado puede calcular su salario.
        El salario de un gerente se calcula como la cantidad de tareas asignadas multiplicadas por 75.
        El salario de los demás empleados se calcula como la cantidad de tareas ejecutadas por 150.

*/
public class Main {

    public static void main(String[] args) {
    Gerente gerente = new Gerente("Jose");
    List<Empleado> empleados = new ArrayList<>(Arrays.asList(
            new Empleado("ana"),
            new Empleado("jim"),
            new Empleado("karen")
    ));
    gerente.setEmpleados(empleados);

    List<Tarea> tareas = new ArrayList<>(Arrays.asList(
            new Tarea(1),
            new Tarea(2),
            new Tarea(3),
            new Tarea(4),
            new Tarea(5),
            new Tarea(6),
            new Tarea(7)
    ));
    gerente.setTareasPendientes(tareas);

    //Asigno Tareas al azar
    while (gerente.getTareasPendientes().size()>0) {
        Double i =  Math.floor(Math.random()*3);
        gerente.asignar(gerente.getProximaTareaPendiente(),gerente.getEmpleados().get(i.intValue()));
    }

    //Para cada Empleado proceso las tareas
    for (Empleado e : gerente.getEmpleados()){
        while (e.getTareasPendientes().size()>0) {
            e.ejecutar(e.getProximaTareaPendiente());
        }
    }
    // Hago listado de tareas realizadas y sueldos
        System.out.println("Tareas asignadas del Gerente: " + gerente.getNombre());
        gerente.mostrarTareas(gerente.getTareasAsignadas());
        System.out.println("Sueldo a cobrar:" + gerente.calcularSalario());
        System.out.println("Tareas pendientes: " + gerente.getTareasPendientes().size());
        System.out.println("-------------------------------------------");

    for (Empleado e : gerente.getEmpleados()){
        System.out.println("Tareas ejecutadas del Empleado: " + e.getNombre());
        gerente.mostrarTareas(e.getTareasEjecutadas());
        System.out.println("Tareas pendientes: " + e.getTareasPendientes().size());
        System.out.println("Sueldo a cobrar:" + e.calcularSalario());
        System.out.println("-------------------------------------------");
    }
    }
}
