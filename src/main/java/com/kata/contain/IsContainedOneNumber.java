package com.kata.contain;

public class IsContainedOneNumber implements IsContained {
  @Override
  public boolean isContained(String expression) {
    return !expression.isEmpty();
  }
}
