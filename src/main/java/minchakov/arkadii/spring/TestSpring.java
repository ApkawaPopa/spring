package minchakov.arkadii.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext.xml"
        );

        System.out.println("Я вывожусь до создания ссылки на бин");

        Music rap = context.getBean("rapMusicBean", RapMusic.class);

        for (int i = 0; i < 3; i++) {
            Music rock = context.getBean("rockMusicBean", RockMusic.class);
        }

        System.out.println("Я вывожусь до закрытия контекста");

        Music classical1 = context.getBean("classicalMusicBean", ClassicalMusic.class);
        Music classical2 = context.getBean("classicalMusicBean", ClassicalMusic.class);

        System.out.println("Ссылки на синглтон-бины, созданные фабричным методом, однинаковые:\n" + classical1 + "\n" + classical2);

        context.close();
    }
}
