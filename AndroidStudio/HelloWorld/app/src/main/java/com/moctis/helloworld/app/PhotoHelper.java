package com.moctis.helloworld.app;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.ImageView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by moctis on 29/6/2557.
 * Copyright
 */
public class PhotoHelper {
    public static Uri generateTimeStampPhotoFileUri() {
        Uri photoFileUri = null;
        File outputDir = getPhotoDirectory();
        if (outputDir != null) {
            String timeStamp = new SimpleDateFormat("yyyMMDD_HHmmss").format(new Date());
            String photoFileName = "IMG_" + timeStamp + ".jpg";

            File file = new File(outputDir, photoFileName);
            photoFileUri = Uri.fromFile(file);
        }
        return photoFileUri;
    }

    private static File getPhotoDirectory() {
        File outputDir = null;

        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState.equals(Environment.MEDIA_MOUNTED)) {
            File pictureDir = Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_PICTURES);
            outputDir = new File(pictureDir, "Moctis");
            if (!outputDir.exists()) {
                if (!outputDir.mkdir()) {
                    LogHelper.d("Failed to create directory: %s", outputDir.getAbsolutePath());
                    outputDir = null;
                }
            }
        }

        return outputDir;
    }

    public static void addPhotoToMediaStoreAndDisplayThumbnail(String pathName, Activity activity,
                                                               final ImageView imageView) {
        final Activity thumbnailActivity = activity;
        String[] fileToScan = {pathName};
        //MediaScannerConnection.scanFile(thumbnailActivity, fileToScan, null,
        MediaScannerConnection.scanFile(activity, fileToScan, null, new MediaScannerConnection.OnScanCompletedListener() {
            @Override
            public void onScanCompleted(String path, Uri uri) {
                long id = ContentUris.parseId(uri);
                ContentResolver contentResolver = thumbnailActivity.getContentResolver();

                final Bitmap thumbnail = MediaStore.Images.Thumbnails.getThumbnail(contentResolver,
                        id, MediaStore.Images.Thumbnails.MINI_KIND, null);

                thumbnailActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(thumbnail);
                    }
                });
            }
        });
    }
}
