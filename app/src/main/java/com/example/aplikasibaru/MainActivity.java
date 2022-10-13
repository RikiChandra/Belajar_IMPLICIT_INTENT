package com.example.aplikasibaru;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.net.Uri;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etWebsite, etLokasi, etTeks;
    Button btnWebsite, btnLokasi, btnTeks;
    String getWebsite, getLokasi, getTeks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWebsite = findViewById(R.id.et_website);
        etLokasi = findViewById(R.id.et_lokasi);
        etTeks = findViewById(R.id.et_teks);
        btnWebsite = findViewById(R.id.btn_website);
        btnLokasi = findViewById(R.id.btn_lokasi);
        btnTeks = findViewById(R.id.btn_teks);

        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWebsite = etWebsite.getText().toString();
                Uri webPage = Uri.parse(getWebsite);
                Intent bukaWebsite = new
                        Intent(Intent.ACTION_VIEW, webPage);
                try {
                    startActivity(bukaWebsite);
                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "Ada Kesalahan Saat Membuka Website !",
                    Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLokasi = etLokasi.getText().toString();
                Uri location = Uri.parse("geo:0,0?q=" +
                        getLokasi);
                Intent bukaLokasi = new
                        Intent(Intent.ACTION_VIEW, location);
                startActivity(bukaLokasi);
            }
        });

        btnTeks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTeks = etTeks.getText().toString();
                String mimeType = "text/plain";
                new ShareCompat.IntentBuilder(MainActivity.this)
                        .setType(mimeType)
                        .setChooserTitle("Bagikan Teks Ini")
                        .setText(getTeks)
                        .startChooser();
            }
        });


    }
}