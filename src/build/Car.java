package build;

public class Car {
    String make;
    Transmission transmission;
    int maxSpead;

    public void setMake(String make) {this.make = make;}

    public void setTransmission(Transmission transmission) {this.transmission = transmission;}

    public void setMaxSpead(int maxSpead) {this.maxSpead = maxSpead;}

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", transmission=" + transmission +
                ", maxSpead=" + maxSpead +
                '}';
    }
}
