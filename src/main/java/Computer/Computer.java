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
        JSONObject[][] pokemon = new JSONObject[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int randomNumb = rand.nextInt(0,pokemons.length-1);
//                System.out.println("Requested: " + pokemons[randomNumb]);
                pokemon[i][j] = getJSONObject("https://pokeapi.co/api/v2/pokemon/" + (pokemons[randomNumb]).toLowerCase());
            }
        }


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
//                JButton pokebutton = new JButton("" + pokemon[i][j].get("name"));

                JSONObject sprites = (JSONObject) pokemon[i][j].get("sprites");
                System.out.println(sprites.get("front_default"));

                ImageIcon img = new ImageIcon("" + sprites.get("front_default"));

                JButton pokebutton = new JButton(img);
                pokebutton.setBounds((j+1) * 100 + 50, (i+1) * 100 + 50, 100,100);
                contentpane.add(pokebutton);
            }
        }




    }
}
