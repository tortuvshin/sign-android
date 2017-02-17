package mn.signlanguage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;

import static mn.signlanguage.MainActivity.PREFER_NAME;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        HashMap<String, String> categories = new HashMap<>();
        categories.put("Амьтад", "animals");
        categories.put("Асуух төлөөний үг", "pronouns");
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
