package org.jby.studyenglish;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    ViewPager pager;
    ContentsPagerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);

        TabLayout tabs = rootView.findViewById(R.id.tabs);

        pager = rootView.findViewById(R.id.pager);
        tabs.setupWithViewPager(pager);
        ContentsPagerAdapter adapter = new ContentsPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new HomeFragment1(), "투데이");
        adapter.addFragment(new HomeFragment2(), "노트");
        pager.setAdapter(adapter);

        return rootView;
    }
}
