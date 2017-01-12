package com.example.panagiotis.m_events;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.panagiotis.m_events.Fragments.FavorityArtists;
import com.example.panagiotis.m_events.Fragments.FavorityTracks;
import com.example.panagiotis.m_events.Fragments.Login_Fragment;
import com.example.panagiotis.m_events.Fragments.Profile_Facebook;
import com.example.panagiotis.m_events.Fragments.SearchResults;
import com.example.panagiotis.m_events.Fragments.top_artists;
import com.example.panagiotis.m_events.Fragments.top_tracks;
import com.example.panagiotis.m_events.Realm_Models.Facebook_User_Details;
import com.example.panagiotis.m_events.Realm_Models.LastFM_models.FavoriteArtists_Realm;
import com.example.panagiotis.m_events.Realm_Models.LastFM_models.FavotiteTracks_Realm;
import com.example.panagiotis.m_events.Realm_Models.LastFM_models.Temp_Realm;
import com.example.panagiotis.m_events.Realm_Models.location_Realm;
import com.facebook.AccessToken;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;


public class MainActivity extends AppCompatActivity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    private DrawerLayout drawerLayout;

    @BindView(R.id.navigation_view)NavigationView navigationView;
    @BindView(R.id.toolbar) Toolbar toolbar;
    //@BindView(R.id.Header_ImageView) ImageView headerImageView;
    ImageView headerImageView;

    private Realm realm;
    View header;

    //Variable for the location of the user
    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        buildGoogleApiClient();
        setSupportActionBar(toolbar);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                if(isLoggedIn()) {
                    if (menuItem.getItemId() == R.id.Profle) {
                        fragment_transfer(new Profile_Facebook());
                    }

                    if (menuItem.getItemId() == R.id.top_Artists) {
                        fragment_transfer(new top_artists());
                    }

                    if (menuItem.getItemId() == R.id.top_Songs) {
                        fragment_transfer(new top_tracks());
                    }

                    if (menuItem.getItemId() == R.id.FavorityMusic) {
                        fragment_transfer(new FavorityTracks());
                    }
                    if (menuItem.getItemId() == R.id.FavorityArtists) {
                        fragment_transfer(new FavorityArtists());
                    }
                }
                return true;
            }
        });

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        header = navigationView.getHeaderView(0);
        headerImageView=(ImageView) header.findViewById(R.id.Header_ImageView);

        if (isLoggedIn()) {
            realm = Realm.getDefaultInstance();
            RealmResults<Facebook_User_Details> results = realm.where(Facebook_User_Details.class).findAll();
            if(results.size()>0) {
                Picasso.with(getApplicationContext())
                        .load(results.get(0).getProfilePictureUrl())
                        .fit()
                        .centerCrop()
                        .into(headerImageView);
            }

            fragment_transfer(new Profile_Facebook());
        } else {
            fragment_transfer(new Login_Fragment());
        }

    }

    public void firstTimeLoggin() {
        realm = Realm.getDefaultInstance();
        RealmResults<Facebook_User_Details> results = realm.where(Facebook_User_Details.class).findAll();
        if (results.size() > 0) {
            Picasso.with(getApplicationContext())
                    .load(results.get(0).getProfilePictureUrl())
                    .fit()
                    .centerCrop()
                    .into(headerImageView);
        }
    }

    private synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    // Redirect the application to the appropriate fragment depending from the argument
    public void fragment_transfer(Fragment f) {
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment;
        fragment = f;
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

    public void fragment_transfer(Fragment f, String artists, String name, String imageURL) {
        Bundle args = new Bundle();
        args.putString("artists", artists);
        args.putString("name", name);
        args.putString("imageURL", imageURL);
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment;
        fragment = f;
        fragment.setArguments(args);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

    public void fragment_transfer(Fragment f, String id, String imageURL) {
        Bundle args = new Bundle();
        args.putString("ArtistID", id);
        args.putString("imageURL", imageURL);
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment;
        fragment = f;
        fragment.setArguments(args);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

    public void fragment_transfer(Fragment f, String artists) {
        Bundle args = new Bundle();
        args.putString("artists", artists);
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment;
        fragment = f;
        fragment.setArguments(args);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

    //This method returns true if the user is already login or false if it is not.
    public boolean isLoggedIn() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        return accessToken != null;
    }

    //This method is called from the fragments to move to the profile fragment
    public void nextActivity() {
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment;
        fragment = new Profile_Facebook();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        final MenuItem myActionMenuItem = menu.findItem( R.id.action_search);
        final SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(isLoggedIn()) {
                    fragment_transfer(new SearchResults(), query);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Please login", Toast.LENGTH_SHORT).show();
                }

                if( ! searchView.isIconified()) {
                    searchView.setIconified(true);
                }
                myActionMenuItem.collapseActionView();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (isLoggedIn()) {


        if (item.getItemId() == R.id.eventsNearMe) {
            Class activityClass = ClusterActivity.class;
            startActivity(new Intent(this, activityClass));
            return true;
        }

        if (item.getItemId() == R.id.addToFavotite) {
            realm = Realm.getDefaultInstance();
            final RealmResults<Temp_Realm> temp_realms =
                    realm.where(Temp_Realm.class).findAll();

            if (temp_realms.size() != 0) {
                final RealmResults<FavoriteArtists_Realm> resultsFavorityArtist = realm.where(FavoriteArtists_Realm.class).equalTo("ArtistID", temp_realms.get(0).getTempID()).findAll();
                final RealmResults<FavotiteTracks_Realm> resultsFavorityTracks = realm.where(FavotiteTracks_Realm.class)
                        .equalTo("TrackName", temp_realms.get(0).getTempName())
                        .equalTo("TrackID", temp_realms.get(0).getTempArtisName())
                        .findAll();


                if (temp_realms.get(0).isCheck()) {
                    if (resultsFavorityArtist.size() == 0) {
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                // Add a person
                                FavoriteArtists_Realm favoriteArtists_realm = realm.createObject(FavoriteArtists_Realm.class);
                                favoriteArtists_realm.setArtistName(temp_realms.get(0).getTempName());
                                favoriteArtists_realm.setArtistID(temp_realms.get(0).getTempID());
                                favoriteArtists_realm.setArtistImage(temp_realms.get(0).getTempImage());
                            }
                        });
                        Toast.makeText(getApplicationContext(), "The Artist " + temp_realms.get(0).getTempName() + " is added to Favorites", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (resultsFavorityTracks.size() == 0) {
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                // Add a person
                                FavotiteTracks_Realm favotiteTracks_realm = realm.createObject(FavotiteTracks_Realm.class);
                                favotiteTracks_realm.setTrackName(temp_realms.get(0).getTempName());
                                favotiteTracks_realm.setTrackID(temp_realms.get(0).getTempArtisName());
                                favotiteTracks_realm.setTrackImage(temp_realms.get(0).getTempImage());
                            }
                        });
                        Toast.makeText(getApplicationContext(), "The Track " + temp_realms.get(0).getTempName() + " is added to Favorites", Toast.LENGTH_SHORT).show();
                    }
                }
            }


            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.delete(Temp_Realm.class);
                }
            });
        }
    }
        else {
            Toast.makeText(getApplicationContext(),"Please login", Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        Geocoder geocoder;
        List<Address> addresses;
        geocoder = new Geocoder(this, Locale.getDefault());
        String country="";
        try {
            addresses = geocoder.getFromLocation(mLastLocation.getLatitude(), mLastLocation.getLongitude(), 1);
            country=addresses.get(0).getCountryName();
        } catch (IOException e) {
            e.printStackTrace();
        }

        realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(location_Realm.class);
            }
        });
        final String finalCountry = country;
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                location_Realm locationRealm = realm.createObject(location_Realm.class);
                locationRealm.setLat(mLastLocation.getLatitude());
                locationRealm.setLot(mLastLocation.getLongitude());
                locationRealm.setCountry(finalCountry);
            }
        });


    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
