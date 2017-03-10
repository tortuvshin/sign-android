package mn.signlanguage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static mn.signlanguage.MainActivity.PREFER_NAME;

public class ItemListActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        initComponents();
    }


    private void initComponents(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);

        String[] myDataset={"1","2","3","4","5","6","7","8","9",
                "10","11","12","13","14","15","16","17","18","19",
                "20","21","22","23","24","25","26","27", "28","29"};
        mRecyclerView = (RecyclerView) findViewById(R.id.list_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this,3);
        mRecyclerView.setLayoutManager(mLayoutManager);
//        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

        HashMap<String, String> categories = new HashMap<>();
        categories.put("Амьтад", "catAnimals");
        categories.put("Асуух төлөөний үг", "catPronouns");
        categories.put("Байгалийн үзэгдэл", "catNature");
        categories.put("Гэр бүл", "catFamily");
        categories.put("Жимс ногоо", "catFruits");
        categories.put("Мэндчилгээ", "catGreetings");
        categories.put("Мэргэжил", "catProfession");
        categories.put("Сэтгэл хөдлөл", "catEmotions");
        categories.put("Тоо", "catNumbers");
        categories.put("Хувцас", "catClothes");
        categories.put("Цагаан толгой", "catAlphabet");
        categories.put("Өнгө", "catColors");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SharedPreferences prefs = getSharedPreferences(PREFER_NAME, 0);
        String select = prefs.getString("select", "");
        String catName = categories.get(select);
        Toast.makeText(getApplicationContext(), catName, Toast.LENGTH_LONG).show();
        getSupportActionBar().setTitle(select);
//        try {
//            getImages(catName);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
        final AssetManager assetManager = getAssets();
        try {

            String[] filelist = assetManager.list("");

            String[] filelistInSubfolder = assetManager.list(catName);
            if (filelist == null) {

            } else {
                for (int i=0; i<filelist.length; i++) {

                    String filename = filelist[i];
                    Log.d("File name: ", filename);

                }
            }
            if (filelistInSubfolder == null) {

            } else {
                for (int i=0; i<filelistInSubfolder.length; i++) {

                    String filename = filelistInSubfolder[i];
                    Log.d("File sub name: ", filename);
                }
            }
            // if(filelistInSubfolder == null) ............

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * assets folder -оос зуругнууд авах
     * @param folderName зураг агуулагдах folder-ын нэр
     * @return зураг болон зургийн нэр агуулах {@link Map <String,  Drawable >}
     * */
    private Map<String, Drawable> getImages(String folderName) throws IOException {
        Map<String, Drawable> drawableImages = new HashMap<String, Drawable>();
        for(String fileName: getAssets().list(folderName))
            if(fileName.endsWith(".jpg")) {
                InputStream is = getAssets().open(fileName);
                drawableImages.put(fileName.replace(".jpg", ""), Drawable.createFromStream(is, null));
            }

            Log.d("Categories ","a");
        return drawableImages;
    }


    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private String[] mDataset;
        private int[] mImages;

        public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            public TextView mTextView;
            public ImageView mImageView;
            public ViewHolder(View v) {
                super(v);
                v.setOnClickListener(this);
                mTextView = (TextView)v.findViewById(R.id.txt);
                mImageView = (ImageView)v.findViewById(R.id.img);
            }

            @Override
            public void onClick(View v) {

            }
        }

        public MyAdapter(String[] myDataset, int[] myImages) {
            mDataset = myDataset;
            mImages = myImages;
        }

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.main_list, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.mTextView.setText(mDataset[position]);
            holder.mImageView.setImageResource(mImages[position]);
        }

        public int getItemCount() {
            return mDataset.length;
        }
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
