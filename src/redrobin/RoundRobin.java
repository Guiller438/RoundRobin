/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package redrobin;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author guill
 */
public class RoundRobin {
    public int conmutaciones;
    public int tiempoejecucion;
    private int tiempomaximo;
    
    public  Queue<Procesadores> procesos; 
    public  Stack<Procesadores> procesosTerminados; 

    public RoundRobin() {
        this.tiempomaximo = 35;
        this.procesos = new LinkedList<>();
        this.procesosTerminados = new Stack<>();
    }
    
    
    public void datospredefinidos(){
        añadir((new Procesadores("P1", 1723001672, 100)));
        añadir((new Procesadores("P2", 1723001672, 191)));
        añadir((new Procesadores("P3", 1723001672, 103)));
        añadir((new Procesadores("P4", 1723001672, 101)));
        añadir((new Procesadores("P5", 1723001672, 112)));
        añadir((new Procesadores("P6", 1723001672, 10)));
    }
    
    public void añadir(Procesadores proceso){
        procesos.offer(proceso);
    }
    
    public void ejecutarRoundRobin(){
        int tiempoEjecucionProceso = 0;
        Procesadores proceso;
        
           while (!procesos.isEmpty()) { // Mientras la cola de procesos no esté vacía (mientras haya procesos por ejecutar) realiza lo siguiente...
            proceso = procesos.poll(); // Obtiene el primer proceso de la cola de procesos y lo elimina de la cola
            tiempoEjecucionProceso = 0; // Inicializa el tiempo de ejecución del proceso en 0
            
            while (!proceso.isTerminado() && tiempoEjecucionProceso < this.tiempomaximo) { // Mientras el proceso no haya terminado y el tiempo de ejecución del proceso sea menor al tiempo máximo de ejecución de un proceso (35) realiza lo siguiente...
                proceso.reducirTiempo(); // Reduce el tiempo del proceso en 1
                
                tiempoejecucion++; // Incrementa el tiempo total de ejecución en 1
                tiempoEjecucionProceso++; // Incrementa el tiempo de ejecución del proceso en 1
            }

            if (proceso.isTerminado()) { // Si el proceso ya terminó de ejecutarse (tiempo del proceso es 0) realiza lo siguiente...
                procesosTerminados.push(proceso); // Agrega el proceso a la pila de procesos terminados
            } else { // Si el proceso no terminó de ejecutarse (tiempo del proceso es mayor a 0) realiza lo siguiente...
                
                procesos.offer(proceso); // Agrega el proceso a la cola de procesos nuevamente para que se vuelva a ejecutar después de los demás procesos
                conmutaciones++; // Incrementa la cantidad de conmutaciones en 1
            }
        }
    }

    public int getTiempomaximo() {
        return tiempomaximo;
    }

    public void setTiempomaximo(int tiempomaximo) {
        this.tiempomaximo = tiempomaximo;
    }
    
    @Override
    public String toString() {
        return "El número total de conmutaciones es de=" + conmutaciones+"\n" + 
                "El tiempo total de ejecucion=" + tiempoejecucion + "\n" + 
                " tiempomaximo=" + tiempomaximo + "\n" 
                + " procesos=" + procesos +"\n" 
                + " procesosTerminados=" + procesosTerminados;
    }
    
    public void Limpiar(){
        procesosTerminados.clear();
    }
    
    public String top(){
        return procesosTerminados.peek().toString();
    }
    
    
}
