package com.example.webservice.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.webservice.Activity.ContentActivity;
import com.example.webservice.Model.Articles;
import com.example.webservice.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ArtikelAdapter extends RecyclerView.Adapter<ArtikelAdapter.Holder> {
    private List<Articles> articlesList;
    private Context context;

    public ArtikelAdapter(Context context, List<Articles> articlesList) {
        this.context = context;
        this.articlesList = articlesList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_artikel, parent, false);
        return new Holder(view);
    }

    public void onBindViewHolder(ArtikelAdapter.Holder holder, final int position){
        holder.bind(position);
    }

    public int getItemCount(){
        return articlesList.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        private RelativeLayout openEdukasi;
        private ImageView imgArtikel;
        private TextView tvJudul;
        private TextView tvTanggal;
        private String image_url;
        private String url;
        private String author;
        private String description;
        private String content;

        public Holder(View itemView){
            super(itemView);

            imgArtikel = itemView.findViewById(R.id.img_artikel);
            tvJudul = itemView.findViewById(R.id.tv_judul_artikel);
            tvTanggal = itemView.findViewById(R.id.tv_tanggal);
            openEdukasi = itemView.findViewById(R.id.openEdukasi);
        }

        public void bind(final int position){
            Picasso.get()
                    .load(articlesList.get(position).getUrlToImage())
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(imgArtikel);

            image_url = articlesList.get(position).getUrlToImage();
            url = articlesList.get(position).getUrl();
            content = articlesList.get(position).getContent();
            author = articlesList.get(position).getAuthor();
            description = articlesList.get(position).getDescription();

            tvJudul.setText(articlesList.get(position).getTitle());
            tvTanggal.setText(articlesList.get(position).getPublishedAt());

            openEdukasi.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
//                    Toast.makeText(context,"clicked :   " + tvJudul.getText().toString() + "\n Position :   " + String.valueOf(position),Toast.LENGTH_LONG).show();


                    Intent intent = new Intent(v.getContext(), ContentActivity.class);
                    intent.putExtra("Title",tvJudul.getText());
                    intent.putExtra("Date",tvTanggal.getText());
                    intent.putExtra("Img_URL",image_url);
                    intent.putExtra("Content",content);
                    intent.putExtra("URL",url);
                    intent.putExtra("Description",description);
                    intent.putExtra("Author",author);
                    v.getContext().startActivity(intent);

                }
            });


        }


    }
}
