package garageoop;

public class Moto extends Vehiculo{

    private boolean casco;
    private boolean sidecar;

    public Moto(String matricula, String marca, String modelo, int año, boolean casco, boolean sidecar) {
        super(matricula, marca, modelo, año);
        this.casco = casco;
        this.sidecar = sidecar;
    }

    public boolean isCasco() {
        return casco;
    }

    public void setCasco(boolean casco) {
        this.casco = casco;
    }

    public boolean isSidecar() {
        return sidecar;
    }

    public void setSidecar(boolean sidecar) {
        this.sidecar = sidecar;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "casco=" + casco +
                ", sidecar=" + sidecar +
                '}';
    }
}
