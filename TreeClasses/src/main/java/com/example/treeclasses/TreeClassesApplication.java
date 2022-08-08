package com.example.treeclasses;

import com.example.treeclasses.trees.trees.Conifer;
import com.example.treeclasses.trees.trees.LeafyTree;
import com.example.treeclasses.trees.trees.abstracts.AbstractTree;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class TreeClassesApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TreeClassesApplication.class, args);
        Scanner scanner = new Scanner(System. in);

        AbstractTree tree;
        String input = "";
        System.out.println("Input 'c' to create a conifer.");
        System.out.println("Input 'l' to create a leafy tree.");
        while(!input.equals("c") && !input.equals("l")){
            input = scanner.nextLine();
            if(!input.equals("c") && !input.equals("l")) {
                System.out.println(String.format("Unknown input: %s, try again.", input));
            }
        }
        if(input.equals("c")) {
            tree = new Conifer();
        } else {
            tree = new LeafyTree();
        }

        input = "";
        System.out.println("Input 'a' to make the tree grow automatically.");
        System.out.println("Input 'm' to control manually - pressing 'Enter' will trigger the grow method once.");
        while(!input.equals("a") && !input.equals("m")){
            input = scanner.nextLine();
            if(!input.equals("a") && !input.equals("m")) {
                System.out.println(String.format("Unknown input: %s, try again.", input));
            }
        }

        while(true){
            if(input.equals("a")) {
                TimeUnit.MILLISECONDS.sleep(900);

                System.out.println("");
                tree.grow();
            } else {
                System.in.read();
                tree.grow();
            }
        }
    }

}
