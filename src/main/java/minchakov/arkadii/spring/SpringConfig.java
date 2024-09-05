package minchakov.arkadii.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@PropertySource("classpath:musicPlayer.properties")
@ComponentScan("minchakov.arkadii.spring")
public class SpringConfig {
    @Bean
    ClassicalMusic classicalMusic() {
        return new ClassicalMusic();
    }

    @Bean
    RockMusic rockMusic() {
        return new RockMusic();
    }

    @Bean
    RapMusic rapMusic() {
        return new RapMusic();
    }

    @Bean
    List<Music> musicList() {
        return List.of(new RapMusic(), new RockMusic(), new ClassicalMusic());
    }

    @Bean
    MusicPlayer musicPlayer() {
        return new MusicPlayer(musicList());
    }

    @Bean
    Computer computer() {
        return new Computer(musicPlayer());
    }
}
