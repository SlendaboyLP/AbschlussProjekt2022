package Computer;

import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static Computer.JSON.getJSON.getJSONObject;

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

    public void choosePokemon(Container contentpane){
        Random rand = new Random();

        String[] pokemons = Pokemon.allPokemon;
        JSONObject[] pokemon = new JSONObject[16];
        for (int i = 0; i < 16; i++) {
            int randomNumb = rand.nextInt(0,pokemons.length-1);
            System.out.println("Requested: " + pokemons[randomNumb]);
            pokemon[i] = getJSONObject("https://pokeapi.co/api/v2/pokemon/" + (pokemons[randomNumb]).toLowerCase());
//            System.out.println("Recieved: " + pokemon.get("name"));
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JButton pokebutton = new JButton("" + pokemon[j+i].get("name"));
                pokebutton.setBounds((j+1) * 100 + 50, (i+1) * 100 + 50, 100,100);
                contentpane.add(pokebutton);
            }
        }




    }
}
