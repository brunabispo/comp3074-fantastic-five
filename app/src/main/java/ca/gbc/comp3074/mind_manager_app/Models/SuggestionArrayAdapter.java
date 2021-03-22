package ca.gbc.comp3074.mind_manager_app.Models;

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
    private final int rowLayout;
    private final List<Suggestion> values;
    private final int categoryImages[];

    public SuggestionArrayAdapter(@NonNull Context context, int resource,
                                  @NonNull List<Suggestion> objects, int[] categoryImages) {

        super(context, resource, objects);

        this.context = context;
        this.values = objects;
        this.categoryImages = categoryImages;
        this.rowLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(this.rowLayout, parent, false);

        ImageView images = row.findViewById(R.id.catgoryImage);
        TextView cTitles = row.findViewById(R.id.lblCategory);
        TextView sNames = row.findViewById(R.id.lblSuggestion);

        //set resources on views
        images.setImageResource(categoryImages[position]);
        cTitles.setText(this.values.get(position).getCategoryName());
        sNames.setText(this.values.get(position).getSuggestionName());

        return row;
    }
}