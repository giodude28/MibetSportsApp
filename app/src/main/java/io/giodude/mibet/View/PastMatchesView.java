package io.giodude.mibet.View;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.giodude.mibet.Adapter.PastAdapter;
import io.giodude.mibet.Model.PastMatchesModel;
import io.giodude.mibet.R;
import io.giodude.mibet.ViewModel.PastViewModel;

public class PastMatchesView extends Fragment {
    private PastViewModel pastViewModel;
    private List<PastMatchesModel.PreviousEvents> eventsModel = new ArrayList<>();
     List<PastMatchesModel.PreviousEvents> eventsModels;
    public PastAdapter pastAdapter;
    public static RecyclerView recyclerView;
    private RecyclerView.LayoutManager rLayout;
    public ProgressBar progressBar;
    TextView text;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        view = inflater.inflate(R.layout.activity_past_view, container, false);
        progressBar = view.findViewById(R.id.progress);
        text = view.findViewById(R.id.tete);
        showevents();
        return view;
    }

    private void getEvents(List<PastMatchesModel.PreviousEvents> eventModels){
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_animation_down_to_up);
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutAnimation(controller);
        rLayout = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(rLayout);
        pastAdapter = new PastAdapter(getContext(), eventModels);
        recyclerView.setAdapter(pastAdapter);
    }

    private void showevents(){
        pastViewModel = ViewModelProviders.of(PastMatchesView.this).get(PastViewModel.class);
        pastViewModel.init();
            pastViewModel.getPast().observe(this, events -> {
                getEvents(events);
                eventsModel.addAll(events);
                pastAdapter.notifyDataSetChanged();

                if (eventsModel.size() == 0) {
                    progressBar.setVisibility(View.VISIBLE);
                    text.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.INVISIBLE);
                    text.setVisibility(View.INVISIBLE);
                }
            });
    }
}