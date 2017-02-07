package com.compilesense.liuyi.welcomerobottechstyle.javabean;

import java.util.List;

/**
 * Created by shenjingyuan002 on 2016/12/6.
 */

public class UISettingHttpBean {

    /**
     * weatherBg : Upload/TV/5/Weather/1.jpg
     * notifyTitle : 各位领导和同事
     * notifyContent : 今天要开会
     * notifyDate : 2014.02.21
     * geogBg : Upload/TV/5/Geog/1.jpg
     * groupImages : [{"imageUrl":"Upload/TV/5/Group/1.jpg"}]
     * tDCode : Upload/TV/5/QrCode/1.jpg
     */

    private String weatherBg;
    private String notifyTitle;
    private String notifyContent;
    private String notifyDate;
    private String notifyTime;
    private String notifyDuration;
    private String geogBg;
    private String tDCode;
    private List<PersonBirthdayBean> personBirthday;
    /**
     * imageUrl : Upload/TV/5/Group/1.jpg
     */

    private List<GroupImagesBean> groupImages;

    public List<PersonBirthdayBean> getPersonBirthday() {
        return personBirthday;
    }

    public void setPersonBirthday(List<PersonBirthdayBean> personBirthday) {
        this.personBirthday = personBirthday;
    }

    public String getWeatherBg() {
        return weatherBg;
    }

    public void setWeatherBg(String weatherBg) {
        this.weatherBg = weatherBg;
    }

    public String getNotifyTitle() {
        return notifyTitle;
    }

    public void setNotifyTitle(String notifyTitle) {
        this.notifyTitle = notifyTitle;
    }

    public String getNotifyTime() {
        return notifyTime;
    }

    public void setNotifyTime(String notifyTime) {
        this.notifyTime = notifyTime;
    }

    public String getNotifyDuration() {
        return notifyDuration;
    }

    public void setNotifyDuration(String notifyDuration) {
        this.notifyDuration = notifyDuration;
    }

    public String getNotifyContent() {
        return notifyContent;
    }

    public void setNotifyContent(String notifyContent) {
        this.notifyContent = notifyContent;
    }

    public String getNotifyDate() {
        return notifyDate;
    }

    public void setNotifyDate(String notifyDate) {
        this.notifyDate = notifyDate;
    }

    public String getGeogBg() {
        return geogBg;
    }

    public void setGeogBg(String geogBg) {
        this.geogBg = geogBg;
    }

    public String getTDCode() {
        return tDCode;
    }

    public void setTDCode(String tDCode) {
        this.tDCode = tDCode;
    }

    public List<GroupImagesBean> getGroupImages() {
        return groupImages;
    }

    public void setGroupImages(List<GroupImagesBean> groupImages) {
        this.groupImages = groupImages;
    }

    public static class GroupImagesBean {
        private String imageUrl;

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }

    public static class PersonBirthdayBean {
        private String personName;
        private String personBirth;
        private String personImgPath;


        public void setPersonName(String personName) {
            this.personName = personName;
        }

        public void setPersonBirth(String personBirth) {
            this.personBirth = personBirth;
        }

        public void setPersonImgPath(String personImgPath) {
            this.personImgPath = personImgPath;
        }

        public String getPersonName() {
            return personName;
        }

        public String getPersonBirth() {
            return personBirth;
        }

        public String getPersonImgPath() {
            return personImgPath;
        }
    }
}
