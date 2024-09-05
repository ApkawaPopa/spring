package minchakov.arkadii.spring;

public class RapMusic implements Music {
    private final String[] songs = new String[]{"Бандана", "Валентина", "Air Force 1"};

    @Override
    public String getSong(int n) {
        return songs[n];
    }

    @Override
    public Genre getGenre() {
        return Genre.RAP;
    }
}
