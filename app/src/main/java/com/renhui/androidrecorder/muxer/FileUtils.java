package com.renhui.androidrecorder.muxer;

import android.os.Environment;

import java.io.File;
import java.io.IOException;

/**
 * Created by renhui on 2017/9/25.
 */

public class FileUtils {
    public static String T_FLASH_PATH = "/storage/sdcard1";

    public static boolean isTFlashCardExists() {
        boolean tfExistsFlag = new File(T_FLASH_PATH, "Android").exists();

        if (getStorageDirWhenInsertSdcard() != null && testNewFileDir()) {
            tfExistsFlag = true;
        }
        return tfExistsFlag;
    }


    public static File getStorageDirWhenInsertSdcard() {
        File dir;
        try {
            dir = new File(T_FLASH_PATH, getMainDirName());
        } catch (Exception e) {
            return null;
        }

        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }

    private static boolean testNewFileDir() {
        File testFile = new File(T_FLASH_PATH, "testNewFile");
        boolean returnFlag = false;
        if (!testFile.exists()) {
            try {
                if (testFile.createNewFile()) {
                    returnFlag = true;
                    testFile.delete();
                }
            } catch (IOException e) {
                returnFlag = false;
            }
        } else {
            testFile.delete();
            returnFlag = true;
        }
        return returnFlag;
    }

    public static String getMainDirName() {
        return "/dudu";
    }


    /**
     * 获取sdcard路径
     */
    public static String getExternalStorageDirectory() {
        return Environment.getExternalStorageDirectory().getPath();
    }
}
