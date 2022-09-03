package com.company;

import algorithems.IDAstar;
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
//        State goal = BFS.solve(start);
//        DFS.solve(start);
//        IDS.solve(start) ;
//        BDS.solve(start , goal); //it should be followed by BFS written above
//        Astar.solve(start);
        IDAstar.solve(start);
//        RBFS.solve(start) ;


    }

    /*
1 3
1 1
...
ans =
1
right
node count = 2

1 3
1 3
...
ans =
1
left
node count = 2


3 1
1 1
.
.
.
ans =
1
down
node count = 2

3 1
3 1
.
.
.
ans =
1
up
node count = 2
     */

    /*
3 2
1 1
. .
. *
. .

2 3
1 1
. . .
. . .

*
3 3
1 1
...
*..
...
ans =
4
right
down
down
left
node count = 10

3 3
3 3
..*
...
...
ans =
5
left
up
up
down
right
node count = 13

*
5 5
3 3
**.**
**.**
.....
**.**
**.**
ans =
7
up
down
down
up
left
right
right
node count = 142

5 5
1 1
.....
.....
.....
.....
.....
ans =
14
down
up
right
down
down
right
up
right
down
down
left
left
left
left
node count = 843200


3 7
1 1
...*...
...*...
.......
ans =
11
down
up
right
down
down
right
right
up
up
right
down
node count = 1342



4 7
1 1
...*...
...*...
.......
...*...

19
ans =
16
down
down
right
up
up
up
down
down
right
right
up
up
right
down
down
left
node count = 309376


     */

    /*

5 5
3 3
.*.**
**.**
.....
**.**
**.**

ans = not found


6 4
3 1
* . * *
* . * *
. . . .
* . . .
* . . .
* . . .

     */




}

