package uz.app.m1lesson31;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Animation.AnimationListener {

    ImageView imageView1, imageView2;
    Animation animation;
    private boolean a = false,b= false;
    private ArrayList<ImageView> list;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imageView1 = findViewById(R.id.img1);
        imageView2 = findViewById(R.id.img2);
         list = new ArrayList<>();

        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale1);

        if (id == R.id.img1) {
            a = true;

            list.add(imageView1);
            imageView1.startAnimation(animation);

            animation.setAnimationListener(this);


        } else if (R.id.img2 == id) {
            b = true;
            list.add(imageView2);
            imageView2.startAnimation(animation);
            animation.setAnimationListener(this);

        }
    }

    @Override
    public void onAnimationEnd(Animation animation) {

        if (list.size() == 2) {
            Toast.makeText(this, "Succses", Toast.LENGTH_SHORT).show();
            if (list.get(0).getTag()==list.get(1).getTag()){
                list.get(0).setVisibility(View.INVISIBLE);
                list.get(1).setVisibility(View.INVISIBLE);

            }
        } else {


            Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.scale2);
            if (a) {
                imageView1.setImageResource(R.drawable.img);
                imageView1.startAnimation(animation1);
                list.add(imageView1);
                a = false;
            } else if (b) {
                imageView2.setImageResource(R.drawable.img);
                imageView2.startAnimation(animation1);
                list.add(imageView2);
                b = false;
            }
            animation1.setAnimationListener(this);
            //
        }
    }
        @Override
        public void onAnimationRepeat (Animation animation){


    }
    @Override
    public void onAnimationStart(Animation animation) {

    }
}

