package android.example.quiztruefalseapp.module;

import android.app.Activity;
import android.content.Context;
import android.example.quiztruefalseapp.MyApplication;
import android.example.quiztruefalseapp.R;
import android.example.quiztruefalseapp.VolleySingleton;
import android.example.quiztruefalseapp.controller.CardStackAdapter;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class QuizManager {

    Context mContext;
    private RequestQueue mRequestQueue;
    private String murl;

    public QuizManager(Context context) {

        mContext=context;
        mRequestQueue = VolleySingleton.getInstance().getRequestQueue();
        murl="https://opentdb.com/api.php?amount=10&category=18&type=boolean";





    }

    public void getQuizQuestion(Activity activity){

        List<QuizQuestion> quizQuestions=new ArrayList<>();
        JsonObjectRequest filmsJsonObjectRequest=new JsonObjectRequest(Request.Method.GET, murl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.i("FILMS",response+"");

                try {
                    JSONArray results=response.getJSONArray("results");

                    for (int index=0;index<results.length();index++){

                        JSONObject questionJsonObject=results.getJSONObject(index);
                        String questionText=questionJsonObject.getString("Question");
                        boolean questionAnswer=questionJsonObject.getBoolean("correct_answer");
                        QuizQuestion myQuestion=new QuizQuestion(questionText,questionAnswer);
                        quizQuestions.add(myQuestion);

                    }

                    CardStackView mCardStackView=activity.findViewById(R.id.myCardStackViewView);
                    mCardStackView.setLayoutManager(new CardStackLayoutManager(mContext));
                    mCardStackView.setAdapter(new CardStackAdapter(mContext,quizQuestions));


                } catch (JSONException e){

                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MyApplication.getAppContext(), error + "" , Toast.LENGTH_LONG).show();


            }
        });

        mRequestQueue.add(filmsJsonObjectRequest);


    }
}