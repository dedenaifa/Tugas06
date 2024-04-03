package com.example.novelday06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.security.PrivateKey;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NovelAdapter novelAdapter;
    private ArrayList<NovelModel> novelModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData();

        recyclerView = findViewById(R.id.recycle_view);
        NovelAdapter novelAdapter = new NovelAdapter(novelModel, this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(novelAdapter);


    }

    private void getData() {
        novelModel = new ArrayList<>();
        novelModel.add(new NovelModel("Impian Angsa Kecil", R.drawable.impian_angsa_kecil, "Buku Impian Angsa Kecil adalah kisah inspiratif tentang seorang angsa muda yang bermimpi besar untuk terbang tinggi di langit. Meskipun dihadapkan pada rintangan, ia tidak pernah kehilangan semangat. Dengan pesan tentang keberanian, keteguhan, dan kepercayaan diri, buku ini mengajak pembaca muda untuk mengejar impian mereka dengan penuh semangat.", 54000));
        novelModel.add(new NovelModel("Kesepian di Masa Tua", R.drawable.kesepian_dimasa_tua, "Buku ini membahas tantangan emosional orang tua di masa tua, khususnya kesepian. Anda akan menemukan penjelasan tentang dampak kesepian, penyebabnya, serta strategi untuk mengatasinya", 67500));
        novelModel.add(new NovelModel("Semua Belum Usai", R.drawable.semua_belum_usai, "Buku ini menggali tema kesepian di antara orang tua di masa tua. Mulai dari penyebab hingga dampaknya, buku ini menawarkan strategi praktis untuk mengatasi kesepian. Dengan menyajikan kisah nyata dan saran-saran yang mendalam, buku ini menjadi panduan yang berharga bagi siapa pun yang ingin memahami dan mengatasi kesepian di usia lanjut.", 70000));
        novelModel.add(new NovelModel("Maju Tak Gentar", R.drawable.maju_tak_gentar, "Maju Tak Gentar adalah buku yang memotivasi pembaca untuk mengatasi rintangan dan mengambil langkah maju dalam hidup mereka tanpa ragu.", 25000));
        novelModel.add(new NovelModel("Terima Kasih Ibu", R.drawable.terima_kasih_ibu, "Buku Terima Kasih Ibu menggambarkan rasa terima kasih yang dalam kepada ibu, memperlihatkan kebaikan, pengorbanan, dan cinta tak terbatasnya. Melalui cerita-cerita yang mengharukan, pembaca akan menghargai peran penting ibu dalam hidup mereka.", 41000));
        novelModel.add(new NovelModel("One Piece", R.drawable.one_piece, "One Piece adalah komik tentang petualangan Monkey D. Luffy dan krunya dalam mencari harta legendaris, One Piece.", 45000));
        novelModel.add(new NovelModel("Kingdom", R.drawable.kingdom, "Kingdom adalah komik yang mengikuti perjalanan Shin, seorang pemuda yang bercita-cita menjadi jenderal besar di era Perang Negara Tiongkok kuno.", 16000));
        novelModel.add(new NovelModel("Grand Blue", R.drawable.grand_blue, "Grand Blue adalah komik komedi yang mengisahkan petualangan sekelompok mahasiswa dalam klub selam dan minum-minum di pinggir pantai.", 18000));
        novelModel.add(new NovelModel("Demon Slayer", R.drawable.demon_slayer, "Demon Slayer adalah komik yang mengikuti Tanjiro Kamado dalam perjalanannya menyelamatkan adiknya yang diubah menjadi setan dan membalas dendam pada pembantainya. ", 32000));
        novelModel.add(new NovelModel("Jujutsu Kaisen", R.drawable.jujutsu_kaisen, "Jujutsu Kaisen adalah komik tentang Yuji Itadori, seorang siswa yang terlibat dalam dunia supernatural dan bergabung dengan Sekolah Jujutsu untuk melawan setan.", 34000));
        novelModel.add(new NovelModel("Alien", R.drawable.alienn, "Buku ini adalah sebuah cerita fiksi ilmiah yang menegangkan, dimana alien menjadi fokus cerita. ", 45000));
        novelModel.add(new NovelModel("The Terminator", R.drawable.terminator, "The Terminator adalah cerita fiksi ilmiah tentang perang antara manusia dan mesin, di mana kecerdasan buatan bernama Skynet mengirim mesin pembunuh bernama Terminator ke masa lalu untuk memusnahkan umat manusia.", 44000));
        novelModel.add(new NovelModel("Blade Runner", R.drawable.blade_runner, "Blade Runner adalah novel fiksi ilmiah yang mengisahkan tentang pemburu bayaran bernama Rick Deckard yang ditugaskan untuk menangkap dan 'pensiun' makhluk sintetis yang memberontak yang dikenal sebagai \"replicant\".", 61000));
        novelModel.add(new NovelModel("The Thing", R.drawable.the_thing, "The Thing adalah novelisasi dari film horor klasik yang mengisahkan kisah sekelompok peneliti di Antartika yang berjuang melawan entitas asing yang dapat mengambil bentuk manusia. ", 62000));
        novelModel.add(new NovelModel("Insterstellar", R.drawable.instertellar, "Interstellar adalah novel yang mengisahkan perjalanan manusia di luar angkasa untuk mencari planet baru yang bisa dihuni manusia.", 98000));

    }
}