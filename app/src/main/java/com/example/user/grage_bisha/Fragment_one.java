
package com.example.user.grage_bisha;

        import android.content.Context;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.support.v4.widget.SwipeRefreshLayout;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.SeekBar;
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

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;


public class Fragment_one extends Fragment {

    private Context mCtx;

    SwipeRefreshLayout mSwipeRefreshLayout;
    //a list to store all the products
    List<ProductMain> productList;

    //the recyclerview
    RecyclerView recyclerView;

    ProgressBar Pbar;
    private Button etUserName;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View view =  inflater.inflate(R.layout.fragment_one,
                container, false);

//        final Button button =
//                (Button) view.findViewById(R.id.erorrp);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                loadProducts();
//            }
//        });


        //getting the recyclerview from xml

        mSwipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipe_container);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                loadProducts();

//                new android.os.Handler().postDelayed(new Runnable() {
//
//                    @Override public void run() {
//
//                        //   mSwipeRefreshLayout.setRefreshing(false);
//
//                    }
//
//                }, 5000);

            }

        });


        recyclerView = (RecyclerView) view.findViewById(R.id.recylcerView2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setVisibility(View.GONE);




        Pbar = (ProgressBar)view.findViewById(R.id.progressBar1);
        Pbar.setVisibility(View.GONE);
        etUserName = (Button) view.findViewById(R.id.erorrp);
        etUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {
               loadProducts();

            }
        });

//        loadProducts();

        //initializing the productlist
        productList = new ArrayList<>();

        loadProducts();



        return view;
    }

//    public void buttonClicked (View view) {
//
//    }


    private void loadProducts() {
        productList.clear();
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

        StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://sultantec.com/haraj_bishah/All_Product.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                //        Toast.makeText(mCtx, "Reponse : " + response, Toast.LENGTH_SHORT).show();
                        try {
//"https://sultantec.com/bisha/prudectall.php",
                            recyclerView.setVisibility(View.VISIBLE);

                            // Pbar.setVisibility(View.VISIBLE);

                            mSwipeRefreshLayout.setRefreshing(false);
                            //converting the string to json array object

                            JSONObject jsonObject = new JSONObject(response);
                            //JSONArray array_1 = jsonObject.getJSONArray("locations");
                            JSONArray array_2 = jsonObject.getJSONArray("All");

                         JSONObject jo = array_2.getJSONObject(0);
                      //  Log.d("f",jsonObject.toString());

                          //  Toast.makeText(mCtx, "Reponse : " + array_2, Toast.LENGTH_SHORT).show();

                          //  Toast.makeText(mCtx, "Reponse : " + array_2, Toast.LENGTH_SHORT).show();

                          //  JSONArray array = new JSONArray(response);





                          //  traversing through all the object
                            for (int i =array_2.length()-1 ; i >=0; i--) {

                               String image1,image2,image3,image4,image5;

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
                            ProductsAdapter adapter = new ProductsAdapter(getContext(), productList);


                            recyclerView.setAdapter(adapter);




                            // recyclerView.setVisibility(View.VISIBLE);

                            Pbar.setVisibility(View.GONE);


                            //  etUserName.setVisibility(View.GONE);





                        } catch (JSONException e) {
                            e.printStackTrace();
                           // Log.e("erroer res",e);
                            mSwipeRefreshLayout.setRefreshing(false);

                           // Toast.makeText(getContext(),""+e, Toast.LENGTH_LONG).show();

                            //etUserName.setVisibility(View.GONE);

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                  //      Log.e("erroer res",error);
                        //Toast.makeText(getContext(),""+error, Toast.LENGTH_LONG).show();
                        Pbar.setVisibility(View.GONE);
                        etUserName.setVisibility(View.VISIBLE);
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(getContext()).add(stringRequest);
    }

}
