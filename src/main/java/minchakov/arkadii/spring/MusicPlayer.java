package minchakov.arkadii.spring;

import java.util.Random;

public class MusicPlayer {
    private final Music music1;
    private final Music music2;
    private final Random random;
    private final int volume;
    private final String name;

    public MusicPlayer(
        Music music1,
        Music music2,
        String name,
        int volume
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
