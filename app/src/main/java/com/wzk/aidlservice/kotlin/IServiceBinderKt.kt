package com.wzk.aidlservice.kotlin

import android.os.Binder
import android.os.RemoteException
import android.util.Log
import com.wzk.aidlservice.constance.CmdConstance


class IServiceBinder : com.wzk.aidlservice.IService.Stub() {
    private var mCallBackBinder: com.wzk.aidlclient.ICallBack? = null

    //使用包装类来过滤请求
    private val mCallBack = object : OnCallBack {
        override fun onCallBack(cmd: Int) {
            if (DEBUG) Log.d(TAG, "onCallBack:收到监听并尝试回传$cmd")
            if (mCallBackBinder != null) {
                try {
                    mCallBackBinder!!.onCallBack(cmd)
                    if (DEBUG) Log.d(TAG, "onCallBack:回传成功")

                } catch (e: RemoteException) {
                    e.printStackTrace()
                }

            }
        }
    }

    fun setICallBack(ICallBack: com.wzk.aidlclient.ICallBack) {
        this.mCallBackBinder = ICallBack
    }


    @Throws(RemoteException::class)
    override fun cmd1() {
        try {
            Thread.sleep(10000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        mCallBack.onCallBack(Binder.getCallingPid())
    }

    @Throws(RemoteException::class)
    override fun cmd2() {
        mCallBack.onCallBack(Binder.getCallingUid())

    }

    @Throws(RemoteException::class)
    override fun cmd3() {
        mCallBack.onCallBack(CmdConstance.CMD_3)

    }

    @Throws(RemoteException::class)
    override fun cmd4() {
        mCallBack.onCallBack(CmdConstance.CMD_4)

    }

    @Throws(RemoteException::class)
    override fun cmd5() {
        mCallBack.onCallBack(CmdConstance.CMD_5)
    }

    @Throws(RemoteException::class)
    override fun cmd6() {
        mCallBack.onCallBack(CmdConstance.CMD_6)

    }

    @Throws(RemoteException::class)
    override fun setCallBack(icallBack: com.wzk.aidlclient.ICallBack) {
        mCallBackBinder = icallBack
    }

    private interface OnCallBack {
        fun onCallBack(cmd: Int)
    }

    companion object {

        //---------------DEBUG配置-------------------------------------------------------
        private val TAG = "IServiceBinder"
        private val DEBUG = true
    }
}
