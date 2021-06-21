package arrylinked;

/**
 * 链表 两两翻转 输入 1->2->3->4->5 输出 2->1->4->3->5
 */

class ReverseLinkedList2 {

    /**
     * 思路
     *
     * 确立小范围转换
     *
     *
     *  Node temp = next.next;
     *             next.next = cur;
     *             cur.next = temp;
     *             last.next = next;
     *
     *  //设置翻转的每一个参数
     *             last = cur;//上的末尾节点
     *             cur = temp;//当前节点
     *             if(cur != null){
     *                 next = cur.next;//下一个节点
     *             }
     *
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
        Node cur = head;
        Node next = cur.next;
        Node last = new Node();
        Node HEAD = next;

        while(cur != null && next != null){
            Node temp = next.next;
            next.next = cur;
            cur.next = temp;
            last.next = next;

            //设置翻转的每一个参数
            last = cur;//上的末尾节点
            cur = temp;//当前节点
            if(cur != null){
                next = cur.next;//下一个节点
            }
        }
        return HEAD;
    }
}
