package com.example.demoCloud;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User(1,"aaa"));
        list.add(new User(2,"bbb"));
        list.add(new User(3,"ccc"));
        list.add(new User(4,"ddd"));
        list.add(new User(5,"eee"));
        Map<Integer,User> map = list.stream().collect(Collectors.toMap(User::getId, Function.identity()));
        System.out.println(map);
    }

    private static class User{
        private Integer id;
        private String name;

        public User(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
