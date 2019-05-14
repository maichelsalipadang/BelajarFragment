package com.maichel.belajarfragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListHeroAdapter extends RecyclerView.Adapter<ListHeroAdapter.CategoryViewHolder> {

    private Context context;
    private ArrayList<Hero> listHero;
    private OnItemClickListener mListener;

    public ListHeroAdapter(Context context) {
        this.context = context;
    }
    public ArrayList<Hero> getListHero() {
        return listHero;
    }
    public void setListHero(ArrayList<Hero> listHero) {
        this.listHero = listHero;
    }

    //membuat settingan untuk onclick
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }

    //menjelaskan bahwa item-item akan ditampilkan di item_row_hero
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_hero,parent,false);
        return new CategoryViewHolder(itemRow);
    }

    //menjelaskan bahwa holder akan mengambil data/text dari method getName, getFrom, getPhoto
    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.tvName.setText(getListHero().get(position).getName());
        holder.tvFrom.setText(getListHero().get(position).getFrom());
        Glide.with(context)
                .load(getListHero().get(position).getPhoto())
                .apply(new RequestOptions().override(200,250))
                .into(holder.imgPhoto);
    }

    ///menjelaskan bahwa jumlah item adalah sesuai dengan jumlah yang ada di getListHero
    @Override
    public int getItemCount() {
        return getListHero().size();
    }

    //untuk mendeklarasikan tiap item di dalam id yang diinginkan
    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvFrom;
        ImageView imgPhoto;
        RelativeLayout parentLayout;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvFrom = itemView.findViewById(R.id.tv_item_from);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            parentLayout = itemView.findViewById(R.id.activity_main);

            //untuk menjelaskan kejadian onclick listener
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v ){
                    if(mListener!=null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}

