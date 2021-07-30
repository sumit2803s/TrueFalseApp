package android.example.quiztruefalseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.example.quiztruefalseapp.controller.CardStackAdapter;
import android.example.quiztruefalseapp.module.QuizManager;
import android.example.quiztruefalseapp.module.QuizQuestion;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {




    private QuizManager mQuizManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuizManager=new QuizManager(this);
        mQuizManager.getQuizQuestion(this);









    }
}
