package minchakov.arkadii.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MusicPlayer {
    private final Music music1;
    private final Music music2;
    private final Random random;
    private final int volume;
    private final String name;

    @Autowired
    public MusicPlayer(
        @Qualifier("rockMusic") Music music1,
        @Qualifier("classicalMusic") Music music2,
        @Value("${musicPlayer.name}") String name,
        @Value("${musicPlayer.volume}") int volume
    ) {
        this.music1 = music1;
        this.music2 = music2;
        random = new Random();
        this.name = name;
        this.volume = volume;
    }

    public String play(Genre genre) {
        int n = random.nextInt(3);
        return "Playing: " + (music1.getGenre() == genre ? music1.getSong(n) : music2.getSong(n));
    }

    public int getVolume() {
        return volume;
    }

    public String getName() {
        return name;
    }
}
