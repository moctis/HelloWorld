package com.moctis.helloworld.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {

    final static String EnableState = "Button_Enable";
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogHelper.LogCallback(this, "onCreate");

        initViews();

        if (savedInstanceState != null) {
            loadState(savedInstanceState);
        }

        onClickMenuWithResult();
    }

    private void loadState(Bundle savedInstanceState) {
        boolean enable = savedInstanceState.getBoolean(EnableState, false);
        findViewById(R.id.secondButton).setEnabled(enable);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public TextView getTextView() {
        if (mTextView == null) {
            mTextView = (TextView) findViewById(R.id.firstTopTextView);
        }
        return mTextView;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_show_activity2:
                return this.onClickMenuShowActivity2();
            case R.id.action_show_activity3:
                return this.onClickMenuShowActivity3();
            case R.id.action_with_result:
                return this.onClickMenuWithResult();
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

    private boolean onClickMenuWithResult() {
        Intent intent = new Intent(this, WithResultActivity.class);
        startActivity(intent);
        return true;
    }

    void initViews() {
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

    void handleButtonCLick() {
        getTextView().setText("Click 1");
        findViewById(R.id.secondButton).setEnabled(true);
    }

    void handleButton2CLick() {
        getTextView().setText("Click 2 !!");
    }

    private void handleButton3Click() {
        getTextView().setText("Button3");
    }


    //<editor-fold desc="lifecycle callbacks">
    @Override
    protected void onStart() {
        super.onStart();
        LogHelper.LogCallback(this, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogHelper.LogCallback(this, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogHelper.LogCallback(this, "onPause");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogHelper.LogCallback(this, "onSaveInstanceState");

        View viewById = this.findViewById(R.id.firstTopButton);

        outState.putBoolean(EnableState, viewById.isEnabled());
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogHelper.LogCallback(this, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogHelper.LogCallback(this, "onDestroy");
    }

    //</editor-fold>
}
