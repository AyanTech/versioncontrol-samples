package ir.ayantech.versioncontrolsamplekotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ir.ayantech.versioncontrol.VersionControlCore
import ir.ayantech.versioncontrol.model.ExtraInfoModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        TODO: (3) Initialize the module.
         */
        VersionControlCore(this).apply {

            setCategoryName("cafebazar") /* mandatory */

            setApplicationName("testcase1") /* optional */
            /*
            if you don't specify application name explicitly,
            it would be default to the name of your app.

            for example:

            if package name is "com.example.app_name"
            application name would be default to "app_name"
            */

            setExtraInfo(AppExtraInfo("x", "y")) /* optional */
            /*
            if you have to send ExtraInfo object
                1. create a class that extends ExtraInfoModel class.
                2. put anything you should send to server in it.
                3. call setExtraInfo() method in the builder.
            */

        }.checkForNewVersion()
    }
}

/* optional */
class AppExtraInfo(val option1: String, val option2: String) : ExtraInfoModel()