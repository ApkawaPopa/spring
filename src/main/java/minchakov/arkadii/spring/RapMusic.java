package minchakov.arkadii.spring;

public class RapMusic implements Music {
    private void init() {
        System.out.println("Init!");
    }

    @Override
    public String getSong() {
        return "Slim Shady";
    }

    private void destroy() {
        System.out.println("Destroy!");
    }
}
