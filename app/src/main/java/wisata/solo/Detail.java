package wisata.solo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    ImageView second_back_arrow, second_arrow_up;
    TextView second_title, second_subtitle, second_rating_number, getSecond_rating_number2, more_details;
    RatingBar second_ratingbar;



    Animation from_left, from_right, from_bottons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        second_back_arrow = findViewById(R.id.second_back_Arrow);
        second_arrow_up = findViewById(R.id.second_arrow_up);
        second_title = findViewById(R.id.second_title);
        second_subtitle = findViewById(R.id.second_subtitle);
        second_rating_number = findViewById(R.id.second_rating_number);
        getSecond_rating_number2 = findViewById(R.id.second_rating_number2);
        more_details = findViewById(R.id.more_details);
        second_ratingbar = findViewById(R.id.second_ratingbar);

        second_back_arrow.setOnClickListener(view -> {
            Intent detail = new Intent(Detail.this, MainActivity.class);
            startActivity(detail);
        });

        //Sembunyikan bar status dan navigasi di bawah
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );

        //Load Animation
        from_left = AnimationUtils.loadAnimation(this, R.anim.anim_from_left);
        from_right = AnimationUtils.loadAnimation(this, R.anim.anim_from_right);
        from_bottons = AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom);

        //Set Animation
        second_back_arrow.setAnimation(from_left);
        second_title.setAnimation(from_right);
        second_subtitle.setAnimation(from_right);
        second_ratingbar.setAnimation(from_right);
        second_rating_number.setAnimation(from_right);
        getSecond_rating_number2.setAnimation(from_right);
        second_arrow_up.setAnimation(from_bottons);
        more_details.setAnimation(from_bottons);


        second_arrow_up.setOnClickListener(view -> {
            Intent intent = new Intent(Detail.this, swipeUp.class);

            Pair[] pairs = new Pair[1];
            pairs[0] = new  Pair<View, String>(second_arrow_up, "background_image_transition");

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Detail.this);

            startActivity(intent, options.toBundle());
        });



    }
}