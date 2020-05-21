package org.jby.studyenglish;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

public class CalendarFragment extends Fragment {
    ViewPager pager;
    ContentsPagerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_calendar, container, false);

        TabLayout tabs = rootView.findViewById(R.id.tabs);

        pager = rootView.findViewById(R.id.pager2);
        tabs.setupWithViewPager(pager);
        ContentsPagerAdapter adapter = new ContentsPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new CalendarFragment1(), "나의일정");
        adapter.addFragment(new CalendarFragment2(), "공인영어시험일정");
        pager.setAdapter(adapter);

        return rootView;
    }
}
