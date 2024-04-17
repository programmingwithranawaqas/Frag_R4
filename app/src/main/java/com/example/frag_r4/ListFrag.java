package com.example.frag_r4;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFrag extends ListFragment {

    NameClicked parent;

    public interface NameClicked
    {
        public void onNameClick(int index);
    }

    public ListFrag() {
        // Required empty public constructor
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        parent.onNameClick(position);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // context is a reference of parent activity of ListFrag
        parent = (NameClicked) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<String> names = new ArrayList<>();

        for(Contact c: MyApplication.contacts)
        {
            names.add(c.getName());
        }

        setListAdapter(new ArrayAdapter<String>(requireContext(),
                android.R.layout.simple_dropdown_item_1line, names));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }
}