package com.network.bean;

public class LoginBean {

    /**
     * isCertified : true
     * isSign : false
     * livePhotoIsCertified : true
     * roleType : 1
     * token : eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZjg1MzUyMS04YzMxLTQzMDktYmVjOS03MTRmZGI0ODQwNmQiLCJzZXNzaW9uSWQiOiJhZjg1MzUyMS04YzMxLTQzMDktYmVjOS03MTRmZGI0ODQwNmQiLCJleHAiOjQ3ODQyNDA1MDEsImlhdCI6MTYyODU2NjkwMX0.L_6cYpPLWUqfqTCZopwCeXpjFO82VNLwqe2EjkdsCU2Kp1swFWsn0Dq3pfNsTNyyRRBP7HrKV5kE8PvbqaR0aA
     */

    @com.google.gson.annotations.SerializedName("isCertified")
    private boolean isCertified;
    @com.google.gson.annotations.SerializedName("isSign")
    private boolean isSign;
    @com.google.gson.annotations.SerializedName("livePhotoIsCertified")
    private boolean livePhotoIsCertified;
    @com.google.gson.annotations.SerializedName("roleType")
    private int roleType;
    @com.google.gson.annotations.SerializedName("token")
    private String token;

    public boolean isIsCertified() {
        return isCertified;
    }

    public void setIsCertified(boolean isCertified) {
        this.isCertified = isCertified;
    }

    public boolean isIsSign() {
        return isSign;
    }

    public void setIsSign(boolean isSign) {
        this.isSign = isSign;
    }

    public boolean isLivePhotoIsCertified() {
        return livePhotoIsCertified;
    }

    public void setLivePhotoIsCertified(boolean livePhotoIsCertified) {
        this.livePhotoIsCertified = livePhotoIsCertified;
    }

    public int getRoleType() {
        return roleType;
    }

    public void setRoleType(int roleType) {
        this.roleType = roleType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
