package spbu.svp;

public class BinarTree<T1 extends Comparable<T1>,T2> {

    private class Node<T1 extends Comparable<T1>, T2>  {

        T1 key;
        T2 value;
        Node<T1, T2> left, right;

        public Node(T1 key, T2 value) {
            this.key = key;
            this.value = value;
        }
    }

    Node<T1, T2> root;

    public  BinarTree(){
        root = null;
    }

    public T2 get(T1 k) throws NoSuchKeyExeption, EmptyTreeExeption {
        Node<T1, T2> x = root;
        int cmp;
        if(isempty())
            throw new EmptyTreeExeption();
        while (x != null) {
            cmp = k.compareTo(x.key);
            if (cmp == 0)
                return x.value;
            else if (cmp < 0)
                x = x.left;
            else
                x = x.right;
        }
        throw new NoSuchKeyExeption();

    }


    public void add(T1 key, T2 value) {

        Node<T1,T2> x = root;
        Node<T1,T2> y = null;
        Node<T1, T2> newNode = new Node<>(key, value);
        if(root == null){
            root = newNode;
            return;
        }
       int cmp = key.compareTo(x.key);;
        while (x != null) {
            cmp = key.compareTo(x.key);
            if (cmp == 0)
                x.value = value;
            else {
                y = x;
                if (cmp < 0)
                    x = x.left;
                else
                    x = x.right;
            }
        }

            if (y == null)
                root = newNode;
            else {
                if (cmp < 0) {
                    y.left = newNode;
                } else {
                    y.right = newNode;
                }
            }

    }

    public boolean isempty() {

        return root == null;

    }


    public void remove(T1 key) throws EmptyTreeExeption,NoSuchKeyExeption {
        Node<T1,T2> x = root;
        Node<T1,T2> y = null;
        Node<T1,T2> y1 = null;
        Node<T1,T2> leftbrunch = null;
        if(isempty()){
            throw new EmptyTreeExeption();

        }
        int cmp;
        while (x != null) {
            cmp = key.compareTo(x.key);
            if (cmp == 0) {
                break;
            }
            else {
                y = x;
                if (cmp < 0)
                    x = x.left;
                else
                    x = x.right;
            }
        if(cmp != 0) {
            throw new NoSuchKeyExeption();
        }

            if (x.right == null) {
                if (y == null)
                    root = x.left;
                else
                {
                    if (x == y.left) {
                        y.left = x.left;
                    } else {
                        y.right = x.left;
                    }
                }
            }
            else
            {
                y1 = null;
                leftbrunch = x.right;

                while (leftbrunch.left != null) {
                    y1 = leftbrunch;
                    leftbrunch = leftbrunch.left;
                }
                if (y != null) {
                    y.left = leftbrunch.right;
                } else {
                    x.right = leftbrunch.right;
                }
                    x.key = leftbrunch.key;
                    x.value = leftbrunch.value;


            }
        }
    }
}
