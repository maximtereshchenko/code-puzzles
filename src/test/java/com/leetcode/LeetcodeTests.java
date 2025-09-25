package com.leetcode;

import com.leetcode.common.ListNode;
import com.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

final class LeetcodeTests {

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Group Anagrams")
    void groupAnagrams(String[] strings, List<List<String>> expected) {
        assertThat(sorted(new GroupAnagrams().groupAnagrams(strings))).isEqualTo(sorted(expected));
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Top K Frequent Elements")
    void topKFrequent(int[] numbers, int k, int[] expected) {
        assertThat(new TopKFrequentElements().topKFrequent(numbers, k)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Encode and Decode Strings")
    void encodeAndDecodeStrings(List<String> strings) {
        var solution = new EncodeAndDecodeStrings();
        assertThat(solution.decode(solution.encode(strings))).isEqualTo(strings);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Product of Array Except Self")
    void productExceptSelf(int[] numbers, int[] expected) {
        assertThat(new ProductOfArrayExceptSelf().productExceptSelf(numbers)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Valid Sudoku")
    void isValidSudoku(char[][] board, boolean expected) {
        assertThat(new ValidSudoku().isValidSudoku(board)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Longest Consecutive Sequence")
    void longestConsecutive(int[] numbers, int expected) {
        assertThat(new LongestConsecutiveSequence().longestConsecutive(numbers))
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Valid Palindrome")
    void isPalindrome(String string, boolean expected) {
        assertThat(new ValidPalindrome().isPalindrome(string)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Two Sum II - Input Array Is Sorted")
    void twoSum(int[] numbers, int target, int[] expected) {
        assertThat(new TwoSumInputArrayIsSorted().twoSum(numbers, target)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("3Sum")
    void threeSum(int[] numbers, List<List<Integer>> expected) {
        assertThat(sorted(new ThreeSum().threeSum(numbers))).isEqualTo(sorted(expected));
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Container With Most Water")
    void maxArea(int[] height, int expected) {
        assertThat(new ContainerWithMostWater().maxArea(height)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Trapping Rain Water")
    void trap(int[] height, int expected) {
        assertThat(new TrappingRainWater().trap(height)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Best Time to Buy and Sell Stock")
    void maxProfit(int[] prices, int expected) {
        assertThat(new BestTimeToBuyAndSellStock().maxProfit(prices)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Longest Substring Without Repeating Characters")
    void lengthOfLongestSubstring(String string, int expected) {
        assertThat(
            new LongestSubstringWithoutRepeatingCharacters()
                .lengthOfLongestSubstring(string)
        )
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Longest Repeating Character Replacement")
    void characterReplacement(String string, int maxReplacements, int expected) {
        assertThat(
            new LongestRepeatingCharacterReplacement()
                .characterReplacement(string, maxReplacements)
        )
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Permutation in String")
    void checkInclusion(String source, String target, boolean expected) {
        assertThat(new PermutationInString().checkInclusion(source, target)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Minimum Window Substring")
    void minWindow(String string, String pattern, String expected) {
        assertThat(new MinimumWindowSubstring().minWindow(string, pattern)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Sliding Window Maximum")
    void maxSlidingWindow(int[] numbers, int windowSize, int[] expected) {
        assertThat(new SlidingWindowMaximum().maxSlidingWindow(numbers, windowSize))
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Valid Parentheses")
    void isValid(String string, boolean expected) {
        assertThat(new ValidParentheses().isValid(string)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Min Stack")
    void minStack(List<String> commands, List<List<Integer>> arguments, List<Integer> expected) {
        var actual = new ArrayList<Integer>();
        MinStack solution = null;
        for (var i = 0; i < commands.size(); i++) {
            actual.add(
                switch (commands.get(i)) {
                    case "MinStack" -> {
                        solution = new MinStack();
                        yield null;
                    }
                    case "push" -> {
                        solution.push(arguments.get(i).getFirst());
                        yield null;
                    }
                    case "pop" -> {
                        solution.pop();
                        yield null;
                    }
                    case "top" -> solution.top();
                    case "getMin" -> solution.getMin();
                    default -> throw new IllegalArgumentException();
                }
            );
        }
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Evaluate Reverse Polish Notation")
    void evalRPN(String[] tokens, int expected) {
        assertThat(new EvaluateReversePolishNotation().evalRPN(tokens)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Generate Parentheses")
    void generateParenthesis(int total, List<String> expected) {
        assertThat(new GenerateParentheses().generateParenthesis(total)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Daily Temperatures")
    void dailyTemperatures(int[] temperatures, int[] expected) {
        assertThat(new DailyTemperatures().dailyTemperatures(temperatures)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Car Fleet")
    void carFleet(int target, int[] positions, int[] speeds, int expected) {
        assertThat(new CarFleet().carFleet(target, positions, speeds)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Largest Rectangle in Histogram")
    void largestRectangleArea(int[] heights, int expected) {
        assertThat(new LargestRectangleInHistogram().largestRectangleArea(heights))
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Binary Search")
    void search(int[] numbers, int target, int expected) {
        assertThat(new BinarySearch().search(numbers, target)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Search a 2D Matrix")
    void searchMatrix(int[][] matrix, int target, boolean expected) {
        assertThat(new Search2DMatrix().searchMatrix(matrix, target)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Koko Eating Bananas")
    void minEatingSpeed(int[] piles, int hours, int expected) {
        assertThat(new KokoEatingBananas().minEatingSpeed(piles, hours)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Find Minimum in Rotated Sorted Array")
    void findMin(int[] numbers, int expected) {
        assertThat(new FindMinimumInRotatedSortedArray().findMin(numbers)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Search in Rotated Sorted Array")
    void searchInRotatedSortedArray(int[] numbers, int target, int expected) {
        assertThat(new SearchInRotatedSortedArray().search(numbers, target)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Time Based Key-Value Store")
    void timeBasedKeyValueStore(
        List<String> commands,
        List<List<Object>> arguments,
        List<String> expected
    ) {
        var actual = new ArrayList<String>();
        TimeBasedKeyValueStore solution = null;
        for (var i = 0; i < commands.size(); i++) {
            actual.add(
                switch (commands.get(i)) {
                    case "TimeMap" -> {
                        solution = new TimeBasedKeyValueStore();
                        yield null;
                    }
                    case "set" -> {
                        var commandArguments = arguments.get(i);
                        solution.set(
                            (String) commandArguments.get(0),
                            (String) commandArguments.get(1),
                            (int) commandArguments.get(2)
                        );
                        yield null;
                    }
                    case "get" -> {
                        var commandArguments = arguments.get(i);
                        yield solution.get(
                            (String) commandArguments.get(0),
                            (int) commandArguments.get(1)
                        );
                    }
                    default -> throw new IllegalArgumentException();
                }
            );
        }
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Median of Two Sorted Arrays")
    void findMedianSortedArrays(int[] numbers1, int[] numbers2, double expected) {
        assertThat(new MedianOfTwoSortedArrays().findMedianSortedArrays(numbers1, numbers2))
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Reverse Linked List")
    void reverseList(ListNode head, ListNode expected) {
        assertThat(new ReverseLinkedList().reverseList(head)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Merge Two Sorted Lists")
    void mergeTwoLists(ListNode list1, ListNode list2, ListNode expected) {
        assertThat(new MergeTwoSortedLists().mergeTwoLists(list1, list2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Linked List Cycle")
    void hasCycle(ListNode head, int position, boolean expected) {
        var last = head;
        while (last.next != null) {
            last = last.next;
        }
        if (position != -1) {
            var cycleNode = head;
            for (var i = 0; i < position; i++) {
                cycleNode = cycleNode.next;
            }
            last.next = cycleNode;
        }
        assertThat(new LinkedListCycle().hasCycle(head)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Reorder List")
    void reorderList(ListNode head, ListNode expected) {
        new ReorderList().reorderList(head);
        assertThat(head).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Remove Node From End of Linked List")
    void removeNthFromEnd(ListNode head, int offset, ListNode expected) {
        assertThat(new RemoveNodeFromEndOfLinkedList().removeNthFromEnd(head, offset))
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Copy Linked List with Random Pointer")
    void copyRandomList(
        CopyLinkedListWithRandomPointer.Node head
    ) {
        var copy = new CopyLinkedListWithRandomPointer().copyRandomList(head);
        assertThat(copy).isNotSameAs(head);
        assertThat(CopyLinkedListWithRandomPointer.Node.equals(copy, head)).isTrue();
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Add Two Numbers")
    void addTwoNumbers(ListNode firstNode, ListNode secondNode, ListNode expected) {
        assertThat(new AddTwoNumbers().addTwoNumbers(firstNode, secondNode)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Find the Duplicate Number")
    void findDuplicate(int[] numbers, int expected) {
        assertThat(new FindTheDuplicateNumber().findDuplicate(numbers)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("LRU Cache")
    void lruCache(
        List<String> commands,
        List<List<Integer>> arguments,
        List<Integer> expected
    ) {
        var actual = new ArrayList<Integer>();
        LRUCache solution = null;
        for (var i = 0; i < commands.size(); i++) {
            actual.add(
                switch (commands.get(i)) {
                    case "LRUCache" -> {
                        solution = new LRUCache(arguments.get(i).getFirst());
                        yield null;
                    }
                    case "put" -> {
                        var commandArguments = arguments.get(i);
                        solution.put(
                            commandArguments.getFirst(),
                            commandArguments.getLast()
                        );
                        yield null;
                    }
                    case "get" -> solution.get(arguments.get(i).getFirst());
                    default -> throw new IllegalArgumentException();
                }
            );
        }
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Merge k Sorted Lists")
    void mergeKLists(ListNode[] lists, ListNode expected) {
        assertThat(new MergeKSortedLists().mergeKLists(lists)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Reverse Nodes in k-Group")
    void reverseKGroup(ListNode head, int length, ListNode expected) {
        assertThat(new ReverseNodesInKGroup().reverseKGroup(head, length)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Invert Binary Tree")
    void invertTree(TreeNode root, TreeNode expected) {
        assertThat(new InvertBinaryTree().invertTree(root)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Maximum Depth of Binary Tree")
    void maxDepth(TreeNode root, int expected) {
        assertThat(new MaximumDepthOfBinaryTree().maxDepth(root)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Diameter of Binary Tree")
    void diameterOfBinaryTree(TreeNode root, int expected) {
        assertThat(new DiameterOfBinaryTree().diameterOfBinaryTree(root)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Balanced Binary Tree")
    void isBalanced(TreeNode root, boolean expected) {
        assertThat(new BalancedBinaryTree().isBalanced(root)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Same Tree")
    void isSameTree(TreeNode first, TreeNode second, boolean expected) {
        assertThat(new SameTree().isSameTree(first, second)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Subtree of Another Tree")
    void isSubtree(TreeNode root, TreeNode subRoot, boolean expected) {
        assertThat(new SubtreeOfAnotherTree().isSubtree(root, subRoot)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Lowest Common Ancestor of a Binary Search Tree")
    void lowestCommonAncestor(TreeNode root, int first, int second, int expected) {
        assertThat(
            new LowestCommonAncestorOfBinarySearchTree()
                .lowestCommonAncestor(
                    root,
                    byValue(root, first).orElseThrow(),
                    byValue(root, second).orElseThrow()
                )
        )
            .isEqualTo(byValue(root, expected).orElseThrow());
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Binary Tree Level Order Traversal")
    void levelOrder(TreeNode root, List<List<Integer>> expected) {
        assertThat(new BinaryTreeLevelOrderTraversal().levelOrder(root)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Binary Tree Right Side View")
    void rightSideView(TreeNode root, List<Integer> expected) {
        assertThat(new BinaryTreeRightSideView().rightSideView(root)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Count Good Nodes in Binary Tree")
    void goodNodes(TreeNode root, int expected) {
        assertThat(new CountGoodNodesInBinaryTree().goodNodes(root)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Validate Binary Search Tree")
    void isValidBST(TreeNode root, boolean expected) {
        assertThat(new ValidateBinarySearchTree().isValidBST(root)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Kth Smallest Element in a BST")
    void kthSmallest(TreeNode root, int index, int expected) {
        assertThat(new KthSmallestElementInBST().kthSmallest(root, index)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Construct Binary Tree from Preorder and Inorder Traversal")
    void buildTree(int[] preorder, int[] inorder, TreeNode expected) {
        assertThat(
            new ConstructBinaryTreeFromPreorderAndInorderTraversal()
                .buildTree(preorder, inorder)
        )
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Binary Tree Maximum Path Sum")
    void maxPathSum(TreeNode root, int expected) {
        assertThat(new BinaryTreeMaximumPathSum().maxPathSum(root)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Serialize and Deserialize Binary Tree")
    void serializeAndDeserializeBinaryTree(TreeNode root) {
        var solution = new SerializeAndDeserializeBinaryTree();
        assertThat(solution.deserialize(solution.serialize(root))).isEqualTo(root);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Kth Largest Element in a Stream")
    void kthLargestElementInStream(
        List<String> commands,
        List<Object> arguments,
        List<Integer> expected
    ) {
        var actual = new ArrayList<Integer>();
        KthLargestElementInStream solution = null;
        for (var i = 0; i < commands.size(); i++) {
            actual.add(
                switch (commands.get(i)) {
                    case "KthLargest" -> {
                        var commandArguments = (List<Object>) arguments.get(i);
                        solution = new KthLargestElementInStream(
                            (Integer) commandArguments.getFirst(),
                            ((List<Integer>) commandArguments.getLast())
                                .stream()
                                .mapToInt(x -> x)
                                .toArray()
                        );
                        yield null;
                    }
                    case "add" -> solution.add(((List<Integer>) arguments.get(i)).getFirst());
                    default -> throw new IllegalArgumentException();
                }
            );
        }
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Last Stone Weight")
    void lastStoneWeight(int[] stones, int expected) {
        assertThat(new LastStoneWeight().lastStoneWeight(stones)).isEqualTo(expected);
    }

    private <T extends Comparable<T>> List<List<T>> sorted(List<List<T>> lists) {
        return lists.stream()
                   .map(list -> list.stream().sorted().toList())
                   .sorted(this::compare)
                   .toList();
    }

    private <T extends Comparable<T>> int compare(List<T> first, List<T> second) {
        var firstIterator = first.iterator();
        var secondIterator = second.iterator();
        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            var comparison = firstIterator.next().compareTo(secondIterator.next());
            if (comparison != 0) {
                return comparison;
            }
        }
        if (firstIterator.hasNext()) {
            return 1;
        }
        if (secondIterator.hasNext()) {
            return -1;
        }
        return 0;
    }

    private Optional<TreeNode> byValue(TreeNode root, int value) {
        if (root == null) {
            return Optional.empty();
        }
        if (root.val == value) {
            return Optional.of(root);
        }
        return byValue(root.left, value).or(() -> byValue(root.right, value));
    }
}