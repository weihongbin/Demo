package whb.cn.com.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * =============================================
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: whb.cn.com.demo.PageFragment.java
 * @author: 魏红彬
 * @date: 2017-03-06 16:23
 */
public class PageFragment extends Fragment {
    private static final String TAG = "PageFragment";

    private String pager;

    public static PageFragment newInstance(String text) {
        Bundle bundle = new Bundle();
        bundle.putString(TAG, text);
        PageFragment pageFragment = new PageFragment();
        pageFragment.setArguments(bundle);
        return pageFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pager = getArguments().getString(TAG);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item, container, false);
        TextView textView = (TextView) view.findViewById(R.id.tv);
        textView.setText(pager);
        return view;
    }
}