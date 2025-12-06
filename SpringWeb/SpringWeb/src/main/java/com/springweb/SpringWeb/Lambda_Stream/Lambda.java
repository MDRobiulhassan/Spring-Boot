package com.springweb.SpringWeb.Lambda_Stream;

public class Lambda {
    public static void main(String[] args) {
        Walk walk = (step, isEnabled) -> {
            System.out.println("step:"+step+",isEnabled:"+isEnabled);
            return 2*step;
        };

        walk.walk(40,true);

        Walk walk1 = (step, isEnabled) -> 2*step ;
        walk1.walk(40,true);
    }
}


