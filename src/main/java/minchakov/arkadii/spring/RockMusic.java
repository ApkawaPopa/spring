package minchakov.arkadii.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("prototype")
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
