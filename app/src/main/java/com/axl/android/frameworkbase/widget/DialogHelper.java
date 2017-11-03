package com.axl.android.frameworkbase.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;

import com.axl.android.frameworkbase.R;


/**
 * Dialog统一调用该类
 * Created by duanxinmeng on 2016/1/21.
 */
public class DialogHelper {
    private Context context;

    public DialogHelper(Context context) {
        this.context = context;
    }

    public Dialog getLoadingDialog() {
        Dialog dialog = new Dialog(context, R.style.dialog_trans);
        dialog.setContentView(R.layout.progress);
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }

    /****
     * 确认取消 弹窗
     *
     * @param message
     */
    public void showAlert(String message) {
        showAlert(null, message, false);
    }

    public void showAlertSingleBtn(String message) {
        showAlert(null, message, true);
    }

    public void showAlertSingleBtn(String title, String message) {
        showAlert(title, message, true);
    }

    public void showAlertSingleBtn(int message) {
        showAlert(null, getString(message), true);
    }

    public void showAlertSingleBtn(int title,int message) {
        showAlert(getString(title), getString(message), true);
    }

    /****
     * 确认取消 弹窗
     *
     * @param message
     */
    public AlertDialog showAlert(String title, String message, boolean singleBtn) {
        return showAlert(title, message, singleBtn ? "" : getString(R.string.cancel), getString(R.string.ok));
    }

    /****
     * 确认取消 弹窗
     *
     * @param message
     */
    public void showAlertNobtns(String title, String message) {
        showAlert(title, message, null, null);
    }

    /****
     * 确认取消 弹窗
     *
     * @param message
     * @param title
     * @param btnLeft
     * @param btnRight
     */
    public AlertDialog showAlert(String title, String message, String btnLeft, String btnRight) {
        return showAlert(title, message, btnLeft, btnRight, null, null);
    }

    public AlertDialog showAlert(int message, DialogInterface.OnClickListener onClickListener, DialogInterface.OnDismissListener onDismissListener) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.dialog);
            AlertDialog dialog = builder.setMessage(message).setPositiveButton(R.string.ok, onClickListener).create();
            dialog.show();
            dialog.setOnDismissListener(onDismissListener);
            return dialog;
        } catch (Exception e) {

        }
        return null;
    }

    /****
     * 确认取消 弹窗
     *
     * @param message
     * @param title
     * @param btnLeft
     * @param btnRight
     * @param leftOnclickListener
     * @param rightOnclickListener
     */
    public AlertDialog showAlert(String title, String message, String btnLeft, String btnRight, DialogInterface.OnClickListener leftOnclickListener, DialogInterface.OnClickListener rightOnclickListener) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.dialog);
            AlertDialog dialog = builder.setMessage(message).setTitle(title).setNegativeButton(btnLeft, leftOnclickListener).setPositiveButton(btnRight, rightOnclickListener).create();
            dialog.show();
            return dialog;
        } catch (Exception e) {
            return null;
        }
    }

    /****
     * 确认取消 弹窗
     *
     * @param message
     * @param title
     * @param btnLeft
     * @param btnRight
     * @param leftOnclickListener
     * @param rightOnclickListener
     */
    public void showAlertNoCancel(String title, String message, String btnLeft, String btnRight, DialogInterface.OnClickListener leftOnclickListener, DialogInterface.OnClickListener rightOnclickListener) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.dialog);
            if (!TextUtils.isEmpty(btnLeft)) {
                builder.setNegativeButton(btnLeft, leftOnclickListener);
            }
            if (!TextUtils.isEmpty(btnRight)) {
                builder.setPositiveButton(btnRight, rightOnclickListener);
            }
            AlertDialog dialog = builder.setMessage(message).setTitle(title).create();
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        } catch (Exception e) {

        }
    }

    /****
     * 确认取消 弹窗
     *
     * @param messageId
     */
    public AlertDialog showAlert(int messageId) {
        return showAlert(null, getString(messageId), false);
    }

    /****
     * 确认取消 弹窗
     *
     * @param messageId
     * @param titleId
     */
    public void showAlert(int titleId, int messageId) {
        showAlert(getString(titleId), getString(messageId), getString(R.string.cancel), getString(R.string.ok));
    }

    /****
     * 确认取消 弹窗
     *
     * @param titleId
     * @param messageId
     * @param btnLeftId
     * @param btnRightId
     */
    public void showAlert(int titleId, int messageId, int btnLeftId, int btnRightId) {
        showAlert(getString(titleId), getString(messageId), getString(btnLeftId), getString(btnRightId));
    }

    /****
     * 确认取消 弹窗
     *
     * @param titleId
     * @param messageId
     * @param btnLeftId
     * @param btnRightId
     * @param leftOnclickListener
     * @param rightOnclickListener
     */
    public void showAlert(int titleId, int messageId, int btnLeftId, int btnRightId, DialogInterface.OnClickListener leftOnclickListener, DialogInterface.OnClickListener rightOnclickListener) {
        showAlert(getString(titleId), getString(messageId), getString(btnLeftId), getString(btnRightId), leftOnclickListener, rightOnclickListener);
    }

    /****
     * 确认取消 弹窗
     *
     * @param titleId
     * @param messageId
     * @param btnLeftId
     * @param btnRightId
     * @param leftOnclickListener
     * @param rightOnclickListener
     */
    public void showAlertNoCancel(int titleId, int messageId, int btnLeftId, int btnRightId, DialogInterface.OnClickListener leftOnclickListener, DialogInterface.OnClickListener rightOnclickListener) {
        showAlertNoCancel(getString(titleId), getString(messageId), getString(btnLeftId), getString(btnRightId), leftOnclickListener, rightOnclickListener);
    }

    /***
     * @param resId
     * @return
     */
    public String getString(int resId) {
        if (resId <= 0) {
            return null;
        }
        return context.getString(resId);
    }

    /****
     * @param id
     * @return
     */
    public int getColor(int id) {
        return context.getResources().getColor(id);
    }

    /****
     * 长按弹窗
     *
     * @param strings
     */
    public void showListDialog(String[] strings, DialogInterface.OnClickListener onClickListener) {
        showListDialog(null, null, strings, onClickListener);
    }

    /****
     * 长按弹窗
     *
     */
    public void showListDialog(Integer[] ids, DialogInterface.OnClickListener onClickListener) {
        showListDialog(null, null, ids, onClickListener);
    }

    /****
     * 长按弹窗
     *
     */
    public void showListDialog(int titleResId, int messageResId, String[] strings, DialogInterface.OnClickListener onClickListener) {
        showListDialog(context.getString(titleResId), context.getString(messageResId), strings, onClickListener);
    }

    /****
     * 长按弹窗
     *
     * @param strings
     */
    public void showListDialog(String title, String message, String[] strings, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog dialog = builder.setTitle(title).setMessage(message).setItems(strings, onClickListener).create();
        dialog.show();
    }

    /****
     * 长按弹窗
     */
    public void showListDialog(String title, String message, Integer[] ids, DialogInterface.OnClickListener onClickListener) {
        if(ids == null){
            return;
        }
        String[] strings = new String[ids.length];
        for (int i = 0;i < ids.length;i++) {
            strings[i] = context.getString(ids[i]);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog dialog = builder.setTitle(title).setMessage(message).setItems(strings, onClickListener).create();
        dialog.show();
    }

    /****
     * 单选弹窗
     *
     * @param title
     * @param items
     * @param checkedItem
     * @param onClickListener
     */
    public void showSingleChoiceDialog(String title, String[] items, int checkedItem, DialogInterface.OnClickListener onClickListener) {
        showSingleChoiceDialog(title, items, checkedItem, onClickListener, null, null, null, null);
    }

    /****
     * 单选弹窗+按钮
     *
     * @param title
     * @param items
     * @param checkedItem
     * @param onClickListener
     * @param leftStr
     * @param rightStr
     * @param leftOnclickListener
     * @param rightOnclickListener
     */
    public void showSingleChoiceDialog(String title, String[] items, int checkedItem, DialogInterface.OnClickListener onClickListener, String leftStr, String rightStr, DialogInterface.OnClickListener leftOnclickListener, DialogInterface.OnClickListener rightOnclickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.dialog);
        AlertDialog dialog = builder.setTitle(title).setSingleChoiceItems(items, checkedItem, onClickListener).setNegativeButton(leftStr, leftOnclickListener).setPositiveButton(rightStr, rightOnclickListener).create();
        dialog.show();
    }
}
