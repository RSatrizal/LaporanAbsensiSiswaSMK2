package com.example.lenovo.laporanabsensisiswasmk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /**
     *
     * Variable Global
     */
    String siswa_nama;
    String kelas;
    String jam_tdkhadir;
    String mp_tdkhadir;
    String mp_guru;
    String siswa_pelapor;
    String kelas_pelapor;
    String message;

    boolean isSakit;
    boolean isIzin;
    boolean isKabur;

    EditText siswa_namaEditText;
    EditText kelasEditText;
    EditText jam_tdkhaditEditText;
    EditText mp_tdkhadirEditText;
    EditText mp_guruEditText;
    EditText siswa_pelaporEditText;
    EditText kelas_pelaporEditText;

    TextView laporan_absensiTextView;
    TextView identitas_siswatdkmasukTextView;
    TextView identitas_pelaporTextView;
    TextView alasan_ketidakhadiranTextView;

    CheckBox SakitCheckBox;
    CheckBox IzinCheckBox;
    CheckBox KaburCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Mencari View untuk digunakan dalam program kita
         */
        siswa_namaEditText = (EditText) findViewById(R.id.siswa_nama);
        kelasEditText = (EditText) findViewById(R.id.kelas);
        jam_tdkhaditEditText = (EditText) findViewById(R.id.jam_tdkhadir);
        mp_tdkhadirEditText = (EditText) findViewById(R.id.mp_tdkhadir);
        mp_guruEditText = (EditText) findViewById(R.id.mp_guru);
        siswa_pelaporEditText = (EditText) findViewById(R.id.siswa_pelapor);
        kelas_pelaporEditText = (EditText) findViewById(R.id.kelas_pelapor);

        laporan_absensiTextView = (TextView) findViewById(R.id.laporan_absensi);
        identitas_siswatdkmasukTextView = (TextView) findViewById(R.id.identitas_siswatdkmasuk);
        identitas_pelaporTextView = (TextView) findViewById(R.id.identitas_pelapor);
        alasan_ketidakhadiranTextView = (TextView) findViewById(R.id.alasan_ketidakhadiran);

        SakitCheckBox = (CheckBox) findViewById(R.id.Sakit);
        IzinCheckBox = (CheckBox) findViewById(R.id.Izin);
        KaburCheckBox = (CheckBox) findViewById(R.id.Kabur);
    }

    public void LaporSend(View view) {
        siswa_nama = siswa_namaEditText.getText().toString();
        kelas = kelasEditText.getText().toString();
        jam_tdkhadir = jam_tdkhaditEditText.getText().toString();
        mp_tdkhadir = mp_tdkhadirEditText.getText().toString();
        mp_guru = mp_guruEditText.getText().toString();
        siswa_pelapor = siswa_pelaporEditText.getText().toString();
        kelas_pelapor = kelas_pelaporEditText.getText().toString();

        isSakit = SakitCheckBox.isChecked(); // Set variable berdasarkan status checkbox di View
        isIzin = IzinCheckBox.isChecked();
        isKabur = KaburCheckBox.isChecked();

        /**
         * Rancang isi pesan yang akan dikirim di sini
         */
        message = "Assalamualaikum wr.wb. bpk/ibu orang tua/wali " ;
        message += "\n\n Dengan ini saya informasikan bahwa:";
        message += "\n Anak bpk/ibu yang bernama : " + siswa_nama;
        message += "\n Kelas : "+ kelas;
        message += "\n tidak mengikuti pembelajaran ke- : "+jam_tdkhadir;
        message += "\n pada mata pelakaran : "+mp_tdkhadir;
        message += "\n yang diajarkan oleh : "+mp_guru;

        if (isSakit || isIzin || isKabur) { // Cek apakah menggunakan topping
            message += "\n Alasan :";
            if (isSakit) { // Cek apakah menggunakan Whipped Cream
                message += "\n- Izin pulang karena sakit";
            }
            if (isIzin) { // Cek apakah menggunakan Chocolate
                message += "\n- Izin pulang karena ada kepentingan keluarga";
            }
            if (isKabur) { // Cek apakah menggunakan Ice Cream
                message += "\n- Pulang tanpa alasan/KABUR";
            }
        } else { // masih disekolah
            message += "\nAnak Bpk/Ibu masih berada di sekolah";
        }

        message += "\n "+ siswa_pelapor;
        message += "\n " + kelas_pelapor;
        message += "\n\nTerima Kasih!";

        /**
         * Kirim pesanan ke aplikasi android yang terinstal menggunakan Intent
         */
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, message); // Isi pesan yang berisi detil pesanan
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
}

