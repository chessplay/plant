package com.lzy.headerviewpager.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageButton;
import com.lzy.headerviewpager.R;
import com.lzy.headerviewpager.Utils;
import com.lzy.headerviewpager.fragment.base.HeaderViewPagerFragment;

import java.util.ArrayList;
import android.widget.ImageView;

public class ListViewFragment extends HeaderViewPagerFragment {

    private ListView listView;

    public static ListViewFragment newInstance() {
        return new ListViewFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listview, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(new MyAdapter());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "点击了条目" + position, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public View getScrollableView() {
        return listView;
    }

    public class MyAdapter extends BaseAdapter {

        private ArrayList<String> strings;
        private int[] imgres={
                R.mipmap.plant1,R.mipmap.plant2,R.mipmap.plant3,R.mipmap.plant4,R.mipmap.plant5,R.mipmap.plant6
        };

        public MyAdapter() {
            strings = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                strings.add("条目" + i);
            }
        }

        @Override
        public int getCount() {
            return strings.size();
        }

        @Override
        public String getItem(int position) {
            return strings.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
              //  convertView = View.inflate(getActivity(), android.R.layout.simple_list_item_1, null);
                convertView = View.inflate(getActivity(), R.layout.listviewitem, null);
            }
           ImageView imgview= (ImageView)convertView.findViewById(R.id.lsimgview);
          //  TextView textView = (TextView) convertView;
            imgview.setImageResource(imgres[position]);
            imgview.setAdjustViewBounds(true);

           // textView.setTextColor(Color.WHITE);
          //  ViewGroup.LayoutParams params = new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 300);
           // imgbtn.setLayoutParams(params);
           // textView.setText(getItem(position));
            //textView.setBackgroundColor(Utils.generateBeautifulColor());
            return convertView;
        }
    }
}
