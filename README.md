# AndroidRecorder
结合博客：[Android 音视频开发(七)： 音视频录制流程总结](http://www.cnblogs.com/renhui/p/7520690.html) 生成Demo：

1.1 需求说明

我们需要做的事情就是：串联整个音视频录制流程，完成音视频的采集、编码、封包成 mp4 输出。

1.2 实现方式

Android音视频采集的方法：预览用SurfaceView，视频采集用Camera类，音频采集用AudioRecord。

1.3 数据处理思路

使用MediaCodec 类进行编码压缩，视频压缩为H.264，音频压缩为aac，使用MediaMuxer 将音视频合成为MP4。
