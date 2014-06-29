package com.moctis.helloworld.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class Activity3 extends ActionBarActivity {

    public static final String EXTRA_CLASS_NAME = "EXTRA_CLASS_NAME";
    public static final String EXTRA_PERSON_NAME = "EXTRA_PERSON_NAME";
    public static final String EXTRA_EMAIL_EXTRA = "EXTRA_EMAIL_EXTRA";

    private Button doneButton;
    private EditText personNameEditText;
    private EditText emailEditText;
    private RadioGroup classNameGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);
        setupViews();
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

    private void setupViews() {
        doneButton = (Button) findViewById(R.id.doneButton);
        personNameEditText = (EditText) findViewById(R.id.personNameEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        classNameGroup = (RadioGroup) findViewById(R.id.classNameGroup);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doneButtonClick();
            }
        });
    }

    private void doneButtonClick() {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_CLASS_NAME, getText(classNameGroup));
        intent.putExtra(EXTRA_PERSON_NAME, getText(personNameEditText));
        intent.putExtra(EXTRA_EMAIL_EXTRA, getText(emailEditText));
        setResult(RESULT_OK, intent);
        finish();
    }


    private String getText(TextView view) {
        return view.getText().toString();
    }

    private String getText(RadioGroup view) {
        int checkedRadioButtonId = view.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(checkedRadioButtonId);
        return radioButton.getText().toString();
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
