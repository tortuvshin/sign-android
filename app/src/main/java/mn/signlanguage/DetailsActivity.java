package mn.signlanguage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        SharedPreferences sharedPreferences = getSharedPreferences(CircleMenuActivity.PREFER_NAME, 0);
        String item = sharedPreferences.getString("item", "");

        ImageView dImage = (ImageView)findViewById(R.id.details_image);

        dImage.setImageDrawable(loadGifDrawable(getApplicationContext(), item));
    }

    public GifDrawable loadGifDrawable(Context context, String path) {
        GifDrawable gifFromAssets = null;
        try {
            gifFromAssets = new GifDrawable( getAssets(), path );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gifFromAssets;
    }
}
