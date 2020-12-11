package ca.gbc.comp3074.mind_manager_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public class SuggestionArrayAdapter extends ArrayAdapter<Suggestion> {

    private final Context context;
    private final List<Suggestion> values;
    private final int rowLayout;
    private final int suggestionNameId;
    private final int categoryNameId;

    public SuggestionArrayAdapter(@NonNull Context context, int resource,
                                  int categoryNameId, int suggestionNameId,
                            @NonNull List<Suggestion> objects) {

        super(context, resource, suggestionNameId, objects);

        this.context = context;
        this.values = objects;
        this.rowLayout = resource;
        this.suggestionNameId = suggestionNameId;
        this.categoryNameId = categoryNameId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(this.rowLayout, parent, false);

        TextView suggestion = rowView.findViewById(this.suggestionNameId);

        suggestion.setText(this.values.get(position).getSuggestionName());

        TextView category = rowView.findViewById(this.categoryNameId);

        category.setText(this.values.get(position).getCategoryName());

        return rowView;
    }
}