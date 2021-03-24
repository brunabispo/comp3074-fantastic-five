package ca.gbc.comp3074.mind_manager_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

public class VideoMain  extends AppCompatActivity {

    RecyclerView recyclerView;
    Vector<VideoPlayer> youtubeVideos = new Vector<VideoPlayer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_performer);
        playVideo();
    }
    public void playVideo(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        //happy
        // String selection = intent.getStringExtra("selection");
        Intent intent = getIntent();
        String song = intent.getStringExtra("musicPlayer");
        TextView songEdit = (TextView)findViewById(R.id.txtSong);
        songEdit.setText(song);
        youtubeVideos.add( new VideoPlayer("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/ru0K8uYEZWw\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new VideoPlayer("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/LjhCEhWiKXk\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new VideoPlayer("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/y8Rr39jKFKU\" frameborder=\"0\" allowfullscreen></iframe>") );

        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);

        recyclerView.setAdapter(videoAdapter);
    }
}
