package car;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Car implements ICar{

    private String name;

    public Car(String name) {
        this.name = name;
    }

    public Car() {
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void drive() {
        System.out.println(name + " drive");
    }

    @Override
    public void stop() {
        System.out.println(name + " stop");
    }


}
