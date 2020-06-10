package org.jby.studyenglish;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;

import org.jby.studyenglish.script.Emergency;
import org.jby.studyenglish.script.Hello;
import org.jby.studyenglish.script.Question;
import org.jby.studyenglish.script.Travel;

public class HomeFragment1 extends Fragment {
    FrameLayout Notecontainer;
    Animation translateIn;
    Animation translateOut;

    TodayNoteItemView view;
    TodayNoteItemView view2;

    int selected = 1;

    boolean running = false;

    Handler handler = new Handler();

    Button helloBtn, travelBtn, questionBtn, emergencyBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home1, container, false);

        helloBtn = rootView.findViewById(R.id.helloBtn);
        travelBtn = rootView.findViewById(R.id.travelBtn);
        questionBtn = rootView.findViewById(R.id.questionBtn);
        emergencyBtn = rootView.findViewById(R.id.emergencyBtn);
        Notecontainer = rootView.findViewById(R.id.todayNoteContainer);

        view = new TodayNoteItemView(getContext());
        view.setEnglish2("who");
        view.setMeaning2("누구?");
        Notecontainer.addView(view);

        view2 = new TodayNoteItemView(getContext());
        view2.setEnglish2("are you");
        view2.setMeaning2("너는?");
        Notecontainer.addView(view2);

        translateIn = AnimationUtils.loadAnimation(getContext(), R.anim.translate_in);
        translateOut = AnimationUtils.loadAnimation(getContext(), R.anim.translate_out);

        AnimThread thread = new AnimThread();
        thread.start();

        Button.OnClickListener onClickListener = new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.helloBtn:
                        Intent intent = new Intent(getContext(), Hello.class);
                        startActivity(intent);
                        break;
                    case R.id.travelBtn:
                        Intent intent1 = new Intent(getContext(), Travel.class);
                        startActivity(intent1);
                        break;
                    case R.id.questionBtn:
                        Intent intent2 = new Intent(getContext(), Question.class);
                        startActivity(intent2);
                        break;
                    case R.id.emergencyBtn:
                        Intent intent3 = new Intent(getContext(), Emergency.class);
                        startActivity(intent3);
                        break;
                }
            }
        };

        return rootView;
    }

    class AnimThread extends Thread {
        public void run(){
            running = true;
            while(running) {
                handler.post(new Runnable() {
                    public void run() {
                        if (selected == 0) {
                            view.startAnimation(translateIn);
                            view2.startAnimation(translateOut);
                        } else if (selected == 1) {
                            view.startAnimation(translateOut);
                            view2.startAnimation(translateIn);
                        }
                    }
                });

                selected += 1;
                if (selected > 1) {
                    selected = 0;
                }

                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                }
            }
        }
    }
}
