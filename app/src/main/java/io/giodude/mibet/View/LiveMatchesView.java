package io.giodude.mibet.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.giodude.mibet.Adapter.LiveAdapter;
import io.giodude.mibet.Connections;
import io.giodude.mibet.Model.LiveMatchesModel;
import io.giodude.mibet.R;
import io.giodude.mibet.ViewModel.LiveViewModel;

public class LiveMatchesView extends Fragment {
private LiveViewModel liveViewModel;
private List<LiveMatchesModel.Datum> livemodel = new ArrayList<>();
List<LiveMatchesModel.Datum> livemods;
public LiveAdapter liveAdapter;
public static RecyclerView recyclerView;
private RecyclerView.LayoutManager rLayout;
public ProgressBar progressBar;
public TextView text;
    View root;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.activity_live_view,container,false);
        text = root.findViewById(R.id.tete);
        progressBar = root.findViewById(R.id.progress);
//    display();
        showlives();
        return root;
    }
//public void display(){
//    final Handler handler = new Handler();
//    handler.postDelayed(() -> {
//        if (Connections.con == "Failed"){
//            Toast.makeText(getContext(),"Cannot Connect to the Server",Toast.LENGTH_SHORT).show();
//            display();
//        }
//    }, 2000);
//}


    private void getLives(List<LiveMatchesModel.Datum> livemodel){
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_animation_down_to_up);
        recyclerView = root.findViewById(R.id.recyclerview);
        recyclerView.setLayoutAnimation(controller);
        rLayout = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(rLayout);
        liveAdapter = new LiveAdapter(getContext(), livemodel);
        recyclerView.setAdapter(liveAdapter);
    }

    private void showlives(){
        liveViewModel = ViewModelProviders.of(LiveMatchesView.this).get(LiveViewModel.class);
        liveViewModel.init();

            liveViewModel.getLives().observe(this, lives -> {
                getLives(lives);
                livemodel.addAll(lives);
                liveAdapter.notifyDataSetChanged();
                if (livemodel.size() == 0) {
                    Toast.makeText(getContext(), livemodel.size(), Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.VISIBLE);
                    text.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.INVISIBLE);
                    text.setVisibility(View.INVISIBLE);
                }


            });
    }
}