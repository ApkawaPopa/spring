package minchakov.arkadii.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext.xml"
        );

        MusicPlayer player = context.getBean("musicPlayerBean", MusicPlayer.class);
        System.out.println(player.getName());
        System.out.println(player.getVolume());
        player.play();

        context.close();
    }
}
