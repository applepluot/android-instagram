package com.codepath.instagram.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.codepath.instagram.R;
import com.codepath.instagram.helpers.InstagramPostsAdapter;
import com.codepath.instagram.helpers.SimpleVerticalSpacerItemDecoration;
import com.codepath.instagram.helpers.Utils;
import com.codepath.instagram.models.InstagramPost;

import java.util.List;


public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Tool > Project > Sync with gradle
        setContentView(R.layout.activity_home);
        // Get the list
        List<InstagramPost> posts = Utils.fetchPosts(this.getApplicationContext(), "popular.json");
        RecyclerView rvPosts = (RecyclerView) findViewById(R.id.rvPosts);
        rvPosts.addItemDecoration(new SimpleVerticalSpacerItemDecoration(10));
        // Get the adapter
        InstagramPostsAdapter adapter = new InstagramPostsAdapter(posts, this);
        rvPosts.setAdapter(adapter);
        rvPosts.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
