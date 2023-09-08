package garageoop;

import java.util.ArrayList;

public class Planta {

    private int numeroPlanta;
    private int NumeroPlazas;
    private ArrayList<Plaza> plazas;

    public Planta(int numeroPlanta, int mumeroPlazas, ArrayList<Plaza> plazas) {
        this.numeroPlanta = numeroPlanta;
        this.NumeroPlazas = mumeroPlazas;
        this.plazas = plazas;
    }

    public int getNumeroPlanta() {
        return numeroPlanta;
    }

    public void setNumeroPlanta(int numeroPlanta) {
        this.numeroPlanta = numeroPlanta;
    }

    public int getNumeroPlazas() {
        return NumeroPlazas;
    }

    public void setNumeroPlazas(int mumeroPlazas) {
        this.NumeroPlazas = mumeroPlazas;
    }

    public ArrayList<Plaza> getPlazas() {
        return plazas;
    }

    public void setPlazas(ArrayList<Plaza> plazas) {
        this.plazas = plazas;
    }

    @Override
    public String toString() {
        return "Planta{" +
                "numeroPlanta=" + numeroPlanta +
                ", NumeroPlazas=" + NumeroPlazas +
                ", plazas=" + plazas +
                '}';
    }
}
