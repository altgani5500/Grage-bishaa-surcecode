package com.example.user.grage_bisha;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ObbInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//
//import info.androidhive.materialtabs.R;
//import info.androidhive.materialtabs.fragments.OneFragment;
//import info.androidhive.materialtabs.fragments.ThreeFragment;
//import info.androidhive.materialtabs.fragments.TwoFragment;
//
//



public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    SharedPreferences settings ;
    FloatingActionButton fab2;
    private static final int MY_SOCKET_TIMEOUT_MS = 400000;
 String ph;
    Dialog  dialog;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.menuside,
            R.drawable.menuside,
            R.drawable.menuside
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ahome);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//
        settings = getSharedPreferences("BISC", 0);
        ph = settings.getString("go1", "44");


        //Toast.makeText(this, ph, Toast.LENGTH_SHORT).show();


        fab2 = (FloatingActionButton) findViewById(R.id.newadd);



//
        if(ph=="44"){

           // fab2.setVisibility(View.VISIBLE);
            fab2.setVisibility(View.GONE);
        }









        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.newadd2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();


                String new_add="newadd";
                Intent alvvwefrerxx = new Intent(Home.this, Login.class);

                alvvwefrerxx.putExtra("logs", new_add);

                startActivity(alvvwefrerxx);
            }
        });






     //

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();


              //  String new_add="newadd";
                Intent alvvwefrerxx = new Intent(Home.this, Noti.class);

               // alvvwefrerxx.putExtra("logs", new_add);

                startActivity(alvvwefrerxx);
            }
        });





//        Button  etUserName23 = (Button) findViewById(R.id.newadd);
//        etUserName23.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View vvv) {
//
//
//                String new_add="newadd";
//                Intent alvvwefrerxx = new Intent(Home.this, Login.class);
//
//                alvvwefrerxx.putExtra("logs", new_add);
//
//                startActivity(alvvwefrerxx);
//               // overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
//              //  finish();
//
//            }
//        });

        cheek_noti();

        Button  etUserName233 = (Button) findViewById(R.id.button15);
        etUserName233.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {

serch_p();

            }
        });




        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

   //  NavigationView .setHomeAsUpIndicator(R.drawable.ic_hamburg);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        setupTabIcons();




        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                // Message.long_message(mContext,tab.getPosition()+"");
                if (tab.getPosition() == 0) {



                           // Toast.makeText(Home.this, "one", Toast.LENGTH_SHORT).show();


                }
                if (tab.getPosition() == 1) {
                   // Toast.makeText(Home.this, "tow", Toast.LENGTH_SHORT).show();
                }
                if (tab.getPosition() == 2) {
                 //   Toast.makeText(Home.this, "there", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });}

    private void setupTabIcons() {

//        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
//        tabOne.setText("الكل");
//     //  tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.menuside, 0, 0);
//        tabLayout.getTabAt(0).setCustomView(tabOne);

//        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
//        tabTwo.setText("معرض الالبل");
//       //tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.menuside, 0, 0);
//        tabLayout.getTabAt(0).setCustomView(tabTwo);
//
//        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
//        tabThree.setText("مستلزمات");
//      //  tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.menuside, 0, 0);
//        tabLayout.getTabAt(1).setCustomView(tabThree);
//        TextView tabfour = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
//        tabfour.setText("ناقلات الالبل");
//       // tabfour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.menuside, 0, 0);
//        tabLayout.getTabAt(2).setCustomView(tabfour);
////
////
//        TextView tabfive = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
//        tabfive.setText("مفقودات");
//     //   tabfive.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.menuside, 0, 0);
//        tabLayout.getTabAt(3).setCustomView(tabfive);
////
////
//        TextView tabsex = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
//        tabsex.setText("اخري");
//        //   tabsex.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.menuside, 0, 0);
//        tabLayout.getTabAt(5).setCustomView(tabsex);





        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("الكل");
        //  tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.menuside, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("سيارات");
        //tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.menuside, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("اثاث منزلي");
        //  tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.menuside, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);


        TextView tabfour = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabfour.setText("عقارات");
        // tabfour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.menuside, 0, 0);
        tabLayout.getTabAt(3).setCustomView(tabfour);


        TextView tabfive = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabfive.setText("اجهزةوهواتف");
        //   tabfive.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.menuside, 0, 0);
        tabLayout.getTabAt(4).setCustomView(tabfive);


        TextView tabsex = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabsex.setText("اخري");
        //   tabsex.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.menuside, 0, 0);
        tabLayout.getTabAt(5).setCustomView(tabsex);


    }



    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Fragment_one(), "الكل");
        adapter.addFrag(new Fragment_tow(), "سيارات");
        adapter.addFrag(new Fragment_there(), "اثاث منزلي");
        adapter.addFrag(new Fragment_four(), "عقارات");
        adapter.addFrag(new Fragment_five(), "هواتف واجهزة");
        adapter.addFrag(new Fragment_sex(), "اخري");

        viewPager.setAdapter(adapter);
    }



    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }





















    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.home, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            String new_add="newadd";
            Intent alvvwefrerxx = new Intent(Home.this, Login.class);

            alvvwefrerxx.putExtra("logs", new_add);
            startActivity(alvvwefrerxx);
            // overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
            //  finish();
        } else if (id == R.id.nav_gallery) {
            Intent alvvwefrerxx = new Intent(Home.this, Register.class);
            startActivity(alvvwefrerxx);
            // overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
            //  finish();

        } else if (id == R.id.nav_slideshow) {
            String new_add="adv";
            Intent alvvwefrerxx = new Intent(Home.this, Login.class);

            alvvwefrerxx.putExtra("logs", new_add);

            startActivity(alvvwefrerxx);
            // overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
            //  finish();

        } else if (id == R.id.nav_manage) {
            String new_add="fev";
            Intent alvvwefrerxx = new Intent(Home.this, Login.class);

            alvvwefrerxx.putExtra("logs", new_add);

            startActivity(alvvwefrerxx);
            // overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
            //  finish();

        } else if (id == R.id.nav_share) {

            app();

        } else if (id == R.id.nav_send) {
co();
        }else if (id == R.id.nav_send2) {
            callme();
        }
        else if (id == R.id.nav_manage2) {
            buclickd2();
        }
        else if (id == R.id.nav_bank) {
      bank();
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    public void app() {

        final Dialog dialog = new Dialog(Home.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_aoutapp);
        // dialog.setTitle("خروج من التطبيق");
        // set the custom dialog components - text, image and button
        //  ImageView image = (ImageView) dialog.findViewById(R.id.image);
        //  image.setImageResource(R.drawable.ic_launcher);

        Button dialogButtonc = (Button) dialog.findViewById(R.id.app);
        // if button is clicked, close the custom dialog
        dialogButtonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();


    }





    public void callme() {

        final Dialog dialog = new Dialog(Home.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_callme);
        // dialog.setTitle("خروج من التطبيق");
        // set the custom dialog components - text, image and button
        //  ImageView image = (ImageView) dialog.findViewById(R.id.image);
        //  image.setImageResource(R.drawable.ic_launcher);

        Button dialogButtonc = (Button) dialog.findViewById(R.id.app);
        // if button is clicked, close the custom dialog
        dialogButtonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();


                try {


                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + "0507772800"));
                    callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(callIntent);
                } catch (ActivityNotFoundException activityException) {
                    Log.e("Calling a Phone Number", "Call failed", activityException);
                }
            }
        });
        dialog.show();


    }


    public void co() {

        final Dialog dialog = new Dialog(Home.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_aoutcom);
        // dialog.setTitle("خروج من التطبيق");
        // set the custom dialog components - text, image and button
        //  ImageView image = (ImageView) dialog.findViewById(R.id.image);
        //  image.setImageResource(R.drawable.ic_launcher);

        Button dialogButtonc = (Button) dialog.findViewById(R.id.app);
        // if button is clicked, close the custom dialog
        dialogButtonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();


    }






    public void bank() {

        final Dialog dialog = new Dialog(Home.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_bank);
        // dialog.setTitle("خروج من التطبيق");
        // set the custom dialog components - text, image and button
        //  ImageView image = (ImageView) dialog.findViewById(R.id.image);
        //  image.setImageResource(R.drawable.ic_launcher);

        Button dialogButtonc = (Button) dialog.findViewById(R.id.app);
        // if button is clicked, close the custom dialog
        dialogButtonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();


    }















    public void buclickd2() {
 final EditText g;

        final TextView t;
        dialog = new Dialog(Home.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_price);
        // dialog.setTitle("خروج من التطبيق");
        // set the custom dialog components - text, image and button
        //  ImageView image = (ImageView) dialog.findViewById(R.id.image);
        //  image.setImageResource(R.drawable.ic_launcher);
        g= (EditText) dialog.findViewById(R.id.editText12);
        t= (TextView) dialog.findViewById(R.id.textView13);

        Button dialogButtonc = (Button) dialog.findViewById(R.id.app);
        // if button is clicked, close the custom dialog
        dialogButtonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


              String  name22 = g.getText().toString();



                if (TextUtils.isEmpty(name22))
                {
                    g.setError("ادخل سعر السلعة");
                    return;
                }else {
                    int a= Integer.parseInt(name22);

                    int r= (a*1)/100 ;
                    t.setText(" النسبة المستحقه هي : " + r + "ريال");
                }
            }
        });

        dialog.show();


    }

    public void serch_p() {
        final EditText g,f;
       final Spinner s;
        final TextView t;
        dialog = new Dialog(Home.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_serch);
        // dialog.setTitle("خروج من التطبيق");
        // set the custom dialog components - text, image and button
        //  ImageView image = (ImageView) dialog.findViewById(R.id.image);
        //  image.setImageResource(R.drawable.ic_launcher);


        s= (Spinner) dialog.findViewById(R.id.editText8);
        g= (EditText) dialog.findViewById(R.id.editText12);

          t=(TextView) dialog.findViewById(R.id.textView18);

        Button dialogButtonc = (Button) dialog.findViewById(R.id.app);
        // if button is clicked, close the custom dialog
        dialogButtonc.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


                String  name22 = s.getSelectedItem().toString();
                String  name223 = g.getText().toString();

                if (name22.equals("اختر فئة الاعلان") ||name22=="اختر فئة الاعلان" )
                {
                    t.setText("الرجاء اختر فيئة الاعلان");
                    return;
                }else if (TextUtils.isEmpty(name223))
                {
                    g.setError("ادخل اسم السلعة");
                    return;
                }
                else
                {

                    if(name22.equals("سيارات")){

                        name22="1";

                        Intent alvvwefrerxx = new Intent(Home.this, Serch.class);
                        alvvwefrerxx.putExtra("class_p", name22);
                        alvvwefrerxx.putExtra("key_p", name223);
                        startActivity(alvvwefrerxx);
                    }else if(name22.equals("اثاث منزلي")){

                        name22="2";

                        Intent alvvwefrerxx = new Intent(Home.this, Serch.class);
                        alvvwefrerxx.putExtra("class_p", name22);
                        alvvwefrerxx.putExtra("key_p", name223);
                        startActivity(alvvwefrerxx);
                    }else if(name22.equals("عقارات")){

                        name22="3";

                        Intent alvvwefrerxx = new Intent(Home.this, Serch.class);
                        alvvwefrerxx.putExtra("class_p", name22);
                        alvvwefrerxx.putExtra("key_p", name223);
                        startActivity(alvvwefrerxx);
                    }
                    else if(name22.equals("اجهزة وهواتف")){

                        name22="4";

                        Intent alvvwefrerxx = new Intent(Home.this, Serch.class);
                        alvvwefrerxx.putExtra("class_p", name22);
                        alvvwefrerxx.putExtra("key_p", name223);
                        startActivity(alvvwefrerxx);
                    }
                    else if(name22.equals("اغراض اخري")){

                        name22="5";

                        Intent alvvwefrerxx = new Intent(Home.this, Serch.class);
                        alvvwefrerxx.putExtra("class_p", name22);
                        alvvwefrerxx.putExtra("key_p", name223);
                        startActivity(alvvwefrerxx);
                    }





                }


            }

        });

        dialog.show();


    }
























    private void cheek_noti() {

        //  String in =getIntent().getStringExtra("phone");;

        final String phone2=Login.mUsername;

//        mProgressDialog = ProgressDialog.show(Show_adv.this,
//                "جاري ...","عملية التفريغ", false, false);


        //  String url = "https://sultantec.com/bisha/del_fev.php?a="+in;
        String url = "http://sultantec.com/haraj_bishah/New_Notification.php";
      //  http://sultantec.com/haraj_bishah/All_Product.php

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                //   Toast.makeText(mContext, " [runing " + s, Toast.LENGTH_SHORT).show();

                try {

                    JSONObject jsonObject = new JSONObject(s);
                    //JSONArray array_1 = jsonObject.getJSONArray("locations");
                   // String query_result = jsonObject.getString("New");
                   // String query_result2 = jsonObject.getString("Status");

                    JSONArray array_2 = jsonObject.getJSONArray("New");

                    //
                    JSONObject jo = array_2.getJSONObject(0);

                  String query_result2 = jo.getString("status");

//                    JSONArray array_1 = jsonObject.getJSONArray(0);
//


                   // JSONObject jo = array_2.getJSONObject(0);
                   // Toast.makeText(Home.this, query_result+"...."+query_result2 , Toast.LENGTH_LONG).show();

Log.e("",jo+"============");

                //   Toast.makeText(Home.this, "Reponse : " + query_result2, Toast.LENGTH_SHORT).show();
                    if (query_result2.equals("1")) {
                        //    mProgressDialog.dismiss();

                        //  onBackPressed();
//                        wwww21.setBackgroundResource(R.drawable.ic_favorite_black_24dp2);
//                        wwww21.setEnabled(false);
                       // fab2.setBackgroundResource(R.drawable.new_not);
                        fab2.setImageResource(R.drawable.new_not);
                        noti_comment();
                       // fab2.setVisibility(View.VISIBLE);
                    } else if (!query_result2.equals("1")) {

                        //  mProgressDialog.dismiss();
                        // Toast.makeText(Show_adv.this, "لم تقم بالاضافة الى المفضلة" +query_result, Toast.LENGTH_LONG).show();
               //         fab2.setBackgroundResource(R.drawable.new_not);

                    }


                } catch (JSONException e) {
                    //  rdr2.setVisibility(View.GONE);
                    // mProgressDialog.dismiss();
                 //   Toast.makeText(Home.this, "yyyyyyy"+e , Toast.LENGTH_LONG).show();
                    e.printStackTrace();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                //  mProgressDialog.dismiss();
                Toast.makeText(Home.this, "vooly"+volleyError , Toast.LENGTH_LONG).show();
            }
        })   {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();



                params.put("phone_number",ph);
               // params.put("product_id", ee);

                // params.put("domain", "http://itsalif.info");

                return params;
            }
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                MY_SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        Volley.newRequestQueue(Home.this).add(stringRequest);
    }




    public void noti_comment() {

        final Dialog dialog = new Dialog(Home.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_newcomment);
        // dialog.setTitle("خروج من التطبيق");
        // set the custom dialog components - text, image and button
        //  ImageView image = (ImageView) dialog.findViewById(R.id.image);
        //  image.setImageResource(R.drawable.ic_launcher);

        Button dialogButtonc = (Button) dialog.findViewById(R.id.app);
        // if button is clicked, close the custom dialog
        dialogButtonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();


    }

    @Override
    protected void onResume() {
        super.onResume();


        ph = settings.getString("go1", "44");

       // Toast.makeText(this, ph, Toast.LENGTH_SHORT).show();
        if(ph!="44"){
            if(fab2.getVisibility()==View.GONE){

                fab2.setVisibility(View.VISIBLE);
                cheek_noti();
            }

        }


    }
}



