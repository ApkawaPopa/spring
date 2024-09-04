package minchakov.arkadii.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Computer {
    private final int id;
    private final MusicPlayer player;

    @Autowired
    public Computer(MusicPlayer player) {
        id = 123;
        this.player = player;
    }

    @Override
    public String toString() {
        return super.toString() + "\nid:" + id + "\nplayer:" + player.play();
    }
}
