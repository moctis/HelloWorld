package com.moctis.helloworld.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUiEvents();
        Test();
    }

    private void Test() {

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

    void setupUiEvents() {
        findViewById(R.id.firstTopButton)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        handleButtonCLick();
                    }
                });

        findViewById(R.id.secondButton)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        handleButton2CLick();
                    }
                });

        findViewById(R.id.aNewButton)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        handleButton3Click();
                    }
                });
    }

    private void handleButton3Click() {
        TextView view = (TextView) findViewById(R.id.firstTopTextView);
        view.setText("Button3");
    }

    void handleButtonCLick() {
        TextView view = (TextView) findViewById(R.id.firstTopTextView);
        view.setText("Click 1");
    }

    void handleButton2CLick() {
        TextView view = (TextView) findViewById(R.id.firstTopTextView);
        view.setText("Click 2 !!");
    }

}
