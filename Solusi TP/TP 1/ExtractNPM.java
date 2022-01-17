import java.util.Scanner;

public class ExtractNPM {
    // Contoh npm
    // 18 01 28082000 1 x
    // 1st part: tahun masuk
    // 2nd part: jurusan
    // 3rd part: tanggal lahir
    // 4th part: uniqueness
    // 5th part: kode npm

    public static long getTahunMasuk(long npm) {
        return npm / 1000000000000L + 2000;
    }

    public static long getKodeJurusan(long npm) {
        return (npm / 10000000000L) % 100;
    }

    public static long getTanggalLahir(long npm) {
        return (npm / 100000000) % 100;
    }
    
    public static long getBulanLahir(long npm) {
        return (npm / 1000000) % 100;
    }

    public static long getTahunLahir(long npm) {
        return (npm / 100) % 10000;
    }

    public static boolean isLengthValid(long npm) {
        return ((int) Math.log10(npm)) + 1 == 14;
    }

    public static boolean isTahunMasukValid(long npm) {
        long tahunMasuk = getTahunMasuk(npm);
        long tahunLahir = getTahunLahir(npm);
        return tahunMasuk - tahunLahir >= 15;
    }

    public static boolean isJurusanValid(long npm) {
        long kodeJurusan = getKodeJurusan(npm);
        return (kodeJurusan > 0 && kodeJurusan <= 3) 
                || (kodeJurusan > 10 && kodeJurusan <= 12) ;
    }

    public static boolean isKodeNPMValid(long npm) {
        long kode = npm % 10;
        npm /= 10;
        int i = 1;
        long temp = 0;
        
        long akhir = npm%1000000;
        long awal = npm/10000000;
        long tengah = (npm/1000000)%10;
        
        while(i<7){
            int digitSatu = (int) akhir%10;
            long pembagiDigitDua = (long)Math.pow(10,6-i);
            int digitDua = (int) (awal/pembagiDigitDua)%10;
            temp += (digitSatu*digitDua);
            akhir /= 10;
            i++;
        }
        temp += tengah;

        long result = 0;
        while (result >= 10 || temp > 0) {
            result += temp % 10;
            temp /= 10;
            if (temp == 0 && result < 10) {
                break;
            } else if (temp == 0) {
                temp = result;
                result = 0;
            }
        }

        return result == kode;
    }

    public static boolean validate(long npm) {
        // System.out.println(isLengthValid(npm));
        // System.out.println(isTahunMasukValid(npm));
        // System.out.println(isJurusanValid(npm));
        // System.out.println(isKodeNPMValid(npm));
        return isLengthValid(npm) && isTahunMasukValid(npm)
                && isJurusanValid(npm) && isKodeNPMValid(npm);
    }

    public static String extractJurusan(long npm) {
        long kodeJurusan = getKodeJurusan(npm);
        if (kodeJurusan == 1) {
            return "Ilmu Komputer";
        } else if (kodeJurusan == 2) {
            return "Sistem Informasi";
        } else if (kodeJurusan == 3) {
            return "Teknologi Informasi";
        } else if (kodeJurusan == 11) {
            return "Teknik Telekomunikasi";
        } else if (kodeJurusan == 12) {
            return "Teknik Elektro";
        } 
        return "";
    }

    public static String extractTanggalLahir(long npm) {
        Long tanggal = getTanggalLahir(npm);
        Long bulan = getBulanLahir(npm);
        Long tahun = getTahunLahir(npm);
        return String.format("%02d-%02d-%04d", tanggal, bulan, tahun);
    }

    public static String extract(long npm) {
        String result = "";
        result += "Tahun masuk: " + Long.toString(getTahunMasuk(npm)) + "\n";
        result += "Jurusan: " + extractJurusan(npm) + "\n";
        result += "Tanggal Lahir: " + extractTanggalLahir(npm);
        return result;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        boolean exitFlag = false;
        while (!exitFlag) {
            System.out.println(">>> Masukkan NPM:");
            long npm = input.nextLong();
            if (npm < 0) {
                System.out.println(">>> Bye Bye!");
                exitFlag = true;
                break;
            }
            boolean valid = validate(npm);
            if (!valid) {
                System.out.println(">>> NPM tidak valid!");
                System.out.println("=====================");
                continue;
            }
            String result = extract(npm);
            System.out.println(">>> Hasil:");
            System.out.println(result);
            System.out.println("=====================");
        }
        input.close();
    }
}