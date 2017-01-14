package com.compilesense.liuyi.welcomerobottechstyle.javabean;

import java.util.List;

/**
 * Created by shenjingyuan002 on 2016/12/6.
 */

public class VisitorsInfoBean {
    public static final String testJsonString1 = "{\n" +
            "\t\"action\":1,\n" +
            "\t\"message\":{\n" +
            "\t    \"visitors\":[\n" +
            "    \t\t{\n" +
            "    \t\t    \"personType\":0,\n" +
            "    \t\t\t\"personId\":\"1\"\n" +
            "    \t\t}\n" +
            "    \t]\n" +
            "\t}\n" +
            "}";
    public static final String testJsonString2 = "{\n" +
            "\t\"action\":1,\n" +
            "\t\"message\":{\n" +
            "\t    \"visitors\":[\n" +
            "    \t\t{\n" +
            "    \t\t    \"personType\":0,\n" +
            "    \t\t\t\"personId\":\"2\"\n" +
            "    \t\t}\n" +
            "    \t]\n" +
            "\t}\n" +
            "}";
    public static final String testJsonString3 = "{\n" +
            "\t\"action\":1,\n" +
            "\t\"message\":{\n" +
            "\t    \"visitors\":[\n" +
            "    \t\t{\n" +
            "    \t\t    \"personType\":0,\n" +
            "    \t\t\t\"personId\":\"3\"\n" +
            "    \t\t}\n" +
            "    \t]\n" +
            "\t}\n" +
            "}";
    /**
     * action : 1
     * message : {"visitors":[{"personId":"1234"}]}
     */

    private int action;
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
        /**
         * personId : 1234
         */

        private List<VisitorsBean> visitors;

        public List<VisitorsBean> getVisitors() {
            return visitors;
        }

        public void setVisitors(List<VisitorsBean> visitors) {
            this.visitors = visitors;
        }

        public static class VisitorsBean {
            private String personId;
            private int personType;//0员工,1访客

            public String getPersonId() {
                return personId;
            }

            public void setPersonId(String personId) {
                this.personId = personId;
            }

            public int getPersonType() {
                return personType;
            }

            public void setPersonType(int personType) {
                this.personType = personType;
            }
        }
    }
}
