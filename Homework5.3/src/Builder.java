// Product
class Car {
    private String model;
    private String engine;
    private String body;

    public void setModel(String model) { this.model = model; }
    public void setEngine(String engine) { this.engine = engine; }
    public void setBody(String body) { this.body = body; }
}

// Builder
interface CarBuilder {
    void buildModel();
    void buildEngine();
    void buildBody();
    Car getCar();
}

// Director
class CarDirector {
    private CarBuilder builder;

    public void setBuilder(CarBuilder builder) {
        this.builder = builder;
    }

    public void constructCar() {
        builder.buildModel();
        builder.buildEngine();
        builder.buildBody();
    }
}
