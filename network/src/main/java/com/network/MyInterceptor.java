package com.network;

import android.app.DownloadManager;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;
import com.network.bean.BaseBean;
import com.network.bean.ResponseBean;
import com.network.keys.RsaKey;
import com.network.utils.AES;
import com.network.utils.RSA;

import org.json.JSONException;
import org.json.JSONObject;
import org.spongycastle.cert.ocsp.Req;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import retrofit2.http.Query;

public class MyInterceptor implements Interceptor {

    private static final String aesKey="UdBqf5MHgAZrT7QfUJMYIHBIKjtZTpcn";
    private INetWork netWork;

    public MyInterceptor(INetWork netWork){
        this.netWork=netWork;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long startReqTime = System.currentTimeMillis();

        if("POST".equals(request.method())){
            try {
                request = rebuildReq(request);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        Response response=chain.proceed(request);
        long endReqTime=System.currentTimeMillis();

        Log.e("请求消费费时间",String.valueOf(endReqTime-startReqTime));


        Response newResponse= null;
        try {
            newResponse = rebuildRes(response);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return newResponse;
    }


    //加密
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public Request rebuildReq(Request request) throws Exception {
        RequestBody body=request.body();
        JSONObject json;

        String version = netWork.appVersion();
        String seqNo = String.valueOf(System.currentTimeMillis());
        String bizdata;
        String signature;
        RSA rsa=new RSA();
        rsa.setPublicKey(RsaKey.publicKey);
        rsa.setPrivateKey(RsaKey.privateKey);
        String encryptKey=rsa.encrypt(aesKey);

        json=new JSONObject();
        if(body.contentLength()==0){
            bizdata="";
        }else{
            String params=getParams(body);
            bizdata=AES.encrypt(aesKey,params);
        }
        String signStr=bizdata + seqNo + encryptKey + version;
        signature=rsa.sign(signStr,"SHA256withRSA");
        json.put("version",version);
        json.put("seqNo",seqNo);
        json.put("bizData",bizdata);
        json.put("encryptKey",encryptKey);
        json.put("signature",signature);

        RequestBody newRequestBody = RequestBody.create(body.contentType(),json.toString());

        return request.newBuilder()
                .method(request.method(),newRequestBody)
                .build();
    }

    //解密
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public Response rebuildRes(Response response) throws Exception {
        String responseTxt = null;

        ResponseBody responseBody=response.body();
        String strText=responseBody.string();
        Log.e("response",strText);
        Gson gson=new Gson();
        ResponseBean responseBean=gson.fromJson(strText, ResponseBean.class);
        ResponseBean.DataBean bean=responseBean.getData();

        if(responseBean.isSuccess()){
            //成功
            String BizData=bean.getBizData();
            String EncryptKey=bean.getEncryptKey();
            String SeqNo=bean.getSeqNo();
            String Signature=bean.getSignature();

            String newSign=SeqNo+EncryptKey+BizData;

            RSA rsa=new RSA();
            rsa.setPublicKey(RsaKey.publicKey);
            rsa.setPrivateKey(RsaKey.privateKey);
            boolean isok=rsa.verify(Signature,newSign,"SHA256withRSA");

            if(isok){
                String aeskey=rsa.decrypt(EncryptKey);
                responseTxt=AES.decrypt(aeskey,BizData);
            }

            if(responseTxt==null){
                responseTxt="";
            }

        }else{
            responseTxt="";
        }

        if("".equals(responseTxt)){
            BaseBean obj=new BaseBean();
            obj.code=999999;
            obj.message="解密失败";
            obj.success=true;
            Gson gson1=new Gson();

            responseTxt=gson1.toJson(obj);
        }

        ResponseBody newBody=ResponseBody.create(MediaType.parse("application/json"),responseTxt);

        return response.newBuilder().body(newBody).build();
    }


    public String getParams(RequestBody body) throws IOException {
        Buffer buffer= new Buffer();
        body.writeTo(buffer);
        return buffer.readUtf8();
    }

}
