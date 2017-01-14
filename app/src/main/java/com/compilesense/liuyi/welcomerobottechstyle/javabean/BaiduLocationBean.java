package com.compilesense.liuyi.welcomerobottechstyle.javabean;

/**
 * Created by shenjingyuan002 on 2016/12/2.
 */

public class BaiduLocationBean {

    /**
     * location : {"lat":30.675832,"lng":104.111083}
     * locid : bd0f5b109b5b14ba2de1dcf3e1d76e1c
     * radius : 30
     * confidence : 0.2
     * address_component : {"country":"中国","province":"四川省","city":"成都市","district":"成华区","street":"建设路","street_number":"14号","admin_area_code":510108}
     * formatted_address : 四川省成都市成华区建设路14号
     * business : 建设路,圣灯,府青路
     */

    private ContentBean content;
    /**
     * error : 161
     * loc_time : 2016-12-02 15:26:02
     */

    private ResultBean result;

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ContentBean {
        /**
         * lat : 30.675832
         * lng : 104.111083
         */

        private LocationBean location;
        private String locid;
        private int radius;
        private double confidence;
        /**
         * country : 中国
         * province : 四川省
         * city : 成都市
         * district : 成华区
         * street : 建设路
         * street_number : 14号
         * admin_area_code : 510108
         */

        private AddressComponentBean address_component;
        private String formatted_address;
        private String business;

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public String getLocid() {
            return locid;
        }

        public void setLocid(String locid) {
            this.locid = locid;
        }

        public int getRadius() {
            return radius;
        }

        public void setRadius(int radius) {
            this.radius = radius;
        }

        public double getConfidence() {
            return confidence;
        }

        public void setConfidence(double confidence) {
            this.confidence = confidence;
        }

        public AddressComponentBean getAddress_component() {
            return address_component;
        }

        public void setAddress_component(AddressComponentBean address_component) {
            this.address_component = address_component;
        }

        public String getFormatted_address() {
            return formatted_address;
        }

        public void setFormatted_address(String formatted_address) {
            this.formatted_address = formatted_address;
        }

        public String getBusiness() {
            return business;
        }

        public void setBusiness(String business) {
            this.business = business;
        }

        public static class LocationBean {
            private double lat;
            private double lng;

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }
        }

        public static class AddressComponentBean {
            private String country;
            private String province;
            private String city;
            private String district;
            private String street;
            private String street_number;
            private int admin_area_code;

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getDistrict() {
                return district;
            }

            public void setDistrict(String district) {
                this.district = district;
            }

            public String getStreet() {
                return street;
            }

            public void setStreet(String street) {
                this.street = street;
            }

            public String getStreet_number() {
                return street_number;
            }

            public void setStreet_number(String street_number) {
                this.street_number = street_number;
            }

            public int getAdmin_area_code() {
                return admin_area_code;
            }

            public void setAdmin_area_code(int admin_area_code) {
                this.admin_area_code = admin_area_code;
            }
        }
    }

    public static class ResultBean {
        private int error;
        private String loc_time;

        public int getError() {
            return error;
        }

        public void setError(int error) {
            this.error = error;
        }

        public String getLoc_time() {
            return loc_time;
        }

        public void setLoc_time(String loc_time) {
            this.loc_time = loc_time;
        }
    }
}
