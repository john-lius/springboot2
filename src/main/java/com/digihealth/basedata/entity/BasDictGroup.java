package com.digihealth.basedata.entity;

public class BasDictGroup {
    /**
     * 码表ID
     */
    private Integer id;

    /**
     * 组
     */
    private String groupId;

    /**
     * 组对应名称
     */
    private String groupName;

    /**
     * 是否有效
     */
    private Boolean enable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
    
}