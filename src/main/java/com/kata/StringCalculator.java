package com.kata;

import com.kata.add.*;
import com.kata.contain.*;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.kata.config.ConstantSeparators.COMMA;

public class StringCalculator
{

    public static String DELIMITER;

    public StringCalculator() {
        DELIMITER = COMMA;
    }

    static Map<IsContained, AddInterface> addMap = new LinkedHashMap<>();
    static {
        addMap.put(new IsContainedDelimiterWithNewLine(), new AddCommaWithNewLine());
        addMap.put(new IsContainedLineExpression(), new AddLineExpression());
        addMap.put(new IsContainedDelimiterExpression(), new AddDelimiterExpression());
        addMap.put(new IsContainedOneNumber(), new AddOneNumber());
    }

    public int Add(final String expression) throws Exception {
        String actualExpression = updateDelimiter(expression);

        int result = 0; // only for empty expression
        for (Map.Entry<IsContained, AddInterface> entry : addMap.entrySet()) {
            if (entry.getKey().isContained(actualExpression)) {
                result = entry.getValue().add(actualExpression);
                break;
            }
        }

        return result;
    }

    private String updateDelimiter(String expression) {
        String actualExpression = expression;
        IsContainedNewDelimiter isContainedNewDelimiter = new IsContainedNewDelimiter();
        if (isContainedNewDelimiter.isContained(expression)) {
            String readDelimiters = "";
            int count = countChar(expression, '[');
            int end = 0;
            int begin = 0;

            for (int index = 0; index < count; index++){
                begin = expression.indexOf("[", begin + 1);
                end  = expression.indexOf("]", end + 1);
                readDelimiters += expression.substring(begin +1, end);
            }

            DELIMITER  = readDelimiters;
            actualExpression = expression.substring(end + 2);
        }
        return actualExpression;
    }

    private int countChar(final String string, char c) {
        int count = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == c) {
                count++;
            }
        }

        return count;
    }
}
