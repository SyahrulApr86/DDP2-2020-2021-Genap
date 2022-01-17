import java.util.*;

public class Simulator {
    public static void main(String[] args) {
        // INITIALIZATION SECTION

        Trainer ash = new Trainer("Ash");
        ash.addPokemon(new Pokemon("Sceptile", ash, 1, 100));
        ash.addPokemon(new Pokemon("Pikachu", ash, 2, 200));
        ash.addPokemon(new Pokemon("Charizard", ash, 3, 150));
        System.out.println(ash);

        Trainer may = new Trainer("May");
        may.addPokemon(new Pokemon("Eeve", may, 1, 75));
        may.addPokemon(new Pokemon("Squirtle", may, 1, 90));
        may.addPokemon(new Pokemon("Skitty", may, 1, 85));
        may.addPokemon(new Pokemon("Venusaur", may, 3, 80));
        System.out.println(may);

        Trainer james = new Trainer("James");
        james.addPokemon(new Pokemon("Numel", james , 1, 90));
        james.addPokemon(new Pokemon("Victreebell", james, 2, 90));
        System.out.println(james);
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");

        // INPUT SECTION

        Scanner in = new Scanner(System.in);
        boolean hasChosenExit = false;
        System.out.println("Selamat datang di database Pacilmon ");
        while (!hasChosenExit) {
            System.out.println();
            System.out.println("1. Cari Pokemon berdasarkan nama");
            System.out.println("2. Cari Pokemon terkuat");
            System.out.println("3. Lihat rata-rata kekuatan Pokemon");
            System.out.println("4. Exit");
            System.out.print("Silahkan masukkan perintah yang ingin dijalankan: ");

            int menu = in.nextInt();
            if (menu == 4) {
                hasChosenExit = true;
            } else {
                Pokemon pokemon;
                switch (menu) {
                    case 1:
                        System.out.print("Masukkan nama pokemon yang ingin dicari: ");
                        String namaPokemon = in.next();
                        pokemon = Trainer.getSpesificPokemon(namaPokemon);
                        if (pokemon == null) {
                            System.out.println("Pokemon tidak ditemukan");
                        } else {
                            System.out.println(pokemon);
                        }
                        break;
                    case 2:
                        pokemon = Trainer.getStrongestPokemon();
                        System.out.println(pokemon);
                        break;
                    case 3:
                        double avgPower = Trainer.getAverageBattlePower();
                        System.out.println("Rata-rata battle power para pokemon adalah " + avgPower);
                        break;
                    default:
                        System.out.println("Pastikan menu yang dipilih benar");
                        break;
                }
            }
        }
        System.out.println("Terima kasih sudah menggunakan database Pacilmon");
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        in.close();
    }
}