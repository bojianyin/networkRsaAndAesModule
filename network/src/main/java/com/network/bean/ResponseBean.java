package com.network.bean;

import com.google.gson.annotations.SerializedName;

public class ResponseBean {
    /**
     * code : 11400200
     * data : {"seqNo":"1628564573688219368704707138","signature":"W/bdmPgNQPxrz0Fol7TRTjmk1dVBbOVe9rlfdN965dT43xAu2RrpqB+Q9fVw7Gdwzc3KjNzfWMAdamxXrP859B3M+ebYFbetFtpzFNwWl0Fmt9OJyCBbhXmPqzESa30JJnBG7t+fP7LRYkMJmjWzMq9W8eCDfj6b9VsdrzGYerzum1oya11d8Gt7KKCZ439/uVWFgLqdyVxR6ITZu0Df4Qhzj7mtWaN2tZkKh3qVBp7TVDc1VZlsOr0kQVwJjkWr3wy/siEPK7+qg159/Ve6t4BomrcNe3Puy+lojA/HYSTKErLFKn3Soy2ewpD5WYYL5npKhLP+PKV9H+kc5XDNmw==","bizData":"Qa38YG5oTvaZOd5bv+4E5wW0yQHfVFD1njiVo/BRFd3K4tVNp7GjMm1j9dEkK2quS1w5hfDzBdkq\niQqjddhDas0mcIHs7vb371U7f1hmlJJBXa6iTNqmYpCg23Omui++gjeLAMfkoKS3jWN7HJvClZSp\n9tPIV+MLTv98tbEC76K8k8GpdZuskbkynsEUVP4kbVR0m/Hkrpn3Z4si2Cs6/PoZ3BLGMiSTS13f\n9KXXg9K/ElUnbYY5hze30SUkBDq6tT0hhF3JMBmKKmx9s7JU/y8FE/lmu7hDtDZNodZ8pk0t/ikI\ne53K2w3XnbahmfbkmBSo0c/PfY+eMC6M/e6wk48C3LnGx6tTMDtTlS6hFFF15z1TKv9jStzot7Mh\nBnUUl2IP2kyuCNi+RHuhbve6Z0GWnpsxzAbcvZ1AaRqPf1C3oWJ40qb4mKpKnDYVACh/ZOohsN0u\n+N1uVpwEJnbVCMm3DFZlZ4Id72Y+wngEyuHhCQIuhbFJtqvOKzJkemgM54e5C2Iw14lzKqaS7IaT\npwEmnEin0zEOS5x57ljX5AwdLrLM5EY05EnO5eC9GbiQCm90GKXzZxJB5cYYUnGlmA==","encryptKey":"PjRBvkYg/5LVC/bEn4//1CgEx4d7+TS5iK9/gcDuRZmAriGk5Fku+XCwcjjVt5V7AIfOcQhG8d9hTHHXnrR7urI4TS8jaIBZKXRuWSPzpDkGtgYSBHNfRGggt7Emg2mKknBCQRhzjwfDDjPlaSCTaAia8iKNWLCY66rA6zcGCm6taRfG5768OHuH68EtYVs8NxcS6yrX6rzrgrSYFFnt+S/gfgtY/+fG4/4bXS2KykhLfVWFOvFRz8FuJgP8NJrz9Y8GIHpoYsJP4kT0dtVdoMWPe15GwSI+mV2Iw5CURrLXOHn7HoTy/aBoEp/p4q43lG8gZewCDoxh9r9Ml2BdFA=="}
     * message : 请求成功
     * success : true
     */

    @SerializedName("code")
    private int code;
    @SerializedName("data")
    private DataBean data;
    @SerializedName("message")
    private String message;
    @SerializedName("success")
    private boolean success;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class DataBean {
        /**
         * seqNo : 1628564573688219368704707138
         * signature : W/bdmPgNQPxrz0Fol7TRTjmk1dVBbOVe9rlfdN965dT43xAu2RrpqB+Q9fVw7Gdwzc3KjNzfWMAdamxXrP859B3M+ebYFbetFtpzFNwWl0Fmt9OJyCBbhXmPqzESa30JJnBG7t+fP7LRYkMJmjWzMq9W8eCDfj6b9VsdrzGYerzum1oya11d8Gt7KKCZ439/uVWFgLqdyVxR6ITZu0Df4Qhzj7mtWaN2tZkKh3qVBp7TVDc1VZlsOr0kQVwJjkWr3wy/siEPK7+qg159/Ve6t4BomrcNe3Puy+lojA/HYSTKErLFKn3Soy2ewpD5WYYL5npKhLP+PKV9H+kc5XDNmw==
         * bizData : Qa38YG5oTvaZOd5bv+4E5wW0yQHfVFD1njiVo/BRFd3K4tVNp7GjMm1j9dEkK2quS1w5hfDzBdkq
         iQqjddhDas0mcIHs7vb371U7f1hmlJJBXa6iTNqmYpCg23Omui++gjeLAMfkoKS3jWN7HJvClZSp
         9tPIV+MLTv98tbEC76K8k8GpdZuskbkynsEUVP4kbVR0m/Hkrpn3Z4si2Cs6/PoZ3BLGMiSTS13f
         9KXXg9K/ElUnbYY5hze30SUkBDq6tT0hhF3JMBmKKmx9s7JU/y8FE/lmu7hDtDZNodZ8pk0t/ikI
         e53K2w3XnbahmfbkmBSo0c/PfY+eMC6M/e6wk48C3LnGx6tTMDtTlS6hFFF15z1TKv9jStzot7Mh
         BnUUl2IP2kyuCNi+RHuhbve6Z0GWnpsxzAbcvZ1AaRqPf1C3oWJ40qb4mKpKnDYVACh/ZOohsN0u
         +N1uVpwEJnbVCMm3DFZlZ4Id72Y+wngEyuHhCQIuhbFJtqvOKzJkemgM54e5C2Iw14lzKqaS7IaT
         pwEmnEin0zEOS5x57ljX5AwdLrLM5EY05EnO5eC9GbiQCm90GKXzZxJB5cYYUnGlmA==
         * encryptKey : PjRBvkYg/5LVC/bEn4//1CgEx4d7+TS5iK9/gcDuRZmAriGk5Fku+XCwcjjVt5V7AIfOcQhG8d9hTHHXnrR7urI4TS8jaIBZKXRuWSPzpDkGtgYSBHNfRGggt7Emg2mKknBCQRhzjwfDDjPlaSCTaAia8iKNWLCY66rA6zcGCm6taRfG5768OHuH68EtYVs8NxcS6yrX6rzrgrSYFFnt+S/gfgtY/+fG4/4bXS2KykhLfVWFOvFRz8FuJgP8NJrz9Y8GIHpoYsJP4kT0dtVdoMWPe15GwSI+mV2Iw5CURrLXOHn7HoTy/aBoEp/p4q43lG8gZewCDoxh9r9Ml2BdFA==
         */

        @SerializedName("seqNo")
        private String seqNo;
        @SerializedName("signature")
        private String signature;
        @SerializedName("bizData")
        private String bizData;
        @SerializedName("encryptKey")
        private String encryptKey;

        public String getSeqNo() {
            return seqNo;
        }

        public void setSeqNo(String seqNo) {
            this.seqNo = seqNo;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getBizData() {
            return bizData;
        }

        public void setBizData(String bizData) {
            this.bizData = bizData;
        }

        public String getEncryptKey() {
            return encryptKey;
        }

        public void setEncryptKey(String encryptKey) {
            this.encryptKey = encryptKey;
        }
    }
}
