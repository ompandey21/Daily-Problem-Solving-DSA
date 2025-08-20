public class RotateLL {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode rotateRight(ListNode head, int k) {

            if (head == null)
                return head;
            k = k % length(head);
            if (k == 0)
                return head;
            ListNode fast = head;
            ListNode slow = head;
            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            ListNode res = slow.next;
            slow.next = null;
            fast.next = head;
            return res;

        }

        public static int length(ListNode head) {
            int l = 0;
            ListNode temp = head;
            while (temp != null) {
                temp = temp.next;
                l++;
            }
            return l;
        }
    }
}
