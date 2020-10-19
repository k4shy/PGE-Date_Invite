package za.co.kashvirsingh.pge_dateinvite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        ImageView bannerView = (ImageView) findViewById(R.id.banner);
        ImageView sideView = (ImageView) findViewById(R.id.funky_gif);
        TextView inviteText = (TextView) findViewById(R.id.invite_text);
        Glide.with(this).asGif().load(R.drawable.sushi_banner).into(bannerView);
        Glide.with(this).asGif().load(R.drawable.sushi).into(sideView);
        sideView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        inviteText.setMovementMethod(new ScrollingMovementMethod());

        themeChange(sideView);
    }

    private void themeChange(ImageView button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
                switch (currentNightMode) {
                    case Configuration.UI_MODE_NIGHT_NO:
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        break;
                    case Configuration.UI_MODE_NIGHT_YES:
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        break;
                }
            }
        });
    }
}