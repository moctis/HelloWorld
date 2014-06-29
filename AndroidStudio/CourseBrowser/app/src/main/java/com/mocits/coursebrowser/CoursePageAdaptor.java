package com.mocits.coursebrowser;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;

/**
 * Created by moctis on 29/6/2557.
 * Copyright
 */
public class CoursePageAdaptor extends FragmentPagerAdapter {
    String[] mCourseTitles;
    String[] mCourseTitleShorts;
    String[] mCourseDescriptions;

    public CoursePageAdaptor(FragmentManager fm, Context context) {
        super(fm);

        Resources resources = context.getResources();
        mCourseTitles = resources.getStringArray(R.array.course_titles);
        mCourseTitleShorts = resources.getStringArray(R.array.course_titles_short);
        mCourseDescriptions = resources.getStringArray(R.array.course_description);
    }


    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();

        bundle.putString(CourseFragment.BUNDLE_COURSE_TITLE, mCourseTitles[position]);
        bundle.putString(CourseFragment.BUNDLE_COURSE_DESCRIPTION, mCourseDescriptions[position]);
        bundle.putInt(CourseFragment.BUNDLE_TOP_CARD, translateTopCardIndex(position));

        CourseFragment courseFragment = new CourseFragment();
        courseFragment.setArguments(bundle);
        return courseFragment;
    }

    private int translateTopCardIndex(int position) {
        switch (position) {
            case 0:
                return R.drawable.images1;
            case 1:
                return R.drawable.images2;
            case 2:
                return R.drawable.images3;
            case 3:
                return R.drawable.images4;
        }
        return R.drawable.ic_launcher;
    }

    @Override
    public int getCount() {
        return mCourseTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mCourseTitleShorts[position];
    }
}
