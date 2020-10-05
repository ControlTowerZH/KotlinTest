package com.haohao.kotlintest.function.mvvm;

import java.util.Random;

/**
 * Description :
 *
 * @author Wanderer
 * @date 2020/9/19
 */
public class MVVMModel {
    //模拟查询账号数据
    public void getAccountData(String accountName, MCallBack callback) {
        Random random = new Random();
        boolean isSuccess = random.nextBoolean();
        if (isSuccess) {
            Account account = new Account();
            account.name = (accountName);
            account.level = (100);
            callback.onSuccess(account);
        } else {
            callback.onFailed();
        }
    }
}
