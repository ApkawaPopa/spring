package minchakov.arkadii.spring;

import org.springframework.stereotype.Component;

@Component
public class RockMusic implements Music {
    private final String[] songs = new String[]{"Wind Cries Mary", "Владивосток 3000", "Smells Like Teen Spirit"};

    @Override
    public String getSong(int n) {
        return songs[n];
    }

    @Override
    public Genre getGenre() {
        return Genre.ROCK;
    }
}
