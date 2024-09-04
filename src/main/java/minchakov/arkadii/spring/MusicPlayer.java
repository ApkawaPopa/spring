package minchakov.arkadii.spring;

public class MusicPlayer {
    private final Music music;

    public MusicPlayer(Music music) {
        this.music = music;
    }

    public void play() {
        System.out.println("Playing: " + music.getSong());
    }
}
