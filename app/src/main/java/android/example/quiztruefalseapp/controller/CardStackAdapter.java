package android.example.quiztruefalseapp.controller;

import android.content.Context;
import android.example.quiztruefalseapp.R;
import android.example.quiztruefalseapp.module.QuizQuestion;
import android.example.quiztruefalseapp.view.FilmsViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardStackAdapter extends RecyclerView.Adapter<FilmsViewHolder> {

    private Context mContext;
    private List<QuizQuestion> mFilmQuestions;
    private LayoutInflater mLayoutInflater;
    public CardStackAdapter(Context context,List<QuizQuestion> filmQuestions){
        mContext=context;
        mFilmQuestions=filmQuestions;
        mLayoutInflater=LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public FilmsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view=mLayoutInflater.inflate(R.layout.film_view,parent,false);


        return new FilmsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmsViewHolder holder, int position) {

        holder.getTxtFilmsQuestion().setText(mFilmQuestions.get(position).getQuestionText());

        holder.getImgButtonTrue().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (mFilmQuestions.get(position).isTrueAnswer()){
                    Toast.makeText(mContext,"You have answered Correctly.Congratulations!",Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(mContext,"Sorry. You were wrong.Try again!!",Toast.LENGTH_SHORT).show();
                }
            }
        });
          holder.getImgButtonFalse().setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {

                  if (mFilmQuestions.get(position).isTrueAnswer()){
                      Toast.makeText(mContext,"Sorry. You were wrong.Try again!!",Toast.LENGTH_SHORT).show();

                  }else {
                      Toast.makeText(mContext,"You have answered Correctly.Congratulations!",Toast.LENGTH_SHORT).show();
                  }
              }
          });
    }

    @Override
    public int getItemCount() {
        return mFilmQuestions.size();
    }
}
