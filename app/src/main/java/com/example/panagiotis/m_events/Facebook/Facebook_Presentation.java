package com.example.panagiotis.m_events.Facebook;

import com.example.panagiotis.m_events.Realm_Models.Facebook_User_Details;
import com.facebook.Profile;

import io.realm.Realm;

/**
 * Created by Panagiotis on 23/12/2016.
 */

public class Facebook_Presentation implements IContract_Facebook.IPresenter_Facebook {
    private Realm realm;

    private IContract_Facebook.IView_Facebook iView_facebook;

    public Facebook_Presentation(IContract_Facebook.IView_Facebook iView_facebook) {
        this.iView_facebook=iView_facebook;
    }

    @Override
    public void getUserProfile() {
        final Profile profile = Profile.getCurrentProfile();

        realm = Realm.getDefaultInstance();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(Facebook_User_Details.class);
            }
        });

        realm.executeTransaction(new Realm.Transaction() {

            @Override
            public void execute(Realm realm) {
                // Add a person
                Facebook_User_Details facebook_user_details = realm.createObject(Facebook_User_Details.class);
                facebook_user_details.setName(profile.getFirstName());
                facebook_user_details.setLastName(profile.getLastName());
                facebook_user_details.setProfilePictureUrl(profile.getProfilePictureUri(600,600).toString());
            }
        });

        iView_facebook.displayProfile();
    }

    @Override
    public void start() {
        iView_facebook.setPresenter(this);
    }
}
