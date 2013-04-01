package com.wusj.computer2c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Welcome extends Activity implements OnItemClickListener {

	private ListView mListView;
	private SimpleAdapter sa;
	private List<HashMap<String, String>> data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);

		initViews();
	}

	protected void initViews() {
		mListView = (ListView) findViewById(R.id.lv);
		mListView.setOnItemClickListener(this);
		String[] cates = getResources().getStringArray(R.array.c2_year);
		data = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < cates.length; i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("title", cates[i]);
			data.add(map);
		}

		sa = new SimpleAdapter(this, data, R.layout.list_item,
				new String[] { "title" }, new int[] { R.id.title });
		mListView.setAdapter(sa);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent = new Intent(this, ProblemMode.class);
		startActivity(intent);
	}

}
