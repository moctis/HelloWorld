package com.moctis.helloworld.app;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DescriptionFragment extends Fragment {

    String[] mCourseDescription;
    TextView mCourseDescriptionTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCourseDescription = getResources().getStringArray(R.array.course_titles);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_description, container, false);

        mCourseDescriptionTextView = (TextView) view.findViewById(R.id.courseDescription);

        return view;
    }

    void setCourse(int index) {
        mCourseDescriptionTextView.setText(mCourseDescription[index]);
    }

}
