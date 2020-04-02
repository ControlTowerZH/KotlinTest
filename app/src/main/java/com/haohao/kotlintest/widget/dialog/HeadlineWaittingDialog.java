package com.haohao.kotlintest.widget.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.haohao.kotlintest.R;


/**
 * 自定义等待窗口
 */
public class HeadlineWaittingDialog {
	/**
	 * 等待窗口
	 */
	public static HeadlineCustomDialog showDialog(Context context) {
		LayoutInflater inflater = LayoutInflater.from(context);
		View layout = inflater.inflate(R.layout.headline_dialog_waiting, null);
		HeadlineCustomDialog.Builder customBuilder = new HeadlineCustomDialog.Builder(context);
		
		HeadlineCustomDialog cDialog = customBuilder.setContentView(layout).create();
		
		cDialog.setCanceledOnTouchOutside(false);
		return cDialog;
	}

}
