package Computer;

public abstract class Computer {
    String name;
    String gender;
    Pokemon pokemon;

    public Computer(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
}
