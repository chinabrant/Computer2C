package com.wusj.computer2c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ProblemMode extends Activity {
	
	private ListView mListViewSelect;
	private List<HashMap<String, String>> data;
	private SimpleAdapter sa;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_problem_mode);
		
		initViews();
	}
	
	protected void initViews() {
		mListViewSelect = (ListView) findViewById(R.id.lv_select);
		data = new ArrayList<HashMap<String, String>>();
		
		ArrayList<String> list = FileUtils.readSelect(this, "test.txt");
		for (int i = 0; i < list.size(); i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("title", list.get(i));
			data.add(map);
		}
		
		sa = new SimpleAdapter(this, data, R.layout.select_list_item, new String[]{"title"}, new int[]{R.id.select_title});
		mListViewSelect.setAdapter(sa);
	}
	
	
}
