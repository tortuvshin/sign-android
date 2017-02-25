package mn.signlanguage;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

import static mn.signlanguage.R.id.imageView;

public class ImageActivity extends AppCompatActivity {

    ImageView image;
    private ImageView imageViewbyCode;
    private RelativeLayout myLayout;
    private AssetManager assetManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        image = (ImageView)findViewById(imageView);
        myLayout = (RelativeLayout)findViewById(R.id.content_image);
        assetManager = getAssets();
    }

    public void displayOneImage(View v) {

        try {
            InputStream is = assetManager.open("img/family.png");
            Bitmap  bitmap = BitmapFactory.decodeStream(is);
            image.setImageBitmap(bitmap);
        } catch (IOException e) {
            Log.e("dsad", e.getMessage());
        }
    }
    public void listAllImages(View v) {
        if (image != null) {
            image.setVisibility(View.GONE);
        }
        try {
            String[] imgPath = assetManager.list("img");
            for (int i = 0; i< imgPath.length; i++) {
                InputStream is = assetManager.open("img/"+imgPath[i]);
                Log.d("dsa", imgPath[i]);
                Bitmap  bitmap = BitmapFactory.decodeStream(is);

                imageViewbyCode = new ImageView(this);
                imageViewbyCode.setImageBitmap(bitmap);
                LinearLayout.LayoutParams params =  new LinearLayout
                        .LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT);
                imageViewbyCode.setLayoutParams(params);
                myLayout.addView(imageViewbyCode);
            }
        } catch (IOException e) {
            Log.e("dsa", e.getMessage());
        }
    }

}
