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
        setContentView(R.layout.activity_project);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Төслийн тухай");
        webView = (WebView)findViewById(R.id.pWebView);
        String mn = "<!DOCTYPE html>\n" +
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

        String a = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<p>Founded by US. Embassy Grants Program\n</p>\n" +
                "\n" +
                "<p>Project name: Bridging the Gap Darkhan Sign - Language Communication project </p>\n" +
                "<p>Team members:</p>\n" +
                "<p style=\"margin-left: 20px\">\n" +
                "            1. Janar Mukhtar (team leader)<br>\n" +
                "            2. Bolor Battulga<br>\n" +
                "            3. Solongo Dorjpalam<br>\n" +
                "            4. Uranzaya Bayarsaikhan<br>\n" +
                "            5. Bolorchimeg Batmunkh<br>\n" +
                "            6. Oyu-Erdene Batsaikhan<br>\n" +
                "            7. Naranmandakh Ankhbayar<br>\n" +
                "            8. Anar Ganzorig<br>\n" +
                "            9. Namuun Atarzol<br>\n" +
                "            10. Amar-Erdene Tsogtsaikhan<br>\n" +
                "            </p>\n" +
                "<p>Coordinated by::</p>\n" +
                "<p style=\"margin-left:20px\">\n" +
                "            Morgan Thomas<br>\n" +
                "            Chuluuntumur Damdin<br></p>\n" +
                "\n" +
                "<p> Developed by:</p>\n" +
                "<p style=\"margin-left:20px\">\n" +
                "            Ts.Naranmandakh<br>\n" +
                "            B.Turtuvshin <br></p>\n" +
                "\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";
        webView.loadData(mn, "text/html; charset=utf-8", "utf-8");
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
