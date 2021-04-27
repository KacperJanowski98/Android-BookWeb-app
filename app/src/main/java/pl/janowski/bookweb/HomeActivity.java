package pl.janowski.bookweb;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class HomeActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_book, R.id.nav_mat, R.id.nav_inf, R.id.nav_ele, R.id.nav_lista)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                int menuID = destination.getId();

                switch (menuID){
                    case R.id.nav_book:
                        Toast.makeText(HomeActivity.this, "BookWeb", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_mat:
                        Toast.makeText(HomeActivity.this, "Matematyka", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_inf:
                        Toast.makeText(HomeActivity.this, "Informatyka", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_ele:
                        Toast.makeText(HomeActivity.this, "Elektronika", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_lista){
                    Intent intent = new Intent(HomeActivity.this, BooksListActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                intent = new Intent(HomeActivity.this, AboutProgramActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_share:
                Intent sendIntend = new Intent();
                sendIntend.setAction(Intent.ACTION_SEND);
                sendIntend.putExtra(Intent.EXTRA_TEXT, "Stworzyłem książke do listowania ksiażek. Chcesz z niej skorzystać? Pobierz ją na...");
                sendIntend.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntend, null);
                startActivity(shareIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}