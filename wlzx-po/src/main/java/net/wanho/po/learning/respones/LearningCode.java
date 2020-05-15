package net.wanho.po.learning.respones;

import lombok.ToString;
import net.wanho.common.exception.ExceptionResult;


@ToString
public enum LearningCode implements ExceptionResult {
    LEARNING_GETMEDIA_ERROR(false,23001,"获取学习地址失败！");
    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private LearningCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
