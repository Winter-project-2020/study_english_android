package org.jby.studyenglish;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import java.util.List;

public class CalendarFragment1 extends Fragment {
    Fragment fragment1, fragment2;
    Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_calendar1, container, false);

        fragment1 = new CalendarFragment1_1();
        fragment2 = new CalendarFragment1_2();

        spinner = rootView.findViewById(R.id.spinner);

        // loading spinner with newly added data
        loadSpinnerData();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if(position==0){
                    // loading spinner with newly added data
                    loadSpinnerData();
                    getFragmentManager().beginTransaction().replace(R.id.eventContainer, fragment1).commit();
                }else {
                    getFragmentManager().beginTransaction().replace(R.id.eventContainer, fragment2).commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        return rootView;
    }

    /**
     * Function to load the spinner data from SQLite database
     * */
    public void loadSpinnerData() {
        // database handler
        CalendarDatabaseHandler db = new CalendarDatabaseHandler(getContext());

        // Spinner Drop down elements
        List<String> items = db.getAllitems();

        items.add(0, "시험일정을 추가해주세요!");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, items);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }
}
