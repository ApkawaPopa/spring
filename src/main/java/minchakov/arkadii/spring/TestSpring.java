package minchakov.arkadii.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        // инит метод классической музыки вызывается только один раз несмотря на три (один в плеере) бина
        // инит метод рока вызывается и перед каждым следующим созданием бина

        MusicPlayer player = context.getBean("musicPlayer", MusicPlayer.class);
        System.out.println("name: " + player.getName() + ", volume: " + player.getVolume());
        player.play();

        ClassicalMusic classicalMusic1 = context.getBean("classicalMusic", ClassicalMusic.class);
        ClassicalMusic classicalMusic2 = context.getBean("classicalMusic", ClassicalMusic.class);

        System.out.println("Is classical music beans equal: " + (classicalMusic1 == classicalMusic2));

        RockMusic rockMusic1 = context.getBean("rockMusic", RockMusic.class);
        RockMusic rockMusic2 = context.getBean("rockMusic", RockMusic.class);

        System.out.println("Is rock music beans equal: " + (rockMusic1 == rockMusic2));

        // дестрой методы рока не вызываются, тк он прототайп и отдается на уничтожение пользователю

        context.close();
    }
}
