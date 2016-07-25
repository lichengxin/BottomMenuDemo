package com.wisdom.btten;

import com.wisdom.main.BaseActivity;
import com.wisdom.main.R;
import android.os.Bundle;

public class BttenActivity extends BaseActivity {

	BttenTabbar tabbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.btten_layout);
		tabbar = new BttenTabbar(this);
	}

}
