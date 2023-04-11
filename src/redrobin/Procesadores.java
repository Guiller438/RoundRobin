package redrobin;

public class Procesadores {
    private String id;
    private int cedula;
    private int tiempo;

    public Procesadores(String id, int cedula, int tiempo) {
        this.id = id;
        this.cedula = cedula;
        this.tiempo = tiempo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "\nid=" + id + "\ncedula=" + cedula + "\ntiempo=" + tiempo;
    }
    
     public void reducirTiempo() { // Método para reducir el tiempo del proceso
        this.tiempo--; // Reduce el tiempo en 1
    }

    public boolean isTerminado() { // Método para saber si el proceso ya terminó
        return tiempo == 0; // Retorna true si el tiempo es 0 que significa que el proceso terminó de ejecutarse y false si no
    }
    
    


}

