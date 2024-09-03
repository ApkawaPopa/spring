package minchakov.arkadii.spring;

public class RockMusic implements Music {
    private void init() {
        System.out.println("Init rock!");
    }

    private void destroy() {
        System.out.println("Destroy rock!");
    }

    @Override
    public String getSong() {
        return "Wind Never Cries";
    }
}
