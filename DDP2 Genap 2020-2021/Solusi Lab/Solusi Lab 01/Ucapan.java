import java.util.*;

public class Ucapan {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        boolean correctMessage = false;
        boolean correctDate = false;

        System.out.print("Masukan tanggal: ");
        int day = in.nextInt();

        in.nextLine();

        System.out.print("Masukan bulan: ");
        String month = in.nextLine();

        System.out.print("Masukan pesan: ");
        String message = in.nextLine();

        if (day == 10 && month.equals("juli")) {
            correctDate = true;
        }

        if (message.equals("happy birthday")) {
            correctMessage = true;
        }

        
        if (correctDate && correctMessage) {
            System.out.println("Terima kasih");
        }

        else if (month.equals("juli") && correctMessage) {
            System.out.println("Bulannya benar, tanggalnya salah");
        }

        else if (day == 10 && correctMessage) {
            System.out.println("Tanggalnya benar, bulannya salah");
        }

        else if (correctMessage) {
            System.out.println("Terima kasih tapi ini bukan ulang tahun aku :D");
        }

        else {
            System.out.println("Biasalah :v");
        }

        in.close();

    }
}