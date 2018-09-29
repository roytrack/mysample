package com.roytrack.dailytest.randomAndFun;

/**
 * Created by Administrator on 2017/11/7.
 */
public class BusTicketCalc {
  public static void main(String[] args) {
    double totalAmount = 0, oneCost = 4, savedAmount = 0;
    for (int i = 0; i < 31; i++) {
      double morning = 0, afternoon = 0;
      if (totalAmount > 100 && totalAmount < 150) {
        morning += 3.2;
        savedAmount += 0.8;
      } else if (totalAmount > 150) {
        morning += 2;
        savedAmount += 2;
      } else {
        morning = oneCost;
      }
      totalAmount += morning;
      if (totalAmount > 100 && totalAmount < 150) {
        afternoon += 3.2;
        savedAmount += 0.8;
      } else if (totalAmount > 150) {
        afternoon += 2;
        savedAmount += 2;
      } else {
        afternoon = oneCost;
      }
      totalAmount += afternoon;

      System.out.println("第" + (i + 1) + "天，上午公交车费" + morning + "元，下午公交车费" + afternoon + "元，月总费用" + totalAmount + "元,节省" + savedAmount + "元");

    }
  }
}
