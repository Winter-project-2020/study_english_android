package org.jby.studyenglish;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;

public class HomeFragment1 extends Fragment {
    FrameLayout container;
    Animation translateIn;
    Animation translateOut;

    boolean running = false;

    Handler handler = new Handler();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home1, container, false);

        container = rootView.findViewById(R.id.todayNoteContainer);

        translateIn = AnimationUtils.loadAnimation(getContext(), R.anim.translate_in);
        translateOut = AnimationUtils.loadAnimation(getContext(), R.anim.translate_out);

        AnimThread thread = new AnimThread();
        thread.start();

        return rootView;
    }

    class AnimThread extends Thread {
        public void run(){
            running = true;
            while(running) {
                handler.post(new Runnable() {
                    public void run() {

                    }
                });

                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                }
            }
        }
    }
}
