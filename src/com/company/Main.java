package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    static final String one[] =     {"один", "одна", "десять", "1"};
    static final String two[] =     {"двадцать", "две", "два", "2"};
    static final String three[] =   {"тридцать", "триста", "три", "3"};
    static final String four[] =    {"сорок", "четыреста", "четыре", "4"};
    static final String five[] =    {"пятьдесят", "пятьсот", "пять", "5"};
    static final String six[] =     {"шестьдесят", "шестьсот", "шесть", "6"};
    static final String seven[] =   {"семьдесят", "семьсот", "семь", "7"};
    static final String eight[] =   {"восемьдесят", "восемьсот", "восемь", "8"};
    static final String nine[] =    {"девяноста", "девятьсот", "девять", "9"};
    static final String tens[][] = {
                                    {"сто", "1"},
                                    {"двести", "2"},
                                    {"одинадцать", "11"},
                                    {"двенадцать", "12"},
                                    {"тринадцать", "13"},
                                    {"четырнадцать", "14"},
                                    {"пятнадцать", "15"},
                                    {"шестнадцать", "16"},
                                    {"семнадцать", "17"},
                                    {"восемнадцать", "18"},
                                    {"девятнадцать", "19"},
                                    {"тысяч ", ""},
                                    {"миллионов ", ""}
                                    };
    static final String decSpaces[][] = {
                                    {"1 ", "1"},
                                    {"2 ", "2"},
                                    {"3 ", "3"},
                                    {"4 ", "4"},
                                    {"5 ", "5"},
                                    {"6 ", "6"},
                                    {"7 ", "7"},
                                    {"8 ", "8"},
                                    {"9 ", "9"},
                            };

    static final String array[][] = {one, two, three, four, five, six, seven, eight, nine};

    public static void main(String[] args) throws IOException {

        String text;

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("text.txt"), StandardCharsets.UTF_8));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            text = sb.toString();
        } finally {
            br.close();
        }

        for (int i = 0; i < 13; i++) {

            for (int j = 0; j < 2; j++) {
                text = text.replaceAll(tens[i][j], tens[i][1]);
            }

            if (i < 9) {
                for (int j = 0; j < 3; j++) {
                    text = text.replaceAll(array[i][j], array[i][3]);
                }
            }
        }
        for (int i = 0; i < decSpaces.length; i++) {
            text = text.replaceAll(decSpaces[i][0], decSpaces[i][1]);
        }

        System.out.println(String.join(" ", text.split("(?<=\\d)(?=[а-я])")));
    }
}