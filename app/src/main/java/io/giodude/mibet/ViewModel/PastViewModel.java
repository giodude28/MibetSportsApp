package io.giodude.mibet.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.giodude.mibet.Connection.Repositories;
import io.giodude.mibet.Model.PastMatchesModel;

public class PastViewModel extends ViewModel {

    private MutableLiveData<List<PastMatchesModel.PreviousEvents>> pasts;
    public Repositories repositories;

    public void init(){
        if (pasts != null){
            return;
        }
        repositories = Repositories.getInstance();
        pasts = repositories.getEvents();
    }

    public LiveData<List<PastMatchesModel.PreviousEvents>> getPast(){
        return pasts;
    }
}
