package io.giodude.mibet.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import io.giodude.mibet.Model.PastMatchesModel;
import io.giodude.mibet.R;

public class PastAdapter extends RecyclerView.Adapter<PastAdapter.ViewHolder> {
    public Context context;
    public List<PastMatchesModel.PreviousEvents> data;
    public PastMatchesModel.PreviousEvents ee;

    public PastAdapter(Context context, List data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View item = layoutInflater.inflate(R.layout.eventsitem,parent,false);
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PastAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(data.get(position));
        ee = data.get(position);
        holder.date.setText(ee.getDateEvent());
        holder.time.setText(ee.getStrTime());
        holder.league.setText(ee.getStrLeague());
        holder.season.setText(ee.getStrSeason());
        holder.home.setText(ee.getStrHomeTeam());
        holder.away.setText(ee.getStrAwayTeam());
        holder.venue.setText(ee.getStrVenue());
        holder.status.setText(ee.getStrStatus());
        holder.homescore.setText(ee.getHomescore());
        holder.awayscore.setText(ee.getAwayscore());
        Picasso.get().load(data.get(position).getStrThumb()).into(holder.eimg);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView date;
        public TextView time;
        public TextView league;
        public TextView season;
        public TextView home;
        public TextView away;
        public TextView venue;
        public TextView status;
        public TextView homescore;
        public TextView awayscore;
        public CircleImageView eimg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.eventdate);
            time = itemView.findViewById(R.id.eventtime);
            league = itemView.findViewById(R.id.eventleague);
            home = itemView.findViewById(R.id.home);
            awayscore = itemView.findViewById(R.id.awayscore);
            homescore = itemView.findViewById(R.id.homescore);
            away = itemView.findViewById(R.id.away);
            season = itemView.findViewById(R.id.eventseason);
            venue = itemView.findViewById(R.id.eventvenue);
            status = itemView.findViewById(R.id.eventstatus);
            eimg = itemView.findViewById(R.id.eventimg);
        }
    }
}
