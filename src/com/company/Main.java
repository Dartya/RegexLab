package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("(сто).*(\\1)");
        Matcher m = p.matcher("сто двадцать один слон" );
        if(m.find()){
            System.out.println(m.group());
        }

    }
}
