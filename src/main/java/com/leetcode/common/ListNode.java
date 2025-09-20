package com.leetcode.common;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@JsonDeserialize(using = ListNode.ListNodeDeserializer.class)
public final class ListNode {

    public int val;
    public ListNode next;

    @Override
    public int hashCode() {
        return 1;
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
        return toString(new StringBuilder(), new HashSet<>());
    }

    private String toString(StringBuilder builder, Set<ListNode> nodes) {
        builder.append(val);
        if (!nodes.add(this)) {
            return builder.append('*').toString();
        }
        if (next == null) {
            return builder.toString();
        }
        builder.append(" -> ");
        return next.toString(builder, nodes);
    }

    static final class ListNodeDeserializer extends StdDeserializer<ListNode> {

        ListNodeDeserializer() {
            super(ListNode.class);
        }

        @Override
        public ListNode deserialize(JsonParser jsonParser, DeserializationContext context)
            throws IOException {
            var values = jsonParser.readValueAs(int[].class);
            if (values.length == 0) {
                return null;
            }
            ListNode head = null;
            for (var i = values.length - 1; i >= 0; i--) {
                var node = new ListNode();
                node.val = values[i];
                node.next = head;
                head = node;
            }
            return head;
        }
    }
}
