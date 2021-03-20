package ca.gbc.comp3074.mind_manager_app.Models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.sql.Connection;
import java.util.List;

import ca.gbc.comp3074.mind_manager_app.GoogleMySQLConnectionHelper;
import ca.gbc.comp3074.mind_manager_app.R;

public class UserArrayAdapter extends ArrayAdapter<User> {

    private final Context context;
    private final List<User> values;

    public UserArrayAdapter(@NonNull Context context, @NonNull List<User> objects) {
        super(context, R.layout.row_layout_users, objects);
        this.context = context;
        this.values = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row_layout_users, parent, false);

        TextView id = rowView.findViewById(R.id.lblID);
        final int ID = values.get(position).getID();
        id.setText(ID+"");

        TextView role = rowView.findViewById(R.id.lblRole);
        role.setText(values.get(position).getRole());

        TextView username = rowView.findViewById(R.id.lblUsername);
        username.setText(this.values.get(position).getUserName());

        TextView firstNameId = rowView.findViewById(R.id.lblFirstName);
        firstNameId.setText(this.values.get(position).getFirstName());

        ImageButton btnView = rowView.findViewById(R.id.btn_delete);
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //deleteUser(connect, ID, db);
            }
        });

        return rowView;
    }

    private void deleteUser(Connection connect, int id, GoogleMySQLConnectionHelper db){
        db.deleteUser(connect, id);
    }
}