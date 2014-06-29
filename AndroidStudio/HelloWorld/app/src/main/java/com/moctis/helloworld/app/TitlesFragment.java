package com.moctis.helloworld.app;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by moctis on 29/6/2557.
 * Copyright
 */
public class TitlesFragment extends ListFragment {
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] titles = getResources().getStringArray(R.array.course_titles);

        ArrayAdapter<String> titleAdaptor = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, titles);
        this.setListAdapter(titleAdaptor);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        OnCourseSelectionChangeListener listener = (OnCourseSelectionChangeListener) getActivity();
        listener.onCourseSelectionChange(position);
    }
}
