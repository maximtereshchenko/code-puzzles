package com.leetcode;

import java.util.ArrayList;
import java.util.List;

//https://neetcode.io/problems/string-encode-and-decode
final class EncodeAndDecodeStrings {

    private static final char DELIMITER = '#';

    String encode(List<String> strings) {
        var builder = new StringBuilder();
        for (var string : strings) {
            builder.append(string.length())
                .append(DELIMITER)
                .append(string);
        }
        return builder.toString();
    }

    List<String> decode(String string) {
        var strings = new ArrayList<String>();
        var index = 0;
        while (index < string.length()) {
            var delimiterIndex = string.indexOf(DELIMITER, index);
            var start = delimiterIndex + 1;
            var end = start + Integer.parseInt(string.substring(index, delimiterIndex));
            strings.add(
                string.substring(
                    start,
                    end
                )
            );
            index = end;
        }
        return strings;
    }
}
