package com.example.management;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.management.base.BaseActivity;
import com.example.management.interfaces.IBasePresenter;
import com.example.management.ui.HomeActivity;
import com.example.management.util.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @Author Why
 * Created on 2020/12/7
 * Desc : 登录
 */

public class MainActivity extends BaseActivity {


    @BindView(R.id.user_img)
    ImageView mUserImg;
    @BindView(R.id.user_name)
    EditText mUserName;
    @BindView(R.id.user_password)
    EditText mUserPassword;
    @BindView(R.id.register)
    Button mRegister;
    @BindView(R.id.tv_forget)
    TextView mTvForget;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected IBasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.user_img, R.id.user_name, R.id.user_password, R.id.register, R.id.tv_forget})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.user_img:
                break;
            case R.id.register:

                String name = mUserName.getText().toString();
                String passWord = mUserPassword.getText().toString();

//                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(passWord) && name.matches("1[0-9]{10}") && passWord.matches("[0-9A-Za-z]{6,16}")) {
//
                    startActivity(new Intent(this, HomeActivity.class));
//
//                } else {
//                    ToastUtils.onShortToast("请输入用户名和密码");
//                }

                break;
            case R.id.tv_forget:
                break;
            default:
        }
    }
}