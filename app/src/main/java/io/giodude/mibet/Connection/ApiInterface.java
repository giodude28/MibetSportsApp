package io.giodude.mibet.Connection;

import io.giodude.mibet.Model.LiveMatchesModel;
import io.giodude.mibet.Model.PastMatchesModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiInterface {

    String Live_URL = "https://sportscore1.p.rapidapi.com/sports/1/";

    @GET("events/live")
    @Headers({"x-rapidapi-host: sportscore1.p.rapidapi.com",
    "x-rapidapi-key: 07e55202eemshd454005e3a79774p103cccjsn4b32f05d3a2f",
    "useQueryString: true"})
    Call<LiveMatchesModel> getLive();

    String Past_URL = "https://www.thesportsdb.com/api/v1/json/1/";

    @GET("eventspastleague.php?id=4328")
    Call<PastMatchesModel> getPast();
}
