package com.kata.contain;

import static com.kata.StringCalculator.DELIMITER;

public class IsContainedDelimiterExpression implements IsContained {
  @Override
  public boolean isContained(String expression) {
    boolean contains = expression.contains(DELIMITER.substring(0, 1));
    return contains;
  }
}

