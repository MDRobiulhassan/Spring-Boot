package com.springweb.SpringWeb.Lambda_Stream;

import java.util.List;
import java.util.stream.Stream;

public class stream {
    public static void main(String[] args) {
        List<String> list = List.of("Banana","Apple","Kiwi","Mango");

        Stream<String> stream =  list.stream();


        stream.filter(fruit->fruit.length()>4)
                .sorted()
                .map(fruit->fruit.length())
                .forEach((fruit -> {System.out.println(fruit);

        }));
    }
}
