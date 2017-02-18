package mn.signlanguage;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

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

        View item1 = LayoutInflater.from(this).inflate(R.layout.menu_item_layout,circleMenu,false);
        View item2 = LayoutInflater.from(this).inflate(R.layout.menu_item_layout,circleMenu,false);
        View item3 = LayoutInflater.from(this).inflate(R.layout.menu_item_layout,circleMenu,false);
        View item4 = LayoutInflater.from(this).inflate(R.layout.menu_item_layout,circleMenu,false);
        View item5 = LayoutInflater.from(this).inflate(R.layout.menu_item_layout,circleMenu,false);
        View item6 = LayoutInflater.from(this).inflate(R.layout.menu_item_layout,circleMenu,false);
        View item7 = LayoutInflater.from(this).inflate(R.layout.menu_item_layout,circleMenu,false);
        View item8 = LayoutInflater.from(this).inflate(R.layout.menu_item_layout,circleMenu,false);
        View item9 = LayoutInflater.from(this).inflate(R.layout.menu_item_layout,circleMenu,false);
        View item10 = LayoutInflater.from(this).inflate(R.layout.menu_item_layout,circleMenu,false);
        View item11 = LayoutInflater.from(this).inflate(R.layout.menu_item_layout,circleMenu,false);
        View item12 = LayoutInflater.from(this).inflate(R.layout.menu_item_layout,circleMenu,false);

        List<View> childList = new ArrayList<>();
        childList.add(item1);
        childList.add(item2);
        childList.add(item3);
        childList.add(item4);
        childList.add(item5);
        childList.add(item6);
        childList.add(item7);
        childList.add(item8);
        childList.add(item9);
        childList.add(item10);
        childList.add(item11);
        childList.add(item12);

        for(View view :childList){
            view.setOnClickListener(this);
        }

        circleMenu.setChildViewsList(childList);
    }

    @Override
    public void onClick(View v) {

    }
}
