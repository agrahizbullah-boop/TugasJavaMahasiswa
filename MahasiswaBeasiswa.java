/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javadatabase;

/**
 *
 * @author agrahizbullah
 */
public class MahasiswaBeasiswa extends Mahasiswa {

    public MahasiswaBeasiswa(int sks) {
        super(sks, "Beasiswa");
    }

    public MahasiswaBeasiswa(String nim, String nama, int tahunmasuk, int sks) {
        super(nim, nama, tahunmasuk, "Beasiswa", sks);
    }

    // Penerapan Polymorphism
    @Override
    public double hitungBiayaKuliah() {
        // Beasiswa: (sks x 150.000) x 50%
        return (this.sks * 150000.0) * 0.50;
    }
}
