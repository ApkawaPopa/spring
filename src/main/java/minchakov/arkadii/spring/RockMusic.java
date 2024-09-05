package minchakov.arkadii.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class RockMusic implements Music {
    private final String[] songs = new String[]{"Wind Cries Mary", "Владивосток 3000", "Smells Like Teen Spirit"};

    @PostConstruct
    private void init() {
        System.out.println("Rock music init");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Rock music destroy");
    }

    @Override
    public String getSong(int n) {
        return songs[n];
    }

    @Override
    public Genre getGenre() {
        return Genre.ROCK;
    }
}
