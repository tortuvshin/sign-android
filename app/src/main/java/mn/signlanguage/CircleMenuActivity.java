package mn.signlanguage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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

        ImageView imageAnimal = (ImageView)findViewById(R.id.animal_image_view);
        ImageView imageAlphabet = (ImageView)findViewById(R.id.alphabet_image_view);
        ImageView imageClothes = (ImageView)findViewById(R.id.clothes_image_view);
        ImageView imageColor = (ImageView)findViewById(R.id.color_image_view);
        ImageView imageEmotion = (ImageView)findViewById(R.id.emotion_image_view);
        ImageView imageFamily = (ImageView)findViewById(R.id.family_image_view);
        ImageView imageFruit = (ImageView)findViewById(R.id.fruit_image_view);
        ImageView imageGreeting = (ImageView)findViewById(R.id.greeting_image_view);
        ImageView imageNature = (ImageView)findViewById(R.id.nature_image_view);
        ImageView imageNumber = (ImageView)findViewById(R.id.number_image_view);
        ImageView imageProfession = (ImageView)findViewById(R.id.profession_image_view);
        ImageView imagePronoun = (ImageView)findViewById(R.id.pronoun_image_view);

        imageAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cat = (TextView)findViewById(R.id.animal_text_view);
                categoryTitle.setText(cat.getText().toString());
                childLayout.setBackgroundResource(R.drawable.cat_animals);
            }
        });

        imageAlphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cat = (TextView)findViewById(R.id.alphabet_text_view);
                categoryTitle.setText(cat.getText().toString());
                childLayout.setBackgroundResource(R.drawable.cat_alphabet);
            }
        });

        imageAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cat = (TextView)findViewById(R.id.animal_text_view);
                categoryTitle.setText(cat.getText().toString());
                childLayout.setBackgroundResource(R.drawable.cat_animals);
                }
        });

        imageClothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cat = (TextView)findViewById(R.id.clothes_text_view);
                categoryTitle.setText(cat.getText().toString());
                childLayout.setBackgroundResource(R.drawable.cat_clothes);
            }
        });
        imageColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cat = (TextView)findViewById(R.id.color_text_view);
                categoryTitle.setText(cat.getText().toString());
                childLayout.setBackgroundResource(R.drawable.cat_colors);
            }
        });

        imageEmotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cat = (TextView)findViewById(R.id.emotion_text_view);
                categoryTitle.setText(cat.getText().toString());
                childLayout.setBackgroundResource(R.drawable.cat_emotions);
            }
        });

        imageFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cat = (TextView)findViewById(R.id.family_text_view);
                categoryTitle.setText(cat.getText().toString());
                childLayout.setBackgroundResource(R.drawable.cat_family);
            }
        });

        imageFruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cat = (TextView)findViewById(R.id.fruit_text_view);
                categoryTitle.setText(cat.getText().toString());
                childLayout.setBackgroundResource(R.drawable.cat_fruits);
            }
        });

        imageGreeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cat = (TextView)findViewById(R.id.greeting_text_view);
                categoryTitle.setText(cat.getText().toString());
                childLayout.setBackgroundResource(R.drawable.cat_greetings);

            }
        });

        imageNature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cat = (TextView)findViewById(R.id.nature_text_view);
                categoryTitle.setText(cat.getText().toString());
                childLayout.setBackgroundResource(R.drawable.cat_nature);
            }
        });

        imageNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cat = (TextView)findViewById(R.id.number_text_view);
                categoryTitle.setText(cat.getText().toString());
                childLayout.setBackgroundResource(R.drawable.cat_numbers);
            }
        });

        imageProfession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cat = (TextView)findViewById(R.id.profession_text_view);
                categoryTitle.setText(cat.getText().toString());
                childLayout.setBackgroundResource(R.drawable.cat_profession);
            }
        });

        imagePronoun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cat = (TextView)findViewById(R.id.pronoun_text_view);
                categoryTitle.setText(cat.getText().toString());
                childLayout.setBackgroundResource(R.drawable.cat_pronouns);
            }
        });


        childLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (categoryTitle.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Ангилал сонгоно уу !", Toast.LENGTH_SHORT).show();
                } else {
                    editor.putString("category", categoryTitle.getText().toString());
                    editor.commit();
                    Intent intent = new Intent(CircleMenuActivity.this, ItemListActivity.class);
                    startActivity(intent);
                }
            }
        });

        ImageButton imageButton = (ImageButton)findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CircleMenuActivity.this, AboutActivity.class);
                startActivity(i);
            }
        });
    }
}
