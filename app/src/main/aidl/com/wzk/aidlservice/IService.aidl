// IService.aidl
package com.wzk.aidlservice;
import com.wzk.aidlservice.ICallBack;
// Declare any non-default types here with import statements
interface IService {
     void cmd1();
     void cmd2();
     void cmd3();
     void cmd4();
     void cmd5();
     void cmd6();
     void setCallBack(ICallBack icallBack);
}
