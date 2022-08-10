package shihab.mypro.com.gridviewex;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import shihab.mypro.com.gridviewex.googlematemodel.Constant;
import shihab.mypro.com.gridviewex.googlematemodel.Main_URL;
import shihab.mypro.com.gridviewex.googlematemodel.MapsActivity;
import shihab.mypro.com.gridviewex.googlematemodel.PlacesResponse;
import shihab.mypro.com.gridviewex.googlematemodel.Sub_URL;

import static com.nightonke.boommenu.ButtonEnum.TextOutsideCircle;

public class google_mate extends AppCompatActivity {

    BoomMenuButton bmb;

    ArrayList<Integer> icons;
    ArrayList<String> titles;

    RadioButton hp,ps,bk,at,ht,re;
    Double lat,lon;
    Sub_URL sub_url;
    List<PlacesResponse.Result> myResult;
    int Size;
    int flag;
    EditText et;
    String inputLocation;
    String place;


    List<Address> addresses;
    double latitude[];
    double longitude[];
    String[] Name;
    String[] poly;
    PlacesResponse body;
    Intent in;
    String markerInterest="all";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_google_mate);
        getSupportActionBar().hide();
        hp=(RadioButton) findViewById(R.id.hospital);
        ps=(RadioButton) findViewById(R.id.police);
        bk=(RadioButton) findViewById(R.id.bank);
        at=(RadioButton) findViewById(R.id.atm);
        ht=(RadioButton) findViewById(R.id.hotel);
        re=(RadioButton) findViewById(R.id.restaurant);

        LibraryInitializer();
        PlaceAutocompleteFragment autocompleteFragment;
        autocompleteFragment = (PlaceAutocompleteFragment) getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                inputLocation=place.getName().toString();
                // TODO: Get info about the selected place.
                //Log.i(TAG, "Place: " + place.getName());
            }

            @Override
            public void onError(Status status) {

            }

        });


        icons = new ArrayList<>();
        titles = new ArrayList<>();
        setInitialize();

        bmb = (BoomMenuButton) findViewById(R.id.bmbMenu);
        bmb.setButtonEnum(TextOutsideCircle);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_5_1);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_5_1);


        //set icon of boom menu
        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {

            int position = i;
            TextOutsideCircleButton.Builder builder = new TextOutsideCircleButton.Builder()
                    .normalImageRes(icons.get(position))
                    .normalText(titles.get(position))
                    .listener(new OnBMClickListener() {
                        @Override
                        public void onBoomButtonClick(int index) {

                            if(index==0){
                                Intent intent = new Intent(getApplicationContext(), UniversityCatagoryActivity.class);
                                startActivity(intent);


                            }
                            if(index==1){

                                Intent intent = new Intent(getApplicationContext(), eligibility.class);
                                startActivity(intent);

                            }
                            if(index==2){

                                Intent intent = new Intent(getApplicationContext(), preparation.class);
                                startActivity(intent);

                            }
                            if(index==3){

                                Intent intent = new Intent(getApplicationContext(), student_forum.class);
                                startActivity(intent);

                            }
                            if(index==4){

                                Intent intent = new Intent(getApplicationContext(), google_mate.class);
                                startActivity(intent);

                            }


                        }
                    });
            bmb.addBuilder(builder);
        }






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);

        setIcomInMenu(menu,R.id.menu_login,R.string.menu_item1,R.drawable.login);
        setIcomInMenu(menu,R.id.menu_share,R.string.menu_item2,R.drawable.share);
        setIcomInMenu(menu,R.id.menu_comment,R.string.menu_item3,R.drawable.comment);
        setIcomInMenu(menu,R.id.menu_exit,R.string.menu_item4,R.drawable.exit);

        return super.onCreateOptionsMenu(menu);


    }

    private void setInitialize() {

        icons.add(R.drawable.ic_all_university);
        icons.add(R.drawable.ic_eligibility);
        icons.add(R.drawable.ic_admission_preparation);
        icons.add(R.drawable.ic_forum);
        icons.add(R.drawable.ic_google_mate);
        icons.add(R.drawable.ic_forum);


        titles.add("University Catagory");
        titles.add("Eligibility");
        titles.add("Admission Preparetion");
        titles.add("Student Forum");
        titles.add("Googlr Mate");
        titles.add("About Us");

    }



    private void setIcomInMenu(Menu menu, int menuItemId, int labelId, int iconId){

        MenuItem item = menu.findItem(menuItemId);
        SpannableStringBuilder builder = new SpannableStringBuilder(" "+getResources().getString(labelId));
        builder.setSpan(new ImageSpan(this,iconId), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        item.setTitle(builder);
    }

    public void Hospital(View view) {
        hp.setChecked(true);
        ps.setChecked(false);
        bk.setChecked(false);
        at.setChecked(false);
        ht.setChecked(false);
        re.setChecked(false);
        flag=0;
    }

    public void Police(View view) {
        hp.setChecked(false);
        ps.setChecked(true);
        bk.setChecked(false);
        at.setChecked(false);
        ht.setChecked(false);
        re.setChecked(false);
        flag=1;
    }

    public void Bank(View view) {
        hp.setChecked(false);
        ps.setChecked(false);
        bk.setChecked(true);
        at.setChecked(false);
        ht.setChecked(false);
        re.setChecked(false);
        flag=2;
    }

    public void ATM(View view) {
        hp.setChecked(false);
        ps.setChecked(false);
        bk.setChecked(false);
        at.setChecked(true);
        ht.setChecked(false);
        re.setChecked(false);
        flag=3;
    }

    public void Hotel(View view) {
        hp.setChecked(false);
        ps.setChecked(false);
        bk.setChecked(false);
        at.setChecked(false);
        ht.setChecked(true);
        re.setChecked(false);
        flag=4;
    }
    public void Restaurant(View view) {
        hp.setChecked(false);
        ps.setChecked(false);
        bk.setChecked(false);
        at.setChecked(false);
        ht.setChecked(false);
        re.setChecked(true);
        flag=5;
    }

    public  void LibraryInitializer() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Main_URL.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        sub_url = retrofit.create(Sub_URL.class);
    }

    public void getMyLocationAddress() {


        // inputLocation= et.getText().toString();
        // Toast.makeText(getApplicationContext(),inputLocation, Toast.LENGTH_SHORT).show();
        Geocoder geocoder= new Geocoder(this, Locale.ENGLISH);



        try {

            //Place your latitude and longitude
            addresses = geocoder.getFromLocationName(inputLocation,1);

            if(addresses != null) {

                Address fetchedAddress = addresses.get(0);

                StringBuilder strAddress = new StringBuilder();

                for(int i=0; i<fetchedAddress.getMaxAddressLineIndex(); i++) {
                    strAddress.append(fetchedAddress.getAddressLine(i)).append("\n");
                }

                lat= addresses.get(0).getLatitude();
                lon= addresses.get(0).getLongitude();

            }

        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Could not get address..!", Toast.LENGTH_LONG).show();
        }

    }



    public void GetData(){


        switch(flag)
        {
            case 0:
                place="hospital";
                markerInterest = "hospital";

                break;
            case 1:
                place="police";
                markerInterest = "police";
                break;
            case 2:
                place="bank";
                markerInterest = "bank";
                break;
            case 3:
                place="atm";
                markerInterest = "atm";
                break;
            case 4:
                place="lodging";
                markerInterest = "hotel";
                break;
            case 5:
                place="restaurant";
                markerInterest = "restaurant";
                break;
            default:
                markerInterest = "all";
        }

//
        //  Toast.makeText(getApplicationContext(),lat.toString()+"\n"+lon.toString(), Toast.LENGTH_SHORT).show();
        //  Toast.makeText(getApplicationContext(),place, Toast.LENGTH_SHORT).show();

        String urls ="maps/api/place/nearbysearch/json?location="+lat+","+lon+"&radius=1500&type="+place+"&key=AIzaSyD37KOcvnZN74V5HCk0J-UKP9mOHHqHGis";
        Log.e("urls",urls);
        Call<PlacesResponse> MainResponseCall=sub_url.getPlaces(urls);


        MainResponseCall.enqueue(new Callback<PlacesResponse>() {
            @Override
            public void onResponse(Call<PlacesResponse> call, Response<PlacesResponse> response) {
                body = response.body();
                myResult=body.getResults();
                Size = myResult.size();
                latitude=new double[myResult.size()];
                longitude=new double[myResult.size()];
                Name=new String[myResult.size()];
                poly=new String[myResult.size()];


                in = new Intent(google_mate.this,MapsActivity.class);
                //     //Details
                for(int i=0;i<Size;i++)
                {
                    poly[i] = myResult.get(i).getVicinity().toString();
                    latitude[i]= myResult.get(i).getGeometry().getLocation().getLat();
                    longitude[i]= myResult.get(i).getGeometry().getLocation().getLng();
                    Name[i]=myResult.get(i).getName().toString();


                    // Toast.makeText(MainActivity.this,test1.toString(), Toast.LENGTH_SHORT).show();
                }
                Log.e("Size : ", latitude.length+"");
                in.putExtra(Constant.MARKER_INTEREST,markerInterest);
                in.putExtra(Constant.Lattitude,latitude);
                in.putExtra(Constant.Longitude,longitude);
                in.putExtra(Constant.Name,poly);
                in.putExtra(Constant.polygon,Name);
                in.putExtra(Constant.Main_Lat,lat);
                in.putExtra(Constant.Main_Lon,lon);

                //ArrayList<String> myList = (ArrayList<String>) getIntent().getSerializableExtra("mylist");

                //  in.putExtra(Constant.Longitude,myResult.get(i).getGeometry().getLocation().getLng());
                //  in.putExtra(Constant.Name,myResult.get(i).getName());
                startActivity(in);

                //  Log.e("urls", String.valueOf(myResult.get(0).getGeometry().getLocation().getLat()));


            }
            @Override
            public void onFailure(Call<PlacesResponse> call, Throwable t) {

            }
        });


    }


    @Override
    protected void onResume() {
        super.onResume();
//        getMyLocationAddress();
//        GetData();

    }

    public void Find(View view) {

        getMyLocationAddress();

        GetData();



    }
}

