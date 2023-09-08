package garageoop;
import java.util.ArrayList;

public class Edificio {

    private int numeroPlantas;
    private ArrayList<Planta> plantas;



    public Edificio(int numeroPlantas, ArrayList<Planta> plantas) {
        this.numeroPlantas = numeroPlantas;
        this.plantas = plantas;
    }

    public int getNumeroPlantas() {
        return numeroPlantas;
    }

    public void setNumeroPlantas(int numeroPlantas) {
        this.numeroPlantas = numeroPlantas;
    }

    public ArrayList<Planta> getPlantas() {
        return plantas;
    }

    public void setPlantas(ArrayList<Planta> plantas) {
        this.plantas = plantas;
    }

    @Override
    public String toString() {
        return "Edificio{" +
                "numeroPlantas=" + numeroPlantas +
                ", plantas=" + plantas +
                '}';
    }
}

