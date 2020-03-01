package com.cxyz.car.data.domain;

public class CommentsItem {

    /**
     * userImage : https://img2.woyaogexing.com/2020/02/20/650de89e20cc40ab999d64865dc3a682!400x400.jpeg
     * userName : 炸天帮花无缺
     * date : 2020年2月10日
     * commentsStatus : 好评
     * content : 这东西整好用，会计师的咖啡哈萨克好地方流口水的后方可撒谎的付款后开始的付款回
     */

    private Long commentsItemId;//评论id
    private Long userId;//用户id
    private Long storeId;//店铺id
    private String userImage;//用户头像
    private String userName;//用户名
    private String date;//发表日期
    private boolean commentsStatus;//评论类型，1好评，0差评
    private String content;//评论内容

    public Long getCommentsItemId() {
        return commentsItemId;
    }

    public void setCommentsItemId(Long commentsItemId) {
        this.commentsItemId = commentsItemId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean getCommentsStatus() {
        return commentsStatus;
    }

    public void setCommentsStatus(boolean commentsStatus) {
        this.commentsStatus = commentsStatus;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CommentsItem{" +
                "userImage='" + userImage + '\'' +
                ", userName='" + userName + '\'' +
                ", date='" + date + '\'' +
                ", commentsStatus='" + commentsStatus + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public CommentsItem(String userImage, String userName, String date, boolean commentsStatus, String content) {
        this.userImage = userImage;
        this.userName = userName;
        this.date = date;
        this.commentsStatus = commentsStatus;
        this.content = content;
    }
}
