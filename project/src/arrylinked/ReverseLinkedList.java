package arrylinked;

/**
 * 翻转一个链表
 * 输入 1->2->3->4->5->null
 * 输出 5->4->3->2->1->null
 */

class ReverseLinkedList {

    /**
     * 翻转链表 思路
     *
     * 获取头部
     *
     *从头部节点开始 一步一步往后移动一个节点
     *
     * while(cur != null){
     * Node temp = cur.next
     *
     * cur = temp
     * }
     *
     * 在移动过程中是指针翻转
     * Node temp = cur.next
     * cur.next = per
     * per = cur
     * cur = temp
     *
     *
     * 最后返回头结点，也就是最终节点 pre （cur 为空时，代表最后节点的下一个位置为空了 所以 头结点时pre）
     *
     *
     *
     */

    public static void main(String[] args) {
        StringBuilder inputStringBuilder = new StringBuilder();
        Node node = inputCode();
        Node sourcenode = inputCode();
        while (node != null){
            inputStringBuilder.append(" ->"+node.currentId);
            node = node.next;
        }
        System.out.println("原："+inputStringBuilder.toString());

        StringBuilder outputStringBuilder = new StringBuilder();
        Node renode = reverseLinkedList(sourcenode);
        while (renode != null){
            outputStringBuilder.append(" ->"+renode.currentId);
            renode = renode.next;
        }
        System.out.println("翻转链表后"+outputStringBuilder.toString());

    }

    public static Node inputCode(){
        Node node = new Node();
        node.currentId = 0;
        Node cur = node;
        for (int i = 1; i < 9; i++){
            Node nodeCache = new Node();
            nodeCache.currentId = i;
            cur.next = nodeCache;
            cur = nodeCache;
        }
        return node;
    }

    static class Node{
        public int currentId = 0;
        public Node next;
    }

    public static Node reverseLinkedList(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node cur = head;
        Node pre = null;
        while (cur != null){
            Node temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
