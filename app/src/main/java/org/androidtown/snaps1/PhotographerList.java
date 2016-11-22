package org.androidtown.snaps1;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * 리스트뷰를 사용하는 방법에 대해 알 수 있습니다.
 *
 * @author Mike
 *
 */
public class PhotographerList extends AppCompatActivity {
    ListView listView1;
    IconTextListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photographer_list);

        // 리스트뷰 객체 참조
        listView1 = (ListView) findViewById(R.id.listView1);

        // 어댑터 객체 생성
        adapter = new IconTextListAdapter(this);

        // 아이템 데이터 만들기
        Resources res = getResources();
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.minkyo), "이름 : 이민교", "신림, 10만원, 남"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.hyunsoo), "이름 : 양현수", "강남, 10만원, 남"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.minkyo), "이름 : 이민교", "신림, 10만원, 남"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.hyunsoo), "이름 : 양현수", "강남, 10만원, 남"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.minkyo), "이름 : 이민교", "신림, 10만원, 남"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.hyunsoo), "이름 : 양현수", "강남, 10만원, 남"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.minkyo), "이름 : 이민교", "신림, 10만원, 남"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.hyunsoo), "이름 : 양현수", "강남, 10만원, 남"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.minkyo), "이름 : 이민교", "신림, 10만원, 남"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.hyunsoo), "이름 : 양현수", "강남, 10만원, 남"));

        // 리스트뷰에 어댑터 설정
        listView1.setAdapter(adapter);

        // 새로 정의한 리스너로 객체를 만들어 설정
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                IconTextItem curItem = (IconTextItem) adapter.getItem(position);
                String[] curData = curItem.getData();

                Toast.makeText(getApplicationContext(), "Selected : " + curData[0], Toast.LENGTH_LONG).show();

            }

        });

    }



}
//test