package com.blc.apps.idcs.admin.error;
public enum ReturnCode {

    /** 操作成功 */
    SUCCESS("200", "操作成功"),

    /** 操作失败 */
    FAIL("400", "操作失败"),

    /** 空指针异常 */
    ERROR_EDIT_PARAMETER("401", "编辑失败，参数错误"),

    /** 自定义异常之返回值为空 */
    ERROR_EDIT_REFERENCE("402", "编辑失败，存在引用关系");

    private ReturnCode(String value, String msg){
        this.val = value;
        this.msg = msg;
    }

    public String val() {
        return val;
    }

    public String msg() {
        return msg;
    }

    private String val;
    private String msg;
    
    public String toString(){
    	return "["+val+"] "+msg;
    }
}