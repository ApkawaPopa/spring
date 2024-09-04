package minchakov.arkadii.spring;

import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Music {
    private final String[] songs = new String[]{"Соната 1", "Симфония 2", "Реквием 3"};

    @Override
    public String getSong(int n) {
        return songs[n];
    }

    @Override
    public Genre getGenre() {
        return Genre.CLASSICAL;
    }
}
