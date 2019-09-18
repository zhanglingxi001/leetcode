import java.lang.reflect.Array;
import java.util.*;

class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode createBinaryTreeByArray(Integer[] array, int index) {
        TreeNode tn = null;
        if (index < array.length) {
            Integer value = array[index];
            if (value == null) return null;
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, index * 2 + 1);
            tn.right = createBinaryTreeByArray(array, index * 2 + 2);
            return tn;
        }
        return tn;
    }

    public void TreeTravel(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        TreeTravel(root.left);
        TreeTravel(root.right);
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode creatList(int[] nums) {
        if (nums.length == 0) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode p = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            p.next = node;
            p = node;
        }
        return head;
    }

    public void travelList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        char[] cl = s.toCharArray();
        int len = s.length();
        int result = 0;
        for (int i = 0; i < len; i++) {
            if (i + 1 == len) {
                String temp = "" + cl[i];
                result += map.get(temp);
            }
            if (i + 1 < len) {
                String temp = "";
                temp += cl[i];
                temp += cl[i + 1];
                System.out.println(temp);
                if (map.containsKey(temp)) {
                    result += map.get(temp);
                    i++;
                } else {
                    String temp1 = "" + cl[i];
                    result += map.get(temp1);
                }
            }
            System.out.println(result);
        }
        return result;
    }

    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs.length == 0) return result;
        int i = 0;
        boolean flag = true;
        while (flag) {
            char temp = '\0';
            for (String s : strs) {
                if (i == s.length()) {
                    flag = false;
                    break;
                }
                if (temp == '\0') temp = s.toCharArray()[i];
                if (s.toCharArray()[i] != temp) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result += temp;
                i++;
            }
        }
        return result;
    }

    public boolean isValid(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') sb.append(c);
            if (c == ')') {
                if (sb.length() == 0) return false;
                if (sb.charAt(sb.length() - 1) == '(') sb.deleteCharAt(sb.length() - 1);
                else return false;
            }
            if (c == ']') {
                if (sb.length() == 0) return false;
                if (sb.charAt(sb.length() - 1) == '[') sb.deleteCharAt(sb.length() - 1);
                else return false;
            }
            if (c == '}') {
                if (sb.length() == 0) return false;
                if (sb.charAt(sb.length() - 1) == '{') sb.deleteCharAt(sb.length() - 1);
                else return false;
            }
        }
        if (sb.length() == 0) return true;
        else return false;
    }


    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int j = 0;
            while (i + j + 1 <= len - 1 && nums[i] == nums[i + j + 1])
                j++;
            for (int k = i + j + 1; j != 0 && k < len; k++) {
                nums[k - j] = nums[k];
            }
            len = len - j;
        }
        return len;
    }


    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        for (int i = 0; i < haystack.length(); i++) {
            boolean flag = true;
            if (haystack.charAt(i) == needle.charAt(0)) {
                for (int j = 0; j < needle.length(); j++) {
                    if (i + j == haystack.length()) return -1;
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) return i;
            }
        }
        return -1;
    }


    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        if (nums[nums.length - 1] < target) return nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
            if (nums[i] > target) return i;
        }
        return 0;
    }

    public int maxSubArray(int[] nums) {
        int left = 0;
        int max = nums[0];
        for (int num : nums) {
            if (left <= 0) left = num;
            else left = left + num;
            if (left > max) max = left;
        }
        return max;
    }

    public int lengthOfLastWord(String s) {
        int len = 0;
        for (int j = s.length() - 1; j >= 0; j--) {
            if (s.charAt(j) != ' ') len++;
            if (s.charAt(j) == ' ' && len != 0) break;
        }
        return len;
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public String addBinary(String a, String b) {
        int temp = 0;
        String result = "";
        int max = Math.max(a.length(), b.length());
        for (int i = a.length(); i < max; i++) a = "0" + a;
        for (int i = b.length(); i < max; i++) b = "0" + b;
        for (int i = max - 1; i >= 0; i--) {
            int add = a.charAt(i) - '0' + b.charAt(i) - '0' + temp;
            temp = add / 2;
            result = (char) (add % 2 + '0') + result;
        }
        if (temp == 1) result = "1" + result;
        return result;
    }

    public int mySqrt(int x) {
        // 注意：针对特殊测试用例，例如 2147395599
        // 要把搜索的范围设置成长整型
        // 为了照顾到 0 把左边界设置为 0
        long left = 0;
        // # 为了照顾到 1 把右边界设置为 x // 2 + 1
        long right = x / 2 + 1;
        while (left < right) {
            // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
            // long mid = left + (right - left + 1) / 2;
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        // 因为一定存在，因此无需后处理
        return (int) left;
    }

    public int climbStairs(int n) {
        if (n == 1) return 1;
        int[] result = new int[n + 1];
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> childQueue = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            for (TreeNode t : queue) {
                if (t.left != null) childQueue.add(t.left);
                if (t.right != null) childQueue.add(t.right);
                temp.add(t.val);
            }
            result.add(0, temp);
            queue = childQueue;
        }
        return result;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        int mid = (nums.length) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if (mid - 1 >= 0) {
            int[] left = Arrays.copyOfRange(nums, 0, mid);
            root.left = sortedArrayToBST(left);
        } else root.left = null;
        if (mid + 1 <= nums.length - 1) {
            int[] right = Arrays.copyOfRange(nums, mid + 1, nums.length);
            root.right = sortedArrayToBST(right);
        } else root.right = null;
        return root;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(deep(root.left) - deep(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int deep(TreeNode root) {
        if (root == null) return 0;
        return Math.max(deep(root.left), deep(root.right)) + 1;
    }


    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int minDepth = 0;
        boolean flag = false;
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!flag) {
            minDepth += 1;
            List<TreeNode> childQueue = new ArrayList<>();
            for (TreeNode t : queue) {
                if (t.left == null && t.right == null) {
                    flag = true;
                    break;
                }
                if (t.left != null) childQueue.add(t.left);
                if (t.right != null) childQueue.add(t.right);
            }
            queue = childQueue;
        }
        return minDepth;
    }


    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.val == sum && root.left == null && root.right == null) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= numRows - 1; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) row.add(1);
                else {
                    int temp = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                    row.add(temp);
                }
            }
            result.add(row);
        }
        return result;
    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) row.add(1);
                else {
                    int temp = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                    row.add(temp);
                }
            }
            result.add(row);
        }
        return result.get(rowIndex - 1);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return PathsSourceTarget(graph, 0);
    }

    public List<List<Integer>> PathsSourceTarget(int[][] graph, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == graph.length - 1) {
            List<Integer> path = new ArrayList<>();
            path.add(n);
            res.add(path);
            return res;
        }
        for (int i : graph[n]) {
            for (List<Integer> path : PathsSourceTarget(graph, i)) {
                path.add(0, n);
                res.add(path);
            }
        }
        return res;
    }


    public boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        while (!map.containsKey(n)) {
            int temp = 0;
            int old = n;
            int sum = 0;
            while (n != 0) {
                temp += (n % 10) * (n % 10);
                sum += n % 10;
                n /= 10;
            }
            n = temp;
            map.put(old, sum);
            if (sum == 1) return true;
        }
        return false;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) return false;
            else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return true;
    }

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        if (head == null) return null;
        while (head != null) {
            if (!set.contains(head)) set.add(head);
            else return head;
            head = head.next;
        }
        return null;
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null)
            return null;
        else {
            int ldep = maxDepth(root.left), rdep = maxDepth(root.right);
            if (ldep == rdep)
                return root;
            else if (ldep > rdep)
                return subtreeWithAllDeepest(root.left);
            else
                return subtreeWithAllDeepest(root.right);
        }
    }


    int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        else
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            map[(magazine.charAt(i) - 'a')]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            map[(ransomNote.charAt(i) - 'a')]--;
            if (map[(ransomNote.charAt(i) - 'a')] < 0) return false;
        }
        return true;
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            if (i <= n) {
                result.add(i);
                add(result, n, i);
            } else break;
        }
        return result;
    }

    private void add(List<Integer> result, int n, int startNum) {
        startNum *= 10;
        for (int i = 0; i < 10; i++, startNum++) {
            if (startNum <= n) {
                result.add(startNum);
                add(result, n, startNum);
            } else return;
        }
    }

    public int firstUniqChar(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) map[(c - 'a')]++;
        int min = -1;
        for (int i = 0; i < 26; i++) {
            if (map[i] == 1) {
                int index = s.indexOf((char) ('a' + i));
                if (index < min || min == -1) min = index;
            }
        }
        return min;
    }

    public char findTheDifference(String s, String t) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) map[(c - 'a')]++;
        for (char c : t.toCharArray()) map[(c - 'a')]++;
        for (int i = 0; i < 26; i++) {
            if (map[i] % 2 != 0) return (char) ('a' + i);
        }
        return 'a';
    }


    public String removeDuplicateLetters(String s) {
        if (s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        char last = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            String s1 = sb.toString();
            if (s1.indexOf(s.charAt(i)) != -1) continue;
            while (last > s.charAt(i)) {
                String sub = s.substring(i + 1, s.length());
                if (sub.indexOf(last) != -1) {
                    sb.deleteCharAt(sb.length() - 1);
                    if (sb.length() == 0) {
                        sb.append(s.charAt(i));
                        last = s.charAt(i);
                        break;
                    }
                    last = sb.charAt(sb.length() - 1);
                } else {
                    String str = sb.toString();
                    if (str.indexOf(s.charAt(i)) == -1) {
                        sb.append(s.charAt(i));
                        last = s.charAt(i);
                    }
                    break;
                }
            }
            if (last < s.charAt(i)) {
                String str = sb.toString();
                if (str.indexOf(s.charAt(i)) == -1) {
                    sb.append(s.charAt(i));
                    last = s.charAt(i);
                }
            }
        }
        return sb.toString();
    }

    public int maxProduct(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            Set<Character> set = new HashSet<>();
            for (char c : words[i].toCharArray()) set.add(c);
            for (int j = i + 1; j < words.length; j++) {
                boolean diff = true;
                for (char c : words[j].toCharArray()) {
                    if (set.contains(c)) {
                        diff = false;
                        break;
                    }
                }
                if (diff) {
                    int temp = words[i].length() * words[j].length();
                    if (temp > max) max = temp;
                }
            }
        }
        return max;
    }


    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == '.') sb.append("[.]");
            else sb.append(c);
        }
        return sb.toString();
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != null && b != null) {
            a = a.next;
            b = b.next;
        }
        while (a != null) {
            headA = headA.next;
            a = a.next;
        }
        while (b != null) {
            headB = headB.next;
            b = b.next;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (res[1] == 0) {
            if (numbers[left] + numbers[right] == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            }
            if (numbers[left] + numbers[right] > target) right--;
            if (numbers[left] + numbers[right] < target) left++;
        }
        return res;
    }

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            if (n % 26 == 0) {
                sb.append('Z');
                n = n / 26 - 1;
            } else {
                sb.append((char) (n % 26 - 1 + 'A'));
                n /= 26;
            }
        }
        return sb.reverse().toString();
    }

    public int titleToNumber(String s) {
        int result = 0;
        for (char c : s.toCharArray()) {
            int temp = c - 'A' + 1;
            result = result * 26 + temp;
        }
        return result;
    }

    public int majorityElement(int[] nums) {
        int result = nums[0];
        int count = 0;
        for (int c : nums) {
            if (c == result) count++;
            else count--;
            if (count < 0) {
                result = c;
                count = 0;
            }
        }
        return result;
    }

    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    public void rotate(int[] nums, int k) {
        if (k == 0) return;
        k = k % nums.length;
        for (int i = 1; i <= k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) count[i] = nums[i];
            else if (i == 1) count[i] = Math.max(nums[0], nums[1]);
            else {
                count[i] = Math.max(count[i - 1], count[i - 2] + nums[i]);
            }
        }
        return count[nums.length - 1];
    }


    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) return null;
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.next.val == val) p.next = p.next.next;
            else p = p.next;
        }
        return head;
    }

    public int[] diStringMatch(String S) {
        int min = 0;
        int max = S.length();
        int[] result = new int[S.length() + 1];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') result[i] = min++;
            if (S.charAt(i) == 'D') result[i] = max--;
        }
        result[S.length()] = max;
        return result;
    }

    public int countPrimes(int n) {
        if (n < 2) return 0;
        int count = 0;
        int[] map = new int[n];
        for (int i = 2; i < n; i++) {
            if (map[i] == 0) {
                count++;
                for (int j = i + i; j < n; j += i) map[j] = 1;
            }
        }
        return count;
    }


    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (map.containsValue(t.charAt(i))) return false;
                map.put(s.charAt(i), t.charAt(i));
            } else {
                if (map.get(s.charAt(i)) != t.charAt(i)) return false;
            }
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        ListNode result = list.get(list.size() - 1);
        ListNode p = result;
        for (int i = list.size() - 2; i >= 0; i--) {
            p.next = list.get(i);
            p = p.next;
        }
        p.next = null;
        return result;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) return true;
            set.add(i);
        }
        return false;
    }


    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public boolean isPowerOfTwo(int n) {
        double sqrt = Math.log(n) / Math.log(2);
        int res = (int) sqrt;
        if (Math.pow(2, res) == n) return true;
        return false;
    }


    class MyQueue {
        Deque<Integer> deque;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            deque = new LinkedList<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            deque.add(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            return deque.removeFirst();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return deque.getFirst();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return deque.isEmpty();
        }
    }


    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        if (head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode resever = head;
        ListNode temp;
        head = head.next;
        while (head != slow) {
            temp = head.next;
            head.next = resever;
            resever = head;
            head = temp;
        }
        if (fast != null) slow = slow.next;
        while (slow != null) {
            if (resever.val != slow.val) return false;
            resever = resever.next;
            slow = slow.next;
        }
        return true;
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) return root;
        if ((root.val < p.val && root.val > q.val) || (root.val > p.val && root.val < q.val)) return root;
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        else return lowestCommonAncestor(root.left, p, q);
    }

    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) map[(int) (c - 'a')]++;
        for (char c : t.toCharArray()) map[(int) (c - 'a')]--;
        for (int i : map) if (i != 0) return false;
        return true;
    }

    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    public int search(int[] nums, int l, int r) {
        if(l==r) return l;
        int mid = (l+r)/2;
        if(nums[mid]>nums[mid+1]) return search(nums,l,mid);
        return search(nums,mid+1,r);
    }

    public int fib(int N) {
        if(N==0) return 0;
        if(N==1) return 1;
        int n_1 = 0;
        int n_2 = 1;
        for(int i = 2;i<=N;i++){
            int temp = n_1;
            n_1 = n_2;
            n_2 = n_2 + temp;
        }
        return n_2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 2, 2, 2, 1};
        String a = "1";
        String b = "IDID";
        int[][] graph = {{1, 2}, {3}, {3}, {}};
//        System.out.println(solution.countPrimes(10));
//        solution.rotate(nums,2);
        Integer[] arr = new Integer[]{0, null, 1, null, 2, null, 3};
//        TreeNode root = solution.createBinaryTreeByArray(arr, 5);
        ListNode head = solution.creatList(nums);
        System.out.println(solution.isPalindrome(head));
//        solution.travelList(solution.removeElements(head, 2));
//        int[] array = solution.diStringMatch(b);
//        System.out.println("111");
//        solution.TreeTravel(root);
//        int[] result = solution.twoSum(nums,6);
//        System.out.println(result[0]);
//        System.out.println(result[1]);
//        Integer[] result = solution.BinaryTreeToArray(root);
//        System.out.println(111);
//        TreeNode root = solution.sortedArrayToBST(nums);
//        solution.TreeTravel(root);
    }
}
