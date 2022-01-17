import java.util.Arrays;

public class Tempat {
    private String nama;
    private String lokasi;
    private String deskripsi;
    private String tipeTempat;
    private boolean dikunjungi = false;
    static Tempat[] semuaTempat = new Tempat[0];
    
    public Tempat(String nama, String lokasi, String deskripsi, String tipeTempat) {
        this.nama = nama;
        this.lokasi = lokasi;
        this.deskripsi = deskripsi;
        this.tipeTempat = tipeTempat;
    }

    public String kunjungi() {
        // TODO: Selesaikan bagian ini!
        this.dikunjungi = true;
        return String.format("Saya mengunjungi %s.", this.nama); 
    }

    public String getTipeTempat() {
        return this.tipeTempat;
    }

    public String beraktivitas(String aktivitas, String namaTempat){
        Tempat tempat = getTempat(namaTempat);
        if (tempat.getTipeTempat().equals("gedung") && aktivitas.toLowerCase().startsWith("belajar")) {
            return tempat.beraktivitas(aktivitas.substring(8));
        } else if (tempat.getTipeTempat().equals("labkom") && aktivitas.toLowerCase().equalsIgnoreCase("gunakan komputer")) {
            return tempat.beraktivitas(aktivitas);
        }
        return String.format("Di %s, aktivitas %s tidak dapat dilakukan.",namaTempat, aktivitas);
    }

    public String beraktivitas(String aktivitas) {
        return String.format("Saya melakukan %s di %s.", aktivitas, this.nama);
    }

    public String getNama() {
        return this.nama;
    }

    public String getLokasi() {
        return this.lokasi;
    }

    public String getDeskripsi() {
        return this.deskripsi;
    }

    public boolean isDikunjungi() {
        return this.dikunjungi;
    }

    public String toString() {
        return String.format("Nama: %s\nLokasi: %s\nDeskripsi: %s\nSudah dikunjungi: %b", nama, lokasi, deskripsi, dikunjungi);
    }

    public static Tempat getTempat(String namaTempat) {
        for (Tempat tempat : Tempat.semuaTempat){
            if (tempat.getNama().equals(namaTempat)){
                return tempat;
            }
        }
        return null;
    }

    public static void tambahArrayTempat(Tempat value) {
        Tempat[] temp = Arrays.copyOf(semuaTempat, semuaTempat.length+1);
        temp[semuaTempat.length] = value;
        semuaTempat = temp;
    }
}
