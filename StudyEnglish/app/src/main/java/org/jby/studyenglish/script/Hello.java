package org.jby.studyenglish.script;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.jby.studyenglish.R;

import java.util.ArrayList;

public class Hello extends AppCompatActivity {

    public static final String LOG_TAG = Hello.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        ArrayList<Helloo> hellos = QueryUtilsHello.extractHellos();

        ListView helloListView = (ListView) findViewById(R.id.listHello);

        final HelloAdapter adapter = new HelloAdapter(this, hellos);

        helloListView.setAdapter(adapter);
    }
}