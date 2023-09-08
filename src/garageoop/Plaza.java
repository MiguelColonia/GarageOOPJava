package garageoop;

public class Plaza {

    private int numero;
    private Vehiculo vehiculoAparcado;

    public Plaza(int numero, Vehiculo vehiculoAparcado) {
        this.numero = numero;
        this.vehiculoAparcado = vehiculoAparcado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Vehiculo getVehiculoAparcado() {
        return vehiculoAparcado;
    }

    public void setVehiculoAparcado(Vehiculo vehiculoAparcado) {
        this.vehiculoAparcado = vehiculoAparcado;
    }

    @Override
    public String toString() {
        return "Plaza{" +
                "numero=" + numero +
                ", vehiculoAparcado=" + vehiculoAparcado +
                '}';
    }
}
