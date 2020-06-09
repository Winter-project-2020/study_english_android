package org.jby.studyenglish;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment2 extends Fragment {
    RecyclerView recyclerView;
    NoteAdapter adapter;

    HomeFragment1 fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home2, container, false);

        recyclerView = rootView.findViewById(R.id.noteRecyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new NoteAdapter();

        adapter.addItem(new Note("English", "영어"));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(NoteAdapter.ViewHolder holder, View view, int position) {
                Note item = (Note) adapter.getItem(position);
                Toast.makeText(getContext(), item.getMeaning(), Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
}
