package org.jby.studyenglish;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.Calendar;

public class CalendarFragment1_1 extends Fragment {
    EditText kindoftest, supplies, place;
    TextView date, time;
    Button button;
    private DatePickerDialog.OnDateSetListener callbackMethod;
    private TimePickerDialog.OnTimeSetListener callbackMethodTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_calendar1_1, container, false);

        CalendarFragment1 calendarFragment1 = new CalendarFragment1();

        kindoftest = rootView.findViewById(R.id.kindoftest);
        supplies = rootView.findViewById(R.id.supplies);
        place = rootView.findViewById(R.id.place);
        button = rootView.findViewById(R.id.button);
        date = rootView.findViewById(R.id.ctextView1_1);
        time = rootView.findViewById(R.id.ctextView1_2);
        callbackMethod = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                date.setText(year + "년" + (month+1) + "월" + dayOfMonth + "일");
            }
        };
        callbackMethodTime = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                time.setText(hourOfDay + "시" + minute + "분");
            }
        };

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(getContext(), callbackMethod, Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH);
                dialog.getDatePicker().setMinDate(System.currentTimeMillis());
                dialog.show();
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog dialog = new TimePickerDialog(getContext(), callbackMethodTime, Calendar.HOUR, Calendar.MINUTE, true);
                dialog.show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = kindoftest.getText().toString();
                String b = date.getText().toString();
                String c = time.getText().toString();
                String d = supplies.getText().toString();
                String e = place.getText().toString();

                CalendarDatabaseHandler db = new CalendarDatabaseHandler(getContext());

                // inserting new data into database
                db.insertData(a, b, c, d, e);

                kindoftest.setText("");
                supplies.setText("");
                place.setText("");

                Toast.makeText(getContext(), "저장되었습니다", Toast.LENGTH_LONG).show();
            }
        });

        return rootView;
    }
}
