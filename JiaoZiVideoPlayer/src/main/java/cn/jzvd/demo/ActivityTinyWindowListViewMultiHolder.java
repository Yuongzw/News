package cn.jzvd.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

/**
 * Created by Nathen on 2017/10/31.
 */
public class ActivityTinyWindowListViewMultiHolder extends AppCompatActivity {

    ListView listView;
    VideoListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_normal);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setTitle("MultiHolderListViewTinyWindow");


        listView = findViewById(R.id.listview);
        mAdapter = new VideoListAdapter(this);
        listView.setAdapter(mAdapter);

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Jzvd.onScrollAutoTiny(view, firstVisibleItem, visibleItemCount, totalItemCount);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public class VideoListAdapter extends BaseAdapter {

        int[] viewtype = {0, 0, 0, 1, 0, 0, 0, 1, 0, 0};//1 = jzvdStd, 0 = textView

        Context context;
        LayoutInflater mInflater;

        public VideoListAdapter(Context context) {
            this.context = context;
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return viewtype.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (getItemViewType(position) == 1) {
                VideoHolder viewHolder;
                if (convertView != null && convertView.getTag() != null && convertView.getTag() instanceof VideoListAdapter.VideoHolder) {
                    viewHolder = (VideoHolder) convertView.getTag();
                } else {
                    viewHolder = new VideoHolder();
                    convertView = mInflater.inflate(R.layout.item_videoview, null);
                    viewHolder.jzvdStd = convertView.findViewById(R.id.videoplayer);
                    convertView.setTag(viewHolder);
                }

                viewHolder.jzvdStd.setUp(
                        VideoConstant.videoUrls[0][position],
                        VideoConstant.videoTitles[0][position], "", Jzvd.SCREEN_WINDOW_LIST);
                viewHolder.jzvdStd.positionInList = position;
                Glide.with(ActivityTinyWindowListViewMultiHolder.this).load(VideoConstant.videoThumbs[0][position]).into(viewHolder.jzvdStd.thumbImageView);
            } else {
                TextViewHolder textViewHolder;
                if (convertView != null && convertView.getTag() != null && convertView.getTag() instanceof VideoListAdapter.TextViewHolder) {
                    textViewHolder = (TextViewHolder) convertView.getTag();
                } else {
                    textViewHolder = new TextViewHolder();
                    LayoutInflater mInflater = LayoutInflater.from(context);
                    convertView = mInflater.inflate(R.layout.item_textview, null);
                    textViewHolder.textView = convertView.findViewById(R.id.textview);
                    convertView.setTag(textViewHolder);
                }
            }
            return convertView;
        }

        @Override
        public int getItemViewType(int position) {
            return viewtype[position];
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        class VideoHolder {
            JzvdStd jzvdStd;
        }

        class TextViewHolder {
            TextView textView;
        }
    }
}
