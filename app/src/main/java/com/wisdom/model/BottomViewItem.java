package com.wisdom.model;

import com.wisdom.main.R;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BottomViewItem {

	public static BottomViewItem instance;

	public static BottomViewItem getInstance() {
		if (instance == null) {
			instance = new BottomViewItem();
		}
		return instance;
	}

	public int viewNum = 4;
	public ImageView[] images = new ImageView[viewNum];
	public TextView[] texts = new TextView[viewNum];
	public LinearLayout[] linears = new LinearLayout[viewNum];
	public int[] images_id = new int[] { R.id.message_image, R.id.contacts_image, R.id.news_image, R.id.setting_image };
	public int[] texts_id = new int[] { R.id.message_text, R.id.contacts_text, R.id.news_text, R.id.setting_text };
	public int[] linears_id = new int[] { R.id.message_layout, R.id.contacts_layout, R.id.news_layout, R.id.setting_layout };
	public int[] images_selected = new int[] { R.drawable.message_selected, R.drawable.contacts_selected, R.drawable.news_selected, R.drawable.setting_selected };
	public int[] images_unselected = new int[] { R.drawable.message_unselected, R.drawable.contacts_unselected, R.drawable.news_unselected, R.drawable.setting_unselected };
	public int[] layouts_id = new int[] { R.layout.message_view, R.layout.contacts_view, R.layout.news_view, R.layout.setting_view };

}
