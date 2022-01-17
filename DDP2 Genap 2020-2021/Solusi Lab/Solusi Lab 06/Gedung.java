import java.util.Arrays;

public class Gedung extends Tempat {
    private String[] listRuangan = new String[0];

    public Gedung(String nama, String lokasi, String deskripsi) {
        // TODO: Selesaikan bagian ini!
        super(nama, lokasi, deskripsi,"gedung");
    }
    
    public String[] listSemuaRuangan() {
        return this.listRuangan;
    }

    public void tambahRuangan(String namaRuangan) {
        String[] temp = Arrays.copyOf(this.listRuangan, this.listRuangan.length+1);
        temp[this.listRuangan.length] = namaRuangan;
        this.listRuangan = temp;
    }

    @Override
    public String beraktivitas(String aktivitas) {
        // TODO: Selesaikan bagian ini!
        this.kunjungi();
        String res = "";
        boolean ada = false;
        for (String ruangan : this.listRuangan) {
            if (ruangan.equals(aktivitas)) {
                ada = true;
                break;
            }
        }
        if (ada) {
            res = "Saya belajar di ruang " + aktivitas + ".";
        } else {
            res = "Tidak ada ruangan bernama " + aktivitas + ".";
        }
        super.kunjungi();
        return res;
    }
    @Override
    public String toString() {
        return String.format("Nama: %s\nLokasi: %s\nDeskripsi: %s\nJumlah Ruangan: %d\nSudah dikunjungi: %b", super.getNama(), super.getLokasi(), super.getDeskripsi(), this.listRuangan.length, super.isDikunjungi());
    }
}
