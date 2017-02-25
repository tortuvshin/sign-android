package mn.signlanguage;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CircleMenuActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CircleMenu circleMenu = (CircleMenu) findViewById(R.id.circlelayout);

        View catAnimal = LayoutInflater.from(this).inflate(R.layout.circle_menu_animal,circleMenu,false);
        View catAlphabet = LayoutInflater.from(this).inflate(R.layout.circle_menu_alphabet,circleMenu,false);
        View catClothes = LayoutInflater.from(this).inflate(R.layout.circle_menu_clothes,circleMenu,false);
        View catColor = LayoutInflater.from(this).inflate(R.layout.circle_menu_color,circleMenu,false);
        View catEmotion = LayoutInflater.from(this).inflate(R.layout.circle_menu_emotion,circleMenu,false);
        View catFamily = LayoutInflater.from(this).inflate(R.layout.circle_menu_family,circleMenu,false);
        View catFruit = LayoutInflater.from(this).inflate(R.layout.circle_menu_fruit,circleMenu,false);
        View catGreeting = LayoutInflater.from(this).inflate(R.layout.circle_menu_greeting,circleMenu,false);
        View catNature = LayoutInflater.from(this).inflate(R.layout.circle_menu_nature,circleMenu,false);
        View catNumber = LayoutInflater.from(this).inflate(R.layout.circle_menu_number,circleMenu,false);
        View catProfession = LayoutInflater.from(this).inflate(R.layout.circle_menu_profession,circleMenu,false);
        View catPronoun = LayoutInflater.from(this).inflate(R.layout.circle_menu_pronoun,circleMenu,false);

        List<View> childList = new ArrayList<>();
        childList.add(catAlphabet);
        childList.add(catAnimal);
        childList.add(catClothes);
        childList.add(catColor);
        childList.add(catEmotion);
        childList.add(catFamily);
        childList.add(catFruit);
        childList.add(catGreeting);
        childList.add(catNature);
        childList.add(catNumber);
        childList.add(catProfession);
        childList.add(catPronoun);

        for(View view :childList){
            view.setOnClickListener(this);
        }

        circleMenu.setChildViewsList(childList);
    }

    @Override
    public void onClick(View v) {
        TextView cat = (TextView)findViewById(R.id.item_text_view);
        String a = cat.getText().toString();
        Toast.makeText(getApplicationContext(), a, Toast.LENGTH_SHORT).show();

    }
}
