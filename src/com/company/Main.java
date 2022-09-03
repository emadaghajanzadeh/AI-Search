package com.company;

import Algorithms.*;
import models.Board;
import models.Cube;
import models.State;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String[] size = scanner.nextLine().split(" ");
        String[] cubeStart = scanner.nextLine().split(" ");
        StringBuilder map = new StringBuilder();
        int length, height;
        int x, y;
        x = Integer.parseInt(cubeStart[0]) - 1;
        y = Integer.parseInt(cubeStart[1]) - 1;
        height = Integer.parseInt(size[0]);
        length = Integer.parseInt(size[1]);
        for (int i = 0; i < height; i++) {
            map.append(scanner.nextLine());
        }
        State start = new State(new Board(length, height, map.toString(), new Cube(x, y)));

        String selectedAlgorithms = scanner.nextLine();
        switch (selectedAlgorithms){
            case "Astar":
                Astar.solve(start);
                break;
            case "DFS":
                DFS.solve(start);
                break;
            case "IDAstar":
                IDAstar.solve(start);
                break;
            case "IDS":
                IDS.solve(start);
                break;
            case "RBFS":
                RBFS.solve(start);
                break;
            case "BDS":
                State goal = BFS.solve(start);
                BDS.solve(start, goal);
                break;
            default:
                System.out.println("Your selected algorithm is not supported by this code!");
                break;

        }

    }


/*
An example of a simple test case
1 3
1 1
...
Astar
*/





}

