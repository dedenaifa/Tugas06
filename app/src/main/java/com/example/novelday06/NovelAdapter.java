package com.example.novelday06;

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

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public NovelAdapter(ArrayList<NovelModel> novelModel) {
        this.novelModel = novelModel;
    }

    @NonNull
    @Override
    public NovelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_novel, parent, false);
        ViewHolder viewholder = new ViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull NovelAdapter.ViewHolder holder, int position) {
        holder.namaNovel.setText(novelModel.get(position).getNamaNovel());
        holder.gambarNovel.setImageResource(novelModel.get(position).getGambarNovel());
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
                public void onClick(View view) {
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
