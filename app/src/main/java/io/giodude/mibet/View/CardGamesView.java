package io.giodude.mibet.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import java.util.ArrayList;
import java.util.List;

import io.giodude.mibet.Adapter.CardGamesAdapter;
import io.giodude.mibet.Data.CasinoData;
import io.giodude.mibet.Model.CasinoModel;
import io.giodude.mibet.R;

public class CardGamesView extends Fragment {
private CardGamesAdapter cardGamesAdapter;
private CasinoModel casinoModel;
public static RecyclerView recyclerView;

    View root;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.activity_card_games_view,container,false);
        cardgames();
        return root;

    }

    private void cardgames(){
        List<CasinoModel> cardgames = new ArrayList<>();
        for (int i = 0; i < CasinoData.gamename.length; i++){
            cardgames.add(new CasinoModel(CasinoData.gamename[i], CasinoData.gamedesc[i], CasinoData.gameimage[i]));
        }

        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_animation_up_to_down);
        recyclerView = root.findViewById(R.id.recyclerview);
        recyclerView.setLayoutAnimation(controller);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        cardGamesAdapter = new CardGamesAdapter(getContext(),cardgames);
        recyclerView.setAdapter(cardGamesAdapter);
    }
}