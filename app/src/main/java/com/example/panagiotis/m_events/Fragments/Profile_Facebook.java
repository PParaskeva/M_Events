package com.example.panagiotis.m_events.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.panagiotis.m_events.R;
import com.example.panagiotis.m_events.Realm_Models.Facebook_User_Details;
import com.example.panagiotis.m_events.Realm_Models.LastFM_models.FavorityTags_Realm;
import com.example.panagiotis.m_events.Realm_Models.location_Realm;
import com.example.panagiotis.m_events.adapters.FavorityTags_adaptor;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;

public class Profile_Facebook extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @BindView(R.id.FacebookProfileNmae) TextView name;
    @BindView(R.id.FacebookProfileLastName) TextView lastName;
    @BindView(R.id.FacebookProfileImageView) ImageView profile_picture;
    @BindView(R.id.FacebookProfileLocation) TextView location;
    @BindView(R.id.FacebookProfileRecycleView) RecyclerView facebookRecycleViewTags;

    private FavorityTags_adaptor adaptor;

    private Realm realm;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_profile__facebook, container, false);
        ButterKnife.bind(this,v);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        int width = displaymetrics.widthPixels;
        realm = Realm.getDefaultInstance();

        for (Facebook_User_Details facebook_user_details : realm.where(Facebook_User_Details.class).findAll()) {
            name.setText("Name :"+facebook_user_details.getName());
            lastName.setText(facebook_user_details.getLastName());

            Picasso.with(getActivity().getApplicationContext())
                    .load(facebook_user_details.getProfilePictureUrl())
                    .fit()
                    .centerCrop()
                    .into(profile_picture);

        }
        RealmResults<location_Realm> resultsLocation = realm.where(location_Realm.class).findAll();

        location.setText("Location :"+resultsLocation.get(0).getCountry());
        displayTags(realm);
        return v;
    }

    private void displayTags(Realm realm){

        RealmResults<FavorityTags_Realm> resultsTags = realm.where(FavorityTags_Realm.class).findAll();
        facebookRecycleViewTags.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        facebookRecycleViewTags.setItemAnimator(new DefaultItemAnimator());
        adaptor=new FavorityTags_adaptor(resultsTags,getActivity(),R.layout.buttontags_row);
        facebookRecycleViewTags.setAdapter(adaptor);
    }

}
