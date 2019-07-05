package com.news.yuong.news.bean;

import java.util.List;

public class VideoDataBean {


    private List<VideoBean> Video;

    public List<VideoBean> getVideo() {
        return Video;
    }

    public void setVideo(List<VideoBean> Video) {
        this.Video = Video;
    }

    public static class VideoBean {
        /**
         * accoutClassify : 1
         * autoPlay : 0
         * category : 科技/人工智能
         * cover : http://vimg.nosdn.127.net/enhanced/UHGxC363JGxctL.jpg
         * danmu : 1
         * extraTags : ["科学实验","创意发明","科技发明","创意科技"]
         * firstFrameImg : http://vimg.nosdn.127.net/preview/20181027/UHGxC363J_1stframe.jpg
         * fullSizeImg : http://vimg.nosdn.127.net/enhanced/UHGxC363JGxctL.jpg
         * length : 271
         * m3u8Hd_url : http://flv0.bn.netease.com/videolib1/1810/27/UHGxC363J/HD/movie_index.m3u8
         * m3u8_url : http://flv0.bn.netease.com/videolib1/1810/27/UHGxC363J/SD/movie_index.m3u8
         * mp4Hd_url : http://flv3.bn.netease.com/videolib1/1810/27/UHGxC363J/HD/UHGxC363J-mobile.mp4
         * mp4_url : http://flv3.bn.netease.com/videolib1/1810/27/UHGxC363J/SD/UHGxC363J-mobile.mp4
         * playCount : 110838
         * playersize : 1
         * program : base
         * prompt : 成功为您推荐10条新视频
         * ptime : 2018-10-27 19:30:28.0
         * recomCount : 0
         * replyBoard : video_bbs
         * replyCount : 2410
         * replyid : GU7FB47V050835RB
         * reqId : 26763ea0-2440-4169-ba41-e5908274140c
         * sectiontitle : /image/snapshot/2017/3/K/P/VCEM2T4KP
         * shortV : false
         * sizeHD : 24431
         * sizeSD : 13694
         * sizeSHD : 45251
         * title : AI觉醒！波士顿动力智能机器人，五年里进化神速，看完心里毛毛的
         * topicDesc : 每个人对生活对世事都有不同的理解和看法，不过，对于幸福生活的追求都是一样。所以，我们算得上志同道合。
         * topicImg : /image/snapshot/2017/3/K/P/VCEM2T4KP
         * topicName : 燕山小春秋
         * topicSid : VCEM2T4KF
         * unlikeReason : ["人工智能视频/1","科学实验/2","新科技/2","智能机器人/3","来源:燕山小春秋/4","内容质量差/6","看过了/6","低俗重口/6"]
         * vid : VGU7FB47V
         * videoRatio : 1.78
         * videoTag : ["科学实验"]
         * videoTopic : {"alias":"生活这件事，咱们认真对待","ename":"T1489556908762","followed":false,"tid":"T1489556908762","tname":"燕山小春秋","topic_icons":"http://dingyue.nosdn.127.net/Fm0hi0k3af7PFu5ehGgxkno8edjbnWDYUoz9Pnru=J2OL1489556908314.jpg"}
         * videosource : 新媒体
         * voteCount : 11141
         */

        private int accoutClassify;
        private int autoPlay;
        private String category;
        private String cover;
        private int danmu;
        private String firstFrameImg;
        private String fullSizeImg;
        private int length;
        private String m3u8Hd_url;
        private String m3u8_url;
        private String mp4Hd_url;
        private String mp4_url;
        private int playCount;
        private int playersize;
        private String program;
        private String prompt;
        private String ptime;
        private int recomCount;
        private String replyBoard;
        private int replyCount;
        private String replyid;
        private String reqId;
        private String sectiontitle;
        private boolean shortV;
        private int sizeHD;
        private int sizeSD;
        private int sizeSHD;
        private String title;
        private String topicDesc;
        private String topicImg;
        private String topicName;
        private String topicSid;
        private String vid;
        private double videoRatio;
        private VideoTopicBean videoTopic;
        private String videosource;
        private int voteCount;
        private List<String> extraTags;
        private List<String> unlikeReason;
        private List<String> videoTag;

        public int getAccoutClassify() {
            return accoutClassify;
        }

        public void setAccoutClassify(int accoutClassify) {
            this.accoutClassify = accoutClassify;
        }

        public int getAutoPlay() {
            return autoPlay;
        }

        public void setAutoPlay(int autoPlay) {
            this.autoPlay = autoPlay;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getDanmu() {
            return danmu;
        }

        public void setDanmu(int danmu) {
            this.danmu = danmu;
        }

        public String getFirstFrameImg() {
            return firstFrameImg;
        }

        public void setFirstFrameImg(String firstFrameImg) {
            this.firstFrameImg = firstFrameImg;
        }

        public String getFullSizeImg() {
            return fullSizeImg;
        }

        public void setFullSizeImg(String fullSizeImg) {
            this.fullSizeImg = fullSizeImg;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getM3u8Hd_url() {
            return m3u8Hd_url;
        }

        public void setM3u8Hd_url(String m3u8Hd_url) {
            this.m3u8Hd_url = m3u8Hd_url;
        }

        public String getM3u8_url() {
            return m3u8_url;
        }

        public void setM3u8_url(String m3u8_url) {
            this.m3u8_url = m3u8_url;
        }

        public String getMp4Hd_url() {
            return mp4Hd_url;
        }

        public void setMp4Hd_url(String mp4Hd_url) {
            this.mp4Hd_url = mp4Hd_url;
        }

        public String getMp4_url() {
            return mp4_url;
        }

        public void setMp4_url(String mp4_url) {
            this.mp4_url = mp4_url;
        }

        public int getPlayCount() {
            return playCount;
        }

        public void setPlayCount(int playCount) {
            this.playCount = playCount;
        }

        public int getPlayersize() {
            return playersize;
        }

        public void setPlayersize(int playersize) {
            this.playersize = playersize;
        }

        public String getProgram() {
            return program;
        }

        public void setProgram(String program) {
            this.program = program;
        }

        public String getPrompt() {
            return prompt;
        }

        public void setPrompt(String prompt) {
            this.prompt = prompt;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public int getRecomCount() {
            return recomCount;
        }

        public void setRecomCount(int recomCount) {
            this.recomCount = recomCount;
        }

        public String getReplyBoard() {
            return replyBoard;
        }

        public void setReplyBoard(String replyBoard) {
            this.replyBoard = replyBoard;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public String getReplyid() {
            return replyid;
        }

        public void setReplyid(String replyid) {
            this.replyid = replyid;
        }

        public String getReqId() {
            return reqId;
        }

        public void setReqId(String reqId) {
            this.reqId = reqId;
        }

        public String getSectiontitle() {
            return sectiontitle;
        }

        public void setSectiontitle(String sectiontitle) {
            this.sectiontitle = sectiontitle;
        }

        public boolean isShortV() {
            return shortV;
        }

        public void setShortV(boolean shortV) {
            this.shortV = shortV;
        }

        public int getSizeHD() {
            return sizeHD;
        }

        public void setSizeHD(int sizeHD) {
            this.sizeHD = sizeHD;
        }

        public int getSizeSD() {
            return sizeSD;
        }

        public void setSizeSD(int sizeSD) {
            this.sizeSD = sizeSD;
        }

        public int getSizeSHD() {
            return sizeSHD;
        }

        public void setSizeSHD(int sizeSHD) {
            this.sizeSHD = sizeSHD;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTopicDesc() {
            return topicDesc;
        }

        public void setTopicDesc(String topicDesc) {
            this.topicDesc = topicDesc;
        }

        public String getTopicImg() {
            return topicImg;
        }

        public void setTopicImg(String topicImg) {
            this.topicImg = topicImg;
        }

        public String getTopicName() {
            return topicName;
        }

        public void setTopicName(String topicName) {
            this.topicName = topicName;
        }

        public String getTopicSid() {
            return topicSid;
        }

        public void setTopicSid(String topicSid) {
            this.topicSid = topicSid;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public double getVideoRatio() {
            return videoRatio;
        }

        public void setVideoRatio(double videoRatio) {
            this.videoRatio = videoRatio;
        }

        public VideoTopicBean getVideoTopic() {
            return videoTopic;
        }

        public void setVideoTopic(VideoTopicBean videoTopic) {
            this.videoTopic = videoTopic;
        }

        public String getVideosource() {
            return videosource;
        }

        public void setVideosource(String videosource) {
            this.videosource = videosource;
        }

        public int getVoteCount() {
            return voteCount;
        }

        public void setVoteCount(int voteCount) {
            this.voteCount = voteCount;
        }

        public List<String> getExtraTags() {
            return extraTags;
        }

        public void setExtraTags(List<String> extraTags) {
            this.extraTags = extraTags;
        }

        public List<String> getUnlikeReason() {
            return unlikeReason;
        }

        public void setUnlikeReason(List<String> unlikeReason) {
            this.unlikeReason = unlikeReason;
        }

        public List<String> getVideoTag() {
            return videoTag;
        }

        public void setVideoTag(List<String> videoTag) {
            this.videoTag = videoTag;
        }

        public static class VideoTopicBean {
            /**
             * alias : 生活这件事，咱们认真对待
             * ename : T1489556908762
             * followed : false
             * tid : T1489556908762
             * tname : 燕山小春秋
             * topic_icons : http://dingyue.nosdn.127.net/Fm0hi0k3af7PFu5ehGgxkno8edjbnWDYUoz9Pnru=J2OL1489556908314.jpg
             */

            private String alias;
            private String ename;
            private boolean followed;
            private String tid;
            private String tname;
            private String topic_icons;

            public String getAlias() {
                return alias;
            }

            public void setAlias(String alias) {
                this.alias = alias;
            }

            public String getEname() {
                return ename;
            }

            public void setEname(String ename) {
                this.ename = ename;
            }

            public boolean isFollowed() {
                return followed;
            }

            public void setFollowed(boolean followed) {
                this.followed = followed;
            }

            public String getTid() {
                return tid;
            }

            public void setTid(String tid) {
                this.tid = tid;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getTopic_icons() {
                return topic_icons;
            }

            public void setTopic_icons(String topic_icons) {
                this.topic_icons = topic_icons;
            }
        }
    }
}
