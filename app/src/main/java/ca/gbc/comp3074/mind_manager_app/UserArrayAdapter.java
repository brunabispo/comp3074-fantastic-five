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

public class UserArrayAdapter extends ArrayAdapter<User> {

    private final Context context;
    private final List<User> values;
    private final int rowLayout;
    private final int roleId;
    private final int userNameId;
    private final int firstNameId;

    public UserArrayAdapter(@NonNull Context context, int resource,
                                  int roleId, int userNameId,int firstNameId, int passwordId,
                                  @NonNull List<User> objects) {
        super(context, resource, userNameId, objects);
        this.context = context;
        this.values = objects;
        this.rowLayout = resource;
        this.roleId = roleId;
        this.userNameId = userNameId;
        this.firstNameId = firstNameId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(this.rowLayout, parent, false);

        TextView role = rowView.findViewById(this.roleId);
        role.setText(this.values.get(position).getRole());

        TextView username = rowView.findViewById(this.userNameId);
        username.setText(this.values.get(position).getUserName());

        TextView firstNameId = rowView.findViewById(this.firstNameId);
        firstNameId.setText(this.values.get(position).getFirstName());

        return rowView;
    }
}