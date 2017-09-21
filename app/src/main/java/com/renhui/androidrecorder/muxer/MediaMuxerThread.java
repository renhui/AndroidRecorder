package com.renhui.androidrecorder.muxer;


/**
 * 音视频混合线程
 */
public class MediaMuxerThread extends Thread {

    private MediaMuxerThread mediaMuxerThread;

    private MediaMuxerThread() {
        // 构造函数
    }

    // 开始音视频混合任务
    public void startMuxer() {
        if (mediaMuxerThread == null) {
            synchronized (MediaMuxerThread.class) {
                if (mediaMuxerThread == null) {
                    mediaMuxerThread = new MediaMuxerThread();
                    mediaMuxerThread.start();
                }
            }
        }
    }

    // 停止音视频混合任务
    public void stopMuxer() {
        if (mediaMuxerThread != null) {
            mediaMuxerThread.exit();
            try {
                mediaMuxerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mediaMuxerThread = null;
        }
    }

    // 添加视频帧数据
    public void addVideoFrameData(byte[] data) {
        if (mediaMuxerThread != null) {
            mediaMuxerThread.addVideoData(data);
        }
    }

    // 添加视频数据
    private void addVideoData(byte[] data) {
//        if (videoThread != null) {
//            videoThread.add(data);
//        }
    }

    private void initMuxer() {
//        muxerDatas = new Vector<>();
//        fileSwapHelper = new FileSwapHelper();
//
//        audioThread = new AudioRunnable(new WeakReference<MediaMuxerRunnable>(this));
//        videoThread = new VideoRunnable(CameraWrapper.IMAGE_WIDTH, CameraWrapper.IMAGE_HEIGHT, new WeakReference<MediaMuxerRunnable>(this));
//
//        audioThread.start();
//        videoThread.start();
//
//        try {
//            readyStart();
//        } catch (IOException e) {
//            Log.e("angcyo-->", "initMuxer 异常:" + e.toString());
//            restart();
//        }
    }

    @Override
    public void run() {
        super.run();
        // 初始化混合器
        initMuxer();
    }

    private void exit() {
        //TODO 退出其他正在执行的线程
    }


}
