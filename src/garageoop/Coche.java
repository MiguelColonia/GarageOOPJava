package garageoop;

public class Coche extends Vehiculo{

    private boolean airbag;
    private boolean aireacondicionado;
    public Coche(String matricula, String marca, String modelo, int año, boolean airbag, boolean aireacondicionado) {
        super(matricula, marca, modelo, año);
        this.airbag = airbag;
        this.aireacondicionado = aireacondicionado;
    }

    public boolean isAirbag() {
        return airbag;
    }

    public void setAirbag(boolean airbag) {
        this.airbag = airbag;
    }

    public boolean isAireacondicionado() {
        return aireacondicionado;
    }

    public void setAireacondicionado(boolean aireacondicionado) {
        this.aireacondicionado = aireacondicionado;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "airbag=" + airbag +
                ", aireacondicionado=" + aireacondicionado +
                '}';
    }
}
