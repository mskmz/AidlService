package com.wzk.aidlservice;

import android.os.RemoteException;
import android.util.Log;

import com.wzk.aidlservice.constance.CmdConstance;

public class IServiceBinder extends com.wzk.aidlservice.IService.Stub {

    //---------------DEBUG配置-------------------------------------------------------
    private static final String TAG = "IServiceBinder";
    private static final boolean DEBUG = true;
    private com.wzk.aidlservice.ICallBack ICallBack;

    public void setICallBack(com.wzk.aidlservice.ICallBack ICallBack) {
        this.ICallBack = ICallBack;
    }

    private onCallBack mCallBack = new onCallBack() {
        @Override
        public void onCallBack(int cmd) {
            if (DEBUG) Log.d(TAG, "onCallBack:收到监听并尝试回传" + cmd);
            if (ICallBack != null) {
                try {
                    ICallBack.onCallBack(cmd);
                    if (DEBUG) Log.d(TAG, "onCallBack:回传成功");

                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    };


    @Override
    public void cmd1() throws RemoteException {
        mCallBack.onCallBack(CmdConstance.CMD_1);
    }

    @Override
    public void cmd2() throws RemoteException {
        mCallBack.onCallBack(CmdConstance.CMD_2);

    }

    @Override
    public void cmd3() throws RemoteException {
        mCallBack.onCallBack(CmdConstance.CMD_3);

    }

    @Override
    public void cmd4() throws RemoteException {
        mCallBack.onCallBack(CmdConstance.CMD_4);

    }

    @Override
    public void cmd5() throws RemoteException {
        mCallBack.onCallBack(CmdConstance.CMD_5);
    }

    @Override
    public void cmd6() throws RemoteException {
        mCallBack.onCallBack(CmdConstance.CMD_6);

    }

    @Override
    public void setCallBack(com.wzk.aidlservice.ICallBack icallBack) throws RemoteException {
        ICallBack = icallBack;
    }

    private interface onCallBack {
        void onCallBack(int cmd);
    }
}
