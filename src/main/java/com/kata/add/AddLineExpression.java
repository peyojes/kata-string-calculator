package com.kata.add;

import java.util.StringTokenizer;

import static com.kata.config.ConstantSeparators.NEW_LINE;

public class AddLineExpression implements AddInterface {

  private AddDelimiterExpression addDelimiterExpression;

  public AddLineExpression() {
    this.addDelimiterExpression = new AddDelimiterExpression();
  }

  @Override
  public int add(String expression) throws Exception {
    int result = 0;
    StringTokenizer tokenizer = new StringTokenizer(expression, NEW_LINE);
    while (tokenizer.hasMoreElements()) {
      result += addDelimiterExpression.add(tokenizer.nextToken());
    }
    return result;
  }
}
