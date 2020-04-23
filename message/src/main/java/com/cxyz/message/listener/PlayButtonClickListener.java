package com.cxyz.message.listener;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.cxyz.context.ChatMessageBean;
import com.cxyz.context.application.BaseApplication;
import com.cxyz.message.starter.IconifyStarter;
import com.cxyz.message.widget.PlayButton;

import java.io.File;

/**
 * Created by dwq on 2017/7/24/024.
 * e-mail:lomapa@163.com
 */

public class PlayButtonClickListener implements View.OnClickListener {
    private PlayButton playButton;
    private boolean leftSide;
    private Context context;
    private String path;

    private AnimationDrawable anim;
    public static PlayButtonClickListener mCurrentPlayButtonClickListner = null;
    private MediaPlayer mediaPlayer = null;
    public static boolean isPlaying = false;
    // 将MediaPlayer播放地址，
    public static String audioPath;
    private ImageView ivIsListened;
    private ChatMessageBean chatMessageBean;
    private IconifyStarter iconifyStarter;
    public PlayButtonClickListener(PlayButton playButton, ImageView ivIsListened, ChatMessageBean chatMessageBean, boolean leftSide, Context context, String path) {
        this.playButton = playButton;
        this.leftSide = leftSide;
        this.context = context;
        this.path = path;
        this.ivIsListened = ivIsListened;
        this.chatMessageBean = chatMessageBean;
    }

    @Override
    public void onClick(View v) {
        if (isPlaying) {
            if (TextUtils.equals(audioPath, path)) {
                mCurrentPlayButtonClickListner.stopPlayVoice();
                return;
            }
            mCurrentPlayButtonClickListner.stopPlayVoice();
        }
        playButton.startRecordAnimation();
        playVoice(path);
        if (leftSide && ivIsListened != null) {
            ivIsListened.setVisibility(View.INVISIBLE);
            chatMessageBean.setIsListened(true);
//            context
            BaseApplication.getInstance().getDaoSession().update(chatMessageBean);
        }
    }

    public void stopPlayVoice() {
        playButton.stopRecordAnimation();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        isPlaying = false;
    }

    public void playVoice(String filePath) {
        if (!(new File(filePath).exists())) {
            return;
        }
        mediaPlayer = new MediaPlayer();
        this.audioPath = path;
        try {
            mediaPlayer.setDataSource(filePath);
            mediaPlayer.prepare();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer mp) {
                    // TODO Auto-generated method stub
                    mediaPlayer.release();
                    mediaPlayer = null;
                    stopPlayVoice(); // stop animation
                }

            });
            isPlaying = true;
            mCurrentPlayButtonClickListner = this;
            mediaPlayer.start();
            playButton.startRecordAnimation();
        } catch (Exception e) {
            System.out.println();
        }
    }


}
