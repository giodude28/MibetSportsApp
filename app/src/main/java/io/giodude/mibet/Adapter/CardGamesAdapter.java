package io.giodude.mibet.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import io.giodude.mibet.Model.CasinoModel;
import io.giodude.mibet.R;

public class CardGamesAdapter extends RecyclerView.Adapter<CardGamesAdapter.ViewHolder> {
    Context context;
    List<CasinoModel> data;
    TextView title1,desc1;
    ImageView img;
    public CardGamesAdapter(Context context, List<CasinoModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public CardGamesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View item = layoutInflater.inflate(R.layout.cardgameitem,parent,false);
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardGamesAdapter.ViewHolder holder, int position) {
        holder.title.setText(data.get(position).getCname());
        holder.img.setImageResource(data.get(position).getCimage());


        final Dialog myDialog;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.cardgamedetails);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        title1 = myDialog.findViewById(R.id.cardtitle);
        desc1 = myDialog.findViewById(R.id.carddesc);
        img = myDialog.findViewById(R.id.cardimage);
        for (int i = 0; i<data.size(); i++) {
            if(holder.title.getText()==data.get(position).getCname()){
                title1.setText(data.get(position).getCname());
                desc1.setText(data.get(position).getCdesc());
                Picasso.get().load(data.get(position).getCimage()).into(img);
            }
        }
        holder.itemView.setOnClickListener(v -> myDialog.show());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.cardtitle);
            img = itemView.findViewById(R.id.cardimage);
        }
    }
}
