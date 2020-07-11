package com.kata.contain;

import static com.kata.config.ConstantSeparators.NEW_LINE;

public class IsContainedLineExpression implements IsContained {
  @Override
  public boolean isContained(String expression) {
    return expression.contains(NEW_LINE);
  }
}
