package pl.janowski.bookweb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ViewHolder> {

    private List<Book> books;

    public BookListAdapter(List<Book> mbooks){
        books = mbooks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View bookView = inflater.inflate(R.layout.books_list_element, parent, false);

        ViewHolder viewHolder = new ViewHolder(bookView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book book = books.get(position);

        TextView textViewTyt = holder.textViewTytul;
        textViewTyt.setText(book.getTitle());
        TextView textViewAut = holder.textViewAutor;
        textViewAut.setText(book.getAuthor());
        TextView textViewDat = holder.textViewData;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        textViewDat.setText(simpleDateFormat.format(book.getDate()));
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewTytul;
        public TextView textViewAutor;
        public TextView textViewData;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTytul = (TextView) itemView.findViewById(R.id.textViewTytul);
            textViewAutor = (TextView) itemView.findViewById(R.id.textViewAutor);
            textViewData = (TextView) itemView.findViewById(R.id.textViewData);
        }
    }
}
