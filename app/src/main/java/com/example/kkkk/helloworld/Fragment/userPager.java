package com.example.kkkk.helloworld.Fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kkkk.helloworld.Activity.MyNoticeActivity;
import com.example.kkkk.helloworld.Activity.TrackActivity;
import com.example.kkkk.helloworld.Activity.WorkOrderActivity;
import com.example.kkkk.helloworld.Activity.WorkReportActivity;
import com.example.kkkk.helloworld.Activity.settingActivity;
import com.example.kkkk.helloworld.Activity.userinfoActivity;
import com.example.kkkk.helloworld.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by kkkk on 2017/11/5.
 */

public class userPager extends Fragment {

    @BindView(R.id.userinfo)
    LinearLayout userinfo;
    @BindView(R.id.activity_open_vip_headicon)
    CircleImageView icon;
    Intent intent;
    Bitmap mBitmap;
    String name_;
    @BindView(R.id.name)
    TextView name;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.userinfo, R.id.set,R.id.workOrder,R.id.wordReport,R.id.myTrack,R.id.myNotice})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.workOrder:
                intent = new Intent(getActivity(), WorkOrderActivity.class);
                startActivity(intent);
                break;
            case R.id.wordReport:
                intent = new Intent(getActivity(), WorkReportActivity.class);
                startActivity(intent);
                break;
            case R.id.myTrack:
                intent = new Intent(getActivity(), TrackActivity.class);
                startActivity(intent);
                break;
            case R.id.myNotice:
                intent = new Intent(getActivity(), MyNoticeActivity.class);
                startActivity(intent);
                break;
            case R.id.userinfo:
                intent = new Intent(getActivity(), userinfoActivity.class);
                //startActivity(intent);
                startActivityForResult(intent, 0);
                break;
            case R.id.set:
                intent = new Intent(getActivity(), settingActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 0:
                Bundle extras = data.getExtras();
                if (extras != null) {
                    mBitmap = extras.getParcelable("icon");
                    name_ = extras.getString("name");
                    if (mBitmap != null) {
                        icon.setImageBitmap(mBitmap);
                    }
                    if (name_.equals("请填写") && name_ == null) {
                            return;
                    } else {
                            name.setText(name_);
                    }
                }
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}

