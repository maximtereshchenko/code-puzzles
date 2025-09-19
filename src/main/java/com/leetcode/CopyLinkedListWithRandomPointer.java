package com.leetcode;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

final class CopyLinkedListWithRandomPointer {

    Node copyRandomList(Node head) {
        return copyRandomList(new HashMap<>(), head);
    }

    private Node copyRandomList(Map<Node, Node> nodes, Node original) {
        if (original == null) {
            return null;
        }
        if (nodes.containsKey(original)) {
            return nodes.get(original);
        }
        var copy = new Node(original.val);
        nodes.put(original, copy);
        copy.next = copyRandomList(nodes, original.next);
        copy.random = copyRandomList(nodes, original.random);
        return copy;
    }

    @JsonDeserialize(using = Node.NodeDeserializer.class)
    static class Node {

        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
        }

        static boolean equals(Node first, Node second) {
            var firstNodes = new LinkedHashSet<Node>();
            if (first != null) {
                first.walk(firstNodes);
            }
            var secondNodes = new LinkedHashSet<Node>();
            if (second != null) {
                second.walk(secondNodes);
            }
            var firstIterator = firstNodes.iterator();
            var secondIterator = secondNodes.iterator();
            while (firstIterator.hasNext() && secondIterator.hasNext()) {
                if (firstIterator.next().val != secondIterator.next().val) {
                    return false;
                }
            }
            return !firstIterator.hasNext() && !secondIterator.hasNext();
        }

        private static Node from(Integer[][] pairs) {
            return node(new HashMap<>(), 0, pairs);
        }

        private static Node node(Map<Integer, Node> nodes, int index, Integer[][] pairs) {
            if (index == pairs.length) {
                return null;
            }
            if (nodes.containsKey(index)) {
                return nodes.get(index);
            }
            var pair = pairs[index];
            var node = new Node(pair[0]);
            nodes.put(index, node);
            node.next = node(nodes, index + 1, pairs);
            if (pair[1] != null) {
                node.random = node(nodes, pair[1], pairs);
            }
            return node;
        }

        @Override
        public String toString() {
            return toString(new StringBuilder());
        }

        private void walk(LinkedHashSet<Node> nodes) {
            if (!nodes.add(this)) {
                return;
            }
            if (next != null) {
                next.walk(nodes);
            }
            if (random != null) {
                random.walk(nodes);
            }
        }

        private String toString(StringBuilder builder) {
            builder.append(val);
            if (random != null) {
                builder.append('(').append(random.val).append(')');
            }
            if (next == null) {
                return builder.toString();
            }
            return next.toString(builder.append(" -> "));
        }

        static final class NodeDeserializer extends StdDeserializer<Node> {

            NodeDeserializer() {
                super(Node.class);
            }

            @Override
            public Node deserialize(JsonParser jsonParser, DeserializationContext context)
                throws IOException {
                return Node.from(jsonParser.readValueAs(Integer[][].class));
            }
        }
    }
}
