package minchakov.arkadii.spring;

public class Computer {
    private final int id;
    private final MusicPlayer player;

    public Computer(MusicPlayer player) {
        id = 123;
        this.player = player;
    }

    @Override
    public String toString() {
        return super.toString() + "\nid:" + id + "\nplayer:" + player.play(Genre.ROCK);
    }
}
