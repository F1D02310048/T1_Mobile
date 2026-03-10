
// Nama : Fadila Rahmania
// NIM  : F1D02310048

import java.util.Scanner

/**
    Menghitung nilai akhir mahasiswa berdasarkan bobot:
    UTS (30%), UAS (40%), dan Tugas (30%).
 */
fun hitungNilaiAkhir(uts: Double, uas: Double, tugas: Double): Double {
    return (uts * 0.3) + (uas * 0.4) + (tugas * 0.3)
}


// Menentukan grade (A-E) berdasarkan akumulasi nilai akhir yang diperoleh mahasiswa
fun tentukanGrade(nilai: Double): String {
    return when {
        nilai >= 85 -> "A"
        nilai >= 70 -> "B"
        nilai >= 60 -> "C"
        nilai >= 50 -> "D"
        nilai >= 0  -> "E"
        else -> "Nilai Tidak Valid"
    }
}

// Menentukan keterangan (label) dari setiap grade (A-E)
fun keteranganGrade(grade: String): String {
    return when (grade) {
        "A" -> "Sangat Baik"
        "B" -> "Baik"
        "C" -> "Cukup"
        "D" -> "Kurang"
        "E" -> "Sangat Kurang"
        else -> "Nilai Tidak Valid"
    }
}

//
/**
 * Menentukan status kelulusan mahasiswa dengan aturan nilai harus >= 60 untuk LULUS,
 * namun jika sebaliknya maka mahasiswa dinyatakan TIDAK LULUS
 */
fun statusKelulusan(nilai: Double): String {
    return if (nilai >= 60) "LULUS" else "TIDAK LULUS"
}

fun main() {
    // Inisialisasi Scanner untuk menerima input dari keyboard
    val input = Scanner(System.`in`)

    println("===== SISTEM PENILAIAN AKADEMIK =====\n")

    // Proses pengambilan data input dari user
    print("Masukkan Nama: ")
    val namaMahasiswa = input.nextLine()

    print("Masukkan Nilai UTS (0-100): ")
    val uts = input.nextDouble()

    print("Masukkan Nilai UAS (0-100): ")
    val uas = input.nextDouble()

    print("Masukkan Nilai Tugas (0-100): ")
    val tugas = input.nextDouble()

    // Memproses data menggunakan fungsi-fungsi yang telah dibuat
    val nilaiAkhir = hitungNilaiAkhir(uts, uas, tugas)
    val grade = tentukanGrade(nilaiAkhir)
    val keterangan = keteranganGrade(grade)
    val status = statusKelulusan(nilaiAkhir)

    // Output hasil perhitungan dan evaluasi ke layar
    println("\n==== HASIL PENILAIAN ====")
    println("Nama        : $namaMahasiswa")
    println("Nilai UTS   : $uts")
    println("Nilai UAS   : $uas")
    println("Nilai Tugas : $tugas")
    println("----------------------------")
    println("Nilai Akhir : $nilaiAkhir")
    println("Grade       : $grade")
    println("Keterangan  : $keterangan")
    println("Status      : $status")

    if (status == "LULUS") {
        println("Selamat! Anda dinyatakan $status")
    } else {
        println("Anda dinyatakan $status")
    }
}