package build;

public class CarBuilder {
    String m = "Default";
    Transmission t = Transmission.MANUAL;
    int s = 150;

    CarBuilder buildMake(String m){
        this.m = m;
        return this;
    }
    CarBuilder buildTransmission(Transmission t){
        this.t = t;
        return this;
    }
    CarBuilder buildSpead(int s){
        this.s = s;
        return this;
    }

    Car build(){
        Car car = new Car();
        car.setMake(m);
        car.setTransmission(t);
        car.setMaxSpead(s);
        return car;
    }

}
