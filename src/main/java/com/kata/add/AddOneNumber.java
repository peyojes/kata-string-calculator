package com.kata.add;

import com.kata.Parser;

public class AddOneNumber implements AddInterface {
  @Override
  public int add(String expression) throws Exception {
    return Parser.getPositiveInt(expression);
  }
}
