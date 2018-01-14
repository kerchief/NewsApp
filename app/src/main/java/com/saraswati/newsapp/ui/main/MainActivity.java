package com.saraswati.newsapp.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.saraswati.newsapp.R;
import com.saraswati.newsapp.data.remote.model.NewsItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_news)
    RecyclerView rvNews;
    private NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //membuat adapter
        adapter = new NewsAdapter();
        //set data
        adapter.setData(getDummyData());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rvNews.setLayoutManager(linearLayoutManager);
        rvNews.setAdapter(adapter);
    }

    public List<NewsItem> getDummyData(){
        List<NewsItem> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            NewsItem newsItem = new NewsItem();
            newsItem.setTitle("Judul "+ String.valueOf(i)); //judul
            newsItem.setAuthor("Penulis "+ String.valueOf(i)); //judul
            newsItem.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum." + String.valueOf(i));
            newsItem.setUrlCover("http://lorempixel.com/400/200/nightlife/" + String.valueOf(i));
            result.add(newsItem);
        }
        return result;
    }
}
