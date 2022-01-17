import java.util.Scanner;

public class Pizza {

    public static void main(String[] args) {
        // Membuat Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt untuk jumlah pizza
        System.out.print("Masukkan jumlah pizza yang ingin dibeli: ");
        int jumlah = input.nextInt();

        // Membuat variabel untuk harga pizza dan diskon
        final int hargaPizza = 30000;
        int jumlahDiskon = 0;

        // looping untuk menentukan diskon yang diperoleh
        for (int counter = 1; counter < jumlah+1; counter++ ){
            jumlahDiskon += counter;

            // membuat kondisi ketika jumlah diskon melebihi 70%
            if (jumlahDiskon >= 70){
                jumlahDiskon = 70;
                break;
            }
        }

        // Menentukan potongan dan harga setelah potongan
        int potonganDiskon = (hargaPizza*jumlah)*jumlahDiskon/100;
        int hargaSetelahDiskon = (hargaPizza*jumlah) - potonganDiskon;

        // Mencetak output
        System.out.println("Anda mendapatkan diskon " + jumlahDiskon + "%");
        System.out.println("Yang harus kamu bayar sebesar: Rp " + hargaSetelahDiskon);

        // Switch statement untuk menentukan bonus
        switch (jumlahDiskon % 7){
            case 0 -> System.out.println("Cola satu liter gratis untuk kamu!");
            case 2 -> System.out.println("Lemon tea dua gelas gratis untuk kamu!");
            case 4 -> System.out.println("Es teh manis gratis untuk kamu!");
            case 5 -> System.out.println("Teh tawar hangat gratis untuk kamu!");
            case 6 -> System.out.println("Air matang gratis untuk kamu!");
            default -> System.out.println("Maaf kamu terpaksa seret..");
        }

        input.close();

    }
}
