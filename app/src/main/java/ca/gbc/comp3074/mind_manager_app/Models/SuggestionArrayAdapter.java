package ca.gbc.comp3074.mind_manager_app.Models;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import ca.gbc.comp3074.mind_manager_app.R;

public class SuggestionArrayAdapter extends ArrayAdapter<Suggestion> {

    private final Context context;
    private final List<Suggestion> values;
    private final int categoryImages[];

    public SuggestionArrayAdapter(@NonNull Context context, @NonNull List<Suggestion> objects, int[] categoryImages) {
        super(context, R.layout.row_layout_suggestions, objects);
        this.context = context;
        this.values = objects;
        this.categoryImages = categoryImages;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("ViewHolder") View rowView = inflater.inflate(R.layout.row_layout_suggestions, parent, false);

        ImageView images = rowView.findViewById(R.id.catgoryImage);
        images.setImageResource(categoryImages[position]);

        TextView categoryTitles = rowView.findViewById(R.id.lblCategory);
        categoryTitles.setText(values.get(position).getCategoryName());

        TextView suggestionNames = rowView.findViewById(R.id.lblSuggestion);
        suggestionNames.setText(values.get(position).getSuggestionName());

        return rowView;
    }
}