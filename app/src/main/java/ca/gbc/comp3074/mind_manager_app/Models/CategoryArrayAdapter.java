package ca.gbc.comp3074.mind_manager_app.Models;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

import ca.gbc.comp3074.mind_manager_app.Admin.AdminAnswersActivity;
import ca.gbc.comp3074.mind_manager_app.Models.Suggestion;
import ca.gbc.comp3074.mind_manager_app.R;

public class CategoryArrayAdapter extends ArrayAdapter<Suggestion> {

    private final Context context;
    private final List<Suggestion> values;

    public CategoryArrayAdapter(@NonNull Context context, @NonNull List<Suggestion> objects) {
        super(context, R.layout.row_layout_categories, objects);
        this.context = context;
        this.values = objects;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

        @SuppressLint("ViewHolder") View rowView = inflater.inflate(R.layout.row_layout_categories, parent, false);

        TextView category = rowView.findViewById(R.id.lblCategories);
        category.setText(values.get(position).getCategoryName());

        ImageButton btnView = rowView.findViewById(R.id.btn_view);
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openAnswers(ID);
            }
        });

        ImageView icon2 = rowView.findViewById(R.id.btn_delete);

        return rowView;
    }

    private void openAnswers(int id){
        Intent start = new Intent(context.getApplicationContext(), AdminAnswersActivity.class);
        start.putExtra("id", id);
        context.startActivity(start);
    }
}