package io.giodude.mibet.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.giodude.mibet.Connection.Repositories;
import io.giodude.mibet.Model.LiveMatchesModel;

public class LiveViewModel extends ViewModel {

    private MutableLiveData<List<LiveMatchesModel.Datum>> lives;
    public Repositories repositories;

    public void init(){
        if (lives != null){
            return;
        }
        repositories = Repositories.getInstance();
        lives = repositories.getLive();
    }

    public LiveData<List<LiveMatchesModel.Datum>> getLives(){

        return lives;
    }
}
