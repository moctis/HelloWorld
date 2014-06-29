package com.moctis.helloworld.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class WithResultActivity extends ActionBarActivity {

    //<editor-fold desc="field">
    public static final int ACTION_PROVIDE_INFO = 1000;
    public static final int ACTION_TAKE_PHOTO = 1001;
    String className;
    String person;
    String email;
    private TextView classNameTextView;
    private TextView personNameTextView;
    private TextView emailTextView;
    private ImageView thumbNailImageView;
    private Uri photoFileUri;
    //</editor-fold>

    //<editor-fold desc="getter/setter">
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
        classNameTextView.setText(className);
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
        personNameTextView.setText(person);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        emailTextView.setText(email);
    }
    //</editor-fold>

    //<editor-fold desc="@Override on...">
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_result);
        setupView(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.with_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        LogHelper.d("onActivityResult requestCode:%d resultCode: %d", requestCode, resultCode);

        switch (requestCode) {
            case ACTION_PROVIDE_INFO:
                handleProvideInfoResult(resultCode, data);
                break;
            case ACTION_TAKE_PHOTO:
                handleTakePhoto(resultCode);
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(Activity3.EXTRA_CLASS_NAME, getClassName());
        outState.putString(Activity3.EXTRA_PERSON_NAME, getPerson());
        outState.putString(Activity3.EXTRA_EMAIL_EXTRA, getEmail());
    }

    //</editor-fold>

    private void setupView(Bundle state) {
        findViewById(R.id.infoButton)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        infoButtonOnClick();
                    }
                });
        findViewById(R.id.takePictureButton)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        takePictureOnClick();
                    }
                });
        findViewById(R.id.sendButton)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sendOnClick();
                    }
                });

        classNameTextView = (TextView) findViewById(R.id.classNameTextView);
        personNameTextView = (TextView) findViewById(R.id.personNameTextView);
        emailTextView = (TextView) findViewById(R.id.emailTextView);
        thumbNailImageView = (ImageView) findViewById(R.id.thumbNailImageView);

        if (state != null) {
            setClassName(state.getString(Activity3.EXTRA_CLASS_NAME));
            setPerson(state.getString(Activity3.EXTRA_PERSON_NAME));
            setEmail(state.getString(Activity3.EXTRA_EMAIL_EXTRA));
        }
    }

    private void infoButtonOnClick() {
        Intent intent = new Intent(this, Activity3.class);
        startActivityForResult(intent, ACTION_PROVIDE_INFO);
    }

    private void takePictureOnClick() {
        photoFileUri = PhotoHelper.generateTimeStampPhotoFileUri();

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoFileUri);
        startActivityForResult(intent, ACTION_TAKE_PHOTO);
    }

    private void handleProvideInfoResult(int resultCode, Intent data) {
        LogHelper.d("resultCode: %d", resultCode);

        if (!correctResult(resultCode, "User Canceled")) return;

        setClassName(data.getStringExtra(Activity3.EXTRA_CLASS_NAME));
        setPerson(data.getStringExtra(Activity3.EXTRA_PERSON_NAME));
        setEmail(data.getStringExtra(Activity3.EXTRA_EMAIL_EXTRA));
    }

    private void handleTakePhoto(int resultCode) {
        if (!correctResult(resultCode, "User Canceled")) {
            photoFileUri = null;
            return;
        }

        String path = photoFileUri.getPath();
        PhotoHelper.addPhotoToMediaStoreAndDisplayThumbnail(path, this, thumbNailImageView);
        thumbNailImageView.setImageURI(photoFileUri);
    }

    private boolean correctResult(int resultCode, String text) {
        if (resultCode == RESULT_OK) {
            return true;
        }
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        return false;
    }

    private void sendOnClick() {
    }
}
