package com.mdorst;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<List<Integer>> passes = readInKeylog("keylog.txt");

        removeDuplicates(passes);

        System.out.println("Count: " + passes.size());

        for (List<Integer> pass : passes)
        {
            System.out.println(pass);
        }
    }

    static List<Integer> findPassword(List<List<Integer>> passes)
    {
        List<Integer> password = new ArrayList<>(10);

        

        return password;
    }

    static List<List<Integer>> readInKeylog(String path)
    {
        List<List<Integer>> passes = new LinkedList<>();

        try (Scanner scanner = new Scanner(new File(path)))
        {
            while (scanner.hasNext())
            {
                List<Integer> pass = new ArrayList<>(3);
                String line = scanner.next();
                for (int i = 0; i < 3; i++)
                {
                    // subtract 48 to convert ascii to int
                    pass.add((int) line.charAt(i) - 48);
                }
                passes.add(pass);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return passes;
    }

    static void removeDuplicates(List<List<Integer>> passes)
    {
        for (int i = 0; i < passes.size(); i++)
        {
            int count = 0;
            for (List<Integer> pass1 : passes)
            {
                boolean found = true;
                for (int k = 0; k < 3; k++)
                {
                    if (!passes.get(i).get(k).equals(pass1.get(k)))
                    {
                        found = false;
                    }
                }
                if (found)
                    count++;
            }
            if (count > 1)
                passes.remove(i);
        }
    }
}
