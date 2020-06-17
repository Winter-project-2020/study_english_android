package org.jby.studyenglish.script;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.jby.studyenglish.R;

import java.util.List;

public class HelloAdapter extends ArrayAdapter<Helloo> {

    public HelloAdapter(@NonNull Context context, List<Helloo> hellos) {
        super(context, 0, hellos);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.hello_list_item, parent, false);
        }

        Helloo currentHello = getItem(position);

        TextView englishView = (TextView)listItemView.findViewById(R.id.TextViewEnglish1);
        englishView.setText("what is this?");

        TextView subView = (TextView)listItemView.findViewById(R.id.TextViewSub1);
        subView.setText("이것은 무엇입니까?");

        return listItemView;
    }
}
