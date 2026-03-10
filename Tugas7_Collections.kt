// Nama : Fadila Rahmania
// NIM  : F1D02310048

import java.util.Scanner

// Data class untuk menyimpan struktur data mahasiswa
data class NilaiMahasiswa(
    val nim: String,
    val nama: String,
    val mataKuliah: String,
    val nilai: Int
)

// Menampilkan semua data mahasiswa dalam format tabel
fun tampilkanData(data: List<NilaiMahasiswa>) {
    println("==== DATA NILAI MAHASISWA ====")
    println(String.format("%-4s %-10s %-15s %-20s %-5s",
        "No", "NIM", "Nama", "MataKuliah", "Nilai"))

    var no = 1
    for (mhs in data) {
        println(String.format("%-4d %-10s %-15s %-20s %-5d",
            no, mhs.nim, mhs.nama, mhs.mataKuliah, mhs.nilai))
        no++
    }
}

// Menentukan grade alfabet berdasarkan skor nilai
fun cariGrade(nilai: Int): String {
    return when {
        nilai >= 85 -> "A"
        nilai >= 75 -> "B"
        nilai >= 65 -> "C"
        nilai >= 55 -> "D"
        else -> "E"
    }
}

// Memfilter dan menampilkan mahasiswa yang lulus (nilai >= 70)
fun tampilkanLulus(data: List<NilaiMahasiswa>) {
    println("\n== Mahasiswa Lulus (>=70) ==")
    for (mhs in data) {
        if (mhs.nilai >= 70) {
            println("${mhs.nama} - ${mhs.nilai}")
        }
    }
}

// Memfilter dan menampilkan mahasiswa yang tidak lulus (nilai < 70)
fun tampilkanTidakLulus(data: List<NilaiMahasiswa>) {
    println("\n== Mahasiswa Tidak Lulus (<70) ==")
    for (mhs in data) {
        if (mhs.nilai < 70) {
            println("${mhs.nama} - ${mhs.nilai}")
        }
    }
}

// Menghitung rata-rata nilai dari seluruh mahasiswa
fun hitungRataRata(data: List<NilaiMahasiswa>) {
    var total = 0
    for (mhs in data) {
        total += mhs.nilai
    }
    val rata = total.toDouble() / data.size
    println("\nRata-rata Nilai: %.2f".format(rata))
}

// Mencari dan menampilkan mahasiswa dengan nilai tertinggi dan terendah
fun tampilkanNilaiEkstrem(data: List<NilaiMahasiswa>) {
    val tertinggi = data.maxByOrNull { it.nilai }
    val terendah = data.minByOrNull { it.nilai }

    println("\nMahasiswa Nilai Tertinggi:")
    println("${tertinggi?.nama} - ${tertinggi?.nilai}")

    println("\nMahasiswa Nilai Terendah:")
    println("${terendah?.nama} - ${terendah?.nilai}")
}

// Fitur pencarian mahasiswa berdasarkan input nama
fun cariMahasiswa(data: List<NilaiMahasiswa>, scanner: Scanner) {
    print("\nMasukkan nama yang ingin dicari: ")
    val namaCari = scanner.nextLine()

    val hasil = mutableListOf<NilaiMahasiswa>()

    // Mencocokkan input nama dengan data (case insensitive)
    for (mhs in data) {
        if (mhs.nama.contains(namaCari, true)) {
            hasil.add(mhs)
        }
    }

    if (hasil.isEmpty()) {
        println("Tidak ada mahasiswa dengan nama \"$namaCari\"")
    } else {
        println("\nMahasiswa ditemukan:")
        println(String.format("%-10s %-15s %-20s %-5s",
            "NIM", "Nama", "MataKuliah", "Nilai"))

        for (mhs in hasil) {
            println(String.format("%-10s %-15s %-20s %-5d",
                mhs.nim, mhs.nama, mhs.mataKuliah, mhs.nilai))
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)

    // Inisialisasi daftar data mahasiswa (List)
    val mahasiswa = listOf(
        NilaiMahasiswa("F1D02310048", "Fadila Rahmania", "Kecerdasan Buatan", 90),
        NilaiMahasiswa("F1D02310052", "Fitri Nufa", "Aljabar Linear", 80),
        NilaiMahasiswa("F1D02310098", "Yusri Abdi", "Pemrograman", 70),
        NilaiMahasiswa("F1D02310123", "M. Wahyu Hilal", "Matematika Diskrit", 75),
        NilaiMahasiswa("F1D02310042", "Bq. Alfia Zahira", "Kalkulus", 60),
        NilaiMahasiswa("F1D02310072", "M. Bayu Aji", "Sistem Operasi", 85),
        NilaiMahasiswa("F1D02310062", "Izzat Nazhiefa", "Jaringan", 95),
        NilaiMahasiswa("F1D02310097", "Pandu Alam", "Basis Data", 65),
        NilaiMahasiswa("F1D02310036", "Fadlullah Hasan", "Struktur Data", 50),
        NilaiMahasiswa("F1D02310054", "Nurmiftah", "Statistika", 55)
    )

    // Memanggil fungsi-fungsi pengolah data
    tampilkanData(mahasiswa)
    tampilkanLulus(mahasiswa)
    tampilkanTidakLulus(mahasiswa)
    hitungRataRata(mahasiswa)
    tampilkanNilaiEkstrem(mahasiswa)

    // Mengurutkan data berdasarkan nilai terkecil ke terbesar
    println("\n== Nilai Ascending ==")
    val asc = mahasiswa.sortedBy { it.nilai }
    for (mhs in asc) {
        println("${mhs.nama} - ${mhs.nilai}")
    }

    // Mengurutkan data berdasarkan nilai terbesar ke terkecil
    println("\n== Nilai Descending ==")
    val desc = mahasiswa.sortedByDescending { it.nilai }
    for (mhs in desc) {
        println("${mhs.nama} - ${mhs.nilai}")
    }

    // Mengelompokkan mahasiswa berdasarkan Grade
    println("\n== Kelompok Grade ==")
    val kelompok = mahasiswa.groupBy { cariGrade(it.nilai) }

    for ((grade, daftar) in kelompok) {
        println("Grade $grade:")
        for (mhs in daftar) {
            println("  ${mhs.nama} - ${mhs.nilai}")
        }
    }

    // Menghitung jumlah frekuensi mahasiswa pada setiap Grade
    println("\n== Jumlah Mahasiswa per Grade ==")
    val jumlah = mahasiswa.groupingBy { cariGrade(it.nilai) }.eachCount()
    for ((grade, jml) in jumlah) {
        println("Grade $grade : $jml mahasiswa")
    }

    // Menjalankan fitur pencarian
    cariMahasiswa(mahasiswa, scanner)
}