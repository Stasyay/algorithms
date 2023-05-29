public class Main {
    public static class dList {
        private Node Head;
        private Node Tail;

        private class Node {
            private int value;
            private Node next;
            private Node prev;
        }

        void print() {
            Node current = Head;
            while (current != null) {
                System.out.println(current.value);
                current = current.next;
            }

        }

        void pushBack(int value) {
            Node node = new Node();
            node.value = value;

            if (Tail != null) {
                Tail.next = node;
                node.prev = Tail;
            } else {
                Head = node;
            }

            Tail = node;
        }

            void swap(Node node){

            Node prev = node.prev;
            node.prev = node.next;
            node.next = prev;
        }

        void revert(){
            Node current = Head;
            Node prev = null;

            while (current != null){
                swap(current);
                prev = current;
                current = current.prev;
            }
            if (prev != null){
                Head = prev;
            }
        }
    }

    public static void main(String[] args) {
        dList list = new dList();

        list.pushBack(1);
        list.pushBack(5);
        list.pushBack(7);
        list.pushBack(3);
        list.pushBack(3);
        list.pushBack(10);

        list.print();
        System.out.println("");
        list.revert();
        list.print();

    }
}
