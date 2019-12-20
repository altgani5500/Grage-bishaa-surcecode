package com.example.user.grage_bisha;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



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
import android.widget.TextView;
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

public class My_adv extends Activity {

    //this is the JSON Data URL
    //make sure you are using the correct ip else it will not work

    Dialog  dialog;
    //a list to store all the products
    List<ProductMain> productList;

    //the recyclerview
    RecyclerView recyclerView;

    ProgressBar Pbar;
    private Button etUserName;
String adrs,cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_adv);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                ///.setAction("Action", null).show();
//                onBackPressed();
//
//            }
//        });



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






    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }



    public void onBackPressed2() {
        super.onBackPressed();
        // overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }




    public class ProductsAdapter3 extends RecyclerView.Adapter<ProductsAdapter3.ProductViewHolder> {

        public   String text;
        public   String date;
        public   String adress;
        public   String image1;
        private ProgressDialog mProgressDialog;
        private static final int MY_SOCKET_TIMEOUT_MS = 400000;

        String con;

        public   String content;
        public   int  id;
        private Context mCtx;
        private List<ProductMain> productList;
        // Context mContxt;

        public ProductsAdapter3(Context mCtx, List<ProductMain> productList) {
            this.mCtx = mCtx;
            this.productList = productList;
        }


        @Override
        public ProductsAdapter3.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(mCtx);
            View view = inflater.inflate(R.layout.product_list3, null);
            return new ProductsAdapter3.ProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ProductViewHolder holder, final int position) {


            final ProductMain product = productList.get(position);
            // final Product product2 = productList.get(position);

            //loading the image
            Glide.with(mCtx)
                    .load(product.getImage())
                    .into(holder.imageView);


            holder.textViewTitle.setText(product.getTitle());


            holder.textViewShortDesc.setText(product.getShortdesc());
            holder.textViewRating.setText(String.valueOf(product.getRating()));
            holder.textViewPrice.setText(String.valueOf(product.getPrice()));


            //loading the image
            Glide.with(mCtx)
                    .load(product.getImage())
                    .into(holder.imageView);


            holder.textViewTitle.setText(product.getTitle());
            holder.textViewShortDesc.setText(product.getPrice());
            holder.textViewRating.setText(String.valueOf(product.getRating()));
            holder.textViewPrice.setText(String.valueOf(product.getPrice()));



            holder.del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    ProductMain product = productList.get(position);
                    image1=product.getImage().toString();
                    text= holder.textViewShortDesc.getText().toString();
                    date= holder.textViewRating.getText().toString();
                    adress= holder.textViewTitle.getText().toString();
                    id=product.getId();
                    date= holder.textViewRating.getText().toString();

                    con=product.getShortdesc().toString();


                    del();






                }
            });




            holder.upd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    ProductMain product = productList.get(position);
                    image1=product.getImage().toString();
                    text= holder.textViewShortDesc.getText().toString();
                    date= holder.textViewRating.getText().toString();
                    adress= holder.textViewTitle.getText().toString();
                    id=product.getId();
                    date= holder.textViewRating.getText().toString();

                    con=product.getShortdesc().toString();


                    edit_p();






                }
            });

        }

        @Override
        public int getItemCount() {
            return productList.size();
        }

        class ProductViewHolder extends RecyclerView.ViewHolder {

            TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
            ImageView imageView;
            //RelativeLayout onclik;
            Button del,upd;


            public ProductViewHolder(View itemView) {
                super(itemView);
                textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
                textViewShortDesc = (TextView) itemView.findViewById(R.id.textView62);
                textViewRating = (TextView) itemView.findViewById(R.id.textViewRating);
                textViewPrice = (TextView) itemView.findViewById(R.id.textViewPrice);
                imageView = (ImageView) itemView.findViewById(R.id.imageView);
                del=(Button) itemView.findViewById(R.id.button2221);
                upd=(Button) itemView.findViewById(R.id.button441);
            }




        }



















        private void del() {

            final String in =Integer.toString(id);



            mProgressDialog = ProgressDialog.show(mCtx,
                    "جاري ...","عملية الحذف", false, false);


//
//        try {
//
//
//            data ="&note=" + URLEncoder.encode(coment, "UTF-8");
//
//
////
//        } catch (Exception e) {
//            // return new String("Exception: " + e.getMessage());
//
//            Toast.makeText(mCtx, "theexption"+e, Toast.LENGTH_SHORT).show();
//        }

//        String a = adress.replaceAll(" ", "%20");
//        String b= con.replaceAll(" ", "%20");
//

            // Toast.makeText(mCtx, in+a+text+date+image1+b, Toast.LENGTH_SHORT).show();


           // String url = "https://sultantec.com/bisha/del_pro.php?a="+in;


            String url ="http://sultantec.com/haraj_bishah/Delete_Product.php";


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
                            //Toast.makeText(mCtx, "تم حذف الاعلان" , Toast.LENGTH_LONG).show();
                            mProgressDialog.dismiss();

                            loadProducts();


//
//                        Intent al = new Intent(mCtx, My_adv.class);
//
//                        mCtx.startActivity(al);

//                        My_adv cls = new My_adv();
//                        cls.loadProducts();


                        } else if (!query_result.equals("Success")) {
                            mProgressDialog.dismiss();
                            Toast.makeText(mCtx, "لم يتم حذف الاعلان" +query_result, Toast.LENGTH_LONG).show();

                        }


                    } catch (JSONException e) {
                        //  rdr2.setVisibility(View.GONE);
                        mProgressDialog.dismiss();
                        Toast.makeText(mCtx, "لم يتم حذف الاعلان"+e , Toast.LENGTH_LONG).show();
                        e.printStackTrace();

                    }




                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    mProgressDialog.dismiss();
                    Toast.makeText(mCtx, "لم يتم حذف الاعلان"+volleyError , Toast.LENGTH_LONG).show();
                }
            })
                {
                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String, String>  params = new HashMap<String, String>();
                        params.put("product_id", in);
                        // params.put("domain", "http://itsalif.info");

                        return params;
                    }
                };


            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                    MY_SOCKET_TIMEOUT_MS,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            Volley.newRequestQueue(mCtx).add(stringRequest);
        }











        public void edit_p() {
            final EditText g,f;

            final TextView t;
            dialog = new Dialog(My_adv.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.custom_edit);
            // dialog.setTitle("خروج من التطبيق");
            // set the custom dialog components - text, image and button
            //  ImageView image = (ImageView) dialog.findViewById(R.id.image);
            //  image.setImageResource(R.drawable.ic_launcher);


            f= (EditText) dialog.findViewById(R.id.editText8);
            g= (EditText) dialog.findViewById(R.id.editText12);


            f.setText(adress);
            g.setText(con);

            Button dialogButtonc = (Button) dialog.findViewById(R.id.app);
            // if button is clicked, close the custom dialog
            dialogButtonc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    String  name22 = f.getText().toString();
                    String  name223 = g.getText().toString();
                    if (TextUtils.isEmpty(name22))
                    {
                        f.setError("الحقل مطلوب");
                        return;
                    }else if (TextUtils.isEmpty(name223))
                    {
                        g.setError("الحقل مطلوب");
                        return;
                    }
                       else
                        adrs = f.getText().toString();
                         cont = g.getText().toString();
                        update_p();
                    }

            });

            dialog.show();


        }




        private void update_p() {

           final String in =Integer.toString(id);

          //  Toast.makeText(mCtx, in, Toast.LENGTH_SHORT).show();

            mProgressDialog = ProgressDialog.show(mCtx,
                    "جاري ...","عملية التعديل", false, false);


//
//        try {
//
//
//            data ="&note=" + URLEncoder.encode(coment, "UTF-8");
//
//
////
//        } catch (Exception e) {
//            // return new String("Exception: " + e.getMessage());
//
//            Toast.makeText(mCtx, "theexption"+e, Toast.LENGTH_SHORT).show();
//        }

//        String a = adress.replaceAll(" ", "%20");
//        String b= con.replaceAll(" ", "%20");
//

            // Toast.makeText(mCtx, in+a+text+date+image1+b, Toast.LENGTH_SHORT).show();

//            final   String a = adrs.replaceAll(" ", "%20");
//            final   String b= cont.replaceAll(" ", "%20");

            final   String a = adrs;
            final   String b= cont;

        //   String url = "https://sultantec.com/bisha/up_pro.php?a="+in+"&b="+a+"&c="+b;

       String url ="http://sultantec.com/haraj_bishah/Edit_Product.php";

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
                           Toast.makeText(mCtx, "تم تعديل الاعلان" , Toast.LENGTH_LONG).show();
                            mProgressDialog.dismiss();
                            dialog.dismiss();

                            loadProducts();


//
//                        Intent al = new Intent(mCtx, My_adv.class);
//
//                        mCtx.startActivity(al);

//                        My_adv cls = new My_adv();
//                        cls.loadProducts();


                        } else if (!query_result.equals("Success")) {
                            mProgressDialog.dismiss();
                            Toast.makeText(mCtx, "لم يتم تعديل الاعلان" +query_result, Toast.LENGTH_LONG).show();

                        }


                    } catch (JSONException e) {
                        //  rdr2.setVisibility(View.GONE);
                        mProgressDialog.dismiss();
                        Toast.makeText(mCtx, "لم يتم تعديل الاعلان"+e , Toast.LENGTH_LONG).show();
                        e.printStackTrace();

                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    mProgressDialog.dismiss();
                    Toast.makeText(mCtx, "لم يتم حذف الاعلان"+volleyError , Toast.LENGTH_LONG).show();
                }
            })      {
                @Override
                protected Map<String, String> getParams()
                {
                    Map<String, String>  params = new HashMap<String, String>();
                    params.put("product_id", in);
                    params.put("title", a);
                    params.put("details", b);
                    // params.put("domain", "http://itsalif.info");

                    return params;
                }
            };

            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                    MY_SOCKET_TIMEOUT_MS,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            Volley.newRequestQueue(mCtx).add(stringRequest);
        }
















        public void signupup() {

            String in =Integer.toString(id);

//
//           MainActivity.phone_temp=phone1;
//            MainActivity.name_temp=name1;
//
//

                new SignupActivityda(mCtx).execute(in,adress,con);


        }








        public class SignupActivityda extends AsyncTask<String, Void, String> {


            private Context context;


            public SignupActivityda(Context context) {
                this.context = context;
            }

            protected void onPreExecute()
            {
                super.onPreExecute();
                mProgressDialog = ProgressDialog.show(mCtx,
                        "جاري ...","ارسال البيانات", false, false);
            }

            @Override
            protected String doInBackground(String... arg0) {
                String name = arg0[0];
                String pass = arg0[1];
                String pass2 = arg0[2];


                String link;
                String data;
                BufferedReader bufferedReader;
                String result;

                try {
                    data = "?a=" + URLEncoder.encode(name, "UTF-8");
                    data += "&b=" + URLEncoder.encode(pass, "UTF-8");
                    data += "&c=" + URLEncoder.encode(pass2, "UTF-8");


                    link = "https://sultantec.com/bisha/up_pro.php" + data;

                    URL url = new URL(link);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();

                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    result = bufferedReader.readLine();
                    return result;
                } catch (Exception e) {
                    return new String("Exception: " + e.getMessage());
                }
            }

            @Override
            protected void onPostExecute(String result) {
                String jsonStr = result;
                if (jsonStr != null) {
                    try {
                        JSONObject jsonObj = new JSONObject(jsonStr);
                        String query_result = jsonObj.getString("query_result");
                        if (query_result.equals("SUCCESS")) {

                            Toast.makeText(mCtx, "تم تعديل الاعلان" , Toast.LENGTH_LONG).show();
                            mProgressDialog.dismiss();

                            loadProducts();


                        } else if (query_result.equals("FAILURE")) {
                            Toast.makeText(mCtx, "لم يتم تعديل الاعلان" , Toast.LENGTH_LONG).show();
                            mProgressDialog.dismiss();

                            loadProducts();
                        } else {
                            Toast.makeText(mCtx, "لم يتم تعديل الاعلان" , Toast.LENGTH_LONG).show();
                            mProgressDialog.dismiss();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(mCtx, "لم يتم تعديل الاعلان" , Toast.LENGTH_LONG).show();
                        mProgressDialog.dismiss();
                    }
                } else {


                    Toast.makeText(mCtx, "لم يتم تعديل الاعلان" , Toast.LENGTH_LONG).show();
                    mProgressDialog.dismiss();
                }

            }}














    }



    public  void loadProducts() {

productList.clear();
        //  String phone=getIntent().getStringExtra("phone");

        final String phone=Login.mUsername;
//        String pass=getIntent().getStringExtra("pass");
        String URL_PRODUCTS = "http://sultantec.com/haraj_bishah/MyProducts.php";
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

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {


                            // Pbar.setVisibility(View.VISIBLE);


                            JSONObject jsonObject = new JSONObject(response);
                            //JSONArray array_1 = jsonObject.getJSONArray("locations");
                            JSONArray array_2 = jsonObject.getJSONArray("My_Products");





                            //
                            JSONObject jo = array_2.getJSONObject(0);
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
                            ProductsAdapter3 adapter = new ProductsAdapter3(My_adv.this, productList);


                            recyclerView.setAdapter(adapter);




                            // recyclerView.setVisibility(View.VISIBLE);
                           // Toast.makeText(My_adv.this, "yes", Toast.LENGTH_SHORT).show();
                            Pbar.setVisibility(View.GONE);


                            //  etUserName.setVisibility(View.GONE);





                        } catch (JSONException e) {
                            e.printStackTrace();
                            Pbar.setVisibility(View.GONE);
                            Log.d("a","exption"+e);
                         //   Toast.makeText(My_adv.this, ""+e, Toast.LENGTH_SHORT).show();
                            //etUserName.setVisibility(View.GONE);

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("a","exption"+error);
                        Pbar.setVisibility(View.GONE);
                        etUserName.setVisibility(View.VISIBLE);
                       // Toast.makeText(My_adv.this, ""+error, Toast.LENGTH_SHORT).show();
                    }
                }

        )

        {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("phone_number", phone);
               // params.put("domain", "http://itsalif.info");

                return params;
            }
        };

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }






//
//   String url = "http://httpbin.org/post";
//    StringRequest postRequest = new StringRequest(Request.Method.POST, url,
//            new Response.Listener<String>()
//            {
//                @Override
//                public void onResponse(String response) {
//                    // response
//                   // Log.d("Response", response);
//                }
//            },
//            new Response.ErrorListener()
//            {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    // error
//                   // Log.d("Error.Response", response);
//                }
//            }
//    ) {
//        @Override
//        protected Map<String, String> getParams()
//        {
//            Map<String, String>  params = new HashMap<String, String>();
//            params.put("name", "Alif");
//            params.put("domain", "http://itsalif.info");
//
//            return params;
//        }
//    };















}
