package minchakov.arkadii.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext.xml"
        );

        MusicPlayer player = new MusicPlayer(
            context.getBean("rapMusicBean", RapMusic.class)
        );

        player.play();

        player = new MusicPlayer(
            context.getBean("rockMusic", RockMusic.class)
        );

        player.play();

        player = new MusicPlayer(
            context.getBean("classicalMusic", ClassicalMusic.class)
        );

        player.play();

        context.close();
    }
}
