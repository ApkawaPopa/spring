package minchakov.arkadii.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:musicPlayer.properties")
@ComponentScan("minchakov.arkadii.spring")
public class SpringConfig {
    @Value("${musicPlayer.name}")
    String name;

    @Value("${musicPlayer.volume}")
    int volume;

    @Bean
    @Scope("singleton")
    ClassicalMusic classicalMusic() {
        return new ClassicalMusic();
    }

    @Bean
    @Scope("prototype")
    RockMusic rockMusic() {
        return new RockMusic();
    }

    @Bean
    MusicPlayer musicPlayer() {
        return new MusicPlayer(rockMusic(), classicalMusic(), name, volume);
    }

    @Bean
    Computer computer() {
        return new Computer(musicPlayer());
    }
}
