package com.example.novelday06;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.ByteArrayOutputStream;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    private String namaNovel, deskripsiNovel;
    private String hargaNovel;
    private int gambarNovel;
    private ImageView imgDetail;
    private TextView txtDetailNama, txtDetailHarga, txtDetailDeskripsi;
    private Button btnShare;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgDetail = findViewById(R.id.imgDetail);
        txtDetailNama = findViewById(R.id.txtDetailNama);
        txtDetailHarga = findViewById(R.id.txtDetailHarga);
        txtDetailDeskripsi = findViewById(R.id.txtDetailDeskripsi);
        btnShare = findViewById(R.id.btnShare);

        namaNovel = getIntent().getStringExtra("namaNovel");
        hargaNovel = getIntent().getStringExtra("harga");
        deskripsiNovel = getIntent().getStringExtra("deskripsi");
        gambarNovel = getIntent().getIntExtra("gambar", 0);

        txtDetailNama.setText(namaNovel);
        txtDetailHarga.setText(hargaNovel);
        txtDetailDeskripsi.setText(deskripsiNovel);
        imgDetail.setImageResource(gambarNovel);
        btnShare.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        shareImageAndText();
    }

    private void shareImageAndText() {
        Bitmap bitmap = ((BitmapDrawable) imgDetail.getDrawable()).getBitmap();
        String text = txtDetailNama.getText().toString() + "\n" +
                txtDetailHarga.getText().toString() + "\n" +
                txtDetailDeskripsi.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/*");

        Uri uri = getImageUri(this, bitmap);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        intent.putExtra(Intent.EXTRA_TEXT, text);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, "Share melalui"));
        } else {
            Toast.makeText(this, "Tidak ada aplikasi yang dapat menangani intent ini", Toast.LENGTH_SHORT).show();
        }
    }
    private Uri getImageUri(Context context, Bitmap bitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, "Title", null);
        return Uri.parse(path);
    }
}