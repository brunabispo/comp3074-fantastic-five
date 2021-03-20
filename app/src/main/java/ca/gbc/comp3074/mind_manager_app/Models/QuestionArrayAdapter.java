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
import ca.gbc.comp3074.mind_manager_app.R;

public class QuestionArrayAdapter extends ArrayAdapter<Question> {

    private final Context context;
    private final List<Question> values;

    public QuestionArrayAdapter(@NonNull Context context, @NonNull List<Question> objects) {
        super(context, R.layout.row_layout_questions, objects);
        this.context = context;
        this.values = objects;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

        @SuppressLint("ViewHolder") View rowView = inflater.inflate(R.layout.row_layout_questions, parent, false);

        TextView id = rowView.findViewById(R.id.lblID);
        final int ID = values.get(position).getID();
        id.setText(ID+"");

        TextView question = rowView.findViewById(R.id.lblQuestions);
        question.setText(values.get(position).getQuestionText());

        ImageButton btnView = rowView.findViewById(R.id.btn_view);
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAnswers(ID);
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