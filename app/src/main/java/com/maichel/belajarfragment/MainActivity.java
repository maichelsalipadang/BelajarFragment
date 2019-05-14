package com.maichel.belajarfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //untuk memanggil Fragment
        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction =  mFragmentManager.beginTransaction();
        MovieFragment mHomeFragment = new MovieFragment();

        Fragment fragment = mFragmentManager.findFragmentByTag(MovieFragment.class.getSimpleName());

        if(!(fragment instanceof MovieFragment)){
            mFragmentTransaction.add(R.id.frame_container,mHomeFragment,MovieFragment.class.getSimpleName());
            Log.d("MyFlexibleFragment","Fragment Name : "+MovieFragment.class.getSimpleName());
            mFragmentTransaction.commit();
        }
    }
}
