package com.kata;

public class Parser {

  public static final int LIMIT = 1000;

  public static int getPositiveInt(final String number) throws Exception {
    int result = Integer.parseInt(number);

    if (result < 0) {
      throw new Exception("negatives not allowed");
    }

    if (result > LIMIT) {
      result = 0;
    }

    return result;
  }
}
