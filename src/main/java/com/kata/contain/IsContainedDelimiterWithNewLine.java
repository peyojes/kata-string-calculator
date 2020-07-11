package com.kata.contain;

import static com.kata.StringCalculator.DELIMITER;
import static com.kata.config.ConstantSeparators.*;

public class IsContainedDelimiterWithNewLine implements IsContained {
  @Override
  public boolean isContained(String expression) {
    return expression.contains(NEW_LINE +  DELIMITER) || expression.contains(DELIMITER + NEW_LINE);
  }
}
