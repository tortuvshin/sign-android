package mn.signlanguage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;

public class DetailsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    String[] filelistInSubfolder;
    ImageView dImage;
    String catName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_vertical);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences sharedPreferences = getSharedPreferences(CircleMenuActivity.PREFER_NAME, 0);
        String item = sharedPreferences.getString("item", "");
        catName = sharedPreferences.getString("item_category", "");
        getSupportActionBar().setTitle(sharedPreferences.getString("item_title", ""));
        dImage = (ImageView)findViewById(R.id.details_image);

        dImage.setImageDrawable(loadGifDrawable(getApplicationContext(), item));

        final AssetManager assetManager = getAssets();

        try {
            String[] filelist = assetManager.list("");
            filelistInSubfolder = assetManager.list(sharedPreferences.getString("item_category", ""));
            if (filelist == null) {
            } else {
                for (int i=0; i<filelist.length; i++) {
                    String filename = filelist[i];
                }
            }
            if (filelistInSubfolder == null) {
            } else {
                for (int i=0; i<filelistInSubfolder.length; i++) {
                    String filename = filelistInSubfolder[i];
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException npe) {
            Toast.makeText(getApplicationContext(), "Алдаа гарлаа !!!", Toast.LENGTH_LONG).show();
        }

        mAdapter = new MyAdapter(filelistInSubfolder,filelistInSubfolder);
        mRecyclerView.setAdapter(mAdapter);
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
                dImage.setImageDrawable(loadGifDrawable(getApplicationContext(), catName+"/"+mTextView.getText().toString()+".gif"));
                getSupportActionBar().setTitle(mTextView.getText().toString());
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
                    .inflate(R.layout.details_list, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.mTextView.setText(mDataset[position].replace(".gif", ""));
//            holder.mImageView.setImageBitmap(loadBitmapFromAssets(getApplicationContext(), catName+"/"+mImages[position]));
            holder.mImageView.setImageDrawable(loadGifDrawable(getApplicationContext(), catName+"/"+mImages[position]));
        }

        public int getItemCount() {
            return mDataset.length;
        }
    }
}
