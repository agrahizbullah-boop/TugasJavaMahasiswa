/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javadatabase;

/**
 *
 * @author agrahizbullah
 */
public class MahasiswaInternasional extends Mahasiswa {

    public MahasiswaInternasional(int sks) {
        super(sks, "Internasional");
    }

    public MahasiswaInternasional(String nim, String nama, int tahunmasuk, int sks) {
        super(nim, nama, tahunmasuk, "Internasional", sks);
    }
    
    // Penerapan Polymorphism
    @Override
    public double hitungBiayaKuliah() {
        // Internasional: (sks x 300.000) + 5.000.000
        return (this.sks * 300000.0) + 5000000.0;
    }
}