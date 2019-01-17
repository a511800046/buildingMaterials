package com.common.base.model;

/**
 * @program: saleSystem
 * @description: Sql日志model
 * @author: chengy
 * @create: 2018-07-09 17:17
 **/
public class Sqllog {

    private static final long serialVersionUID = 7003339443903675827L;
    private String sql;
    private Long timeConsuming;
    private String success;
    private String callLocation;
    private int lineNum;
    private String argsInfo;
    private Object[] args;

    public Sqllog() {
    }

    public Sqllog(String sql, Long timeConsuming, String success, String callLocation, int lineNum, Object[] args) {
        this.sql = sql;
        this.timeConsuming = timeConsuming;
        this.success = success;
        this.callLocation = callLocation;
        this.lineNum = lineNum;
        this.args = args;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String toString() {
        if (args != null && args.length > 0) {
            for (Object str : args) {
                this.sql = this.sql.replaceFirst("\\?", "'" + str.toString() + "'");
            }
        }
        String str = "Sql日志: sql [ " + this.sql + " ] 调用位置 [ " + this.callLocation + ":" + this.lineNum + " ] 消耗时间 [" + timeConsuming + "毫秒] 是否成功 [" + success + "]";
        return str;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Long getTimeConsuming() {
        return timeConsuming;
    }

    public void setTimeConsuming(Long timeConsuming) {
        this.timeConsuming = timeConsuming;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getCallLocation() {
        return callLocation;
    }

    public void setCallLocation(String callLocation) {
        this.callLocation = callLocation;
    }

    public int getLineNum() {
        return lineNum;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }

    public String getArgsInfo() {
        return argsInfo;
    }

    public void setArgsInfo(String argsInfo) {
        this.argsInfo = argsInfo;
    }
}
