package com.example.aplikasiwisatatalabricked;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    String[] namaTempatWisata = {
            "Pulau Komodo",
            "Trio Gili",
            "Raja Ampat",
            "Danau Sentani",
            "Bali",
            "Taman Laut Bunaken",
            "Puncak Jayawijaya",
            "Tanah Toraja",
            "Candi Borobudur",
            "Taman Mini Indonesia Indah"
    };

    String[] lokasiTempatWisata = {
            "Kepulauan Nusa Tenggara",
            "Lombok",
            "Papua",
            "Papua",
            "Denpasar",
            "Sulawesi Utara",
            "Papua",
            "Sulawesi Selatan",
            "Yogyakarta",
            "Jakarta"
    };

    Integer[] deskripsiTempatWisata = {
            R.string.pulau_komodo,
            R.string.trio_gili,
            R.string.raja_ampat,
            R.string.danau_sentani,
            R.string.bali,
            R.string.taman_laut_bunaken,
            R.string.puncak_jayawijaya,
            R.string.tana_toraja,
            R.string.candi_borobudur,
            R.string.taman_laut_bunaken
    };

    Integer[] gambarTempatWisata = {
            R.drawable.pulaukomodo,
            R.drawable.triogili,
            R.drawable.pantairajaampat,
            R.drawable.danausentani,
            R.drawable.bali1,
            R.drawable.tamanbunaken,
            R.drawable.puncakjaya,
            R.drawable.tanahtoraja,
            R.drawable.candiborobudur,
            R.drawable.tmii
    };

    String[] wikipediaTempatWisata = {
            "https://id.wikipedia.org/wiki/Pulau_Komodo",
            "https://id.wikipedia.org/wiki/Kepulauan_Gili",
            "https://id.wikipedia.org/wiki/Kepulauan_Raja_Ampat",
            "https://id.wikipedia.org/wiki/Danau_Sentani",
            "https://id.wikipedia.org/wiki/Bali",
            "https://id.wikipedia.org/wiki/Taman_Nasional_Bunaken",
            "https://id.wikipedia.org/wiki/Puncak_Jaya",
            "https://id.wikipedia.org/wiki/Kabupaten_Tana_Toraja",
            "https://id.wikipedia.org/wiki/Borobudur",
            "https://id.wikipedia.org/wiki/Taman_Mini_Indonesia_Indah"
    };

    String[] mapsTempatWisata = {
            "https://bit.ly/maps_pulau_komodo",
            "https://bit.ly/maps_trio_gili",
            "https://bit.ly/maps_raja_ampat",
            "https://bit.ly/maps_danau_sentani",
            "https://bit.ly/maps_bali",
            "https://bit.ly/maps_taman_laut_bunaken",
            "https://bit.ly/maps_puncak_jayawijaya",
            "https://bit.ly/maps_tana_toraja",
            "https://bit.ly/maps_candi_borobudur",
            "https://bit.ly/maps_taman_mini_indonesia_indah"
    };

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setTitle("Destination");
        }

        AdapterListWisata listWisataAdapter = new AdapterListWisata(
                this,
                namaTempatWisata,
                lokasiTempatWisata,
                deskripsiTempatWisata,
                gambarTempatWisata);

        ListView listDaftarTempatWisata = (ListView)findViewById(R.id.listDaftarWisata);
        listDaftarTempatWisata.setAdapter(listWisataAdapter);

        listDaftarTempatWisata.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int posisi, long id) {

                AlertDialogData(namaTempatWisata[posisi],
                        lokasiTempatWisata[posisi],
                        deskripsiTempatWisata[posisi],
                        gambarTempatWisata[posisi],
                        wikipediaTempatWisata[posisi],
                        mapsTempatWisata[posisi]);

            }
        });
    }
    public void AlertDialogData(final String namaTempatWisata,
                                final String lokasiTempatWisata,
                                final Integer deskripsiTempatWisata,
                                final Integer gambarTempatWisata,
                                final String wikipediaTempatWisata,
                                final String mapsTempatWisata) {
        builder = new AlertDialog.Builder(MainActivity.this);
        builder .setTitle("Info Tempat Wisata")
                .setMessage("Nama Tempat Wisata : " + namaTempatWisata + "\n" +
                        "Lokasi Tempat Wisata : " + lokasiTempatWisata + "\n" +
                        "Deskripsi Tempat Wisata : " + deskripsiTempatWisata + "\n" +
                        "Gambar Resource: " + gambarTempatWisata + "\n" +
                        "Link Url: " + wikipediaTempatWisata + "\n" +
                        "Link Maps: " + mapsTempatWisata)
                .setPositiveButton("Lihat", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        kirimToDetailActivity(namaTempatWisata, lokasiTempatWisata, deskripsiTempatWisata, gambarTempatWisata, wikipediaTempatWisata, mapsTempatWisata);

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        builder.create().show();
    }

    public void kirimToDetailActivity(String namaTempatWisata, String lokasiTempatWisata, Integer deskripsiTempatWisata, Integer gambarTempatWisata, String wikipediaTempatWisata, String mapsTempatWisata) {

        Bundle dataTempatWisata = new Bundle();
        dataTempatWisata.putString("NAMA TEMPAT WISATA", namaTempatWisata);
        dataTempatWisata.putString("LOKASI TEMPAT WISATA", lokasiTempatWisata);
        dataTempatWisata.putInt("DESKRIPSI TEMPAT WISATA", deskripsiTempatWisata);
        dataTempatWisata.putInt("GAMBAR TEMPAT WISATA", gambarTempatWisata);
        dataTempatWisata.putString("WIKIPEDIA TEMPAT WISATA", wikipediaTempatWisata);
        dataTempatWisata.putString("MAPS TEMPAT WISATA", mapsTempatWisata);

        Intent prosesKirim = new Intent(MainActivity.this, DetailActivity.class);
        prosesKirim.putExtras(dataTempatWisata);
        startActivity(prosesKirim);
        finish();
    }
}
