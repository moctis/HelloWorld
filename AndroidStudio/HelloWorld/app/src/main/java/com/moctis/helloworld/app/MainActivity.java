package com.moctis.helloworld.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_show_activity2:
                return this.onClickMenuShowActivity2();
            case R.id.action_show_activity3:
                return this.onClickMenuShowActivity3();
            case R.id.action_exit:
                return this.onClickMenuExit();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean onClickMenuShowActivity2() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
        return true;
    }

    public boolean onClickMenuShowActivity3() {
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
        return true;
    }

    public boolean onClickMenuExit() {
        finish();
        return true;
    }
}
