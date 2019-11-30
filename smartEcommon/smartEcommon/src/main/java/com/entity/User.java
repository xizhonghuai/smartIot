package com.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-04-29 17:01
 * @Version 1.0
 */
public class User implements Serializable {


    private Integer id;
    private String userName;
    private String userPassword;
    private String CompanyName;
    private String realName;
    private String telephone;
    private Integer authorizationId;
    private Integer systemId;
    private String systemTitle;
    private String key;
    private Date regDate;

    public User() {
    }

    public User(Integer id, String userName, String userPassword, String companyName, String realName, String telephone, Integer authorizationId, Integer systemId, String systemTitle, String key, Date regDate) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        CompanyName = companyName;
        this.realName = realName;
        this.telephone = telephone;
        this.authorizationId = authorizationId;
        this.systemId = systemId;
        this.systemTitle = systemTitle;
        this.key = key;
        this.regDate = regDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getAuthorizationId() {
        return authorizationId;
    }

    public void setAuthorizationId(Integer authorizationId) {
        this.authorizationId = authorizationId;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public String getSystemTitle() {
        return systemTitle;
    }

    public void setSystemTitle(String systemTitle) {
        this.systemTitle = systemTitle;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", CompanyName='" + CompanyName + '\'' +
                ", realName='" + realName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", authorizationId=" + authorizationId +
                ", systemId=" + systemId +
                ", systemTitle='" + systemTitle + '\'' +
                ", key='" + key + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}
