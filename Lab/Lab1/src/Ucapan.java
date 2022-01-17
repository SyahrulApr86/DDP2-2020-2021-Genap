import  java.util.Scanner;

public class Ucapan {

    public static void main(String[] args) {
        // Membuat Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt untuk menerima tanggal
        System.out.print("Masukkan tanggal: ");
        byte day = input.nextByte();
        input.nextLine();

        // Prompt untuk bulan
        System.out.print("Masukkan bulan: ");
        String month = input.nextLine();

        // Prompt untuk ucapan
        System.out.print("Masukkan ucapan: ");
        String message = input.nextLine();

        // Cek tanggal dan bulan
        boolean correctDate = day == 10 && month.equals("juli");

        // Cek ucapan
        boolean correctMessage = message.equals("happy birthday");

        // Conditionals statement untuk mencetak output
        if (correctDate && correctMessage){
            System.out.println("Terima kasih");
        }else if (month.equals("juli") && correctMessage){
            System.out.println("Bulannya benar, tanggalnya salah");
        }else if (day == 10 && correctMessage){
            System.out.println("Tanggalnya benar, bulannya salah");
        }else if (correctMessage){
            System.out.println("Terima kasih tapi ini bukan ulang tahun aku :D");
        }else {
            System.out.println("Biasalah :v");
        }

        input.close();
    }
}
