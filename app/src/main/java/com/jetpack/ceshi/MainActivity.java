package com.jetpack.ceshi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.network.api.Api_interface;
import com.network.CommonObserver;
import com.network.NetWorkHelper;
import com.network.bean.BaseBean;
import com.network.bean.LoginBean;

import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);
        textView=findViewById(R.id.content);

        btn.setOnClickListener(v -> {
            try {
                NetWorkHelper helper=NetWorkHelper.getInstance();
                Api_interface api = helper.getApiService(Api_interface.class);

                JSONObject object=new JSONObject();
                object.put("account","11190000000");
                object.put("captcha","525552");
                object.put("password","UZK2Jhvhw5whx0UYKQko3Q==");
                object.put("rc","4BpZ/hWh88xhURFla2ec1f6q9+jVGzKT2voTP1IQ1XcwH0EarJ0MnOBlsT0JED1fLRqRRvMFgk4ypM4eknFhk/0xGZP6PpKxQROnklhfGiUNU6FH9xXAdNbossFQ7+VIuWLesT8ob9ln/p6+DaoUfw==");
                object.put("serverRandom","da7s3SKHAx8Uw/g46HgmFw==");
                RequestBody body=RequestBody.create(MediaType.parse("application/json"),object.toString());

                api.dologin(body)
                        .subscribeOn(Schedulers.io()) // 在子线程中进行Http访问
                        .observeOn(AndroidSchedulers.mainThread()) // UI线程处理返回接口
                        .subscribe(new CommonObserver<BaseBean<LoginBean>>() {
                            @Override
                            public void onSuccess(BaseBean<LoginBean> response) {
                                Log.e("token","into"+response.message);
                                if(response.code==999999){
                                    textView.setText(response.message);
                                }else{
                                    textView.setText(response.data.getToken());
                                }
                            }

                            @Override
                            public void onFail(Throwable t) {
                                Log.e("error",t.toString());
                            }
                        });

            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}