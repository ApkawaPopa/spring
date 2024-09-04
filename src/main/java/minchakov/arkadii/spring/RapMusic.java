package minchakov.arkadii.spring;

import org.springframework.stereotype.Component;

@Component("rapMusicBean")
public class RapMusic implements Music {
    @Override
    public String getSong() {
        return "Slim Shady";
    }
}
