package com.lzy.headerviewpager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lzy.headerviewpager.Utils;
import com.lzy.headerviewpager.R;
import com.lzy.headerviewpager.fragment.base.HeaderViewPagerFragment;
import android.widget.TextView;
import android.text.TextPaint;


public class ScrollViewFragment extends HeaderViewPagerFragment {

    private View scrollView;

    public static ScrollViewFragment newInstance() {
        return new ScrollViewFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        scrollView = inflater.inflate(R.layout.fragment_scrollview, container, false);
        LinearLayout views = (LinearLayout) scrollView.findViewById(R.id.container);
        String[] msg={"用户信息","区域信息","设备信息","账号余额","充值中心","联系我们","注销"};
        for (int i = 0; i < 7; i++) {
            TextView view = new TextView(getActivity());
            view.setText(msg[i]);
            view.setTextSize(20);

            TextPaint tp = view.getPaint();
            tp.setFakeBoldText(true);
            view.setBackgroundColor(Utils.generateBeautifulColor());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 180);
            view.setLayoutParams(params);
            view.setGravity(5);
            views.addView(view);
        }
        return scrollView;
    }

    @Override
    public View getScrollableView() {
        return scrollView;
    }
}
