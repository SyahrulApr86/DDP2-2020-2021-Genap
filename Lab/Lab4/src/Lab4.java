import java.util.Scanner;

public class Lab4 {
    public static int size;

    public static void main(String[] args) {
        // Membuat Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt untuk input ukuran kolom dan baris
        System.out.print("Ukuran kolom dan baris: ");
        size = Integer.parseInt(input.nextLine());
        int[][] peta = new int[size][size];

        // Prompt untuk input matriks
        System.out.println("Peta matrix: ");
        for (int i = 0; i < peta.length; i++) {
            for (int u = 0; u < peta.length; u++){
                int data = input.nextInt();
                peta[i][u] = data;
            }input.nextLine();
        }

        // Prompt untuk menentukan putaran
        System.out.print("Putaran: ");
        String urutanTahap = input.nextLine();

        // Conditionals Statement untuk memproses matriks
        for (int i = 0; i < urutanTahap.length(); i++) {
            char currentStep = urutanTahap.charAt(i);
            if (currentStep == 'L') {
                peta = putarPetaKiri(peta);
            } else if (currentStep == 'R') {
                peta = putarPetaKanan(peta);
            }
        }

        printPeta(peta, size);
        input.close();

    }

    /**
     * Method untuk mencetak array multidimensi sebagai sebuah matriks
     * @param peta Array multidimensi yang akan dicetak sebagi matriks
     * @param size Ukuran matriks
     */
    public static void printPeta(int[][] peta, int size) {
        System.out.println("Output: ");
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                System.out.print(peta[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Method untuk memutar matriks ke kiri
     * @param peta Array multidimensi yang akan diputar
     * @return Array multidimensi setelah diputar
     */
    public static int[][] putarPetaKiri(int[][] peta) {
        int[][] newPeta = new int[peta.length][peta.length];

        for (int i = 0; i < peta.length; i++){
            for (int j = 0; j < peta.length; j++) {
                newPeta[peta.length-1-j][i] = peta[i][j];
            }
        }
        return newPeta;
    }

    /**
     * Method untuk memutar matriks ke kanan
     * @param peta Array multidimensi yang akan diputar
     * @return Array multidimensi setelah diputar
     */
    public static int[][] putarPetaKanan(int[][] peta) {
        int[][] newPeta = new int[peta.length][peta.length];

        for (int i = 0; i < peta.length; i++){
            for (int j = 0; j < peta.length; j++) {
                newPeta[j][peta.length-1-i] = peta[i][j];
            }
        }
        return newPeta;
    }
}