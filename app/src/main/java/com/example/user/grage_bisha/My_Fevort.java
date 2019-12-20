package com.example.user.grage_bisha;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

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
import java.util.HashMap;
import java.util.List;

import android.widget.Toast;


import java.util.Map;

public class My_Fevort extends Activity {

    //this is the JSON Data URL
    //make sure you are using the correct ip else it will not work
 //   private static final String URL_PRODUCTS = "http://sultantec.com/files/api.php";

    //a list to store all the products
    private static final int MY_SOCKET_TIMEOUT_MS = 400000;
    List<ProductMain> productList;
    private ProgressDialog mProgressDialog;
    //the recyclerview
    RecyclerView recyclerView;

    ProgressBar Pbar;
    private Button etUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_fevort);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

  Button fab = (Button) findViewById(R.id.button13);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              regect2();

            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recylcerView2);


        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recylcerView2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setNestedScrollingEnabled(false);

        Pbar = (ProgressBar)findViewById(R.id.progressBar1);

        etUserName = (Button) findViewById(R.id.erorrp);
        etUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {
                loadProducts();
                etUserName.setVisibility(View.GONE);

            }
        });



        //initializing the productlist
        productList = new ArrayList<>();

        //this method will fetch and parse json
        //to display it in recyclerview
        loadProducts();
    }

    private void loadProducts() {

        /*
        * Creating a String Request
        * The request type is GET defined by first parameter
        * The URL is defined in the second parameter
        * Then we have a Response Listener and a Error Listener
        * In response listener we will get the JSON response as a String
        * */
        // recyclerView.setVisibility(View.GONE);
        Pbar.setVisibility(View.VISIBLE);
        etUserName.setVisibility(View.GONE);


//        String phone=getIntent().getStringExtra("phone");
//        String pass=getIntent().getStringExtra("pass");
//
        final String phone2=Login.mUsername;

        String URL_PRODUCTS = "http://sultantec.com/haraj_bishah/MyFavorites.php";


        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {




                            JSONObject jsonObject = new JSONObject(response);
                            //JSONArray array_1 = jsonObject.getJSONArray("locations");
                            JSONArray array_2 = jsonObject.getJSONArray("My_Favorites");
                            Log.d("a",array_2.toString());
                            //
                          //  JSONObject jo = array_2.getJSONObject(0);
                            //traversing through all the object
                            for (int i =array_2.length()-1 ; i >=0; i--) {

                                //getting product object from json array
                                JSONObject product = array_2.getJSONObject(i);

                                //adding the product to product list
                                productList.add(new ProductMain(
                                        product.getInt("product_id"),

                                        product.getString("product_title"),
                                        product.getString("product_description"),
                                        product.getString("user_id"),
                                        product.getString("product_date"),
                                        product.getString("product_main_image"),
                                        product.getString("product_image1"),
                                        product.getString("product_image2"),
                                        product.getString("product_image3"),
                                        product.getString("product_image4"),
                                        product.getString("product_image5")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview




                            ProductsAdapter2 adapter = new ProductsAdapter2(My_Fevort.this, productList);
                            recyclerView.setAdapter(adapter);

                            // recyclerView.setVisibility(View.VISIBLE);

                            Pbar.setVisibility(View.GONE);


                            //  etUserName.setVisibility(View.GONE);



                        } catch (JSONException e) {
                            e.printStackTrace();

                            Log.d("a",""+e);
                            //etUserName.setVisibility(View.GONE);

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("a",error.toString());
                        Pbar.setVisibility(View.GONE);
                        etUserName.setVisibility(View.VISIBLE);
                    }
                })

        {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("phone_number", phone2);
                Log.e("logfile",phone2) ;
                // params.put("domain", "http://itsalif.info");

                return params;
            }
        };

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
       // overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }










    private void regect2() {

        //String in =getIntent().getStringExtra("phone");;




        mProgressDialog = ProgressDialog.show(My_Fevort.this,
                "جاري ...","عملية التفريغ", false, false);




        //String url = "https://sultantec.com/bisha/del_fev.php?a="+in;
String url="http://sultantec.com/haraj_bishah/Delete_Favorite.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                //   Toast.makeText(mContext, " [runing " + s, Toast.LENGTH_SHORT).show();

                try {

                    JSONObject jsonObject = new JSONObject(s);
                    //JSONArray array_1 = jsonObject.getJSONArray("locations");
                    String query_result = jsonObject.getString("Status");


                    //   Toast.makeText(mContext, "Reponse : " + array_2, Toast.LENGTH_SHORT).show();
                    if (query_result.equals("Success")) {
                        mProgressDialog.dismiss();
                        Toast.makeText(My_Fevort.this, "تمت تفريغ المفضلة" , Toast.LENGTH_LONG).show();
onBackPressed();
                    } else if (!query_result.equals("Success")) {
                        mProgressDialog.dismiss();
                        Toast.makeText(My_Fevort.this, "لم تتم  تفريغ المفضلة" +query_result, Toast.LENGTH_LONG).show();
                    }


                } catch (JSONException e) {
                    //  rdr2.setVisibility(View.GONE);
                    mProgressDialog.dismiss();
                    Toast.makeText(My_Fevort.this, "لم تتم  تفريغ المفضلة"+e , Toast.LENGTH_LONG).show();
                    e.printStackTrace();

                }




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mProgressDialog.dismiss();
                Toast.makeText(My_Fevort.this, "لم تتم  تفريغ المفضلة"+volleyError , Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams()
            {
                final String phone23=Login.mUsername;
                Map<String, String>  params = new HashMap<String, String>();

                params.put("phone_number", phone23);
              //  params.put("product_id", ee);

                // params.put("domain", "http://itsalif.info");

                return params;
            }
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                MY_SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        Volley.newRequestQueue(My_Fevort.this).add(stringRequest);
    }



}
