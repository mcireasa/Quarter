package com.mcireasa.quizzapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mcireasa.quizzapp.Model.Test;
import com.mcireasa.quizzapp.R;
import com.mcireasa.quizzapp.TestsActivity;

import java.util.List;

public class TestsAdapter extends ArrayAdapter<Test> {

    public TestsAdapter(@NonNull Context context, int resource, @NonNull List<Test> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView ==  null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.test_item, null);
        }
        Test test=getItem(position);

        TextView nameTest=(TextView)convertView.findViewById(R.id.nameTest);
        nameTest.setText(test.getText());
        Button button=(Button)convertView.findViewById(R.id.deleteTestButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Button was clicked for "+getItem(position).getText(),Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;

    }


}
