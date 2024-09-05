package minchakov.arkadii.spring;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Random;

public class MusicPlayer {
    private final List<Music> musicList;
    private final Random random;

    @Value("${musicPlayer.name}")
    String name;

    @Value("${musicPlayer.volume}")
    int volume;

    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
        random = new Random();
    }

    public String play() {
        return "Playing: " + musicList.get(random.nextInt(3)).getSong(random.nextInt(3));
    }

    public int getVolume() {
        return volume;
    }

    public String getName() {
        return name;
    }
}
