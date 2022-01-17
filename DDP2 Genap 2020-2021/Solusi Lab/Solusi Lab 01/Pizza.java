import java.util.*;

public class Pizza {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah pizza yang ingin dibeli: ");
        int jumlah = input.nextInt();

        int hargaPizza = 30000;
        int jumlahDiskon = 0;

        for (int i = 1; i <= jumlah; i++) {

            jumlahDiskon += i;

            if (jumlahDiskon >= 70) {
                jumlahDiskon = 70;
                break;
            }

        }

        int potonganDiskon = (hargaPizza * jumlah) * jumlahDiskon / 100;
        int hargaSetelahDiskon = (hargaPizza * jumlah) - potonganDiskon;

        System.out.println("Anda mendapatkan diskon " + jumlahDiskon + "%");
        System.out.println("Yang harus kamu bayar sebesar: Rp " + hargaSetelahDiskon);

        switch (jumlahDiskon % 7) {

        case 0:
            System.out.println("Cola satu liter gratis untuk kamu!");
            break;

        case 2:
            System.out.println("Lemon tea dua gelas gratis untuk kamu!");
            break;

        case 4:
            System.out.println("Es teh manis gratis untuk kamu!");
            break;

        case 5:
            System.out.println("Teh tawar hangat gratis untuk kamu!");
            break;

        case 6:
            System.out.println("Air matang gratis untuk kamu!");
            break;

        default:
            System.out.println("Maaf kamu terpaksa seret");
        }
        input.close();
    }
}