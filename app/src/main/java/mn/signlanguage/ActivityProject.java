package mn.signlanguage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebView;

public class ActivityProject extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_project);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Төслийн тухай");
        webView = (WebView)findViewById(R.id.pWebView);
        String a = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<p>Санхүүжүүлсэн: Монгол дахь Америкийн Элчин сайдын яам: \"Нийгэмд үйлчлэх оюутнууд\" тэтгэлэг</p>\n" +
                "\n" +
                "<p>Төслийн нэр: \"Нөхөрлөлийн гүүр\"</p>\n" +
                "<p>Багийн гишүүд:</p>\n" +
                "<p style=\"margin-left: 20px\">\n" +
                "            1. Мухтар Жанар (багийн ахлагч)<br>\n" +
                "            2. Баттулга Болор<br>\n" +
                "            3. Доржпалам Солонго<br>\n" +
                "            4. Баярсайхан Уранзаяа<br>\n" +
                "            5. Батмөнх Болорчимэг<br>\n" +
                "            6. Батсайхан Оюу-Эрдэнэ<br>\n" +
                "            7. Анхбаяр Наранмандах<br>\n" +
                "            8. Ганзориг Анар<br>\n" +
                "            9. Атарзол Намуун<br>\n" +
                "            10. Цогтсайхан Амар-Эрдэнэ<br>\n" +
                "            </p>\n" +
                "<p>Төслийн удирдагч:</p>\n" +
                "<p style=\"margin-left:20px\">\n" +
                "            Дамдингийн Чулуунтөмөр<br>\n" +
                "            Морган Томас<br></p>\n" +
                "\n" +
                "<p> Програм хөгжүүлэгч:</p>\n" +
                "<p style=\"margin-left:20px\">\n" +
                "            Ц.Наранмандах<br>\n" +
                "            Б.Төртүвшин <br></p>\n" +
                "\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";
        webView.loadData(a, "text/html; charset=utf-8", "utf-8");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
