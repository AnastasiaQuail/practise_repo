package spbu.svp;
public class Main {

    public static void main(String[] args) {

        BinarTree<Integer, String> tree = new BinarTree<>();

        tree.add(1, "a");
        try {
            System.out.println(tree.get(1));
        } catch (NoSuchKeyExeption noSuchKeyExeption) {
            System.out.println(noSuchKeyExeption.getMessage());
        } catch (EmptyTreeExeption emptyTreeExeptin) {
            System.out.println(emptyTreeExeptin.getMessage());
        }


        System.out.println(tree.isempty());

        tree.add(3, "c");
        try {
            tree.remove(2);
        } catch (EmptyTreeExeption emptyTreeExeptin) {
            System.out.println(emptyTreeExeptin.getMessage());
        } catch (NoSuchKeyExeption noSuchKeyExeption) {
            System.out.println(noSuchKeyExeption.getMessage());
        }
        try {
            System.out.println(tree.get(3));
        } catch (NoSuchKeyExeption e) {
            System.out.println(e.getMessage());
        } catch (EmptyTreeExeption emptyTreeExeptin) {
            System.out.println(emptyTreeExeptin.getMessage());
        }
        try {
            tree.get(2);
        } catch (NoSuchKeyExeption noSuchKeyExeption) {
            System.out.println(noSuchKeyExeption.getMessage());
        } catch (EmptyTreeExeption emptyTreeExeptin) {
            System.out.println(emptyTreeExeptin.getMessage());
        }
    }

    }
