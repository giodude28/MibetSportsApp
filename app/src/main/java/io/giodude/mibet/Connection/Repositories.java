package io.giodude.mibet.Connection;


import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import io.giodude.mibet.Connections;
import io.giodude.mibet.Model.LiveMatchesModel;
import io.giodude.mibet.Model.PastMatchesModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repositories {

    private static Repositories instance;
    static ApiClient rfit = new ApiClient();
    public Context context;
  /*  Activity activity;

    public void Repositories(Context context){
        this.context = context;
        this.activity = (Activity) this.context;

    }*/


    public static Repositories getInstance(){
        if (instance==null){
            instance = new Repositories();
        }
        return instance;
    }

    public MutableLiveData<List<LiveMatchesModel.Datum>> getLive(){
//try{

    final MutableLiveData<List<LiveMatchesModel.Datum>> data = new MutableLiveData<>();
    Call<LiveMatchesModel> call = rfit.retrofitBuilder().getLive();
    call.enqueue(new Callback<LiveMatchesModel>() {
        @Override
        public void onResponse(Call<LiveMatchesModel> call, Response<LiveMatchesModel> response) {
        try
        {

            LiveMatchesModel datalist = response.body();
            List<LiveMatchesModel.Datum> datumlist = datalist.getData();
            data.setValue(datumlist);
        }catch (Exception e){
            Log.d("Data","Null List!");
        }

        }

        @Override
        public void onFailure(Call<LiveMatchesModel> call, Throwable t) {
        }



    });
    return data;
//}catch (Exception e){
//
//}
//return getLive();
    }

    public MutableLiveData<List<PastMatchesModel.PreviousEvents>> getEvents(){

        final MutableLiveData<List<PastMatchesModel.PreviousEvents>> data = new MutableLiveData<>();
        Call<PastMatchesModel> call = rfit.retrofitBuilder1().getPast();
        call.enqueue(new Callback<PastMatchesModel>() {
            @Override
            public void onResponse(Call<PastMatchesModel> call, Response<PastMatchesModel> response) {
                try
                {
                    PastMatchesModel dataList1 = response.body();
                    List<PastMatchesModel.PreviousEvents> samples = dataList1.getPrevious();
                    data.setValue(samples);
                }catch (Exception e){
                    Log.d("Data","Null List!");
                }

            }

            @Override
            public void onFailure(Call<PastMatchesModel> call, Throwable t) {
                Log.d("Data","Null List!");
            }
        });
        return data;
    }

}
