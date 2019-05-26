package com.example.webservice.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.webservice.R;
import com.squareup.picasso.Picasso;

public class ContentActivity extends AppCompatActivity {

    ImageView imgArtikel;
    TextView title;
    TextView date;
    TextView author;
    TextView decription;
    TextView content;
    TextView url;
    String img_url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_artikel);

        title = findViewById(R.id.judul);
        imgArtikel = findViewById(R.id.img);
        date = findViewById(R.id.tanggal);
        url = findViewById(R.id.url_site);
        content = findViewById(R.id.konten);
        decription = findViewById(R.id.deskripsi);
        author = findViewById(R.id.penulis);

        img_url = getIntent().getStringExtra("Img_URL");

        show();
    }

    public void show() {
        Picasso.get()
                .load(img_url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imgArtikel);
        title.setText(getIntent().getStringExtra("Title"));
        date.setText(getIntent().getStringExtra("Date"));
        url.setText(getIntent().getStringExtra("URL"));
        Linkify.addLinks(url,Linkify.WEB_URLS);
        content.setText(getIntent().getStringExtra("Content"));
        decription.setText(getIntent().getStringExtra("Description"));
        author.setText("Author : " + getIntent().getStringExtra("Author"));

    }
}
