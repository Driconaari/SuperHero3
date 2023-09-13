import java.util.ArrayList;

public class Database {
    private ArrayList<Superhero> superheroes = new ArrayList<>();

    public void addSuperhero(Superhero superhero) {
        superheroes.add(superhero);
    }

    public ArrayList<Superhero> getAllSuperheroes() {
        return superheroes;
    }

    // Eventuelle andre metoder til søgning eller opdatering af databasen
}
