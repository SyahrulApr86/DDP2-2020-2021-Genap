import java.util.Scanner;

public class Simulator {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Dogegochi dogegochi = new Dogegochi();
    boolean looper = true;
    String commandString;

    System.out.println("Selamat Datang di Dogegochi!");
    System.out.println("Perintah yang dapat dijalankan Dogegochi :");
    System.out.println("1. Main");
    System.out.println("2. Makan");
    System.out.println("3. Selesai Bermain");

    while(looper) {
      System.out.println();
      dogegochi.getStatus();
      System.out.print("Masukkan Perintah: ");
      commandString = input.nextLine();
      int command = Integer.parseInt(commandString);
      if (command == 1) {
        dogegochi.play();
      } else if (command == 2) {
        System.out.print("Masukkan Makanan dan jumlahnya: ");
        String food = input.nextLine();
        String[] foodCommand = food.split(" ");
        try {
          int quantity = Integer.parseInt(foodCommand[1]);
          dogegochi.eat(foodCommand[0], quantity);
        } catch (ArrayIndexOutOfBoundsException exception){
          System.out.println("[FAILED: Kamu tidak memberikan jumlah makanan yang ingin diberikan]");
        } catch (NumberFormatException exception){
          System.out.println("[FAILED: Jumlah makanan harus berupa angka]");
        }

      } else if (command == 3) {
        looper = false;
      } else {
        System.out.println("[FAILED: Doge tidak mengerti perintah ini]");
      }
    }
    System.out.println("[Bye-bye doge!!]");
    input.close();
  }
}
