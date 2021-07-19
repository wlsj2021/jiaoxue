package com.wlsj2021.jiaoxue.net;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class TestEntity {

    @SerializedName("data")
    private DataDTO data;
    @SerializedName("errorCode")
    private Integer errorCode;
    @SerializedName("errorMsg")
    private String errorMsg;


    public static class DataDTO {
        @SerializedName("admin")
        private Boolean admin;
        @SerializedName("chapterTops")
        private List<?> chapterTops;
        @SerializedName("coinCount")
        private Integer coinCount;
        @SerializedName("collectIds")
        private List<?> collectIds;
        @SerializedName("email")
        private String email;
        @SerializedName("icon")
        private String icon;
        @SerializedName("id")
        private Integer id;
        @SerializedName("nickname")
        private String nickname;
        @SerializedName("password")
        private String password;
        @SerializedName("publicName")
        private String publicName;
        @SerializedName("token")
        private String token;
        @SerializedName("type")
        private Integer type;
        @SerializedName("username")
        private String username;

        public void setAdmin(Boolean admin) {
            this.admin = admin;
        }

        public void setChapterTops(List<?> chapterTops) {
            this.chapterTops = chapterTops;
        }

        public void setCoinCount(Integer coinCount) {
            this.coinCount = coinCount;
        }

        public void setCollectIds(List<?> collectIds) {
            this.collectIds = collectIds;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setPublicName(String publicName) {
            this.publicName = publicName;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Boolean getAdmin() {
            return admin;
        }

        public List<?> getChapterTops() {
            return chapterTops;
        }

        public Integer getCoinCount() {
            return coinCount;
        }

        public List<?> getCollectIds() {
            return collectIds;
        }

        public String getEmail() {
            return email;
        }

        public String getIcon() {
            return icon;
        }

        public Integer getId() {
            return id;
        }

        public String getNickname() {
            return nickname;
        }

        public String getPassword() {
            return password;
        }

        public String getPublicName() {
            return publicName;
        }

        public String getToken() {
            return token;
        }

        public Integer getType() {
            return type;
        }

        public String getUsername() {
            return username;
        }
    }
}
