package com.example.aplikasiwisatatalabricked.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.aplikasiwisatatalabricked.R;
import com.example.aplikasiwisatatalabricked.adapterwisata.WisataAdapter;
import com.example.aplikasiwisatatalabricked.modelwisata.ModelWisata;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WisataActivity {

    private Object Wisata;

    public WisataActivity(Object wisata) {
        Wisata = wisata;
    }

    public class WisataActivity extends AppCompatActivity implements WisataAdapter.onSelectData, WisataActivityy {

        RecyclerView rvWisata;
        LayoutMarginDecoration gridMargin;
        ProgressDialog progressDialog = new ProgressDialog(this);
        List<ModelWisata> modelKuliner = new ArrayList<>();
        Toolbar tbWisata;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_wisata);

            tbWisata = findViewById(R.id.toolbar_wisata);
            tbWisata.setTitle("Daftar Wisata Purwakarta");
            setSupportActionBar();
            assert getSupportActionBar() != null;
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            progressDialog.setTitle("Mohon Tunggu");
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Sedang menampilkan data...");

            rvWisata = findViewById(R.id.rvWisata);
            GridLayoutManager mLayoutManager = new GridLayoutManager(this,
                    2, RecyclerView.VERTICAL, false);
            rvWisata.setLayoutManager(mLayoutManager);
            gridMargin = new LayoutMarginDecoration(2, Tools.dp2px(this, 4));
            rvWisata.addItemDecoration(gridMargin);
            rvWisata.setHasFixedSize(true);

            getWisata();
        }

        private void setSupportActionBar() {
        }

        private void getWisata() {
            progressDialog.show();
            AndroidNetworking.get((String) Wisata)
                    .setPriority(Priority.HIGH)
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {

                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                progressDialog.dismiss();
                                JSONArray playerArray = response.getJSONArray("wisata");
                                for (int i = 0; i < playerArray.length(); i++) {
                                    JSONObject temp = playerArray.getJSONObject(i);
                                    ModelWisata dataApi = new ModelWisata();
                                    dataApi.setIdWisata(temp.getString("id"));
                                    dataApi.setTxtNamaWisata(temp.getString("nama"));
                                    dataApi.setGambarWisata(temp.getString("gambar_url"));
                                    dataApi.setKategoriWisata(temp.getString("kategori"));
                                    modelKuliner.add(dataApi);
                                    showWisata();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                Toast.makeText(WisataActivity.this,
                                        "Gagal menampilkan data!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onError(ANError anError) {

                        }



                    });
        }

        private void showWisata() {
        }

        @Override
        public void onSelected(ModelWisata modelWisata) {
            Intent intent = new Intent(WisataActivity.this, DetailWisataActivity.class);
            intent.putExtra("detailWisata", String.valueOf(modelWisata));
            startActivity(intent);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            if (item.getItemId() == android.R.id.home) {
                finish();
                return true;
            }
            return super.onOptionsItemSelected(item);
        }

        private class Wisata {
        }
    }
}
