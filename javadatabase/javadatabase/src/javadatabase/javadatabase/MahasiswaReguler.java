/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javadatabase;

/**
 *
 * @author agrahizbullah
 */
public class MahasiswaReguler extends Mahasiswa {

    // Constructor khusus untuk perhitungan biaya (memanggil Mahasiswa(int sks, String jenisMahasiswa))
    public MahasiswaReguler(int sks) {
        super(sks, "Reguler");
    }
    
    // Constructor lengkap (memanggil Mahasiswa(String nim, String nama, int tahunmasuk, String jenisMahasiswa, int sks))
    public MahasiswaReguler(String nim, String nama, int tahunmasuk, int sks) {
        super(nim, nama, tahunmasuk, "Reguler", sks);
    }

    // Penerapan Polymorphism
    @Override
    public double hitungBiayaKuliah() {
        // Reguler: sks x 150.000
        return this.sks * 150000.0;
    }
}
