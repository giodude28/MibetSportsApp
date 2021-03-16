package io.giodude.mibet.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LiveMatchesModel {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public class Datum{
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("slug")
        @Expose
        private String slug;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("status_more")
        @Expose
        private String statusMore;
        @SerializedName("home_team")
        @Expose
        private HomeTeam homeTeam;
        @SerializedName("away_team")
        @Expose
        private AwayTeam awayTeam;
        @SerializedName("start_at")
        @Expose
        private String startAt;
        @SerializedName("priority")
        @Expose
        private Integer priority;
        @SerializedName("home_score")
        @Expose
        private HomeScore homeScore;
        @SerializedName("away_score")
        @Expose
        private AwayScore awayScore;
        @SerializedName("season")
        @Expose
        private Season season;
        @SerializedName("league")
        @Expose
        private League league;
        @SerializedName("sport")
        @Expose
        private Sport sport;


        public Datum(Integer id, String slug, String name, String status, String statusMore, HomeTeam homeTeam, AwayTeam awayTeam, String startAt, Integer priority, HomeScore homeScore, AwayScore awayScore, Season season, League league,Sport sport) {
            this.id = id;
            this.slug = slug;
            this.name = name;
            this.status = status;
            this.statusMore = statusMore;
            this.homeTeam = homeTeam;
            this.awayTeam = awayTeam;
            this.startAt = startAt;
            this.priority = priority;
            this.homeScore = homeScore;
            this.awayScore = awayScore;
            this.season = season;
            this.league = league;
            this.sport = sport;
        }
        public class HomeTeam{
            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("name")
            @Expose
            private String name;

            public HomeTeam(Integer id, String slug, String name) {
                this.id = id;
                this.slug = slug;
                this.name = name;
            }

            public Integer getId() {
                return id;
            }

            public String getSlug() {
                return slug;
            }

            public String getName() {
                return name;
            }
        }

        public class AwayTeam{
            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("name")
            @Expose
            private String name;

            public AwayTeam(Integer id, String slug, String name) {
                this.id = id;
                this.slug = slug;
                this.name = name;
            }

            public Integer getId() {
                return id;
            }

            public String getSlug() {
                return slug;
            }

            public String getName() {
                return name;
            }
        }

        public class HomeScore{
            @SerializedName("current")
            @Expose
            private Integer current;
            @SerializedName("display")
            @Expose
            private Integer display;

            public HomeScore(Integer current, Integer display) {
                this.current = current;
                this.display = display;
            }

            public Integer getCurrent() {
                return current;
            }

            public Integer getDisplay() {
                return display;
            }
        }

        public class AwayScore{
            @SerializedName("current")
            @Expose
            private Integer current;
            @SerializedName("display")
            @Expose
            private Integer display;

            public AwayScore(Integer current, Integer display) {
                this.current = current;
                this.display = display;
            }

            public Integer getCurrent() {
                return current;
            }

            public Integer getDisplay() {
                return display;
            }
        }
        public class Season{
            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("year_start")
            @Expose
            private Integer yearStart;
            @SerializedName("year_end")
            @Expose
            private Object yearEnd;

            public Season(Integer id, String slug, String name, Integer yearStart, Object yearEnd) {
                this.id = id;
                this.slug = slug;
                this.name = name;
                this.yearStart = yearStart;
                this.yearEnd = yearEnd;
            }

            public Integer getId() {
                return id;
            }

            public String getSlug() {
                return slug;
            }

            public String getName() {
                return name;
            }

            public Integer getYearStart() {
                return yearStart;
            }

            public Object getYearEnd() {
                return yearEnd;
            }
        }

        public class League{
            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("name")
            @Expose
            private String name;

            public League(Integer id, String slug, String name) {
                this.id = id;
                this.slug = slug;
                this.name = name;
            }

            public Integer getId() {
                return id;
            }

            public String getSlug() {
                return slug;
            }

            public String getName() {
                return name;
            }
        }
        public class Sport{
            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("slug")
            @Expose
            private Object slug;
            @SerializedName("name")
            @Expose
            private String name;

            public Sport(Integer id, Object slug, String name) {
                this.id = id;
                this.slug = slug;
                this.name = name;
            }

            public Integer getId() {
                return id;
            }

            public Object getSlug() {
                return slug;
            }

            public String getName() {
                return name;
            }
        }

        public Integer getId() {
            return id;
        }

        public String getSlug() {
            return slug;
        }

        public String getName() {
            return name;
        }

        public String getStatus() {
            return status;
        }

        public String getStatusMore() {
            return statusMore;
        }

        public HomeTeam getHomeTeam() {
            return homeTeam;
        }

        public AwayTeam getAwayTeam() {
            return awayTeam;
        }

        public String getStartAt() {
            return startAt;
        }

        public Integer getPriority() {
            return priority;
        }

        public HomeScore getHomeScore() {
            return homeScore;
        }

        public AwayScore getAwayScore() {
            return awayScore;
        }

        public Season getSeason() {
            return season;
        }

        public League getLeague() {
            return league;
        }

        public Sport getSport() {
            return sport;
        }



    }

    public List<Datum> getData() {
        return data;
    }
}
