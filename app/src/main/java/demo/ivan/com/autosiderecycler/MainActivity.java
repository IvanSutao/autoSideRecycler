package demo.ivan.com.autosiderecycler;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import demo.ivan.com.ClassifyLine.ClassifyLineAdapter;
import demo.ivan.com.ClassifyLine.DivLinearSnapHelper;

public class MainActivity extends AppCompatActivity {

    private ClassifyLineAdapter mLineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.rv_classify_line);
        new DivLinearSnapHelper().attachToRecyclerView(mRecyclerView);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(lm);
        mLineAdapter = new ClassifyLineAdapter(this);
        mRecyclerView.setAdapter(mLineAdapter);
        setData();
    }

    public void setData() {
        List<String> imageUrls = new ArrayList<>();
        imageUrls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489140233265&di=1dc81ca9048383fede008b8e6a8bf50b&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fpic%2Fitem%2F4d5e27ed2e738bd447fa9de5a18b87d6257ff972.jpg");
        imageUrls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489140245122&di=b5dc786d2e7379e637e3f07681d23ff7&imgtype=0&src=http%3A%2F%2Fa.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F72f082025aafa40f334b883fad64034f79f01946.jpg");
        imageUrls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489140896008&di=b6d5b655fc1ec7e72f70f4634be3d2de&imgtype=0&src=http%3A%2F%2Fimg2.a0bi.com%2Fupload%2Fttq%2F20160110%2F1452399200997.jpg");
        imageUrls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489140915014&di=b032ce6bf87cc092507328d562722a71&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F5bafa40f4bfbfbed0ac552ba79f0f736aec31f52.jpg");
        mLineAdapter.setData(imageUrls);
    }
}
