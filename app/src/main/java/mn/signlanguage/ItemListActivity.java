package mn.signlanguage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import pl.droidsonroids.gif.GifDrawable;

import static mn.signlanguage.MainActivity.PREFER_NAME;

public class ItemListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    String[] filelistInSubfolder;
    String catName;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        initComponents();
    }

    private void initComponents(){

        mRecyclerView = (RecyclerView) findViewById(R.id.list_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this,3);
        mRecyclerView.setLayoutManager(mLayoutManager);

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

        prefs = getSharedPreferences(PREFER_NAME, 0);
        editor = prefs.edit();
        String select = prefs.getString("category", "");

        catName = categories.get(select);
        getSupportActionBar().setTitle(select);

        final AssetManager assetManager = getAssets();

        try {
            filelistInSubfolder = assetManager.list(catName);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException npe) {
            Toast.makeText(getApplicationContext(), "Алдаа гарлаа !!!", Toast.LENGTH_LONG).show();
        }

        Collections.sort(Arrays.asList(filelistInSubfolder), String.CASE_INSENSITIVE_ORDER);

        mAdapter = new MyAdapter(filelistInSubfolder,filelistInSubfolder);
        mRecyclerView.setAdapter(mAdapter);
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private String[] mDataset;
        private String[] mImages;

        public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            public TextView mTextView;
            public ImageView mImageView;
            public ViewHolder(View v) {
                super(v);
                v.setOnClickListener(this);
                mTextView = (TextView)v.findViewById(R.id.txt);
                mImageView = (ImageView) v.findViewById(R.id.img);
            }

            @Override
            public void onClick(View v) {
                editor.putString("item", catName+"/"+mTextView.getText().toString());
                editor.putString("item_title", mTextView.getText().toString());
                editor.putString("item_category", catName);
                editor.commit();
                Intent i = new Intent(ItemListActivity.this, DetailsActivity.class);
                startActivity(i);
            }
        }

        public MyAdapter(String[] myDataset, String[] myImages) {
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
            if(mImages[position].contains(".JPG")) {

                holder.mTextView.setText(mDataset[position].replaceAll("([.])([A-Za-z])*", ""));
                holder.mImageView.setImageBitmap(loadBitmapFromAssets(getApplicationContext(), catName+"/"+mImages[position]));

            } else {

                holder.mTextView.setText(mDataset[position].replaceAll("([.])([A-Za-z])*", "."));
                holder.mImageView.setImageDrawable(loadGifDrawable(getApplicationContext(), catName+"/"+mImages[position]));
            }
        }

        public int getItemCount() {
            return mDataset.length;
        }
    }

    public GifDrawable loadGifDrawable(Context context, String path) {
        GifDrawable gifFromAssets = null;
        try {
            gifFromAssets = new GifDrawable( getAssets(), path );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gifFromAssets;
    }

    public Bitmap loadBitmapFromAssets(Context context, String path)
    {
        InputStream stream = null;
        try
        {
            stream = context.getAssets().open(path);
            return BitmapFactory.decodeStream(stream);
        }
        catch (Exception ignored) {} finally
        {
            try
            {
                if(stream != null)
                {
                    stream.close();
                }
            } catch (Exception ignored) {}
        }
        return null;
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
