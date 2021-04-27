package pl.janowski.bookweb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import pl.janowski.bookweb.ui.main.FragmentElectronicFragment;

public class fragment_electronic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_electronic_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, FragmentElectronicFragment.newInstance())
                    .commitNow();
        }
    }
}