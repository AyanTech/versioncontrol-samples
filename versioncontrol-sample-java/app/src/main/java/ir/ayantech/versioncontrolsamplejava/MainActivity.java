package ir.ayantech.versioncontrolsamplejava;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ir.ayantech.versioncontrol.VersionControlCore;
import ir.ayantech.versioncontrol.model.ExtraInfoModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        TODO: (3) Initialize the module.
         */
        new VersionControlCore(this)

                .setCategoryName("cafebazar") /* mandatory */

                .setApplicationName("testcase1") /* optional */
                /*
                if you don't specify application name explicitly,
                it would be default to the name of your app.

                for example:

                if package name is "com.example.app_name"
                application name would be default to "app_name"
                */

                .setExtraInfo(new AppExtraInfo("x", "y")) /* optional */
                /*
                if you have to send ExtraInfo object
                    1. create a class that extends ExtraInfoModel class.
                    2. put anything you should send to server in it.
                    3. call setExtraInfo() method in the builder.
                */

                .checkForNewVersion();
    }
}

/* optional */
class AppExtraInfo extends ExtraInfoModel {
    private @NonNull String Option1;
    private @NonNull String Option2;

    public AppExtraInfo(@NonNull String option1, @NonNull String option2) {
        Option1 = option1;
        Option2 = option2;
    }

    public @NonNull String getOption1() {
        return Option1;
    }

    public @NonNull String getOption2() {
        return Option2;
    }
}