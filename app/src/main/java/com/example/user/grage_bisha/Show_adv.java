package com.example.user.grage_bisha;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.androidquery.util.AQUtility.getContext;

public class Show_adv extends Activity {
    String image1,image2,image3,image4,image5;
    ImageView image1s,image2s,image3s,image4s,image5s;
   //private Context mCtx;
    Dialog  dialog;
    //a list to store all the products
   // List<Product> productList;
    String ee;
    //the recyclerview
   // RecyclerView recyclerView;
    String c;
  //  final Context context = this;
   // ProgressBar Pbar;
   // private Button etUserName;
   Button wwww21;
String coment_body;

    SharedPreferences settings ;
    private static final int MY_SOCKET_TIMEOUT_MS = 400000;

    private ProgressDialog mProgressDialog;


    private Context mCtx2;
    String ph;
    //a list to store all the products
    List<ProductMain2> productList;

    //the recyclerview
    RecyclerView recyclerView;

    ProgressBar Pbar;
    private Button etUserName;
  //  SwipeRefreshLayout mSwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_adv);
        settings = getSharedPreferences("BISC", 0);
         ph = settings.getString("go1", "44");
        cheek_favorite();
      //  loadcomment();
        recyclerView = (RecyclerView)findViewById(R.id.recylcerView2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setVisibility(View.GONE);




        Pbar = (ProgressBar)findViewById(R.id.progressBar1);
        Pbar.setVisibility(View.GONE);
        etUserName = (Button)findViewById(R.id.erorrp);
        etUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {
                loadcomment();

            }
        });

//        loadProducts();

        //initializing the productlist
       // productList = new ArrayList<>();


        image1s =(ImageView)findViewById(R.id.imageView9);
        image2s =(ImageView)findViewById(R.id.imageView8);
        image3s =(ImageView)findViewById(R.id.imageView7);
        image4s =(ImageView)findViewById(R.id.imageView6);
        image5s =(ImageView)findViewById(R.id.imageView3);





       wwww21 =(Button)findViewById(R.id.button12);


        wwww21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vv) {
                Add_fav();
            }
        });


        Button wwww2 =(Button)findViewById(R.id.button11);
        wwww2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vv) {
         buclickd2();
            }
        });
        //getting the recyclerview from xml
       // recyclerView = (RecyclerView) findViewById(R.id.nonScrollListView);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//

        TextView  etUserName23 = (TextView) findViewById(R.id.textView20);
        etUserName23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {
callme();

            }
        });

     //   recyclerView.setNestedScrollingEnabled(false);
        String a = getIntent().getStringExtra("g1");//conent
        String b = getIntent().getStringExtra("g2");//image
        c = getIntent().getStringExtra("g3");//date
        String d = getIntent().getStringExtra("g4");//adress

        int e = getIntent().getIntExtra("g5",0);//adress
        String f = getIntent().getStringExtra("g6");//con

ee=Integer.toString(e);

      //Toast.makeText(Show_adv.this, c, Toast.LENGTH_SHORT).show();

        TextView aa =(TextView)findViewById(R.id.textView16);
        TextView bb =(TextView)findViewById(R.id.textView17);
        TextView cc =(TextView)findViewById(R.id.textView38);
        TextView dd =(TextView)findViewById(R.id.textView233);


          aa.setText(d);bb.setText(a);cc.setText(c);dd.setText(f);

        etUserName23.setText(c);
       image1= getIntent().getStringExtra("g7");
        image2= getIntent().getStringExtra("g8");
        image3= getIntent().getStringExtra("g9");
        image4= getIntent().getStringExtra("g10");
        image5= getIntent().getStringExtra("g11");


if(!image1.equals("nil")) {

    image1s.getLayoutParams().height=300;
   // image1s.getLayoutParams().width=200;

    Glide.with(Show_adv.this)
            .load(image1)
            .centerCrop()
            .into(image1s);

}

        if(!image2.equals("nil")) {
            image2s.getLayoutParams().height=300;
            Glide.with(Show_adv.this)
                    .load(image2)
                    .centerCrop()
                    .into(image2s);
        }

        if(!image3.equals("nil")) {
            image3s.getLayoutParams().height=300;
            Glide.with(Show_adv.this)
                    .load(image3)
                    .centerCrop()
                    .into(image3s);

        }

        if(!image4.equals("nil")) {
            image4s.getLayoutParams().height=300;
            Glide.with(Show_adv.this)
                    .load(image4)
                    .centerCrop()
                    .into(image4s);
        }

        if(!image5.equals("nil")) {
            image5s.getLayoutParams().height=300;
            Glide.with(Show_adv.this)
                    .load(image5)
                    .centerCrop()
                    .into(image5s);
        }



        image1s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent alvvwefrerxx3 = new Intent(Show_adv.this, Image_Ve.class);

                alvvwefrerxx3.putExtra("image_v", image1);

                startActivity(alvvwefrerxx3);
            }
        });
        image2s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent alvvwefrerxx3 = new Intent(Show_adv.this, Image_Ve.class);

                alvvwefrerxx3.putExtra("image_v", image2);

                startActivity(alvvwefrerxx3);
            }
        });
        image3s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent alvvwefrerxx3 = new Intent(Show_adv.this, Image_Ve.class);

                alvvwefrerxx3.putExtra("image_v", image3);

                startActivity(alvvwefrerxx3);
            }
        });
        image4s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent alvvwefrerxx3 = new Intent(Show_adv.this, Image_Ve.class);

                alvvwefrerxx3.putExtra("image_v", image4);

                startActivity(alvvwefrerxx3);
            }
        });
        image5s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent alvvwefrerxx3 = new Intent(Show_adv.this, Image_Ve.class);

                alvvwefrerxx3.putExtra("image_v", image5);

                startActivity(alvvwefrerxx3);
            }
        });


   // Toast.makeText(Show_adv.this, "Reponse : " + image1+image2+image3+image4+image5, Toast.LENGTH_SHORT).show();

    // Toast.makeText(Show_adv.this,f, Toast.LENGTH_LONG).show();


     //   Toast.makeText(Show_adv.this, a+b+c+d, Toast.LENGTH_LONG).show();
       // Pbar = (ProgressBar)findViewById(R.id.progressBar1);

//        etUserName = (Button) findViewById(R.id.erorrp);
//        etUserName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View vvv) {
//                loadProducts();
//                etUserName.setVisibility(View.GONE);
//
//            }
//        });



        //initializing the productlist
        productList = new ArrayList<>();
        loadcomment();
        //this method will fetch and parse json
        //to display it in recyclerview
      //  loadProducts();
     //   cheek_favorite();

    }




//    private void loadProducts() {
//        //    final String URL_PRODUCTS = "http://sultantec.com/files/api.php";
//        /*
//        * Creating a String Request
//        * The request type is GET defined by first parameter
//        * The URL is defined in the second parameter
//        * Then we have a Response Listener and a Error Listener
//        * In response listener we will get the JSON response as a String
//        * */
//        // recyclerView.setVisibility(View.GONE);
//      //  Pbar.setVisibility(View.VISIBLE);
//       // etUserName.setVisibility(View.GONE);
//
//        StringRequest stringRequest = new StringRequest(Request.Method.GET,"https://sultantec.com/bisha/photos_p.php?id="+ee,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//
//                            recyclerView.setVisibility(View.VISIBLE);
//
//                            // Pbar.setVisibility(View.VISIBLE);
//
//
//                            //converting the string to json array object
//                            JSONArray array = new JSONArray(response);
//
//                            //traversing through all the object
//                            for (int i =array.length()-1 ; i >=0; i--) {
//
//                                //getting product object from json array
//                                JSONObject product = array.getJSONObject(i);
//
//                                //adding the product to product list
//                                productList.add(new Product(
//                                        product.getInt("id"),
//                                        product.getString("title"),
//                                        product.getString("shortdesc"),
//                                        product.getString("rating"),
//                                        product.getString("price"),
//                                        product.getString("image")
//                                ));
//                            }
//
//                            //creating adapter object and setting it to recyclerview
//                            ProductsAdapter4 adapter = new ProductsAdapter4(Show_adv.this, productList);
//
//
//                            recyclerView.setAdapter(adapter);
//
//
//
//
//                            // recyclerView.setVisibility(View.VISIBLE);
//
//                           // Pbar.setVisibility(View.GONE);
//
//
//                            //  etUserName.setVisibility(View.GONE);
//
//
//
//
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                            // Log.e("erroer res",e);
//
//
//                            Toast.makeText(Show_adv.this,""+e, Toast.LENGTH_LONG).show();
//
//                            //etUserName.setVisibility(View.GONE);
//
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        //      Log.e("erroer res",error);
//                        // Toast.makeText(getContext(),""+error, Toast.LENGTH_LONG).show();
//                       // Pbar.setVisibility(View.GONE);
//                       // etUserName.setVisibility(View.VISIBLE);
//                    }
//                });
//
//        //adding our stringrequest to queue
//        Volley.newRequestQueue(Show_adv.this).add(stringRequest);
//    }



    public void buclickd2() {
        final EditText g;

        //final TextView t;
        dialog = new Dialog(Show_adv.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_coment);
        // dialog.setTitle("خروج من التطبيق");
        // set the custom dialog components - text, image and button
        //  ImageView image = (ImageView) dialog.findViewById(R.id.image);
        //  image.setImageResource(R.drawable.ic_launcher);
        g= (EditText) dialog.findViewById(R.id.editText12);
       // t= (TextView) dialog.findViewById(R.id.textView13);

        Button dialogButtonc = (Button) dialog.findViewById(R.id.app);
        // if button is clicked, close the custom dialog
        dialogButtonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


             coment_body = g.getText().toString();

                if (TextUtils.isEmpty(coment_body))
                {
                    g.setError("الرجاء كتابة تعليق");
                    return;
                }else {
                //    int a= Integer.parseInt(coment_body);
                   // int r= (a*1)/100 ;
                //    t.setText(" النسبة المستحقه هي : " + r + "ريال");
                    coment_send();
                }
            }
        });

        dialog.show();


    }



    public void callme() {

        final Dialog dialog = new Dialog(Show_adv.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_callme_adv);
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
                    callIntent.setData(Uri.parse("tel:" + "0"+c));
                    callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(callIntent);
                } catch (ActivityNotFoundException activityException) {
                    Log.e("Calling a Phone Number", "Call failed", activityException);
                }
            }
        });
        dialog.show();


    }





    private void cheek_favorite() {

      //  String in =getIntent().getStringExtra("phone");;

        final String phone2=Login.mUsername;

//        mProgressDialog = ProgressDialog.show(Show_adv.this,
//                "جاري ...","عملية التفريغ", false, false);


      //  String url = "https://sultantec.com/bisha/del_fev.php?a="+in;
        String url = "http://sultantec.com/haraj_bishah/Check_Favotite.php";


        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                //   Toast.makeText(mContext, " [runing " + s, Toast.LENGTH_SHORT).show();

                try {

                    JSONObject jsonObject = new JSONObject(s);
                    //JSONArray array_1 = jsonObject.getJSONArray("locations");
                    String query_result = jsonObject.getString("Status");


                    //   Toast.makeText(mContext, "Reponse : " + array_2, Toast.LENGTH_SHORT).show();
                    if (query_result.equals("Yes")) {
                    //    mProgressDialog.dismiss();
                      Toast.makeText(Show_adv.this, "لقد قمت بالاضافة الى المفضلة مسبقا" , Toast.LENGTH_LONG).show();
                      //  onBackPressed();
                        wwww21.setBackgroundResource(R.drawable.ic_favorite_black_24dp2);
                         wwww21.setEnabled(false);
                    } else if (!query_result.equals("Yes")) {
                      //  mProgressDialog.dismiss();
                  // Toast.makeText(Show_adv.this, "لم تقم بالاضافة الى المفضلة" +query_result, Toast.LENGTH_LONG).show();
                    }

                } catch (JSONException e) {
                    //  rdr2.setVisibility(View.GONE);
                   // mProgressDialog.dismiss();
              //   Toast.makeText(Show_adv.this, "يوجد مشكلة في الاتصال بالانترنت" , Toast.LENGTH_LONG).show();
                    e.printStackTrace();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
              //  mProgressDialog.dismiss();
              Toast.makeText(Show_adv.this, "يوجد مشكلة في الاتصال بالانترنت", Toast.LENGTH_LONG).show();
            }
        })   {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();



                params.put("phone_number",ph);
                params.put("product_id", ee);

                // params.put("domain", "http://itsalif.info");

                return params;
            }
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                MY_SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        Volley.newRequestQueue(Show_adv.this).add(stringRequest);
    }















    private void Add_fav() {

      //  String in =getIntent().getStringExtra("phone");;

        final String phone2=Login.mUsername;

        mProgressDialog = ProgressDialog.show(Show_adv.this,
                "جاري ...","عملية الاضافة الى المفضلة", false, false);


        String url = "http://sultantec.com/haraj_bishah/Add_Favorite.php";

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
                        Toast.makeText(Show_adv.this, "لقد قمت بالاضافة الى المفضلة " , Toast.LENGTH_LONG).show();
                        //  onBackPressed();
                        wwww21.setBackgroundResource(R.drawable.ic_favorite_black_24dp2);

                        wwww21.setEnabled(false);
                    } else if (!query_result.equals("Success")) {
                         mProgressDialog.dismiss();
                      Toast.makeText(Show_adv.this, "لم تتم  عملية الاضافة المفضلة" , Toast.LENGTH_LONG).show();
                    }


                } catch (JSONException e) {
                    //  rdr2.setVisibility(View.GONE);
                    mProgressDialog.dismiss();
                  Toast.makeText(Show_adv.this, "لم تتم  الاضافة الي المفضلة تاكد من الاتصال بالانترنت", Toast.LENGTH_LONG).show();
                    e.printStackTrace();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
               mProgressDialog.dismiss();
                Toast.makeText(Show_adv.this, "لم تتم  الاضافة الي المفضلة تاكد من الاتصال بالانترنت"+volleyError , Toast.LENGTH_LONG).show();
            }
        })   {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();

                params.put("phone_number", ph);
                params.put("product_id", ee);

                // params.put("domain", "http://itsalif.info");

                return params;
            }
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                MY_SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        Volley.newRequestQueue(Show_adv.this).add(stringRequest);
    }















    private void coment_send() {

        //String in =getIntent().getStringExtra("phone");;

        final String phone2=Login.mUsername;

        mProgressDialog = ProgressDialog.show(Show_adv.this,
                "جاري ...","ارسال التعليق", false, false);


        String url = "http://sultantec.com/haraj_bishah/Add_Comment.php";

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
                        Toast.makeText(Show_adv.this, "تم ارسال التعليق" , Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                        //  onBackPressed();
                       // wwww21.setEnabled(false);
                    } else if (!query_result.equals("Success")) {
                        mProgressDialog.dismiss();
                        Toast.makeText(Show_adv.this, "لم تتم  عملية ارسال التعليق" +query_result, Toast.LENGTH_LONG).show();
                    }


                } catch (JSONException e) {
                    //  rdr2.setVisibility(View.GONE);
                    mProgressDialog.dismiss();
                    Toast.makeText(Show_adv.this, "لم تتم  عملية ارسال التعليق" , Toast.LENGTH_LONG).show();
                    e.printStackTrace();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mProgressDialog.dismiss();
                Toast.makeText(Show_adv.this, "لم تتم  عملية ارسال التعليق"+volleyError , Toast.LENGTH_LONG).show();
            }
        })   {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();

                params.put("phone_number", ph);
                params.put("product_id", ee);
                params.put("comment_body", coment_body);
                // params.put("domain", "http://itsalif.info");

                return params;
            }
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                MY_SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        Volley.newRequestQueue(Show_adv.this).add(stringRequest);
    }


















    private void loadcomment() {
        //productList.clear();
        //    final String URL_PRODUCTS = "http://sultantec.com/files/api.php";
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

        StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://sultantec.com/haraj_bishah/Product_Details.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //        Toast.makeText(mCtx, "Reponse : " + response, Toast.LENGTH_SHORT).show();
                        try {
//"https://sultantec.com/bisha/prudectall.php",
                            recyclerView.setVisibility(View.VISIBLE);

                            // Pbar.setVisibility(View.VISIBLE);

                            //mSwipeRefreshLayout.setRefreshing(false);
                            //converting the string to json array object

                            JSONObject jsonObject = new JSONObject(response);
                            //JSONArray array_1 = jsonObject.getJSONArray("locations");
                            JSONArray array_2 = jsonObject.getJSONArray("Product_Comments");

                            //
                           // JSONObject jo = array_2.getJSONObject(0);
                            //    Log.d("f",jo.toString());

                        //  Toast.makeText(Show_adv.this, "Reponse : " + array_2, Toast.LENGTH_SHORT).show();

                            //  Toast.makeText(mCtx, "Reponse : " + array_2, Toast.LENGTH_SHORT).show();

                            //  JSONArray array = new JSONArray(response);



                            //  traversing through all the object
                            for (int i =array_2.length()-1 ; i >=0; i--) {

                                String image1,image2,image3,image4,image5;

                                //getting product object from json array
                                JSONObject product = array_2.getJSONObject(i);

                                //adding the product to product list

                                productList.add(new ProductMain2(
                                        product.getString("comment_body"),
                                        product.getString("user_comment")

                                ));



                            }

                            //creating adapter object and setting it to recyclerview
                            ProductsAdaptercomment adapter = new ProductsAdaptercomment(Show_adv.this, productList);
                            recyclerView.setAdapter(adapter);




                            // recyclerView.setVisibility(View.VISIBLE);

                            Pbar.setVisibility(View.GONE);


                            //  etUserName.setVisibility(View.GONE);





                        } catch (JSONException e) {
                            e.printStackTrace();
                            // Log.e("erroer res",e);
                      //      mSwipeRefreshLayout.setRefreshing(false);
                            Pbar.setVisibility(View.GONE);
                            Toast.makeText(Show_adv.this,""+e, Toast.LENGTH_LONG).show();

                            //etUserName.setVisibility(View.GONE);

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //      Log.e("erroer res",error);
                     Toast.makeText(Show_adv.this,""+error, Toast.LENGTH_LONG).show();
                        Pbar.setVisibility(View.GONE);
                        etUserName.setVisibility(View.VISIBLE);
                    //    mSwipeRefreshLayout.setRefreshing(false);
                    }
                })
        {
            @Override
            protected Map<String, String> getParams()
            {
               // final String phone23=Login.mUsername;
                Map<String, String>  params = new HashMap<String, String>();

                params.put("product_id", ee);
                //  params.put("product_id", ee);

                // params.put("domain", "http://itsalif.info");

                return params;
            }
        };

        //adding our stringrequest to queue
     //   Volley.newRequestQueue(Show_adv.add(stringRequest);
        Volley.newRequestQueue(Show_adv.this).add(stringRequest);
    }









}
