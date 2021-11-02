package com.jacky.generic_;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 2021/11/2
 */
public class P567GenericHomework01 {
    public static void main(String[] args) {

    }

    @Test
    public void testList(){
        DAO<User> userDAO = new DAO<>();
        userDAO.save("1", new User(1, 15, "jacky"));
        userDAO.save("2", new User(1, 15, "jacky"));
        userDAO.save("3", new User(1, 15, "jacky"));

        List<User> list = userDAO.list();
        System.out.println(list);
    }

}

class User {
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class DAO<T> {
    public Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    public List<T> list() {
        List<T> list = new ArrayList<>();

        Set<String> keySet = map.keySet();
        for (String key :keySet) {
            list.add(get(key));
        }
        return list;
    }

    public void delete(String id) {
        map.remove(id);
    }
}


