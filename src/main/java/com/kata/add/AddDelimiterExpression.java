package com.kata.add;

import com.kata.Parser;

import java.util.StringTokenizer;

import static com.kata.StringCalculator.DELIMITER;

public class AddDelimiterExpression implements AddInterface {
  @Override
  public int add(String expression) throws Exception {
    int result = 0;
    StringTokenizer tokenizer = new StringTokenizer(expression, DELIMITER);
    while (tokenizer.hasMoreElements()) {
      result += Parser.getPositiveInt(tokenizer.nextToken());
    }
    return result;
  }
}
