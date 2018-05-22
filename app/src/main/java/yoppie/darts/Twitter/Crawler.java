package yoppie.darts.Twitter;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by yoppie on 2018/03/20.
 */

public class Crawler extends AsyncTask<Void, Void, String>{

    private String url;
    @SuppressLint("StaticFieldLeak")
    private ImageView changeImage;

    public Crawler(String url, ImageView changeImage){
        this.url = url;
        this.changeImage = changeImage;
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            Document document = Jsoup.connect(this.url).get();
            Elements title = document.getElementsByTag("title");
            Document document2 = Jsoup.connect(title.get(0).html()).get();
            Elements meta = document2.getElementsByAttributeValue("property", "og:image");
            return meta.first().attr("content");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        Picasso.get().load(result).into(this.changeImage);
    }

}
