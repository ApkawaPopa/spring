package minchakov.arkadii.spring;

public class Singleton {
    private static Singleton instance;

    private String value;

    private Singleton(String value) {
        this.value = value;
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton("Initial");
        }

        return instance;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

class TestSingleton {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println("singleton1 == singleton2: " + (singleton1 == singleton2));

        System.out.println("\nsingleton1.value: " + singleton1.getValue());
        System.out.println("singleton2.value: " + singleton2.getValue());

        singleton1.setValue("Changed");
        System.out.println("\nsingleton1.value: " + singleton1.getValue());
        System.out.println("singleton2.value: " + singleton2.getValue());
    }
}
