package minchakov.arkadii.spring;

import java.util.List;
import java.util.stream.Collectors;

public class MusicPlayer {
    private List<Music> musicList;
    private String name;
    private int volume;

    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

    private MusicPlayer() {
    }

    public void play() {
        System.out.println(
            "Current playlist: " + musicList.stream().map(Music::getSong).collect(Collectors.joining(", "))
        );
    }

    public List<Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
