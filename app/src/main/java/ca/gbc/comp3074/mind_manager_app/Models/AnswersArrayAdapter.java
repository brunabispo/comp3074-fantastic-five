package ca.gbc.comp3074.mind_manager_app.Models;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import ca.gbc.comp3074.mind_manager_app.Admin.AdminAnswersActivity;
import ca.gbc.comp3074.mind_manager_app.R;

public class AnswersArrayAdapter extends ArrayAdapter<Answer> {

    private final Context context;
    private final List<Answer> values;

    public AnswersArrayAdapter(@NonNull Context context, @NonNull List<Answer> objects) {
        super(context, R.layout.row_layout_answers, objects);
        this.context = context;
        this.values = objects;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

        @SuppressLint("ViewHolder") View rowView = inflater.inflate(R.layout.row_layout_answers, parent, false);

        TextView answer = rowView.findViewById(R.id.lblAnswer);
        answer.setText(" "+values.get(position).getText());

        TextView bored_rating = rowView.findViewById(R.id.lblBored);
        bored_rating.setText(values.get(position).getBoredRating()+"");

        TextView energetic_rating = rowView.findViewById(R.id.lblEnergetic);
        energetic_rating.setText(values.get(position).getEnergeticRating()+"");

        TextView happy_rating = rowView.findViewById(R.id.lblHappy);
        happy_rating.setText(values.get(position).getHappyRating()+"");

        TextView sad_rating = rowView.findViewById(R.id.lblSad);
        sad_rating.setText(values.get(position).getSadRating()+"");

        TextView tired_rating = rowView.findViewById(R.id.lblTired);
        tired_rating.setText(values.get(position).getTiredRating()+"");

        ImageButton btnView = rowView.findViewById(R.id.btn_edit);
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openAnswers(ID);
            }
        });

        return rowView;
    }

    private void openAnswers(int id){
        Intent start = new Intent(context.getApplicationContext(), AdminAnswersActivity.class);
        start.putExtra("id", id);
        context.startActivity(start);
    }
}