package mn.signlanguage;

import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dalvik.system.PathClassLoader;

import static android.R.attr.path;
import static mn.signlanguage.MainActivity.PREFER_NAME;

public class DetailsActivity extends AppCompatActivity {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        HashMap<String, String> categories = new HashMap<>();
        categories.put("Амьтад", "animal");
        categories.put("Асуух төлөөний үг", "pronoun");
        categories.put("Байгалийн үзэгдэл", "nature");
        categories.put("Гэр бүл", "family");
        categories.put("Жимс ногоо", "fruit");
        categories.put("Мэндчилгээ", "greeting");
        categories.put("Мэргэжил", "profession");
        categories.put("Сэтгэл хөдлөл", "emotion");
        categories.put("Тоо", "number");
        categories.put("Хувцас", "clothes");
        categories.put("Цагаан толгой", "alphabet");
        categories.put("Өнгө", "color");


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SharedPreferences prefs = getSharedPreferences(PREFER_NAME, 0);
        String select = prefs.getString("select", "");
        String catName = categories.get(select);
        Toast.makeText(getApplicationContext(), catName, Toast.LENGTH_LONG).show();
        getSupportActionBar().setTitle(select);

//        String uri = "@drawable/animal";
//
//        int imageRes = getResources().getIdentifier(uri, null, getPackageName());
//
//        img = (ImageView) findViewById(R.id.imageView2);
//        Drawable res = getResources().getDrawable(imageRes);
//
//        img.setImageDrawable(res);
//
//        AssetManager manager = getAssets();
//
//        InputStream open = null;
//        try {
//            open = manager.open("animal.png");
//            Bitmap bitmap = BitmapFactory.decodeStream(open);
//            img = (ImageView) findViewById(R.id.imageView2);
//            img.setImageBitmap(bitmap);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (open != null) {
//                try {
//                    open.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        Uri path = Uri.parse("android.resource://mn.signlanguage/test/");
        File file = new File(path.getPath());

        boolean b = false;
        if(file.exists())
            b = true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }
}
