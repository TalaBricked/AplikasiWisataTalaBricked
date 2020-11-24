package com.example.aplikasiwisatatalabricked;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

    public class DetailActivity extends AppCompatActivity {

        @BindView(R.id.tvNamaTempatWisata)
        TextView tvNamaTempatWisata;
        @BindView(R.id.tvLokasiTempatWisata)
        TextView tvLokasiTempatWisata;
        @BindView(R.id.tvDeskripsiTempatWisata)
        TextView tvDeskripsiTempatWisata;
        @BindView(R.id.ivGambarTempatWisata)
        ImageView ivGambarTempatWisata;
        @BindView(R.id.tvInfoWikipedia)
        TextView tvInfoWikipedia;
        @BindView(R.id.tvBackToList)
        TextView tvBackToList;
        @BindView(R.id.wvTampilkan)
        WebView wvTampilkan;
        @BindView(R.id.tvInfoMapLokasi)
        TextView tvInfoMapLokasi;
        @BindView(R.id.tvWebView)
        TextView tvWebView;
        @BindView(R.id.wvTampilkanMaps)
        WebView wvTampilkanMaps;
        WebSettings webSettings;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detail);
            ButterKnife.bind(this);

            Bundle getDataTempatWisata = getIntent().getExtras();

            assert getDataTempatWisata != null;
            String getNamaTempatWisata = getDataTempatWisata.getString("NAMA TEMPAT WISATA");
            String getLokasiTempatWisata = getDataTempatWisata.getString("LOKASI TEMPAT WISATA");
            int getDeskripsiTempatWisata = getDataTempatWisata.getInt("DESKRIPSI TEMPAT WISATA");
            int getGambarTempatWisata = getDataTempatWisata.getInt("GAMBAR TEMPAT WISATA");
            final String getWikipediaTempatWisata = getDataTempatWisata.getString("WIKIPEDIA TEMPAT WISATA");
            final String getMapsTempatWisata = getDataTempatWisata.getString("MAPS TEMPAT WISATA");

            tvNamaTempatWisata.setText(getNamaTempatWisata);
            tvLokasiTempatWisata.setText(getLokasiTempatWisata);
            tvDeskripsiTempatWisata.setText(getDeskripsiTempatWisata);
            Picasso.get().load(getGambarTempatWisata).into(ivGambarTempatWisata);

            tvInfoWikipedia.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(View v) {

                    tvWebView.setText("Wikipedia");
                    wvTampilkanMaps.setVisibility(View.GONE);
                    wvTampilkan.setVisibility(View.VISIBLE);
                    showInWiki(getWikipediaTempatWisata);

                }
            });

            tvBackToList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

            tvInfoMapLokasi.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(View v) {

                    tvWebView.setText("Maps");
                    wvTampilkan.setVisibility(View.GONE);
                    wvTampilkanMaps.setVisibility(View.VISIBLE);
                    showInMaps(getMapsTempatWisata);

                }
            });

        }

        @Override
        public void onBackPressed() {
            super.onBackPressed();
            startActivity(new Intent(DetailActivity.this, MainActivity.class));
            finish();
        }

        @SuppressLint("SetJavaScriptEnabled")
        public void showInWiki(String URL_WIKI) {
            webSettings = wvTampilkan.getSettings();
            webSettings.setJavaScriptEnabled(true);

            wvTampilkan.setWebViewClient(new WebViewClient());
            wvTampilkan.loadUrl(URL_WIKI);
        }

        @SuppressLint("SetJavaScriptEnabled")
        public void showInMaps(String URL_MAPS) {
            webSettings = wvTampilkanMaps.getSettings();
            webSettings.setJavaScriptEnabled(true);

            wvTampilkanMaps.setWebViewClient(new WebViewClient());
            wvTampilkanMaps.loadUrl(URL_MAPS);
        }
    }
