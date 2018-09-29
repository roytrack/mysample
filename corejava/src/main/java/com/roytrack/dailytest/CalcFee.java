package com.roytrack.dailytest;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Base64;

/**
 * Created by roytrack on 2015/4/19.
 */
public class CalcFee {

  public static void main(String[] args) {
    int[][] taocan = {
            {76, 200, 400, 50},
            {106, 300, 800, 62},
            {136, 500, 1024, 75},
            {166, 500, 2048, 87},
            {196, 500, 3072, 100},
            {296, 1000, 4096, 137},
            {396, 2000, 6114, 179},
            {596, 3000, 11264, 229}
    };
    System.out.println("套餐费用\t返还费用\t实际花费\t分钟数（0.15元/分钟）\t流量（0.3元/M）\t" +
            "分钟折算(元)\t流量折算(元)\t(合计费用/实际花费)");
    NumberFormat f = DecimalFormat.getInstance();
    f.setMaximumFractionDigits(2);
    for (int[] i : taocan) {
      System.out.println(i[0] + "\t\t\t" + i[3] + "\t\t\t" + (i[0] - i[3]) + "\t\t\t" + i[1] + "\t\t\t\t\t\t\t\t"
              + (i[1] >= 1000 ? "" : "\t")
              + i[2] + "\t\t\t\t\t\t"
              + (i[2] >= 1000 ? "" : "\t")
              + f.format(i[1] * 0.15) + "\t\t\t\t\t\t" +
              f.format(i[2] * 0.3)
              + "\t\t\t\t\t"
              + (i[1] < 500 ? "\t" : "")
              + f.format((i[1] * 0.15 + i[2] * 0.3) / (i[0] - i[3]))
      );
    }
    Base64.Encoder ed = Base64.getEncoder();
    Base64.Decoder d = Base64.getDecoder();
    String estr = ed.encodeToString("china unicom bad thing".getBytes());
    System.out.println(estr);
    System.out.println(new String(d.decode(estr.getBytes())));

  }
}
