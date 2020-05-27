package org.jby.studyenglish;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class CalendarFragment1 extends Fragment {
    Fragment fragment1, fragment2;
    List<String> items = new ArrayList<String>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_calendar1, container, false);

        fragment1 = new CalendarFragment1_1();

        items.add(0, "시험 일정을 추가하세요!");

        Spinner spinner = rootView.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getContext(), android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if(position == 0){
                    getFragmentManager().beginTransaction().replace(R.id.eventContainer, fragment1).commit();
                }else{

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                getFragmentManager().beginTransaction().replace(R.id.eventContainer, fragment1).commit();
            }
        });

        return rootView;
    }
}
