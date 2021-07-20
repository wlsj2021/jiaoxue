package com.wlsj2021.jiaoxue.net;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class CommonlyUsedEntity {

    @SerializedName("data")
    private List<DataDTO> data;
    @SerializedName("errorCode")
    private Integer errorCode;
    @SerializedName("errorMsg")
    private String errorMsg;


    public static class DataDTO {
        @SerializedName("category")
        private String category;
        @SerializedName("icon")
        private String icon;
        @SerializedName("id")
        private Integer id;
        @SerializedName("link")
        private String link;
        @SerializedName("name")
        private String name;
        @SerializedName("order")
        private Integer order;
        @SerializedName("visible")
        private Integer visible;

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getOrder() {
            return order;
        }

        public void setOrder(Integer order) {
            this.order = order;
        }

        public Integer getVisible() {
            return visible;
        }

        public void setVisible(Integer visible) {
            this.visible = visible;
        }
    }

    public List<DataDTO> getData() {
        return data;
    }

    public void setData(List<DataDTO> data) {
        this.data = data;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
