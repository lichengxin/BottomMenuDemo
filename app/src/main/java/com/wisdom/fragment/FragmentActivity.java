package com.wisdom.fragment;

import java.util.HashMap;
import java.util.Map;
import com.wisdom.main.BaseActivity;
import com.wisdom.main.R;
import com.wisdom.model.BottomViewItem;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FragmentActivity extends BaseActivity implements OnClickListener {

	/**
	 * 对fragment进行增删替换处理的实例
	 */
	private FragmentTransaction transaction;
	/**
	 * 首次创建页面的临时fragment
	 */
	private BaseFragment newFragment;
	/**
	 * fragment构造函数不建议带参数，So如此传递xml布局参数
	 */
	private Bundle args = new Bundle();
	/**
	 * 底部菜单栏初始化所有控件类的一个实例
	 */
	private BottomViewItem item;
	/**
	 * 用于存放所有新建的fragment
	 */
	private Map<Integer, BaseFragment> fragmentMap;

	/**
	 * fragment管理器
	 */
	private FragmentManager fragmentManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.fragment_layout);
		item = BottomViewItem.getInstance();
		fragmentMap = new HashMap<Integer, BaseFragment>();
		initViews();
		fragmentManager = getFragmentManager();
		setTabSelection(0);
	}

	/**
	 * 底部菜单栏控件初始化
	 */
	private void initViews() {
		for (int i = 0; i < item.viewNum; i++) {
			item.linears[i] = (LinearLayout) findViewById(item.linears_id[i]);
			item.linears[i].setOnClickListener(this);
			item.images[i] = (ImageView) findViewById(item.images_id[i]);
			item.texts[i] = (TextView) findViewById(item.texts_id[i]);
		}
	}

	@Override
	public void onClick(View v) {
		for (int i = 0; i < item.linears_id.length; i++)
			if (v.getId() == item.linears_id[i]) {
				setTabSelection(i);
			}
	}

	/**
	 * @param index
	 *            根据索引值切换fragment
	 */
	private void setTabSelection(int index) {
		clearSelection();
		transaction = fragmentManager.beginTransaction();
		hideFragments(transaction);
		item.images[index].setImageResource(item.images_selected[index]);
		item.texts[index].setTextColor(getResources().getColor(R.color.bottom_text_selected));
		if (fragmentMap.get(index) == null) {
			newFragment = new BaseFragment();
			args.putInt("layoutId", item.layouts_id[index]);
			fragmentMap.put(index, newFragment);
			fragmentMap.get(index).setArguments(args);
			transaction.add(R.id.main_fragment, fragmentMap.get(index));
		} else {
			transaction.show(fragmentMap.get(index));
		}
		transaction.commit();
	}

	/**
	 * 清空所有图标和文字状态
	 */
	private void clearSelection() {
		for (int i = 0; i < item.viewNum; i++) {
			item.images[i].setImageResource(item.images_unselected[i]);
			item.texts[i].setTextColor(getResources().getColor(R.color.bottom_text_unselected));
		}
	}

	/**
	 * @param transaction
	 *            隐藏所有非空fragment
	 */
	private void hideFragments(FragmentTransaction transaction) {
		for (int i = 0; i < fragmentMap.size(); i++) {
			if (fragmentMap.get(i) != null) {
				transaction.hide(fragmentMap.get(i));
			}
		}
	}

}