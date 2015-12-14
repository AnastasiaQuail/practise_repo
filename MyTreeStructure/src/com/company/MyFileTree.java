package com.company;

import java.util.ArrayList;
import java.util.function.Function;

/**
 * Created by user on 11.12.2015.
 */
public class MyFileTree<T2> {

    private class Entity<T2> {

        String key;
        T2 value;

        public void setKey(String key) {
            this.key = key;
        }

        public void setValue(T2 value) {
            this.value = value;
        }

        public void setChildren(ArrayList<Entity<T2>> children) {
            this.children = children;
        }

        public String getKey() {
            return key;
        }

        public T2 getValue() {
            return value;
        }

        public ArrayList<Entity<T2>> getChildren() {
            return children;
        }


        ArrayList<Entity<T2>> children;

        Entity(String key, T2 value, ArrayList<Entity<T2>> children) {

            this.key = key;
            this.value = value;
            this.children = children;
        }

        Entity(String key, T2 value) {
            this(key, value, new ArrayList<Entity<T2>>());
        }

        protected void applayFunction(Function<T2, T2> function) {
            value = function.apply(value);
        }

    }

    Entity<T2> root;

    public MyFileTree() {
        root = new Entity<T2>(null, null);
    }

    private Entity<T2> searchForKey(String searchway, Entity<T2> search) throws NoSuchKeyExeption {
        Entity<T2> tmp = search;
        ArrayList<Entity<T2>> children = tmp.getChildren();
        int i = 0;
        while (!searchway.equals(children.get(i).getKey())) {
            i++;
            if (i == children.size())
                throw new NoSuchKeyExeption();
        }
        return tmp = children.get(i);
    }


    public void addEntity(String way, T2 value) throws NoSuchKeyExeption {

        String[] derictories = way.split("/");
        int n = derictories.length;
        Entity<T2> new_entity = new Entity<T2>(way, value);
        ArrayList<Entity<T2>> list = new ArrayList<>();
        Entity<T2> tmp = root;
        if (root.getChildren().size() != 0) {
            for (int i = 0; i < n - 1; i++)
                try {
                    tmp = searchForKey(derictories[i], tmp);
                } catch (NoSuchKeyExeption e) {
                    e.printStackTrace();
                    return;
                }
        }
        new_entity.setKey(derictories[n - 1]);
        list = tmp.getChildren();
        list.add(new_entity);
        tmp.setChildren(list);

    }


    public void deleteEntity(String key) throws NoSuchKeyExeption {
        String[] derictories = key.split("/");
        ArrayList<Entity<T2>> list = new ArrayList<>();
        Entity<T2> tmp = root;
        int n = derictories.length;
        if (root.getChildren().size() != 0) {
            for (int i = 0; i < n - 1; i++)
                try {
                    tmp = searchForKey(derictories[i], tmp);
                } catch (NoSuchKeyExeption e) {
                    e.printStackTrace();
                }
        }
        list = tmp.getChildren();
        int i = 0;
        while (!derictories[n - 1].equals(list.get(i).getKey())) {
            i++;
            if (i == derictories.length)
                throw new NoSuchKeyExeption();
        }
        list.remove(i);
        tmp.setChildren(list);

    }

private  void iterate(Entity<T2> entity,Function<T2,T2> function){
    entity.applayFunction(function);
    ArrayList<Entity<T2>> list = entity.getChildren();
    if(list.size()==0)
        return ;
    for (Entity<T2> t2Entity : list) {
        iterate(t2Entity,function);
    }

}

    public void IteratorFunction(Function<T2, T2> function) throws EmptyTreeExeption {
        Entity<T2> tmp = root;
        ArrayList<Entity<T2>> list = root.getChildren();
        if (list.size() == 0)
            throw new EmptyTreeExeption();
        for (Entity<T2> t2Entity : list) {
            iterate(t2Entity,function);
        }
    }

}



























