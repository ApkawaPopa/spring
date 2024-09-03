package minchakov.arkadii.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext.xml"
        );

        MusicPlayer player1 = context.getBean("musicPlayerBean", MusicPlayer.class);
        MusicPlayer player2 = context.getBean("musicPlayerBean", MusicPlayer.class);

        System.out.println("default toString():\n" + player1 + "\n" + player2);
        System.out.println("equal: " + (player1 == player2));
        assert player1 != player2;

        System.out.println("\nvolumes: " + player1.getVolume() + " " + player2.getVolume());
        assert player1.getVolume() == 9;
        assert player2.getVolume() == 9;

        player2.setVolume(20);
        System.out.println("volumes: " + player1.getVolume() + " " + player2.getVolume());
        assert player1.getVolume() == 9;
        assert player1.getVolume() == 20;

        context.close();
    }
}
