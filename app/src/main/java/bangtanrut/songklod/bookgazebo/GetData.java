package bangtanrut.songklod.bookgazebo;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by Administrator on 23/4/2560.
 */

public class GetData extends AsyncTask<String,Void,String>{

    private Context context;

    public GetData(Context context) {
        this.context = context;
    }


    @Override
    protected String doInBackground(String... params) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(params[0]).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            Log.d("23Aprilv1", "e doIn ==>" + e.toString());
            return null;
        }


    }
} //Mani Class
