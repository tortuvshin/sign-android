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
        CircleMenu flingCircleMenuLayout = (CircleMenu) findViewById(R.id.circlelayout);

        View item1 = LayoutInflater.from(this).inflate(R.layout.menu_item_layout,flingCircleMenuLayout,false);
        View item2 = LayoutInflater.from(this).inflate(R.layout.menu_item_layout,flingCircleMenuLayout,false);
        View item3 = LayoutInflater.from(this).inflate(R.layout.menu_item_layout,flingCircleMenuLayout,false);
        View item4 = LayoutInflater.from(this).inflate(R.layout.menu_item_layout,flingCircleMenuLayout,false);
        View item5 = LayoutInflater.from(this).inflate(R.layout.menu_item_layout,flingCircleMenuLayout,false);
        View item6 = LayoutInflater.from(this).inflate(R.layout.menu_item_layout,flingCircleMenuLayout,false);

        List<View> childList = new ArrayList<>();
        childList.add(item1);
        childList.add(item2);
        childList.add(item3);
        childList.add(item4);
        childList.add(item5);
        childList.add(item6);

        for(View view :childList){
            view.setOnClickListener(this);
        }

        flingCircleMenuLayout.setChildViewsList(childList);
    }

    @Override
    public void onClick(View v) {

    }
}
