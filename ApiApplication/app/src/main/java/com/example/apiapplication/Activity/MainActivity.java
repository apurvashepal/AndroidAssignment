package com.example.apiapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.apiapplication.WebHttp.JsonPlaceHolderApi;
import com.example.apiapplication.Model.Post;
import com.example.apiapplication.R;
import com.example.apiapplication.WebHttp.RetrofitClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textViewReault, textViewResultSingle;
    private Button getData, getData1, postData, putData, deleteData;
    private EditText getId;
    private ScrollView scrollView1, scrollView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewReault = findViewById(R.id.text_result);
        textViewResultSingle = findViewById(R.id.text_result_single);
        getData = findViewById(R.id.getData);
        getData.setOnClickListener(this);
        getData1 = findViewById(R.id.getData1);
        getData1.setOnClickListener(this);
        postData=findViewById(R.id.postData);
        postData.setOnClickListener(this);
        scrollView1=findViewById(R.id.scrollView1);
        scrollView2=findViewById(R.id.scrollView2);


    }

    @Override
    public void onClick(View view) {

        JsonPlaceHolderApi jsonPlaceHolderApi = RetrofitClient.getClient().create(JsonPlaceHolderApi.class);
        switch (view.getId()) {
            case R.id.getData:
                Call<ResponseBody> call= jsonPlaceHolderApi.getPosts();
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if( response.body()!=null) try {
                            JSONArray jsonArray = new JSONArray(response.body().string());
                           JSONObject jsonObject;

                            List<Post> jsonList = new ArrayList<>();
                            for (int i = 0; i < jsonArray.length(); i++) {


                            }
                            for(int count=0;count<jsonList.size();count++){
                                textViewReault.setText((CharSequence) jsonList.get(count));
                            }
                            // textViewReault.setText(post);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });

                break;
            case R.id.getData1:
                getId = findViewById(R.id.dataId);
                scrollView1.setVisibility(View.GONE);
                scrollView2.setVisibility(View.VISIBLE);
                int id = Integer.valueOf(getId.getText().toString());
                Call<ResponseBody> call1= jsonPlaceHolderApi.getPost(id);
                call1.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.body() != null){
                            try {
                                Post post= new Post(new JSONObject(response.body().string()));
                                String content= post.toString();
                                textViewResultSingle.setText(content);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
                break;

            case R.id.postData:


        }


    }
}
