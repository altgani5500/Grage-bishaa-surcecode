package com.example.user.grage_bisha;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;


public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {

public  static String text;
    public  static String date;
    public  static String adress;
    public  static String image1;
   String image11,image2,image3,image4,image5;
    int up=0;

    private static final int MY_SOCKET_TIMEOUT_MS = 400000;


String con;

    public  static String content;
    public  static int  id;

    private Context mCtx;
    private List<ProductMain> productList;
   // Context mContxt;

    public ProductsAdapter(Context mCtx, List<ProductMain> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }


    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.product_list, null);
        return new ProductViewHolder(view);
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
        holder.textViewShortDesc.setText(product.getPrice());
        holder.textViewRating.setText(String.valueOf(product.getRating()));
        holder.textViewPrice.setText(String.valueOf(product.getPrice()));



        holder.fev.setOnClickListener(new View.OnClickListener() {
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





if(up==0){
                holder.fev.setImageResource(R.drawable.select);
                regect();
    up=1;
}
                else if(up==1){
                    holder.fev.setImageResource(R.drawable.unselect);
                    up=0;
                  regect2();
                }





            }
        });





        holder.onclik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//text=product.getImage();
               // text=product.getImage().toString();

                image11=product.getImage1();
                image2=product.getImage2();
                image3=product.getImage3();
                image4=product.getImage4();
                image5=product.getImage5();

                ProductMain product = productList.get(position);
                image1=product.getImage().toString();
                text= holder.textViewShortDesc.getText().toString();
                date= holder.textViewRating.getText().toString();
                adress= holder.textViewTitle.getText().toString();
                  id=product.getId();
                date= holder.textViewRating.getText().toString();

                con=product.getShortdesc().toString();

                Intent al = new Intent(mCtx, Show_adv.class);

                al.putExtra("g1", text); al.putExtra("g2", image1); al.putExtra("g3", date); al.putExtra("g4", adress);

                al.putExtra("g5", id);al.putExtra("g6", con);


                al.putExtra("g7", image11);al.putExtra("g8", image2);
                al.putExtra("g9", image3);al.putExtra("g10", image4);
                al.putExtra("g11", image5);

                mCtx.startActivity(al);



              //overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);

     //  Toast.makeText(mCtx, "تمت الاضافة الي المفضلة" , Toast.LENGTH_LONG).show();

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
        ImageView fev;
RelativeLayout onclik;



        public ProductViewHolder(View itemView) {
            super(itemView);
            textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = (TextView) itemView.findViewById(R.id.textView38);
            textViewRating = (TextView) itemView.findViewById(R.id.textView25);
            textViewPrice = (TextView) itemView.findViewById(R.id.textViewPrice);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            onclik=(RelativeLayout)itemView.findViewById(R.id.onclik2);
            fev = (ImageView) itemView.findViewById(R.id.button2);
        }




    }























    public void signup() {



       String in =Integer.toString(id);


         new SignupActivityda(mCtx).execute(in,adress,text,date,image1,con);

      //  Toast.makeText(mCtx, in+adress+text+date+image1+con, Toast.LENGTH_SHORT).show();
    }








    public class SignupActivityda extends AsyncTask<String, Void, String> {


        private Context context;


        public SignupActivityda(Context context) {
            this.context = context;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String... arg0) {
            String pass = arg0[0];
            String pass1 = arg0[1];
            String pass2 = arg0[2];
            String pass3 = arg0[3];
            String pass4 = arg0[4];
            String pass5 = arg0[5];


            String link;
            String data;
            BufferedReader bufferedReader;
            String result;

            try {
                data = "?a=" + URLEncoder.encode(pass, "UTF-8");
                data += "&b=" + URLEncoder.encode(pass1, "UTF-8");
                data += "&c=" + URLEncoder.encode(pass2, "UTF-8");
                data += "&d=" + URLEncoder.encode(pass3, "UTF-8");
                data += "&e=" + URLEncoder.encode(pass4, "UTF-8");
                data += "&f=" + URLEncoder.encode(pass5, "UTF-8");




                link = "https://sultantec.com/bisha/add_fev.php" + data;

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
                        Toast.makeText(mCtx, "تمت الاضافة الي المفضلة" , Toast.LENGTH_LONG).show();

                    } else if (query_result.equals("FAILURE")) {
                        Toast.makeText(mCtx, "لم تتم الاضافة الي المفضلة" , Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(mCtx, "لم تتم الاضافة الي المفضلة" , Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(mCtx, "لم تتم الاضافة الي المفضلة"+e , Toast.LENGTH_LONG).show();
                }
            } else {


                Toast.makeText(mCtx, "لم تتم الاضافة الي المفضلة" , Toast.LENGTH_LONG).show();
            }

        }}







    private void regect() {

        String in =Integer.toString(id);







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

        String a = adress.replaceAll(" ", "%20");
        String b= con.replaceAll(" ", "%20");


       // Toast.makeText(mCtx, in+a+text+date+image1+b, Toast.LENGTH_SHORT).show();


        String url = "https://sultantec.com/bisha/add_fev.php?a="+in+"&b="+a +"&c="+text +"&d="+date+"&e="+image1+"&f="+b;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                //   Toast.makeText(mContext, " [runing " + s, Toast.LENGTH_SHORT).show();

                try {

                    JSONObject jsonObject = new JSONObject(s);
                    //JSONArray array_1 = jsonObject.getJSONArray("locations");
                    String query_result = jsonObject.getString("query_result");


                    //   Toast.makeText(mContext, "Reponse : " + array_2, Toast.LENGTH_SHORT).show();
                    if (query_result.equals("SUCCESS")) {
                        Toast.makeText(mCtx, "تمت الاضافة الي المفضلة" , Toast.LENGTH_LONG).show();

                    } else if (query_result.equals("FAILURE")) {
                        Toast.makeText(mCtx, "لم تتم الاضافة الي المفضلة" +query_result, Toast.LENGTH_LONG).show();
                    }


                } catch (JSONException e) {
                    //  rdr2.setVisibility(View.GONE);
                    Toast.makeText(mCtx, "لم تتم الاضافة الي المفضلة"+e , Toast.LENGTH_LONG).show();
                    e.printStackTrace();

                }




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(mCtx, "لم تتم الاضافة الي المفضلة"+volleyError , Toast.LENGTH_LONG).show();
            }
        }) {
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                MY_SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        Volley.newRequestQueue(mCtx).add(stringRequest);
    }

















    private void regect2() {

        String in =Integer.toString(id);







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

        String a = adress.replaceAll(" ", "%20");
        String b= con.replaceAll(" ", "%20");


        //Toast.makeText(mCtx, in+a+text+date+image1+b, Toast.LENGTH_SHORT).show();


        String url = "https://sultantec.com/bisha/reg_fev.php?a="+in;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                //   Toast.makeText(mContext, " [runing " + s, Toast.LENGTH_SHORT).show();

                try {

                    JSONObject jsonObject = new JSONObject(s);
                    //JSONArray array_1 = jsonObject.getJSONArray("locations");
                    String query_result = jsonObject.getString("query_result");


                    //   Toast.makeText(mContext, "Reponse : " + array_2, Toast.LENGTH_SHORT).show();
                    if (query_result.equals("SUCCESS")) {
                        Toast.makeText(mCtx, "تمت الازالة من المفضلة" , Toast.LENGTH_LONG).show();

                    } else if (query_result.equals("FAILURE")) {
                        Toast.makeText(mCtx, "لم تتم الازالة من المفضلة" +query_result, Toast.LENGTH_LONG).show();
                    }


                } catch (JSONException e) {
                    //  rdr2.setVisibility(View.GONE);
                    Toast.makeText(mCtx, "لم تتم الازالة من المفضلة"+e , Toast.LENGTH_LONG).show();
                    e.printStackTrace();

                }




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(mCtx, "لم تتم الاضافة الي المفضلة"+volleyError , Toast.LENGTH_LONG).show();
            }
        }) {
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                MY_SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        Volley.newRequestQueue(mCtx).add(stringRequest);
    }





}