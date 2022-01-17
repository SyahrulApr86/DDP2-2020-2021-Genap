import java.util.Scanner;

public class SolusiLab4 {
    public static int size;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ukuran kolom dan baris: ");
        size = Integer.parseInt(input.nextLine());
        int[][] peta = new int[size][size];

        System.out.println("Peta matrix: ");
        /* TO DO: Assign data ke multidimensional array */
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                int data = input.nextInt();
                peta[i][j] = data;
            }
            input.nextLine();
        }

        System.out.print("Putaran: ");
        String urutanTahap = input.nextLine();

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

    public static void printPeta(int[][] peta, int size) {
        System.out.println("Output: ");
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                System.out.print(peta[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] putarPetaKiri(int[][] peta) {
        int[][] petaBaru = new int[peta.length][peta.length];
        for (int i = 0; i < peta.length; i++) {
            for (int j = 0; j < peta.length; j++) {
                petaBaru[i][j] = peta[j][peta.length - i - 1];
            }
        }

        return petaBaru;
    }

    public static int[][] putarPetaKanan(int[][] peta) {
        /* TO DO: Melakukan rotate kanan pada peta */
        int[][] petaBaru = new int[peta.length][peta.length];
        for (int i = 0; i < peta.length; i++) {
            for (int j = 0; j < peta.length; j++) {
                petaBaru[i][j] = peta[peta.length - j - 1][i];
            }
        }

        return petaBaru;
    }
}