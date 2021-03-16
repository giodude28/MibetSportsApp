package io.giodude.mibet.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.giodude.mibet.Model.LiveMatchesModel;
import io.giodude.mibet.R;

public class LiveAdapter extends RecyclerView.Adapter<LiveAdapter.ViewHolder> {
    public Context context;
    public List<LiveMatchesModel.Datum> data;
    public LiveMatchesModel.Datum ee;
    TextView title1,hname,aname,hscore,ascore,leagues,season,date,sport;
    public LiveAdapter(Context context, List data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public LiveAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View item = layoutInflater.inflate(R.layout.livesitem,parent,false);
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LiveAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(data.get(position));
        ee = data.get(position);
        holder.home.setText(ee.getHomeTeam().getName());
        holder.away.setText(ee.getAwayTeam().getName());
        holder.date.setText(ee.getStartAt());
        holder.stats.setText(ee.getStatus());

        final Dialog myDialog;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.livesdetails);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        title1 = myDialog.findViewById(R.id.eventtitles);
        hname = myDialog.findViewById(R.id.homes);
        aname = myDialog.findViewById(R.id.aways);
        hscore = myDialog.findViewById(R.id.homescoress);
        ascore = myDialog.findViewById(R.id.awayscores);
        date = myDialog.findViewById(R.id.eventdates);
        sport = myDialog.findViewById(R.id.eventsports);
        for (int i = 0; i<data.size(); i++) {
            if(holder.home.getText()==data.get(position).getHomeTeam().getName()){
                title1.setText(data.get(position).getName());
                hname.setText(ee.getHomeTeam().getName());
                aname.setText(ee.getAwayTeam().getName());
                hscore.setText(ee.getHomeScore().getCurrent().toString());
                ascore.setText(ee.getAwayScore().getCurrent().toString());
                date.setText(ee.getStartAt());
                sport.setText(ee.getSport().getName());
            }
        }
        holder.itemView.setOnClickListener(v -> myDialog.show());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView stats;
        public TextView date;
        public TextView home;
        public TextView away;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            stats = itemView.findViewById(R.id.eventstatus);
            home = itemView.findViewById(R.id.home);
            away = itemView.findViewById(R.id.away);
            date = itemView.findViewById(R.id.eventdate);
        }
    }
}
