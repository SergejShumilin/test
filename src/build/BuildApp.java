package build;

public class BuildApp {
    public static void main(String[] args) {
Car car = new CarBuilder()
        .buildMake("Audi")
        .buildTransmission(Transmission.AUTO)
        .buildSpead(260)
        .build();

        System.out.println(car);
    }
}
