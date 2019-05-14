package com.maichel.belajarfragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailMovieFragment extends Fragment {
    public static String EXTRA_PERSON = "extra_person";
    private TextView detailFilm;
    private TextView detailJudul;
    private ImageView detailPhoto;
    View v;


    public DetailMovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_detail_movie, container, false);
        return v;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        detailFilm=view.findViewById(R.id.judul_detail);
        detailJudul=view.findViewById(R.id.film_detail);
        detailPhoto=view.findViewById(R.id.photo_detail);

        Person mPerson = getArguments().getParcelable(MovieFragment.EXTRA_PERSON);

        String textJudul=mPerson.getName();
        detailJudul.setText(textJudul);
        String textFilm = mPerson.getDetail();
        detailFilm.setText(textFilm);
        int imageResource = mPerson.getImageResource();
        detailPhoto.setImageResource(imageResource);

    }


}
