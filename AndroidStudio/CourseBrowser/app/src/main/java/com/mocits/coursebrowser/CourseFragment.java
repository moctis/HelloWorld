package com.mocits.coursebrowser;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by moctis on 29/6/2557.
 * Copyright
 */
public class CourseFragment extends Fragment {
    public final static String BUNDLE_COURSE_TITLE = "course title";
    public final static String BUNDLE_COURSE_DESCRIPTION = "course description";
    public final static String BUNDLE_TOP_CARD = "top card";
    public final static String BUNDLE_COURSE_TYPE_LOGO = "course type logo";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        Bundle arguments = getArguments();
        if (arguments != null) {
            String courseTitle = arguments.getString(BUNDLE_COURSE_TITLE);
            String courseDescription = arguments.getString(BUNDLE_COURSE_DESCRIPTION);
            int topCard = arguments.getInt(BUNDLE_TOP_CARD);
            int courseTypeLogo = arguments.getInt(BUNDLE_COURSE_TYPE_LOGO);

            displayValues(view, courseTitle, courseDescription, topCard, courseTypeLogo);
        }

        return view;
    }

    private void displayValues(View view, String courseTitle, String courseDescription, int topCard, int courseTypeLogo) {
        TextView courseTitleTextView = (TextView) view.findViewById(R.id.courseTitle);
        TextView courseDescriptionTextView = (TextView) view.findViewById(R.id.courseDescription);
        ImageView topCardImageView = (ImageView) view.findViewById(R.id.topCard);

        courseTitleTextView.setText(courseTitle);
        courseDescriptionTextView.setText(courseDescription);
        topCardImageView.setImageResource(topCard);
    }
}
