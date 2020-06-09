package org.jby.studyenglish;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TodayNoteItemView extends LinearLayout {
    TextView english2;
    TextView meaning2;

    public TodayNoteItemView(Context context) {
        super(context);

        init(context);
    }

    public TodayNoteItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.home1_item, this, true);

        english2 = findViewById(R.id.english2);
        meaning2 = findViewById(R.id.meaning2);
    }

    public void setEnglish2(String english) {
        english2.setText(english);
    }

    public void setMeaning2(String meaning) {
        meaning2.setText(meaning);
    }

}
