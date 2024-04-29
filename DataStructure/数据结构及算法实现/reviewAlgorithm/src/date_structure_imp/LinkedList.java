package date_structure_imp;


/**
 * @author MrkWinter
 * @version 1.0
 */
public class LinkedList {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.add(new Node("a"));
        linkList.add(new Node("b"));
        linkList.add(new Node("c"));
        linkList.add(new Node("d"));
        linkList.list();
        linkList.reverseLinkList(linkList.head);
        linkList.list();
        Node lastIndeNode = linkList.findLastIndeNode(linkList.head, 3);
        System.out.println(lastIndeNode.date);
        linkList.reverseList(linkList.head);
        linkList.list();

        linkList.reversePrint(linkList.head.next);
    }
}

class LinkList {
    public Node head = new Node();

    public void add(Node node) {
        if (head.next == null) {
            head.next = node;
            return;
        }
        node.next = head.next;
        head.next = node;
    }
    public void addEnd(Node node) {
        Node cur = head;
        while(cur.next!=null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    public void list() {
        Node cur = head.next;
        while (cur != null) {
            System.out.println(cur.date);
            cur = cur.next;
        }
    }

    public void delete() {

    }

    public int getLength(Node node) {
        if (node == null)
            return 0;
        Node cur = node.next;
        //头结点不算
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count += 1;
        }
        return count;
    }

    //获得倒数第k个结点
    public Node findLastIndeNode(Node head, int index) {
        if (head == null)
            throw new RuntimeException("头结点为空");
        if (index <= 0)
            throw new RuntimeException("index应大于0");
        //思路 使用双指针
        //先让frontNode 指向第index个位置
        Node frontNode = head;
        for (int i = 0; i < index; i++) {
            if (frontNode == null)
                throw new RuntimeException("输入数据有误");
            frontNode = frontNode.next;
        }
        //behindNode 指向第一个位置
        Node behindNode = head.next;
        while (frontNode.next != null) {
            behindNode = behindNode.next;
            frontNode = frontNode.next;
        }
        return behindNode;
    }

    //单链表的反转1
    public void reverseLinkList(Node head) {
        if (head == null || head.next == null || head.next.next == null)
            return;
        Node newHead = head.next;
        Node cur = newHead.next;
        newHead.next = null;
        Node curNext = null;
        while (cur != null) {
            curNext = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = curNext;
        }
        head.next = newHead;
    }

    //单链表的反转2
    public void reverseList(Node head) {
        //这里是新增结点的思路
        if (head == null || head.next == null || head.next.next == null)
            return;
        Node reverseHead = new Node();
        Node cur = head.next;
        Node curNext = null;
        while (cur != null) {
            curNext = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = curNext;
        }
        head.next = reverseHead.next;
    }

    //从尾到头反向打印链表 栈
    public void reversePrint(Node node) {
        if (node.next != null) {
            reversePrint(node.next);
        }
        System.out.println(node.date);
    }

    // 合并两个有序的单向链表 尾插
    public Node mergeLink(Node head1, Node head2) {
        Node newHead = new Node();
        Node cur1 = head1.next;
        Node cur1Next = null;
        Node cur2 = head2.next;
        Node cur2Next = null;
        while (cur1 != null && cur2 != null) {
            if (cur1.date.compareTo(cur2.date) > 0) {
                //cur1date大
                cur1Next = cur1.next;
                cur1.next = null;
                newHead.addEnd(cur1);
                cur1 = cur1Next;
            } else  {
                //cur2date大
                cur2Next = cur2.next;
                cur2.next = null;
                // 将cur1添加到newHead尾部
                newHead.addEnd(cur2);
                cur2 = cur2Next;
            }
        }
        if(cur1==null) {
            newHead.addEnd(cur2);
        } else {
            newHead.addEnd(cur1);
        }
        return newHead;
    }

    public Node mergeLink2(Node head1,Node head2) {
        if(head1==null || head2 == null)
            throw  new RuntimeException("链表不能为空");
        Node newHead = new Node();
        Node cur1 = head1.next;
        Node cur2 = head2.next;
        Node curEnd = newHead;
        while(cur1!=null&&cur2!=null) {
            if (cur1.date.compareTo(cur2.date) > 0) {
                curEnd.next = cur1;
                curEnd = cur1;
                cur1 = cur1.next;
            } else  {
                curEnd.next = cur2;
                curEnd = cur2;
                cur2 = cur2.next;
            }
        }
        if(cur1==null) {
            curEnd.next = cur2;
        } else {
            curEnd.next = cur1;
        }
        return newHead;
    }

}

class Node {
    public String date;
    public Node next;

    public Node(String date) {
        this.date = date;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return date;
    }
    public void addEnd(Node node) {
        Node cur = this;
        while(cur.next!=null) {
            cur = cur.next;
        }
        cur.next = node;
    }
}