package com.kata.contain;

public class IsContainedNewDelimiter implements IsContained {
  @Override
  public boolean isContained(String expression) {
    return expression.contains("//[");
  }
}
