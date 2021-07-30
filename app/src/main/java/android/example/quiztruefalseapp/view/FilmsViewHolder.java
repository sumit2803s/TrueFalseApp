package android.example.quiztruefalseapp.view;

import android.example.quiztruefalseapp.R;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FilmsViewHolder extends RecyclerView.ViewHolder {

    private TextView txtFilmsQuestion;
    private ImageButton imgButtonTrue;
    private ImageButton imgButtonFalse;

    public FilmsViewHolder(@NonNull View itemView) {
        super(itemView);

        txtFilmsQuestion=itemView.findViewById(R.id.film_question_text);
        imgButtonTrue=itemView.findViewById(R.id.falseButton);

    }

    public TextView getTxtFilmsQuestion() {
        return txtFilmsQuestion;
    }



    public ImageButton getImgButtonTrue() {
        return imgButtonTrue;
    }



    public ImageButton getImgButtonFalse() {
        return imgButtonFalse;
    }


}
