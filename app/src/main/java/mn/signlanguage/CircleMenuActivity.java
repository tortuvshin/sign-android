package mn.signlanguage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mn.signlanguage.widgets.CircleMenu;

public class CircleMenuActivity extends AppCompatActivity{

    public static final String PREFER_NAME = "SignLanguage";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sharedPreferences = getSharedPreferences(PREFER_NAME, 0);
        editor = sharedPreferences.edit();

        CircleMenu circleMenu = (CircleMenu) findViewById(R.id.circlelayout);
        final RelativeLayout childLayout = (RelativeLayout) findViewById(R.id.circlelayoutChild);
        final TextView categoryTitle = (TextView)findViewById(R.id.categoryTitle);

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

        circleMenu.setChildViewsList(childList);

        catAlphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cat = (TextView)findViewById(R.id.alphabet_text_view);
                categoryTitle.setText(cat.getText().toString());
                childLayout.setBackgroundResource(R.drawable.cat_alphabet);
            }
        });

        catAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cat = (TextView)findViewById(R.id.animal_text_view);
                categoryTitle.setText(cat.getText().toString());
                childLayout.setBackgroundResource(R.drawable.cat_animals);
                }
        });

        catClothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cat = (TextView)findViewById(R.id.clothes_text_view);
                categoryTitle.setText(cat.getText().toString());
                childLayout.setBackgroundResource(R.drawable.cat_clothes);
            }
        });
        catColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cat = (TextView)findViewById(R.id.color_text_view);
                categoryTitle.setText(cat.getText().toString());
                childLayout.setBackgroundResource(R.drawable.cat_colors);
            }
        });

        catEmotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cat = (TextView)findViewById(R.id.emotion_text_view);
                categoryTitle.setText(cat.getText().toString());
                childLayout.setBackgroundResource(R.drawable.cat_emotions);
            }
        });

        catFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cat = (TextView)findViewById(R.id.family_text_view);
                categoryTitle.setText(cat.getText().toString());
                childLayout.setBackgroundResource(R.drawable.cat_family);
            }
        });

        catFruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cat = (TextView)findViewById(R.id.fruit_text_view);
                categoryTitle.setText(cat.getText().toString());
                childLayout.setBackgroundResource(R.drawable.cat_fruits);
            }
        });

        catGreeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cat = (TextView)findViewById(R.id.greeting_text_view);
                categoryTitle.setText(cat.getText().toString());
                childLayout.setBackgroundResource(R.drawable.cat_greetings);

            }
        });

        catNature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cat = (TextView)findViewById(R.id.nature_text_view);
                categoryTitle.setText(cat.getText().toString());
                childLayout.setBackgroundResource(R.drawable.cat_nature);
            }
        });

        catNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cat = (TextView)findViewById(R.id.number_text_view);
                categoryTitle.setText(cat.getText().toString());
                childLayout.setBackgroundResource(R.drawable.cat_numbers);
            }
        });

        catProfession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cat = (TextView)findViewById(R.id.profession_text_view);
                categoryTitle.setText(cat.getText().toString());
                childLayout.setBackgroundResource(R.drawable.cat_profession);
            }
        });

        catPronoun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cat = (TextView)findViewById(R.id.pronoun_text_view);
                categoryTitle.setText(cat.getText().toString());
                childLayout.setBackgroundResource(R.drawable.cat_pronouns);
            }
        });
    }

    public void startDetails(String a){
        editor.putString("category", a);
        editor.commit();
        Intent intent = new Intent(CircleMenuActivity.this, ItemListActivity.class);
        startActivity(intent);
    }
}
