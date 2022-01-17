
/*
 * TO DO: 
 * Provide Constructor
 * Complete all TO DOs
 * Write setter and getter if needed
 */

public class Trainer {
    private static Pokemon[] allPokemon = new Pokemon[30];
    private static int numOfAllPokemon;
    private Pokemon[] trainersPokemon = new Pokemon[5];
    private int numOfTrainersPokemon;
    private final String name;

    // Constructor
    public Trainer(String name) {
        this.name = name;
    }

    // Getter
    public String getName() {
        return name;
    }

    /**
     * Method untuk menambahkan pokemon ke daftar pokemon
     * @param pokemon Pokemon yang akan ditambahkan ke dalam daftar pokemon
     */
    public void addPokemon(Pokemon pokemon) {
        // Menambahkan ke daftar semua pokemon
        for(int i = 0; i < allPokemon.length; i++){
            if(allPokemon[i] == null) {
                allPokemon[i] = pokemon;
                break;
            }
        }

        // Menambahkan ke daftar pokemon dari trainer
        for(int i = 0; i < trainersPokemon.length; i++){
            if(trainersPokemon[i] == null) {
                trainersPokemon[i] = pokemon;
                break;
            }
        }
    }

    /**
     * Fungsi untuk mengembalikan objek pokemon dengan nama sesuai parameter
     * @param name Nama pokemon
     * @return Objek Pokemon
     */
    public static Pokemon getSpesificPokemon(String name) {
        for (Pokemon pokemon : allPokemon) {
            if (pokemon != null && pokemon.getName().equals(name)) {
                return pokemon;
            }
        }
        return null;
    }

    /**
     * Fungsi untuk mengembalikan objek pokemon dengan battle power terkuat
     * @return Objek Pokemon dengan battle power terkuat
     */
    public static Pokemon getStrongestPokemon() {
        Pokemon strongestPokemon = allPokemon[0];
        for (Pokemon pokemon : allPokemon) {
            if (pokemon != null && pokemon.getBattlePower() > strongestPokemon.getBattlePower()) {
                strongestPokemon = pokemon;
            }
        }
        return strongestPokemon;
    }

    /**
     * Fungsi untuk mengembalikan jumlah battle power seluruh pokemon
     * @return jumlah battle power seluruh pokemon
     */
    public static int getTotalBattlePower() {
        int totalBattlePower = 0;
        for (Pokemon pokemon : allPokemon) {
            if (pokemon != null){
            totalBattlePower += pokemon.getBattlePower();
            }
        } return totalBattlePower;
    }

    /**
     * Fungsi untuk mengembalikan objek pokemon dengan battle power terkuat
     * @return Objek Pokemon dengan battle power terkuat
     */
    public static double getAverageBattlePower() {
        int numberOfPokemon = 0;
        for (Pokemon pokemon : allPokemon) {
            if ( pokemon != null ) numberOfPokemon++;
        }
        return (float) getTotalBattlePower()/numberOfPokemon;
    }

    /**
     * @return string representation of the Trainer
     */
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Daftar pokemon milik ").append(this.name).append(": \n");
        for (Pokemon pokemon: trainersPokemon) {
            if (pokemon == null) break;
            builder.append(pokemon);
            builder.append("\n");
        }
        return builder.toString();
    }
}