package com.example.android_e_learning.adapter;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.example.android_e_learning.R;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class VideoAdapter extends CommonAdapter<String> {
    private Context mContext;

    public VideoAdapter(Context context, List<String> datas, int layoutId) {
        super(context, layoutId, datas);
        this.mContext = context;
    }

    @Override
    protected void convert(ViewHolder viewHolder, String url, int position) {
        JCVideoPlayerStandard player = viewHolder.getView(R.id.player_list_video);
//        if (player != null) {
//            player.release();
//        }
        boolean setUp = player.setUp(url, JCVideoPlayer.SCREEN_LAYOUT_LIST, "");
        if (setUp) {
            Glide.with(mContext).load("http://tang5618.com:8080/HTML/WEB/9.19.png").into(player.thumbImageView);
        }
    }
}
