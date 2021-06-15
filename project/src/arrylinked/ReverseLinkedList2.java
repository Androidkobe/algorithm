package arrylinked;

/**
 * 链表 两两翻转 输入 1->2->3->4->5 输出 2->1->4->3->5
 */

class ReverseLinkedList2 {

    /**
     * 思路
     */

    public static void main(String[] args) {
        StringBuilder inputStringBuilder = new StringBuilder();
        Node node = inputCode();
        Node sourcenode = inputCode();
        while (node != null) {
            inputStringBuilder.append(" ->" + node.currentId);
            node = node.next;
        }
        System.out.println("原：" + inputStringBuilder.toString());

        StringBuilder outputStringBuilder = new StringBuilder();
        Node renode = reverseLinkedList(sourcenode);
        while (renode != null) {
            outputStringBuilder.append(" ->" + renode.currentId);
            renode = renode.next;
        }
        System.out.println("两两翻转后" + outputStringBuilder.toString());

    }

    public static Node inputCode() {
        Node node = new Node();
        node.currentId = 0;
        Node cur = node;
        for (int i = 1; i < 9; i++) {
            Node nodeCache = new Node();
            nodeCache.currentId = i;
            cur.next = nodeCache;
            cur = nodeCache;
        }
        return node;
    }

    static class Node {
        public int currentId = 0;
        public Node next;
    }

    public static Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pre = new Node();
        Node cur = head;
        Node next = head = cur.next;
        Node next2 = cur.next.next;

        while(cur != null && next != null){
            pre.next = next;
            next.next = cur;
            cur.next = next2;
            pre = cur;

            cur = next2;

            if(cur != null && cur.next != null){
                next = cur.next;
                next2 = cur.next.next;
            }else{
                next = null;
                next2 = null;
            }
        }

        return head;
    }
}
