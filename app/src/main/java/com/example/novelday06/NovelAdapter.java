package com.example.novelday06;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NovelAdapter extends RecyclerView.Adapter<NovelAdapter.ViewHolder> {

    private ArrayList<NovelModel> novelModel;
    private OnItemClickListener mListener;
    private Context mContext; //

    public NovelAdapter(ArrayList<NovelModel> novelModel, Context context) {
        this.novelModel = novelModel;
        this.mContext = context;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    @NonNull
    @Override
    public NovelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_novel, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NovelAdapter.ViewHolder holder, int position) {
        NovelModel currentNovel = novelModel.get(position);

        holder.namaNovel.setText(currentNovel.getNamaNovel());
        holder.gambarNovel.setImageResource(currentNovel.getGambarNovel());
        holder.deskripsiNovel.setText(currentNovel.getDeskripsiNovel());
        holder.hargaNovel.setText(String.valueOf(currentNovel.getHargaNovel()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailActivity.class);

                intent.putExtra("namaNovel", novelModel.get(position).getNamaNovel());
                intent.putExtra("harga", String.valueOf(novelModel.get(position).getHargaNovel()));
                intent.putExtra("deskripsi", novelModel.get(position).getDeskripsiNovel());
                intent.putExtra("gambar", novelModel.get(position).getGambarNovel());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return novelModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView namaNovel;
        TextView deskripsiNovel;
        TextView hargaNovel;
        ImageView gambarNovel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namaNovel = itemView.findViewById(R.id.nama_novel);
            deskripsiNovel = itemView.findViewById(R.id.deskripsi_novel);
            hargaNovel = itemView.findViewById(R.id.harga_novel);
            gambarNovel = itemView.findViewById(R.id.gambar_novel);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}