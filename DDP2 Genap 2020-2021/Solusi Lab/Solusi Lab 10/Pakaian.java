public class Pakaian extends Barang {

	private char ukuran;

	private String warna;

	public Pakaian(int bobot, String nama, String warna, char ukuran) {
		super(bobot, nama);
		this.warna = warna;
		this.ukuran = ukuran;
	}

	public String getRekap() {
        return String.format(
            "Barang Elektronik %s\n" + 
            "Bobot: %d\n" + 
            "Ukuran: %c\n" +
			"Warna: %s", 
            super.getNama(), super.getBobot(), this.ukuran, this.warna);
    }

}