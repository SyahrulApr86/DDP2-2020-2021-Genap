import java.util.*;

public class Trainer {
    private static Pokemon[] allPokemon = new Pokemon[30];
    private static int numOfAllPokemon;
    private Pokemon[] trainersPokemon;
    private int numOfTrainersPokemon;
    private String name;

    public Trainer(String name) {
        this.name = name;
        this.trainersPokemon = new Pokemon[5];
    }

    public void addPokemon(Pokemon pokemon) {
        trainersPokemon[numOfTrainersPokemon] = pokemon;
        allPokemon[numOfAllPokemon] = pokemon;
        numOfTrainersPokemon++;
        numOfAllPokemon++;
    }

    public static Pokemon getSpesificPokemon(String name) {
        Pokemon returnPokemon = null;
        for (Pokemon pokemon : allPokemon) {
            if (pokemon == null) break;
            if (pokemon.getName().equalsIgnoreCase(name)) {
                returnPokemon = pokemon;
                break;
            }
        }
        return returnPokemon;
    }

    public static Pokemon getStrongestPokemon() {
        Pokemon strongestPokemon = allPokemon[0];
        for (Pokemon pokemon : allPokemon) {
            if (pokemon == null) break;
            if (pokemon.getBattlePower() > strongestPokemon.getBattlePower()) {
                strongestPokemon = pokemon;
            }
        }
        return strongestPokemon;
    }

    public static int getTotalBattlePower() {
        int totalPower = 0;
        for (Pokemon pokemon : allPokemon) {
            if (pokemon == null)
                break;
            totalPower += pokemon.getBattlePower();
        }
        return totalPower;
    }

    public static double getAverageBattlePower() {
        return getTotalBattlePower() / numOfAllPokemon;
    }

    public String getName() {
        return this.name;
    }

    /**
     * @return string representation of the Trainer
     */
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Daftar pokemon milik " + this.name + ": \n");
        for (Pokemon pokemon: trainersPokemon) {
            if (pokemon == null) break;
            builder.append(pokemon.toString());
            builder.append("\n");
        }
        return builder.toString();
    }
}