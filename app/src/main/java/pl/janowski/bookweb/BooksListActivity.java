package pl.janowski.bookweb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class BooksListActivity extends AppCompatActivity {

    private List<Book> books = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);

        Calendar calNawyki = new GregorianCalendar(1989, 8, 15);
        Calendar calSer = new GregorianCalendar(1998, 9, 8);
        Calendar calOcean = new GregorianCalendar(2005, 2,20);
        Calendar calWinning = new GregorianCalendar(2005, 4, 16);
        Calendar calSprzedaz = new GregorianCalendar(2008, 2, 26);
        Calendar calNowy = new GregorianCalendar(2019, 7, 11);
        Calendar calMenad = new GregorianCalendar(2017, 3, 10);
        Calendar calRzeczy = new GregorianCalendar(1994, 2, 17);
        Calendar calZrob = new GregorianCalendar(2006, 4, 22);
        Calendar calOjciec = new GregorianCalendar(1997, 5, 23);

        Book nawyki = new Book("7 nawyków skutecznego działania","Stephaen R. Covey", calNawyki.getTime());
        Book ser = new Book("Kto zabrał mój ser?", "Spencer Johnson", calSer.getTime());
        Book ocean = new Book("Strategia Błękitnego Oceanu", "W. Chan Kim", calOcean.getTime());
        Book winning = new Book("Winning znaczy zwyciężać", "Jack Welch", calWinning.getTime());
        Book sprzedaz = new Book("Zarządzanie sprzedażą - praktyki najlepszych", "Chet Holmes", calSprzedaz.getTime());
        Book nowy = new Book("Nowy Jednominutowy Menadżer", "dr Ken Blanchard", calNowy.getTime());
        Book menad = new Book("Menadżer 80/20 - pracuj mniej", "Richard koch", calMenad.getTime());
        Book rzeczy = new Book("Najpierw rzeczy najważniejsze", "Stephen R. Covey", calRzeczy.getTime());
        Book zrob = new Book("Zaryzykuj - Zrób To!", "Richard Branson", calZrob.getTime());
        Book ojciec = new Book("Bogaty ojciec, biedny ojciec", "Robert Kiyosaki", calOcean.getTime());
        books.add(nawyki);
        books.add(ser);
        books.add(ocean);
        books.add(winning);
        books.add(sprzedaz);
        books.add(nowy);
        books.add(menad);
        books.add(rzeczy);
        books.add(zrob);
        books.add(ojciec);

        for (Book i : books){
            Log.i("Ksiazki w liscie to: ", i.toString());
        }

        BookListAdapter bookListAdapter = new BookListAdapter(books);

        RecyclerView rvBooks = (RecyclerView) findViewById(R.id.books_list_recycler_view);

        rvBooks.setAdapter(bookListAdapter);

        rvBooks.setLayoutManager(new LinearLayoutManager(this));

    }
}