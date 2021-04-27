package pl.janowski.bookweb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AboutProgramActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_program);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}