
public class Homework4 {

    public static class RedBlackTree {
        Node root;

        private class Node {
            int value;
            Color color;
            Node left;
            Node right;
        }

        private  enum Color{
            RED,
            BLACK
        }


        private Node rebalance(Node node){
            Node result = node;
            boolean needRebalance;
            do{
                needRebalance = false;
                if (result.right != null && result.right.color == Color.RED &&
                        (result.left == null || result.left.color == Color.BLACK)) {
                    needRebalance = true;
                    result = rightSwap(result);
                }
                if (result.left != null && result.left.color == Color.RED &&
                        result.left.left != null && result.left.left.color == Color.RED) {
                    needRebalance = true;
                    result = leftSwap(result);
                }
                if (result.left != null && result.left.color == Color.RED &&
                        result.right !=null && result.right.color == Color.RED){
                    needRebalance = true;

                    colorSwap(result);
                }
            }
            while (needRebalance);
            return result;
        }

        private void colorSwap(Node node){
            node.right.color = Color.BLACK;
            node.left.color = Color.BLACK;
            node.color = Color.RED;
        }

        private Node leftSwap(Node node) {
            Node left = node.left;
            Node betweenChild = left.right;
            left.right = node;
            node.left = betweenChild;
            left.color = node.color;
            node.color = Color.RED;
            return left;
        }

        private Node rightSwap(Node node) {
            Node right = node.right;
            Node betweenChild = right.left;
            right.left = node;
            node.right = betweenChild;
            right.color = node.color;
            node.color = Color.RED;
            return right;
        }

        public boolean push (int value){
            if (root != null) {
                boolean result = pushNode(root, value);
                root = rebalance(root);
                root.color = Color.BLACK;
                System.out.println(value);
                return result;

            } else {
                root = new Node();
                root.color = Color.BLACK;
                root.value = value;
                return true;
            }
        }

        public boolean pushNode(Node node, int value) {
            if (node.value == value) {
                return false;
            } else {
                if (node.value > value){
                    if (node.left != null){
                        boolean result = pushNode(node.left, value);
                        node.left = rebalance(node.left);
                        return  result;
                    } else{
                        node.left = new Node();
                        node.left.color = Color.RED;
                        node.left.value = value;
                        return true;
                    }
                } else {
                    if (node.right != null){
                        boolean result = pushNode(node.right, value);
                        node.right = rebalance(node.right);
                        return result;
                    } else {
                        node.right = new Node();
                        node.right.color = Color.RED;
                        node.right.value = value;
                        return true;
                    }
                }

            }
        }
    }

    public static void main(String[] args) {

        RedBlackTree tree = new RedBlackTree();
        tree.push(10);
        tree.push(20);
        tree.push(9);
        tree.push(24);
        tree.push(13);
        tree.push(1);
        tree.push(51);
        tree.push(34);
        tree.push(5);
        tree.push(33);

    }

}
