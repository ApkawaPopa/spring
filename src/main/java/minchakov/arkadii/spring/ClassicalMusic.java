package minchakov.arkadii.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class ClassicalMusic implements Music {
    private final String[] songs = new String[]{"Соната 1", "Симфония 2", "Реквием 3"};

    @PostConstruct
    private void init() {
        System.out.println("Classical music init");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Classical music destroy");
    }

    @Override
    public String getSong(int n) {
        return songs[n];
    }

    @Override
    public Genre getGenre() {
        return Genre.CLASSICAL;
    }
}
