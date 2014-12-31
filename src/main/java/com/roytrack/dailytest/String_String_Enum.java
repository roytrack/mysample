package com.roytrack.dailytest;

/**
 * Created by ruanchangming on 2014/12/30.
 */
public enum String_String_Enum {
    UNKNOWN("未知", "-999"),
    REBATE_IMPORT("返利上传","1000"),
    REBATE_FREEZ("返利冻结","1001"),
    REBATE_FREEZ_CANCEL("解除返利冻结","1002"),
    REBATE_ORDER_COST("下单消耗","1003"),
    REBATE_ORDER_CANCEL("订单取消","1004"),
    REBATE_ORDER_REFUND("订单退货","1005"),
    REBATE_TRANSF("商家返利互转","1006"),
    REBATE_AVIAL("可用返利余额调整","1007"),
    BELUM_IMPORT("回款上传","2000"),
    BELUM_ORDER_COST("订单消耗","2001"),
    BELUM_ORDER_CANCEL("订单取消","2002"),
    BELUM_ORDER_REFUND("订单退货","2003"),
    BELUM_BALANCE_ADJUST("余额调整","2004");


    private String value;
    private String desc;

    private String_String_Enum(String desc, String value){
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static String_String_Enum getEnum(String type) {
        String_String_Enum[] status = String_String_Enum.values();
        for (int i = 0; i < status.length; i++) {
            if (status[i].getValue().equals(type) ) {
                return status[i];
            }
        }
        return UNKNOWN;
    }
}
