package com.example.chillmovie.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.chillmovie.R;
import com.example.chillmovie.adapter.BannerMoviesPagerAdapter;
import com.example.chillmovie.adapter.MainRecyclerAdapter;
import com.example.chillmovie.model.AllCategory;
import com.example.chillmovie.model.BannerMovies;
import com.example.chillmovie.model.CategoryItem;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    BannerMoviesPagerAdapter bannerMoviesPagerAdapter;
    TabLayout indicatorTab, categoryTab;
    ViewPager bannerMoviesViewPager;
    List<BannerMovies> homeBannerList;
    List<BannerMovies> tvShowBannerList;
    List<BannerMovies> movieBannerList;
    List<BannerMovies> kidsBannerList;
    Timer sliderTimer;

    NestedScrollView nestedScrollView;
    AppBarLayout appBarLayout;

    MainRecyclerAdapter mainRecyclerAdapter;
    RecyclerView mainRecycler;
    List<AllCategory> allCategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        indicatorTab = findViewById(R.id.tab_indicator);
        categoryTab = findViewById(R.id.tabLayout);
        nestedScrollView = findViewById(R.id.nested_scroll);
        appBarLayout = findViewById(R.id.appbar);

        homeBannerList = new ArrayList<>();
        homeBannerList.add(new BannerMovies(1, "Doctor Strange in the Multiverse of Madness", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/2745/1282745-h-888fe17d3e5e.jpg", "https://cdn.winten.workers.dev/4:/Data/Doctor.Strange.in.the.Multiverse.of.Madness.2022.IMAX.1080p.DSNP.WEB-DL.DDP5.1.Atmos.H.264-CMRG[TGx]/Doctor.Strange.in.the.Multiverse.of.Madness.2022.IMAX.1080p.DSNP.WEB-DL.DDP5.1.Atmos.H.264-CMRG.mkv"));
        homeBannerList.add(new BannerMovies(1, "She-Hulk: Attorney At Law", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/6618/1316618-h-d1f32eaa614e.jpg", ""));
        homeBannerList.add(new BannerMovies(1, "Thor: Love and Thunder", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/8446/1338446-h-9384d1cbac80.jpg", ""));
        homeBannerList.add(new BannerMovies(1, "SPY x FAMILY", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/4157/1364157-h-71993caf734b.jpg", ""));

        tvShowBannerList = new ArrayList<>();
        tvShowBannerList.add(new BannerMovies(1, "Keluarga Cemara: The Series", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/8376/1358376-h-ac224c03fd5a.jpg", ""));
        tvShowBannerList.add(new BannerMovies(2, "She-Hulk: Attorney At Law", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/6618/1316618-h-d1f32eaa614e.jpg", ""));
        tvShowBannerList.add(new BannerMovies(3, "Big Mouth", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/7715/1307715-h-f6457f08d918.jpg", ""));
        tvShowBannerList.add(new BannerMovies(4, "SPY x FAMILY", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/4157/1364157-h-71993caf734b.jpg", ""));

        movieBannerList = new ArrayList<>();
        movieBannerList.add(new BannerMovies(1, "Doctor Strange in the Multiverse of Madness", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/2745/1282745-h-888fe17d3e5e.jpg", ""));
        movieBannerList.add(new BannerMovies(2, "Cruella", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/2576/1162576-h-872f370d3ca2.jpg", ""));
        movieBannerList.add(new BannerMovies(3, "Thor: Love and Thunder", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/8446/1338446-h-9384d1cbac80.jpg", ""));
        movieBannerList.add(new BannerMovies(4, "SPY x FAMILY", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/4157/1364157-h-71993caf734b.jpg", ""));

        kidsBannerList = new ArrayList<>();
        kidsBannerList.add(new BannerMovies(1, "Turning Red", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/2810/1132810-h-49fd39fd4100.jpg", ""));
        kidsBannerList.add(new BannerMovies(2, "Ejen Ali", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/9863/1319863-h-2a5f00404e18.jpg", ""));
        kidsBannerList.add(new BannerMovies(3, "Frozen II", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/8244/748244-h.jpg", ""));
        kidsBannerList.add(new BannerMovies(4, "Pinocchio", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/8444/1338444-h-f2d94ae93769.jpg", ""));


        //default tab selected
        setBannerMoviesPagerAdapter(homeBannerList);

        //on tab change selected data
        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 1:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(tvShowBannerList);
                        return;
                    case 2:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(movieBannerList);
                        return;
                    case 3:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(kidsBannerList);
                        return;
                    default:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(homeBannerList);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //add catitem data
        List<CategoryItem> homeCatListItem1 = new ArrayList<>();
        homeCatListItem1.add(new CategoryItem(1, "She-Hulk: Attorney At Law", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/6618/1316618-h-d1f32eaa614e.jpg", ""));
        homeCatListItem1.add(new CategoryItem(2, "KKN Di Desa Penari", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/7155/1317155-h-e387fd45d3bf.jpg", ""));
        homeCatListItem1.add(new CategoryItem(3, "Thor: Love and Thunder", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/8446/1338446-h-9384d1cbac80.jpg", ""));
        homeCatListItem1.add(new CategoryItem(4, "Keluarga Cemara The Series", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/8376/1358376-h-ac224c03fd5a.jpg", ""));
        homeCatListItem1.add(new CategoryItem(5, "SPY x FAMILY", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/4157/1364157-h-71993caf734b.jpg", ""));

        List<CategoryItem> homeCatListItem2 = new ArrayList<>();
        homeCatListItem2.add(new CategoryItem(1, "She-Hulk: Attorney At Law", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/6618/1316618-h-d1f32eaa614e.jpg", ""));
        homeCatListItem2.add(new CategoryItem(2, "KKN Di Desa Penari", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/7155/1317155-h-e387fd45d3bf.jpg", ""));
        homeCatListItem2.add(new CategoryItem(3, "Thor: Love and Thunder", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/8446/1338446-h-9384d1cbac80.jpg", ""));
        homeCatListItem2.add(new CategoryItem(4, "Keluarga Cemara The Series", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/8376/1358376-h-ac224c03fd5a.jpg", ""));
        homeCatListItem2.add(new CategoryItem(5, "SPY x FAMILY", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/4157/1364157-h-71993caf734b.jpg", ""));

        List<CategoryItem> homeCatListItem3 = new ArrayList<>();
        homeCatListItem3.add(new CategoryItem(1, "Teka Teki Tika", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/690/1230690-h-78d22e4cd15a.jpg", ""));
        homeCatListItem3.add(new CategoryItem(2, "Asih 2", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/6346/946346-h.jpg", ""));
        homeCatListItem3.add(new CategoryItem(3, "The Watcher", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/6989/1006989-h-efed419db76e.jpg", ""));
        homeCatListItem3.add(new CategoryItem(4, "Werewolf By Night", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/5799/1375799-h-5b1d33cc0f0f.jpg", ""));
        homeCatListItem3.add(new CategoryItem(5, "One Dollar Lawyer", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/8387/1358387-h-ca86c9ad1f94.jpg", ""));

        List<CategoryItem> homeCatListItem4 = new ArrayList<>();
        homeCatListItem4.add(new CategoryItem(1, "Doctor Strange in the Multiverse of Madness", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/2745/1282745-h-888fe17d3e5e.jpg", ""));
        homeCatListItem4.add(new CategoryItem(2, "Captain Marvel", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/4396/754396-h.jpg", ""));
        homeCatListItem4.add(new CategoryItem(3, "Thor: Love and Thunder", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/8446/1338446-h-9384d1cbac80.jpg", ""));
        homeCatListItem4.add(new CategoryItem(4, "Shang-Chi and The Legends of The Ten Rings", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/8753/1078753-h-f46e08b01d9d.jpg", ""));
        homeCatListItem4.add(new CategoryItem(5, "Avengers: Endgame", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/4016/754016-h.jpg", ""));

        List<CategoryItem> homeCatListItem5 = new ArrayList<>();
        homeCatListItem5.add(new CategoryItem(1, "Wedding Agreement The Series", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/7128/1257128-h-3e8611dcbfc3.jpg", ""));
        homeCatListItem5.add(new CategoryItem(2, "KKN Di Desa Penari", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/7155/1317155-h-e387fd45d3bf.jpg", ""));
        homeCatListItem5.add(new CategoryItem(3, "Gara Gara Warisan", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/9925/1329925-h-47e2ea99267c.jpg", ""));
        homeCatListItem5.add(new CategoryItem(4, "Keluarga Cemara The Series", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/8376/1358376-h-ac224c03fd5a.jpg", ""));
        homeCatListItem5.add(new CategoryItem(5, "Yowis Ben FInale", "https://img1.hotstarext.com/image/upload/f_auto,t_web_m_1_5x/sources/r1/cms/prod/9907/1219907-h-42380e068a31.jpg", ""));


        allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory(1, "Pilihan Top Untukmu", homeCatListItem1));
        allCategoryList.add(new AllCategory(2, "Trending", homeCatListItem2));
        allCategoryList.add(new AllCategory(3, "Akan Datang", homeCatListItem3));
        allCategoryList.add(new AllCategory(4, "Marvel Cinematic Universe", homeCatListItem4));
        allCategoryList.add(new AllCategory(5, "Eksklusif dari Indonesia", homeCatListItem5));

        //pass array to recycler setup method
        setMainRecycler(allCategoryList);

    }

    private void setBannerMoviesPagerAdapter(List<BannerMovies> bannerMoviesList){

        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        bannerMoviesPagerAdapter = new BannerMoviesPagerAdapter(this, bannerMoviesList);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagerAdapter);
        indicatorTab.setupWithViewPager(bannerMoviesViewPager);

        sliderTimer = new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlider(), 4000, 6000);
        indicatorTab.setupWithViewPager(bannerMoviesViewPager,true);

    }

    class AutoSlider extends TimerTask{

        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(bannerMoviesViewPager.getCurrentItem() < homeBannerList.size() - 1){

                        bannerMoviesViewPager.setCurrentItem(bannerMoviesViewPager.getCurrentItem() + 1);

                    }
                    else{
                        bannerMoviesViewPager.setCurrentItem(0);
                    }
                }
            });

        }
    }

    public void setMainRecycler(List<AllCategory> allCategoryList){

        mainRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mainRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(this, allCategoryList);
        mainRecycler.setAdapter(mainRecyclerAdapter);

    }

    private void setScrollDefaultState(){
        nestedScrollView.fullScroll(View.FOCUS_UP);
        nestedScrollView.scrollTo(0,0);
        appBarLayout.setExpanded(true);
    }

}