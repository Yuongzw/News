package com.news.yuong.news.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsDetailBean {

    /**
     * abstract : 最近，BBC中文网刊文称，寻求中日关系“真正正常化”，就应该为“精日”恢复名誉。作者据称是一个“多年来观察中国社会和中日关系”的日本媒体人。
     * action_extra : {"channel_id": 3189398996}
     * action_list : [{"action":1,"desc":"","extra":{}},{"action":3,"desc":"","extra":{}},{"action":7,"desc":"","extra":{}},{"action":9,"desc":"","extra":{}}]
     * aggr_type : 1
     * allow_download : false
     * article_alt_url : http://m.toutiao.com/group/article/6622814436446962189/
     * article_sub_type : 1
     * article_type : 1
     * article_url : https://m.haiwainet.cn/ttc/353596/2018/1112/content_31435263_1.html
     * ban_comment : 0
     * behot_time : 1542003732
     * bury_count : 0
     * cell_flag : 262155
     * cell_layout_style : 1
     * cell_type : 0
     * comment_count : 955
     * content_decoration :
     * cursor : 1542003732000
     * digg_count : 2562
     * display_url : http://toutiao.com/group/6622814436446962189/
     * filter_words : [{"id":"8:0","is_selected":false,"name":"看过了"},{"id":"9:1","is_selected":false,"name":"内容太水"},{"id":"5:9103991","is_selected":false,"name":"拉黑作者:海外网"},{"id":"3:264324585","is_selected":false,"name":"不想看:抗日战争"},{"id":"6:15826","is_selected":false,"name":"不想看:日本"}]
     * forward_info : {"forward_count":65}
     * gallary_image_count : 1
     * group_id : 6622814436446962189
     * has_image : true
     * has_m3u8_video : false
     * has_mp4_video : 0
     * has_video : false
     * hot : 0
     * ignore_web_transform : 0
     * interaction_data :
     * is_subject : false
     * item_id : 6622814436446962189
     * item_version : 0
     * keywords : 日本,法西斯,精日,军国主义,中日联合声明,侵华日军
     * level : 0
     * log_pb : {"impr_id":"201811121422120100200370990720FDA","is_following":"0"}
     * media_info : {"avatar_url":"http://p2.pstatp.com/large/1687/8327084584","follow":false,"is_star_user":false,"media_id":3244931401,"name":"海外网","recommend_reason":"","recommend_type":0,"user_id":3242684112,"user_verified":true,"verified_content":""}
     * media_name : 海外网
     * middle_image : {"height":263,"uri":"list/pgc-image/R99eISWGCr6r1F","url":"http://p1.pstatp.com/list/300x196/pgc-image/R99eISWGCr6r1F.webp","url_list":[{"url":"http://p1.pstatp.com/list/300x196/pgc-image/R99eISWGCr6r1F.webp"},{"url":"http://pb3.pstatp.com/list/300x196/pgc-image/R99eISWGCr6r1F.webp"},{"url":"http://pb9.pstatp.com/list/300x196/pgc-image/R99eISWGCr6r1F.webp"}],"width":480}
     * need_client_impr_recycle : 1
     * publish_time : 1541994148
     * read_count : 678781
     * repin_count : 566
     * rid : 201811121422120100200370990720FDA
     * share_count : 2254
     * share_info : {"cover_image":null,"description":null,"on_suppress":0,"share_type":{"pyq":0,"qq":0,"qzone":0,"wx":0},"share_url":"http://m.toutiao.com/group/6622814436446962189/?iid=0&app=news_article&is_hit_share_recommend=0","title":"日本人士呼吁为\u201c精日\u201d正名，什么情况？","token_type":1,"weixin_cover_image":{"height":580,"uri":"large/tos-cn-i-0000/fd1bb67e-e62c-11e8-81f0-0cc47a930f74","url":"http://p9.pstatp.com/large/tos-cn-i-0000/fd1bb67e-e62c-11e8-81f0-0cc47a930f74","url_list":[{"url":"http://p9.pstatp.com/large/tos-cn-i-0000/fd1bb67e-e62c-11e8-81f0-0cc47a930f74"},{"url":"http://pb1.pstatp.com/large/tos-cn-i-0000/fd1bb67e-e62c-11e8-81f0-0cc47a930f74"},{"url":"http://pb3.pstatp.com/large/tos-cn-i-0000/fd1bb67e-e62c-11e8-81f0-0cc47a930f74"}],"width":388}}
     * share_url : http://m.toutiao.com/group/6622814436446962189/?iid=0&app=news_article&is_hit_share_recommend=0
     * show_dislike : true
     * show_portrait : false
     * show_portrait_article : false
     * source : 海外网
     * source_icon_style : 6
     * source_open_url : sslocal://profile?uid=3242684112
     * tag : news_history
     * tag_id : 6622814436446962189
     * tip : 0
     * title : 日本人士呼吁为“精日”正名，什么情况？
     * ugc_recommend : {"activity":"","reason":"海外网官方账号"}
     * url : https://m.haiwainet.cn/ttc/353596/2018/1112/content_31435263_1.html
     * user_info : {"avatar_url":"http://p3.pstatp.com/thumb/1687/8327084584","description":"人民日报海外版官方网站","follow":false,"follower_count":0,"name":"海外网","schema":"sslocal://profile?uid=3242684112&refer=all","user_auth_info":"{\"auth_type\":\"0\",\"auth_info\":\"海外网官方账号\"}","user_id":3242684112,"user_verified":true,"verified_content":"海外网官方账号"}
     * user_repin : 0
     * user_verified : 1
     * verified_content : 海外网官方账号
     * video_style : 0
     */

    @SerializedName("abstract")
    private String abstractX;
    private String action_extra;
    private int aggr_type;
    private boolean allow_download;
    private String article_alt_url;
    private int article_sub_type;
    private int article_type;
    private String article_url;
    private int ban_comment;
    private int behot_time;
    private int bury_count;
    private int cell_flag;
    private int cell_layout_style;
    private int cell_type;
    private int comment_count;
    private String content_decoration;
    private long cursor;
    private int digg_count;
    private String display_url;
    private ForwardInfoBean forward_info;
    private int gallary_image_count;
    private long group_id;
    private boolean has_image;
    private boolean has_m3u8_video;
    private int has_mp4_video;
    private boolean has_video;
    private int hot;
    private int ignore_web_transform;
    private String interaction_data;
    private boolean is_subject;
    private long item_id;
    private int item_version;
    private String keywords;
    private int level;
    private LogPbBean log_pb;
    private MediaInfoBean media_info;
    private String media_name;
    private MiddleImageBean middle_image;
    private int need_client_impr_recycle;
    private int publish_time;
    private int read_count;
    private int repin_count;
    private String rid;
    private int share_count;
    private ShareInfoBean share_info;
    private String share_url;
    private boolean show_dislike;
    private boolean show_portrait;
    private boolean show_portrait_article;
    private String source;
    private int source_icon_style;
    private String source_open_url;
    private String tag;
    private long tag_id;
    private int tip;
    private String title;
    private UgcRecommendBean ugc_recommend;
    private String url;
    private UserInfoBean user_info;
    private int user_repin;
    private int user_verified;
    private String verified_content;
    private int video_style;
    private List<ActionListBean> action_list;
    private List<FilterWordsBean> filter_words;

    public String getAbstractX() {
        return abstractX;
    }

    public void setAbstractX(String abstractX) {
        this.abstractX = abstractX;
    }

    public String getAction_extra() {
        return action_extra;
    }

    public void setAction_extra(String action_extra) {
        this.action_extra = action_extra;
    }

    public int getAggr_type() {
        return aggr_type;
    }

    public void setAggr_type(int aggr_type) {
        this.aggr_type = aggr_type;
    }

    public boolean isAllow_download() {
        return allow_download;
    }

    public void setAllow_download(boolean allow_download) {
        this.allow_download = allow_download;
    }

    public String getArticle_alt_url() {
        return article_alt_url;
    }

    public void setArticle_alt_url(String article_alt_url) {
        this.article_alt_url = article_alt_url;
    }

    public int getArticle_sub_type() {
        return article_sub_type;
    }

    public void setArticle_sub_type(int article_sub_type) {
        this.article_sub_type = article_sub_type;
    }

    public int getArticle_type() {
        return article_type;
    }

    public void setArticle_type(int article_type) {
        this.article_type = article_type;
    }

    public String getArticle_url() {
        return article_url;
    }

    public void setArticle_url(String article_url) {
        this.article_url = article_url;
    }

    public int getBan_comment() {
        return ban_comment;
    }

    public void setBan_comment(int ban_comment) {
        this.ban_comment = ban_comment;
    }

    public int getBehot_time() {
        return behot_time;
    }

    public void setBehot_time(int behot_time) {
        this.behot_time = behot_time;
    }

    public int getBury_count() {
        return bury_count;
    }

    public void setBury_count(int bury_count) {
        this.bury_count = bury_count;
    }

    public int getCell_flag() {
        return cell_flag;
    }

    public void setCell_flag(int cell_flag) {
        this.cell_flag = cell_flag;
    }

    public int getCell_layout_style() {
        return cell_layout_style;
    }

    public void setCell_layout_style(int cell_layout_style) {
        this.cell_layout_style = cell_layout_style;
    }

    public int getCell_type() {
        return cell_type;
    }

    public void setCell_type(int cell_type) {
        this.cell_type = cell_type;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public String getContent_decoration() {
        return content_decoration;
    }

    public void setContent_decoration(String content_decoration) {
        this.content_decoration = content_decoration;
    }

    public long getCursor() {
        return cursor;
    }

    public void setCursor(long cursor) {
        this.cursor = cursor;
    }

    public int getDigg_count() {
        return digg_count;
    }

    public void setDigg_count(int digg_count) {
        this.digg_count = digg_count;
    }

    public String getDisplay_url() {
        return display_url;
    }

    public void setDisplay_url(String display_url) {
        this.display_url = display_url;
    }

    public ForwardInfoBean getForward_info() {
        return forward_info;
    }

    public void setForward_info(ForwardInfoBean forward_info) {
        this.forward_info = forward_info;
    }

    public int getGallary_image_count() {
        return gallary_image_count;
    }

    public void setGallary_image_count(int gallary_image_count) {
        this.gallary_image_count = gallary_image_count;
    }

    public long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(long group_id) {
        this.group_id = group_id;
    }

    public boolean isHas_image() {
        return has_image;
    }

    public void setHas_image(boolean has_image) {
        this.has_image = has_image;
    }

    public boolean isHas_m3u8_video() {
        return has_m3u8_video;
    }

    public void setHas_m3u8_video(boolean has_m3u8_video) {
        this.has_m3u8_video = has_m3u8_video;
    }

    public int getHas_mp4_video() {
        return has_mp4_video;
    }

    public void setHas_mp4_video(int has_mp4_video) {
        this.has_mp4_video = has_mp4_video;
    }

    public boolean isHas_video() {
        return has_video;
    }

    public void setHas_video(boolean has_video) {
        this.has_video = has_video;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public int getIgnore_web_transform() {
        return ignore_web_transform;
    }

    public void setIgnore_web_transform(int ignore_web_transform) {
        this.ignore_web_transform = ignore_web_transform;
    }

    public String getInteraction_data() {
        return interaction_data;
    }

    public void setInteraction_data(String interaction_data) {
        this.interaction_data = interaction_data;
    }

    public boolean isIs_subject() {
        return is_subject;
    }

    public void setIs_subject(boolean is_subject) {
        this.is_subject = is_subject;
    }

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public int getItem_version() {
        return item_version;
    }

    public void setItem_version(int item_version) {
        this.item_version = item_version;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public LogPbBean getLog_pb() {
        return log_pb;
    }

    public void setLog_pb(LogPbBean log_pb) {
        this.log_pb = log_pb;
    }

    public MediaInfoBean getMedia_info() {
        return media_info;
    }

    public void setMedia_info(MediaInfoBean media_info) {
        this.media_info = media_info;
    }

    public String getMedia_name() {
        return media_name;
    }

    public void setMedia_name(String media_name) {
        this.media_name = media_name;
    }

    public MiddleImageBean getMiddle_image() {
        return middle_image;
    }

    public void setMiddle_image(MiddleImageBean middle_image) {
        this.middle_image = middle_image;
    }

    public int getNeed_client_impr_recycle() {
        return need_client_impr_recycle;
    }

    public void setNeed_client_impr_recycle(int need_client_impr_recycle) {
        this.need_client_impr_recycle = need_client_impr_recycle;
    }

    public int getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(int publish_time) {
        this.publish_time = publish_time;
    }

    public int getRead_count() {
        return read_count;
    }

    public void setRead_count(int read_count) {
        this.read_count = read_count;
    }

    public int getRepin_count() {
        return repin_count;
    }

    public void setRepin_count(int repin_count) {
        this.repin_count = repin_count;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public int getShare_count() {
        return share_count;
    }

    public void setShare_count(int share_count) {
        this.share_count = share_count;
    }

    public ShareInfoBean getShare_info() {
        return share_info;
    }

    public void setShare_info(ShareInfoBean share_info) {
        this.share_info = share_info;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public boolean isShow_dislike() {
        return show_dislike;
    }

    public void setShow_dislike(boolean show_dislike) {
        this.show_dislike = show_dislike;
    }

    public boolean isShow_portrait() {
        return show_portrait;
    }

    public void setShow_portrait(boolean show_portrait) {
        this.show_portrait = show_portrait;
    }

    public boolean isShow_portrait_article() {
        return show_portrait_article;
    }

    public void setShow_portrait_article(boolean show_portrait_article) {
        this.show_portrait_article = show_portrait_article;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getSource_icon_style() {
        return source_icon_style;
    }

    public void setSource_icon_style(int source_icon_style) {
        this.source_icon_style = source_icon_style;
    }

    public String getSource_open_url() {
        return source_open_url;
    }

    public void setSource_open_url(String source_open_url) {
        this.source_open_url = source_open_url;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public long getTag_id() {
        return tag_id;
    }

    public void setTag_id(long tag_id) {
        this.tag_id = tag_id;
    }

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UgcRecommendBean getUgc_recommend() {
        return ugc_recommend;
    }

    public void setUgc_recommend(UgcRecommendBean ugc_recommend) {
        this.ugc_recommend = ugc_recommend;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UserInfoBean getUser_info() {
        return user_info;
    }

    public void setUser_info(UserInfoBean user_info) {
        this.user_info = user_info;
    }

    public int getUser_repin() {
        return user_repin;
    }

    public void setUser_repin(int user_repin) {
        this.user_repin = user_repin;
    }

    public int getUser_verified() {
        return user_verified;
    }

    public void setUser_verified(int user_verified) {
        this.user_verified = user_verified;
    }

    public String getVerified_content() {
        return verified_content;
    }

    public void setVerified_content(String verified_content) {
        this.verified_content = verified_content;
    }

    public int getVideo_style() {
        return video_style;
    }

    public void setVideo_style(int video_style) {
        this.video_style = video_style;
    }

    public List<ActionListBean> getAction_list() {
        return action_list;
    }

    public void setAction_list(List<ActionListBean> action_list) {
        this.action_list = action_list;
    }

    public List<FilterWordsBean> getFilter_words() {
        return filter_words;
    }

    public void setFilter_words(List<FilterWordsBean> filter_words) {
        this.filter_words = filter_words;
    }

    public static class ForwardInfoBean {
        /**
         * forward_count : 65
         */

        private int forward_count;

        public int getForward_count() {
            return forward_count;
        }

        public void setForward_count(int forward_count) {
            this.forward_count = forward_count;
        }
    }

    public static class LogPbBean {
        /**
         * impr_id : 201811121422120100200370990720FDA
         * is_following : 0
         */

        private String impr_id;
        private String is_following;

        public String getImpr_id() {
            return impr_id;
        }

        public void setImpr_id(String impr_id) {
            this.impr_id = impr_id;
        }

        public String getIs_following() {
            return is_following;
        }

        public void setIs_following(String is_following) {
            this.is_following = is_following;
        }
    }

    public static class MediaInfoBean {
        /**
         * avatar_url : http://p2.pstatp.com/large/1687/8327084584
         * follow : false
         * is_star_user : false
         * media_id : 3244931401
         * name : 海外网
         * recommend_reason :
         * recommend_type : 0
         * user_id : 3242684112
         * user_verified : true
         * verified_content :
         */

        private String avatar_url;
        private boolean follow;
        private boolean is_star_user;
        private long media_id;
        private String name;
        private String recommend_reason;
        private int recommend_type;
        private long user_id;
        private boolean user_verified;
        private String verified_content;

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public boolean isFollow() {
            return follow;
        }

        public void setFollow(boolean follow) {
            this.follow = follow;
        }

        public boolean isIs_star_user() {
            return is_star_user;
        }

        public void setIs_star_user(boolean is_star_user) {
            this.is_star_user = is_star_user;
        }

        public long getMedia_id() {
            return media_id;
        }

        public void setMedia_id(long media_id) {
            this.media_id = media_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRecommend_reason() {
            return recommend_reason;
        }

        public void setRecommend_reason(String recommend_reason) {
            this.recommend_reason = recommend_reason;
        }

        public int getRecommend_type() {
            return recommend_type;
        }

        public void setRecommend_type(int recommend_type) {
            this.recommend_type = recommend_type;
        }

        public long getUser_id() {
            return user_id;
        }

        public void setUser_id(long user_id) {
            this.user_id = user_id;
        }

        public boolean isUser_verified() {
            return user_verified;
        }

        public void setUser_verified(boolean user_verified) {
            this.user_verified = user_verified;
        }

        public String getVerified_content() {
            return verified_content;
        }

        public void setVerified_content(String verified_content) {
            this.verified_content = verified_content;
        }
    }

    public static class MiddleImageBean {
        /**
         * height : 263
         * uri : list/pgc-image/R99eISWGCr6r1F
         * url : http://p1.pstatp.com/list/300x196/pgc-image/R99eISWGCr6r1F.webp
         * url_list : [{"url":"http://p1.pstatp.com/list/300x196/pgc-image/R99eISWGCr6r1F.webp"},{"url":"http://pb3.pstatp.com/list/300x196/pgc-image/R99eISWGCr6r1F.webp"},{"url":"http://pb9.pstatp.com/list/300x196/pgc-image/R99eISWGCr6r1F.webp"}]
         * width : 480
         */

        private int height;
        private String uri;
        private String url;
        private int width;
        private List<UrlListBean> url_list;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public List<UrlListBean> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<UrlListBean> url_list) {
            this.url_list = url_list;
        }

        public static class UrlListBean {
            /**
             * url : http://p1.pstatp.com/list/300x196/pgc-image/R99eISWGCr6r1F.webp
             */

            private String url;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }

    public static class ShareInfoBean {
        /**
         * cover_image : null
         * description : null
         * on_suppress : 0
         * share_type : {"pyq":0,"qq":0,"qzone":0,"wx":0}
         * share_url : http://m.toutiao.com/group/6622814436446962189/?iid=0&app=news_article&is_hit_share_recommend=0
         * title : 日本人士呼吁为“精日”正名，什么情况？
         * token_type : 1
         * weixin_cover_image : {"height":580,"uri":"large/tos-cn-i-0000/fd1bb67e-e62c-11e8-81f0-0cc47a930f74","url":"http://p9.pstatp.com/large/tos-cn-i-0000/fd1bb67e-e62c-11e8-81f0-0cc47a930f74","url_list":[{"url":"http://p9.pstatp.com/large/tos-cn-i-0000/fd1bb67e-e62c-11e8-81f0-0cc47a930f74"},{"url":"http://pb1.pstatp.com/large/tos-cn-i-0000/fd1bb67e-e62c-11e8-81f0-0cc47a930f74"},{"url":"http://pb3.pstatp.com/large/tos-cn-i-0000/fd1bb67e-e62c-11e8-81f0-0cc47a930f74"}],"width":388}
         */

        private Object cover_image;
        private Object description;
        private int on_suppress;
        private ShareTypeBean share_type;
        private String share_url;
        private String title;
        private int token_type;
        private WeixinCoverImageBean weixin_cover_image;

        public Object getCover_image() {
            return cover_image;
        }

        public void setCover_image(Object cover_image) {
            this.cover_image = cover_image;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public int getOn_suppress() {
            return on_suppress;
        }

        public void setOn_suppress(int on_suppress) {
            this.on_suppress = on_suppress;
        }

        public ShareTypeBean getShare_type() {
            return share_type;
        }

        public void setShare_type(ShareTypeBean share_type) {
            this.share_type = share_type;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getToken_type() {
            return token_type;
        }

        public void setToken_type(int token_type) {
            this.token_type = token_type;
        }

        public WeixinCoverImageBean getWeixin_cover_image() {
            return weixin_cover_image;
        }

        public void setWeixin_cover_image(WeixinCoverImageBean weixin_cover_image) {
            this.weixin_cover_image = weixin_cover_image;
        }

        public static class ShareTypeBean {
            /**
             * pyq : 0
             * qq : 0
             * qzone : 0
             * wx : 0
             */

            private int pyq;
            private int qq;
            private int qzone;
            private int wx;

            public int getPyq() {
                return pyq;
            }

            public void setPyq(int pyq) {
                this.pyq = pyq;
            }

            public int getQq() {
                return qq;
            }

            public void setQq(int qq) {
                this.qq = qq;
            }

            public int getQzone() {
                return qzone;
            }

            public void setQzone(int qzone) {
                this.qzone = qzone;
            }

            public int getWx() {
                return wx;
            }

            public void setWx(int wx) {
                this.wx = wx;
            }
        }

        public static class WeixinCoverImageBean {
            /**
             * height : 580
             * uri : large/tos-cn-i-0000/fd1bb67e-e62c-11e8-81f0-0cc47a930f74
             * url : http://p9.pstatp.com/large/tos-cn-i-0000/fd1bb67e-e62c-11e8-81f0-0cc47a930f74
             * url_list : [{"url":"http://p9.pstatp.com/large/tos-cn-i-0000/fd1bb67e-e62c-11e8-81f0-0cc47a930f74"},{"url":"http://pb1.pstatp.com/large/tos-cn-i-0000/fd1bb67e-e62c-11e8-81f0-0cc47a930f74"},{"url":"http://pb3.pstatp.com/large/tos-cn-i-0000/fd1bb67e-e62c-11e8-81f0-0cc47a930f74"}]
             * width : 388
             */

            private int height;
            private String uri;
            private String url;
            private int width;
            private List<UrlListBeanX> url_list;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public List<UrlListBeanX> getUrl_list() {
                return url_list;
            }

            public void setUrl_list(List<UrlListBeanX> url_list) {
                this.url_list = url_list;
            }

            public static class UrlListBeanX {
                /**
                 * url : http://p9.pstatp.com/large/tos-cn-i-0000/fd1bb67e-e62c-11e8-81f0-0cc47a930f74
                 */

                private String url;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }

    public static class UgcRecommendBean {
        /**
         * activity :
         * reason : 海外网官方账号
         */

        private String activity;
        private String reason;

        public String getActivity() {
            return activity;
        }

        public void setActivity(String activity) {
            this.activity = activity;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }

    public static class UserInfoBean {
        /**
         * avatar_url : http://p3.pstatp.com/thumb/1687/8327084584
         * description : 人民日报海外版官方网站
         * follow : false
         * follower_count : 0
         * name : 海外网
         * schema : sslocal://profile?uid=3242684112&refer=all
         * user_auth_info : {"auth_type":"0","auth_info":"海外网官方账号"}
         * user_id : 3242684112
         * user_verified : true
         * verified_content : 海外网官方账号
         */

        private String avatar_url;
        private String description;
        private boolean follow;
        private int follower_count;
        private String name;
        private String schema;
        private String user_auth_info;
        private long user_id;
        private boolean user_verified;
        private String verified_content;

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public boolean isFollow() {
            return follow;
        }

        public void setFollow(boolean follow) {
            this.follow = follow;
        }

        public int getFollower_count() {
            return follower_count;
        }

        public void setFollower_count(int follower_count) {
            this.follower_count = follower_count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSchema() {
            return schema;
        }

        public void setSchema(String schema) {
            this.schema = schema;
        }

        public String getUser_auth_info() {
            return user_auth_info;
        }

        public void setUser_auth_info(String user_auth_info) {
            this.user_auth_info = user_auth_info;
        }

        public long getUser_id() {
            return user_id;
        }

        public void setUser_id(long user_id) {
            this.user_id = user_id;
        }

        public boolean isUser_verified() {
            return user_verified;
        }

        public void setUser_verified(boolean user_verified) {
            this.user_verified = user_verified;
        }

        public String getVerified_content() {
            return verified_content;
        }

        public void setVerified_content(String verified_content) {
            this.verified_content = verified_content;
        }
    }

    public static class ActionListBean {
        /**
         * action : 1
         * desc :
         * extra : {}
         */

        private int action;
        private String desc;
        private ExtraBean extra;

        public int getAction() {
            return action;
        }

        public void setAction(int action) {
            this.action = action;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public ExtraBean getExtra() {
            return extra;
        }

        public void setExtra(ExtraBean extra) {
            this.extra = extra;
        }

        public static class ExtraBean {
        }
    }

    public static class FilterWordsBean {
        /**
         * id : 8:0
         * is_selected : false
         * name : 看过了
         */

        private String id;
        private boolean is_selected;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isIs_selected() {
            return is_selected;
        }

        public void setIs_selected(boolean is_selected) {
            this.is_selected = is_selected;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
