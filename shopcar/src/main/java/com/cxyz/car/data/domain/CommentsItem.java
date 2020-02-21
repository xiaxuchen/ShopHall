package com.cxyz.car.data.domain;

public class CommentsItem {

    /**
     * userImage : https://img2.woyaogexing.com/2020/02/20/650de89e20cc40ab999d64865dc3a682!400x400.jpeg
     * userName : 炸天帮花无缺
     * date : 2020年2月10日
     * commentsStatus : 好评
     * content : 这东西整好用，会计师的咖啡哈萨克好地方流口水的后方可撒谎的付款后开始的付款回
     */

    private String userImage;
    private String userName;
    private String date;
    private String commentsStatus;
    private String content;
    private String delete;

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
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

    public String getCommentsStatus() {
        return commentsStatus;
    }

    public void setCommentsStatus(String commentsStatus) {
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

    public CommentsItem(String userImage, String userName, String date, String commentsStatus, String content) {
        this.userImage = userImage;
        this.userName = userName;
        this.date = date;
        this.commentsStatus = commentsStatus;
        this.content = content;
    }
}
