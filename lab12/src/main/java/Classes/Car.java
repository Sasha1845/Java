package Classes;

public class Car {
    private String brand;
    private Engine engine;

    public Car(String brand, Engine engine) {
        this.brand = brand;
        this.engine = engine;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean engineIsRunning() {
        return engine.isEngineWorks();
    }
}
