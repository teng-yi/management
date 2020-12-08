package com.why.myapplication.base;


import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.why.myapplication.interfaces.IBasePresenter;
import com.why.myapplication.interfaces.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

/**
 * @author why
 */
public abstract class BaseActivity<P extends IBasePresenter> extends AppCompatActivity implements IBaseView {
    protected P mPresenter;
    private Unbinder bind;

    /**
     * 如果勾选了不再询问
     */
    private static final int NOT_NOTICE = 2;

    private AlertDialog alertDialog;
    private AlertDialog mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        //绑定ButterKnife
        bind = ButterKnife.bind(this);

        //找控件
        initView();

        //权限处理
        initPresenter();

        //初始化P层
        mPresenter = onCreatePresenter();
        if (mPresenter != null) {

            //P层与V层关联
            mPresenter.onAttachView(this);
            //加载数据
            initData();
        }
    }

    /**
     * 绑定布局
     *
     * @return
     */
    protected abstract int getLayout();

    /**
     * 绑定数据
     *
     * @return
     */
    protected abstract P onCreatePresenter();

    /**
     * 绑定控件
     */
    protected abstract void initView();

    /**
     * 设置数据
     */
    protected abstract void initData();

    @Override
    public void showTips(String tips) {

    }

    @Override
    public void showLoading(int visible) {

    }

    private void initPresenter() {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                //选择了“始终允许”
                if (grantResults[i] == PERMISSION_GRANTED) {

                } else {
                    if (!ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[i])) {//用户选择了禁止不再询问

                        AlertDialog.Builder builder = new AlertDialog.Builder(BaseActivity.this);
                        builder.setTitle("permission")
                                .setMessage("点击允许才可以使用我们的app哦")
                                .setPositiveButton("去允许", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int id) {
                                        if (mDialog != null && mDialog.isShowing()) {
                                            mDialog.dismiss();
                                        }
                                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                        Uri uri = Uri.fromParts("package", getPackageName(), null);//注意就是"package",不用改成自己的包名
                                        intent.setData(uri);
                                        startActivityForResult(intent, NOT_NOTICE);
                                    }
                                });
                        mDialog = builder.create();
                        mDialog.setCanceledOnTouchOutside(false);
                        mDialog.show();

                    } else {//选择禁止
                        AlertDialog.Builder builder = new AlertDialog.Builder(BaseActivity.this);
                        builder.setTitle("permission")
                                .setMessage("点击允许才可以使用我们的app哦")
                                .setPositiveButton("去允许", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int id) {
                                        if (alertDialog != null && alertDialog.isShowing()) {
                                            alertDialog.dismiss();
                                        }
                                        ActivityCompat.requestPermissions(BaseActivity.this,
                                                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                                    }
                                });
                        alertDialog = builder.create();
                        alertDialog.setCanceledOnTouchOutside(false);
                        alertDialog.show();
                    }
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //P层调用接触关联的方法
        if (mPresenter != null) {
            mPresenter.onDetach();
        }

        //ButterKnife 解除绑定
        if (bind != null) {
            bind.unbind();
        }
    }
}
