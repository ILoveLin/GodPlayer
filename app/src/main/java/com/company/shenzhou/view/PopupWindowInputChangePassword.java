package com.company.shenzhou.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.company.shenzhou.R;
import com.company.shenzhou.utils.ClearEditText;
import com.yun.common.utils.DensityUtils;
import com.yun.common.utils.ScreenUtils;

/**
 * LoveLin
 * <p>
 * Describe
 */
public class PopupWindowInputChangePassword extends PopupWindow {

    private Activity mContext;
    private ClearEditText cet_user_username;
    private PasswordV2EditText cet_user_password;
    private TextView tv_two_bt_title;
    private TextView tv_add;
    private TextView makeSure;
    private TextView makeCancle;
    private final LinearLayout linear_pop_change;


    public PopupWindowInputChangePassword(Activity context) {
        this.mContext = context;

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.pop_change_password, null);

        tv_add = (TextView) view.findViewById(R.id.tv_add);
        linear_pop_change = (LinearLayout) view.findViewById(R.id.linear_pop_change);
        tv_two_bt_title = (TextView) view.findViewById(R.id.tv_two_bt_title);
        cet_user_username = (ClearEditText) view.findViewById(R.id.cet_user_username);
        cet_user_password = (PasswordV2EditText) view.findViewById(R.id.cet_user_new_password);
//        cet_user_password = (ClearEditText) view.findViewById(R.id.cet_user_new_password);
        makeSure = (TextView) view.findViewById(R.id.tv_bt_ok);
        makeCancle = (TextView) view.findViewById(R.id.tv_bt_cancel);


        int w = ScreenUtils.getScreenWidth(mContext) - DensityUtils.dp2px(mContext, 60);
        int h = context.getWindowManager().getDefaultDisplay().getHeight();
        // ??????SelectPicPopupWindow???View
        this.setContentView(view);
        // ??????SelectPicPopupWindow??????????????????
        this.setWidth(w);
        // ??????SelectPicPopupWindow??????????????????
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        // ??????SelectPicPopupWindow?????????????????????
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        // ???back??????????????????????????????,???????????????????????????OnDismisslistener ????????????????????????????????????
        this.setBackgroundDrawable(new BitmapDrawable());
        // mPopupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
        // ??????SelectPicPopupWindow????????????????????????

    }


    /**
     * ??????popupWindow
     *
     * @param parent
     */
    public void showPopupWindow(View parent, int gravity) {
        if (!this.isShowing()) {
            // ?????????????????????popupwindow
            setBackgroundAlpha(mContext, 0.5f);
            this.showAtLocation(parent, gravity, 0, 0);
        } else {
            this.dismiss();
        }

    }

    public LinearLayout getLinear_pop_change() {
        return linear_pop_change;
    }

    @Override
    public void dismiss() {
        super.dismiss();
        setBackgroundAlpha(mContext, 1f);
    }

    public TextView getTv_two_bt_title() {
        return tv_two_bt_title;
    }

    public void setTv_two_bt_title(TextView tv_two_bt_title) {
        this.tv_two_bt_title = tv_two_bt_title;
    }

    public TextView getTv_add() {
        return tv_add;
    }

    public void setTv_add(TextView tv_add) {
        this.tv_add = tv_add;
    }

    public static void setBackgroundAlpha(Activity activity, float bgAlpha) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        window.setAttributes(lp);
    }

    public ClearEditText getCet_user_username() {
        return cet_user_username;
    }

    public void setCet_user_username(ClearEditText cet_user_username) {
        this.cet_user_username = cet_user_username;
    }

    public PasswordV2EditText getCet_user_password() {
        return cet_user_password;
    }

    public void setCet_user_password(PasswordV2EditText cet_user_password) {
        this.cet_user_password = cet_user_password;
    }

    public TextView getMakeSure() {
        return makeSure;
    }

    public void setMakeSure(TextView makeSure) {
        this.makeSure = makeSure;
    }

    public TextView getMakeCancle() {
        return makeCancle;
    }

    public void setMakeCancle(TextView makeCancle) {
        this.makeCancle = makeCancle;
    }
    /**
     * ????????????
     */
//    private void showSaveDialog() {
//        final PopupWindowTwoButton twoButton = new PopupWindowTwoButton((Activity) mContext);
//        twoButton.getTv_content().setText("?????????????????????");
//        twoButton.getTv_ok().setText("??????");
//        twoButton.getTv_cancel().setText("??????");
//        twoButton.getTv_ok().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SharePreferenceUtil.put(mContext, Global.LOGIN_FLAG, false);
//                SharePreferenceUtil.put(mContext, Global.KEY_ID, "");
//                mView.showMyToast("????????????");
//                twoButton.dismiss();
//                mView.openActivity();
//            }
//        });
//        twoButton.getTv_cancel().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                twoButton.dismiss();
//            }
//        });
//        twoButton.showPopupWindow(mView.getExitView(), Gravity.CENTER);
//    }
}
