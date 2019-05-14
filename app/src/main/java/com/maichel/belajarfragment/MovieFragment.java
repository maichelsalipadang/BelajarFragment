package com.maichel.belajarfragment;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment implements ListHeroAdapter.OnItemClickListener {
    private RecyclerView rvCategory;
    private ArrayList<Hero> list = new ArrayList<>();
    private static String[] dataName;
    private static String[] dataDescription;
    private static TypedArray dataPhoto;
    View v;
    public static String EXTRA_PERSON = "extra_person";


    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_movie, container, false);

        //balada onclick recyler-fragment
        /*Bundle bundle=getArguments();
        if(bundle!=null){
            Person mPerson=bundle.getParcelable("key");
            mPerson.setName(dataName[i]);
            mPerson.setDetail(dataDescription[i]);
            mPerson.setPhoto(dataPhoto.getResourceId(i, -1));


        }*/

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        //memilih rv_category sebagai id untuk rvCategory
        rvCategory = view.findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        dataName=getResources().getStringArray(R.array.data_name);
        dataDescription=getResources().getStringArray(R.array.data_description);
        dataPhoto=getResources().obtainTypedArray(R.array.data_photo);

        //membuat loop untuk memanggil item dari dataname
        for (int i = 0; i < dataName.length;i++){
            Hero hero = new Hero();
            hero.setPhoto(dataPhoto.getResourceId(i,-1));
            hero.setName(dataName[i]);
            hero.setFrom(dataDescription[i]);
            list.add(hero);
        }
        showRecyclerList();



    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        ListHeroAdapter listHeroAdapter = new ListHeroAdapter(getContext());
        listHeroAdapter.setListHero(list);
        rvCategory.setAdapter(listHeroAdapter);

        //implementasi onClick
        listHeroAdapter.setOnItemClickListener(MovieFragment.this);


    }

    //menjelaskan apa yang terjadi saat dilakukan onitemclick (yaitu mengirim data lewat parceable Person
    @Override
    public void onItemClick(int position) {
        Person mPerson = new Person();
        mPerson.setName(dataName[position]);
        mPerson.setDetail(dataDescription[position]);
        mPerson.setPhoto(dataPhoto.getResourceId(position, -1));

        DetailMovieFragment mDetailMovieFragment = new DetailMovieFragment();

        Bundle bundle = new Bundle();
        bundle.putParcelable(EXTRA_PERSON, mPerson);

        getActivity().getSupportFragmentManager();

        DetailMovieFragment fragment = new DetailMovieFragment();
        fragment.setArguments(bundle);

        FragmentManager mFragmentManager = getFragmentManager();
        if (mFragmentManager != null) {
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.frame_container, mDetailMovieFragment, DetailMovieFragment.class.getSimpleName());
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        }
    }

    /*@Override
    public void onItemClick(int position) {
        Person mPerson = new Person();
        mPerson.setName(dataName[position]);
        mPerson.setDetail(dataDescription[position]);
        mPerson.setPhoto(dataPhoto.getResourceId(position, -1));

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener(){
            @Override
            public void onItemClicked(RecyclerView recyclerView,int position, View v) {
                Person mPerson = new Person();
                mPerson.setName(dataName[position]);
                mPerson.setDetail(dataDescription[position]);
                mPerson.setPhoto(dataPhoto.getResourceId(position, -1));

                DetailMovieFragment mDetailMovieFragment = new DetailMovieFragment();

                Bundle bundle = new Bundle();
                bundle.putParcelable(EXTRA_PERSON, mPerson);

                getActivity().getSupportFragmentManager();

                DetailMovieFragment fragment = new DetailMovieFragment();
                fragment.setArguments(bundle);

                FragmentManager mFragmentManager = getFragmentManager();
                if (mFragmentManager != null) {
                    FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.frame_container, mDetailMovieFragment, DetailMovieFragment.class.getSimpleName());
                    mFragmentTransaction.addToBackStack(null);
                    mFragmentTransaction.commit();
                }

            }
        });*/



        //Toast.makeText(MovieFragment.this, "Coba beng" + position,Toast.LENGTH_SHORT).show();
        //Toast.makeText(Cone)

        //balada intent recycler 1
        /*Intent moveWithDescription = new Intent(getContext()MovieFragment.this,DetailMovieFragment.class);
        moveWithDescription.putExtra(DetailMovieFragment.EXTRA_PERSON,mPerson);
        startActivity(moveWithDescription);

        Person mBundle = new Bundle();
        mBundle = mPerson;

        DetailMovieFragment mDetailMovieFragment = new DetailMovieFragment();
        mDetailMovieFragment.setArguments(Person);*/





}
