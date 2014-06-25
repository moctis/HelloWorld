package com.moctis.helloworld.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class Activity3 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_showToast:
                return this.onClickMenuShowToast();
            case R.id.action_close:
                return this.onClickMenuExit();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    boolean onClickMenuShowToast() {
        Toast toast = Toast.makeText(this, getString(R.string.thisIsAToastText), Toast.LENGTH_LONG);
        toast.show();
        return true;
    }

    boolean onClickMenuExit() {
        finish();
        return true;
    }
}
