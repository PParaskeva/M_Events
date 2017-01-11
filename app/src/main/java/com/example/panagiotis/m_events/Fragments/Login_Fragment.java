package com.example.panagiotis.m_events.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.panagiotis.m_events.Facebook.Facebook_Presentation;
import com.example.panagiotis.m_events.Facebook.IContract_Facebook;
import com.example.panagiotis.m_events.MainActivity;
import com.example.panagiotis.m_events.R;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.common.base.Preconditions.checkNotNull;

public class Login_Fragment extends Fragment implements IContract_Facebook.IView_Facebook {

    private IContract_Facebook.IPresenter_Facebook iPresenter_facebook;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter_facebook=new Facebook_Presentation(this);
    }

    //LoginButton loginButton;
    //TextView statues;
    CallbackManager callbackManager;

    @BindView(R.id.login_button) LoginButton loginButton;
    @BindView(R.id.StatuesView) TextView statues;

    private AccessTokenTracker accessTokenTracker;
    private ProfileTracker profileTracker;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this,v);
//        loginButton=(LoginButton) v.findViewById(R.id.login_button);
//        statues=(TextView) v.findViewById(R.id.StatuesView);
        callbackManager=CallbackManager.Factory.create();
        loginButton.setFragment(this);

        loginButton.setReadPermissions(Arrays.asList(
                "public_profile", "email", "user_birthday", "user_friends"));

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                iPresenter_facebook.getUserProfile();

            }

            @Override
            public void onCancel() {

                statues.setText("The user canseled the Log in");
            }

            @Override
            public void onError(FacebookException error) {

            }
        });

        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldToken, AccessToken newToken) {
            }
        };

        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile newProfile) {
//                ((MainActivity)getActivity()).nextActivity(newProfile);
            }
        };
        accessTokenTracker.startTracking();
        profileTracker.startTracking();

        return v;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }


    @Override
    public void displayProfile() {
        ((MainActivity)getActivity()).nextActivity();
        Toast.makeText(getActivity(), "Logging in...", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onResume() {
        super.onResume();
        iPresenter_facebook.start();
    }

    @Override
    public void setPresenter(IContract_Facebook.IPresenter_Facebook presenter) {
        this.iPresenter_facebook=checkNotNull(presenter);
    }
}
