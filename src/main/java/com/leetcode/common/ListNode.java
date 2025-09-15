package com.leetcode.common;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Objects;

@JsonDeserialize(using = ListNode.ListNodeDeserializer.class)
public final class ListNode {

    public int val;
    public ListNode next;

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int val) {
        this(val, null);
    }

    public ListNode() {}

    private static ListNode from(int[] values) {
        if (values.length == 0) {
            return null;
        }
        var head = new ListNode(values[0]);
        var current = head;
        for (var i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        return object instanceof ListNode listNode &&
                   val == listNode.val &&
                   Objects.equals(next, listNode.next);
    }

    @Override
    public String toString() {
        if (next == null) {
            return String.valueOf(val);
        }
        return "%d -> %s".formatted(val, next);
    }

    static final class ListNodeDeserializer extends StdDeserializer<ListNode> {

        ListNodeDeserializer() {
            super(ListNode.class);
        }

        @Override
        public ListNode deserialize(JsonParser jsonParser, DeserializationContext context)
            throws IOException {
            var values = jsonParser.readValueAs(int[].class);
            return ListNode.from(values);
        }
    }
}
