package com.wusj.computer2c;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.content.Context;
import android.util.Log;

public class FileUtils {
	public static ArrayList<String> readSelect(Context context, String fileName) {
		Log.i("wusj", "start");
		ArrayList<String> list = new ArrayList<String>();
		InputStream in = null;
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		try {
			in = context.getAssets().open(fileName);
			br = new BufferedReader(new InputStreamReader(in, "GBK"));
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.equals("")) {
					sb.append(line + "\n");
				} else if (line.equals("end")){
					break;
				}else {
					list.add(sb.toString());
					Log.i("wusj", sb.toString());
					Log.i("wusj", "----------------------");
					sb.delete(0, sb.length());
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return list;
	}
}
