package com.example.user.grage_bisha;


import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;


public class ProductsAdaptercomment extends RecyclerView.Adapter<ProductsAdaptercomment.ProductViewHolder> {

//public  static String text;
//    public  static String date;
//    public  static String adress;
//    public  static String image1;
//   String image11,image2,image3,image4,image5;
    int up=0;
String phone_call;
    private static final int MY_SOCKET_TIMEOUT_MS = 400000;


String con;

    public  static String content;
    public  static String  id;

    //private Context mCtx2;
    private Context mCtx2;
    private List<ProductMain2> productList;
   // Context mContxt;

    public ProductsAdaptercomment(Context mCtx2, List<ProductMain2> productList) {
        this.mCtx2 = mCtx2;
        this.productList = productList;
    }




    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx2);
        View view = inflater.inflate(R.layout.product_list_comment, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, final int position) {
     final ProductMain2 product = productList.get(position);


        holder.textViewTitle.setText(product.getuser());
        holder.textViewShortDesc.setText(product.getBody());






//        holder.fev.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                ProductMain2 product = productList.get(position);
////                image1=product.getImage().toString();
////                text= holder.textViewShortDesc.getText().toString();
////                date= holder.textViewRating.getText().toString();
////                adress= holder.textViewTitle.getText().toString();
////                id=product.getId();
////                date= holder.textViewRating.getText().toString();
////
////                con=product.getShortdesc().toString();
////
//
//
//
//
////if(up==0){
////                holder.fev.setImageResource(R.drawable.select);
////                regect();
////    up=1;
////}
////                else if(up==1){
////                    holder.fev.setImageResource(R.drawable.unselect);
////                    up=0;
////                  regect2();
////                }
////
////
////
////
////
//        }
//        });








//

        holder.textViewTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone_call= holder.textViewTitle.getText().toString();
                callme();
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
            textViewTitle = (TextView) itemView.findViewById(R.id.textView3);
            textViewShortDesc = (TextView) itemView.findViewById(R.id.textView19);
//            textViewRating = (TextView) itemView.findViewById(R.id.textView25);
//            textViewPrice = (TextView) itemView.findViewById(R.id.textViewPrice);
//            imageView = (ImageView) itemView.findViewById(R.id.imageView);
//            onclik=(RelativeLayout)itemView.findViewById(R.id.onclik2);
//            fev = (ImageView) itemView.findViewById(R.id.button2);
        }

    }





















//
//
//    public void signup() {
//
//
//
//       //String in =Integer.toString(id);
//        String in=id;
//
//         new SignupActivityda(mCtx2).execute(in,adress,text,date,image1,con);
//
//      //  Toast.makeText(mCtx, in+adress+text+date+image1+con, Toast.LENGTH_SHORT).show();
//    }
//
//
//
//
//
//
//
//
//    public class SignupActivityda extends AsyncTask<String, Void, String> {
//
//
//        private Context context;
//
//
//        public SignupActivityda(Context context) {
//            this.context = context;
//        }
//
//        protected void onPreExecute()
//        {
//            super.onPreExecute();
//
//        }
//
//        @Override
//        protected String doInBackground(String... arg0) {
//            String pass = arg0[0];
//            String pass1 = arg0[1];
//            String pass2 = arg0[2];
//            String pass3 = arg0[3];
//            String pass4 = arg0[4];
//            String pass5 = arg0[5];
//
//
//            String link;
//            String data;
//            BufferedReader bufferedReader;
//            String result;
//
//            try {
//                data = "?a=" + URLEncoder.encode(pass, "UTF-8");
//                data += "&b=" + URLEncoder.encode(pass1, "UTF-8");
//                data += "&c=" + URLEncoder.encode(pass2, "UTF-8");
//                data += "&d=" + URLEncoder.encode(pass3, "UTF-8");
//                data += "&e=" + URLEncoder.encode(pass4, "UTF-8");
//                data += "&f=" + URLEncoder.encode(pass5, "UTF-8");
//
//
//
//
//                link = "https://sultantec.com/bisha/add_fev.php" + data;
//
//                URL url = new URL(link);
//                HttpURLConnection con = (HttpURLConnection) url.openConnection();
//
//                bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
//                result = bufferedReader.readLine();
//                return result;
//            } catch (Exception e) {
//                return new String("Exception: " + e.getMessage());
//            }
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            String jsonStr = result;
//            if (jsonStr != null) {
//                try {
//                    JSONObject jsonObj = new JSONObject(jsonStr);
//                    String query_result = jsonObj.getString("query_result");
//                    if (query_result.equals("SUCCESS")) {
//                        Toast.makeText(mCtx2, "تمت الاضافة الي المفضلة" , Toast.LENGTH_LONG).show();
//
//                    } else if (query_result.equals("FAILURE")) {
//                        Toast.makeText(mCtx2, "لم تتم الاضافة الي المفضلة" , Toast.LENGTH_LONG).show();
//                    } else {
//                        Toast.makeText(mCtx2, "لم تتم الاضافة الي المفضلة" , Toast.LENGTH_LONG).show();
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                    Toast.makeText(mCtx2, "لم تتم الاضافة الي المفضلة"+e , Toast.LENGTH_LONG).show();
//                }
//            } else {
//
//
//                Toast.makeText(mCtx2, "لم تتم الاضافة الي المفضلة" , Toast.LENGTH_LONG).show();
//            }
//
//        }}
//
//
//
//
//
//
//
//    private void regect() {
//
//      //  String in =Integer.toString(id);
//
//
//
//String in=id;
//
//
//
////
////        try {
////
////
////            data ="&note=" + URLEncoder.encode(coment, "UTF-8");
////
////
//////
////        } catch (Exception e) {
////            // return new String("Exception: " + e.getMessage());
////
////            Toast.makeText(mCtx, "theexption"+e, Toast.LENGTH_SHORT).show();
////        }
//
//        String a = adress.replaceAll(" ", "%20");
//        String b= con.replaceAll(" ", "%20");
//
//
//       // Toast.makeText(mCtx, in+a+text+date+image1+b, Toast.LENGTH_SHORT).show();
//
//
//        String url = "https://sultantec.com/bisha/add_fev.php?a="+in+"&b="+a +"&c="+text +"&d="+date+"&e="+image1+"&f="+b;
//
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String s) {
//
//                //   Toast.makeText(mContext, " [runing " + s, Toast.LENGTH_SHORT).show();
//
//                try {
//
//                    JSONObject jsonObject = new JSONObject(s);
//                    //JSONArray array_1 = jsonObject.getJSONArray("locations");
//                    String query_result = jsonObject.getString("query_result");
//
//
//                    //   Toast.makeText(mContext, "Reponse : " + array_2, Toast.LENGTH_SHORT).show();
//                    if (query_result.equals("SUCCESS")) {
//                        Toast.makeText(mCtx2, "تمت الاضافة الي المفضلة" , Toast.LENGTH_LONG).show();
//
//                    } else if (query_result.equals("FAILURE")) {
//                        Toast.makeText(mCtx2, "لم تتم الاضافة الي المفضلة" +query_result, Toast.LENGTH_LONG).show();
//                    }
//
//
//                } catch (JSONException e) {
//                    //  rdr2.setVisibility(View.GONE);
//                    Toast.makeText(mCtx2, "لم تتم الاضافة الي المفضلة"+e , Toast.LENGTH_LONG).show();
//                    e.printStackTrace();
//
//                }
//
//
//
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//                Toast.makeText(mCtx2, "لم تتم الاضافة الي المفضلة"+volleyError , Toast.LENGTH_LONG).show();
//            }
//        }) {
//        };
//
//        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
//                MY_SOCKET_TIMEOUT_MS,
//                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
//                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//
//        Volley.newRequestQueue(mCtx2).add(stringRequest);
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    private void regect2() {
//
//        //String in =Integer.toString(id);
//
//String in =id;
//
//
//
//
//
////
////        try {
////
////
////            data ="&note=" + URLEncoder.encode(coment, "UTF-8");
////
////
//////
////        } catch (Exception e) {
////            // return new String("Exception: " + e.getMessage());
////
////            Toast.makeText(mCtx, "theexption"+e, Toast.LENGTH_SHORT).show();
////        }
//
//        String a = adress.replaceAll(" ", "%20");
//        String b= con.replaceAll(" ", "%20");
//
//
//        //Toast.makeText(mCtx, in+a+text+date+image1+b, Toast.LENGTH_SHORT).show();
//
//
//        String url = "https://sultantec.com/bisha/reg_fev.php?a="+in;
//
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String s) {
//
//                //   Toast.makeText(mContext, " [runing " + s, Toast.LENGTH_SHORT).show();
//
//                try {
//
//                    JSONObject jsonObject = new JSONObject(s);
//                    //JSONArray array_1 = jsonObject.getJSONArray("locations");
//                    String query_result = jsonObject.getString("query_result");
//
//
//                    //   Toast.makeText(mContext, "Reponse : " + array_2, Toast.LENGTH_SHORT).show();
//                    if (query_result.equals("SUCCESS")) {
//                        Toast.makeText(mCtx2, "تمت الازالة من المفضلة" , Toast.LENGTH_LONG).show();
//
//                    } else if (query_result.equals("FAILURE")) {
//                        Toast.makeText(mCtx2, "لم تتم الازالة من المفضلة" +query_result, Toast.LENGTH_LONG).show();
//                    }
//
//
//                } catch (JSONException e) {
//                    //  rdr2.setVisibility(View.GONE);
//                    Toast.makeText(mCtx2, "لم تتم الازالة من المفضلة"+e , Toast.LENGTH_LONG).show();
//                    e.printStackTrace();
//
//                }
//
//
//
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//                Toast.makeText(mCtx2, "لم تتم الاضافة الي المفضلة"+volleyError , Toast.LENGTH_LONG).show();
//            }
//        }) {
//        };
//
//        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
//                MY_SOCKET_TIMEOUT_MS,
//                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
//                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//
//        Volley.newRequestQueue(mCtx2).add(stringRequest);
//    }
//
//





    public void callme() {

        final Dialog dialog = new Dialog(mCtx2);
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
                    callIntent.setData(Uri.parse("tel:" + "0"+phone_call));
                    callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mCtx2.startActivity(callIntent);
                } catch (ActivityNotFoundException activityException) {
                    Log.e("Calling a Phone Number", "Call failed", activityException);
                }
            }
        });
        dialog.show();


    }

}