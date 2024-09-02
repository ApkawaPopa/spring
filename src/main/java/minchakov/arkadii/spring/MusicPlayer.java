package minchakov.arkadii.spring;

public class MusicPlayer {
    private Music music;

    public MusicPlayer(Music music) {
        this.music = music;
    }

    public void play() {
        System.out.println("Current cong: " + music.getSong());
    }
}
