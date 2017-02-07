package com.compilesense.liuyi.welcomerobottechstyle.javabean;

import java.util.List;

/**
 * Created by shenjingyuan002 on 2016/12/6.
 */

public class UISettingBean {

    public static String testJsonString = "{\n" +
            "    \"action\": 2,\n" +
            "    \"message\": {\n" +
            "        \"weatherBg\": \"http://gb.cri.cn/mmsource/images/2012/02/24/1253be0757974be28b2476674e879b87.jpg\",\n" +
            "        \"notifyTitle\": \"各位领导和同事\",\n" +
            "        \"notifyContent\": \"今天要开会test\",\n" +
            "        \"notifyDate\": \"2014.02.21\",\n" +
            "        \"geogBg\": \"http://gb.cri.cn/mmsource/images/2012/02/24/1253be0757974be28b2476674e879b87.jpg\",\n" +
            "        \"groupImages\": [\n" +
            "            {\n" +
            "                \"imageUrl\": \"http://pic.58pic.com/58pic/15/85/26/54P58PICjZB_1024.jpg\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"tDCode\": \"http://h.hiphotos.baidu.com/image/pic/item/3bf33a87e950352a5936aa0a5543fbf2b2118b59.jpg\"\n" +
            "    }\n" +
            "}";
    /**
     * action : 2
     * message : {"weatherBg":"Upload/TV/5/Weather/1.jpg","notifyTitle":"各位领导和同事","notifyContent":"今天要开会","notifyDate":"2014.02.21","geogBg":"Upload/TV/5/Geog/1.jpg","groupImages":[{"imageUrl":"Upload/TV/5/Group/1.jpg"}],"tDCode":"Upload/TV/5/QrCode/1.jpg"}
     */

    private int action;
    /**
     * weatherBg : Upload/TV/5/Weather/1.jpg
     * notifyTitle : 各位领导和同事
     * notifyContent : 今天要开会
     * notifyDate : 2014.02.21
     * geogBg : Upload/TV/5/Geog/1.jpg
     * groupImages : [{"imageUrl":"Upload/TV/5/Group/1.jpg"}]
     * tDCode : Upload/TV/5/QrCode/1.jpg
     */

    private MessageBean message;

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public MessageBean getMessage() {
        return message;
    }

    public void setMessage(MessageBean message) {
        this.message = message;
    }

    public static class MessageBean {
        private String weatherBg;
        private String notifyTitle;
        private String notifyContent;
        private String notifyDate;
        private String geogBg;
        private String tDCode;
        /**
         * imageUrl : Upload/TV/5/Group/1.jpg
         */

        private List<GroupImagesBean> groupImages;


        private List<UISettingHttpBean.PersonBirthdayBean> personBirthday;
        public List<UISettingHttpBean.PersonBirthdayBean> getPersonBirthday() {
            return personBirthday;
        }
        public void setPersonBirthday(List<UISettingHttpBean.PersonBirthdayBean> personBirthday) {
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
}
