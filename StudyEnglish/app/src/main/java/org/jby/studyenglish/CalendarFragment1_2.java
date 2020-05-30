package org.jby.studyenglish;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class CalendarFragment1_2 extends Fragment {
    public TextView query;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_calendar1_2, container, false);

        query = rootView.findViewById(R.id.query);

        if(getArguments() != null){
            String schedule = getArguments().getString("schedule");
            query.setText(schedule.toString());
        }

        return rootView;
    }

    public void inquery(String list) {
        query.setText(list.toString());
    }
}