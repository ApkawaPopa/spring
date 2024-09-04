package minchakov.arkadii.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext.xml"
        );

        MusicPlayer player = context.getBean("musicPlayer", MusicPlayer.class);
        System.out.println(player.play(Genre.CLASSICAL));
        System.out.println(player.play(Genre.ROCK));

        context.close();
    }
}
