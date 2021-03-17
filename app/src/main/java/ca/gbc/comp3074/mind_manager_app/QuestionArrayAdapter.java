package ca.gbc.comp3074.mind_manager_app;

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

public class QuestionArrayAdapter extends ArrayAdapter<Question> {

    private final Context context;
    private final List<Question> values;

    public QuestionArrayAdapter(@NonNull Context context, @NonNull List<Question> objects) {
        super(context, R.layout.row_layout_questions, objects);
        this.context = context;
        this.values = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row_layout_questions, parent, false);

        TextView id = rowView.findViewById(R.id.lblID);
        id.setText(values.get(position).getID()+"");

        TextView question = rowView.findViewById(R.id.lblQuestions);
        question.setText(values.get(position).getQuestionText());

        ImageView icon1 = rowView.findViewById(R.id.iconView);
        icon1.setImageResource(values.get(position).getIconIdView());

        ImageView icon2 = rowView.findViewById(R.id.iconDel2);
        icon2.setImageResource(values.get(position).getIconIdDel());

        return rowView;
    }
}