package models;

import java.util.ArrayList;
import java.util.Stack;

public class State implements Comparable<State> {
    private static ArrayList<State> states = new ArrayList();
    private int depth;
    private Board board;
    private State parent;
    private static int count = 0 ;
    private int id ;
    private int action;






//    public void setFn(int fn) {
//        this.fn = fn;
//    }

//    public void setHn(int hn) {
//        this.hn = hn;
//    }
    //0 -> up
    //1 -> down
    //2 -> left
    //3 -> right

    public State(Board board) {
        this.board = board;
        this.depth = 0;
        this.parent = null;
        states.add(this) ;
        this.id = count++ ;
    }

    private State(int depth, Board board, State parent, int action) {
        this.depth = depth + 1;
        this.board = board;
        this.parent = parent;
        this.action = action;
        states.add(this) ;
        this.id = count++ ;
    }

    public ArrayList<State> makeChild() {
        ArrayList<State> states = new ArrayList<>();
        if (board.getCube().isStand()) {
            if (board.getCube().getX() >= 2) {
                Board tempBoard = board.moveUp();
                if (tempBoard != null)
                    states.add(new State(depth, tempBoard, this, 0));
            }
            if (board.getCube().getX() <= board.getHeight() - 3) {
                Board tempBoard = board.moveDown();
                if (tempBoard != null)
                    states.add(new State(depth, tempBoard, this, 1));
            }
            if (board.getCube().getY() >= 2) {
                Board tempBoard = board.moveLeft();
                if (tempBoard != null)
                    states.add(new State(depth, tempBoard, this, 2));
            }
            if (board.getCube().getY() <= board.getLength() - 3) {
                Board tempBoard = board.moveRight();
                if (tempBoard != null)
                    states.add(new State(depth, tempBoard, this, 3));
            }
        } else {
            if (board.getCube().isHorizontal()) {
                if (board.getCube().getX() >= 1) {
                    Board tempBoard = board.moveUp();
                    if (tempBoard != null)
                        states.add(new State(depth, tempBoard, this, 0));
                }
                if (board.getCube().getY() <= board.getLength() - 3) {
                    Board tempBoard = board.moveRight();
                    if (tempBoard != null)
                        states.add(new State(depth, tempBoard, this, 3));
                }
            } else {
                if (board.getCube().getX() >= 2) {
                    Board tempBoard = board.moveUp();
                    if (tempBoard != null)
                        states.add(new State(depth, tempBoard, this, 0));
                }
                if (board.getCube().getY() <= board.getLength() - 2) {
                    Board tempBoard = board.moveRight();
                    if (tempBoard != null)
                        states.add(new State(depth, tempBoard, this, 3));
                }
            }
            if (board.getCube().getX() <= board.getHeight() - 2) {
                Board tempBoard = board.moveDown();
                if (tempBoard != null)
                    states.add(new State(depth, tempBoard, this, 1));
            }
            if (board.getCube().getY() >= 1) {
                Board tempBoard = board.moveLeft();
                if (tempBoard != null)
                    states.add(new State(depth, tempBoard, this, 2));
            }

        }


        return states;
    }

    public boolean isFinal() {
        return board.isFinal();
    }

    public void print() {
        Stack<Integer> actions = new Stack<>();
        State temp = this;
        while (temp.parent != null) {
            actions.push(temp.action);
            temp = temp.parent;
        }
        System.out.println(actions.size());
        while (!actions.isEmpty()) {
            switch (actions.pop()) {
                case 0:
                    System.out.println("up");
                    break;
                case 1:
                    System.out.println("down");
                    break;
                case 3:
                    System.out.println("right");
                    break;
                case 2:
                    System.out.println("left");
                    break;
            }
        }
    }
    public int getId(){
        return this.id ;
    }
    public void print(State limit){
        Stack<Integer> actions = new Stack<>();
        State temp = this;

        while (temp.parent != null && temp.board.equal(limit.board.getMap())==0) {
            actions.push(temp.action);
            temp = temp.parent;
        }
        System.out.println(actions.size());
        while (!actions.isEmpty()) {
            switch (actions.pop()) {
                case 0:
                    System.out.println("up");
                    break;
                case 1:
                    System.out.println("down");
                    break;
                case 3:
                    System.out.println("right");
                    break;
                case 2:
                    System.out.println("left");
                    break;
            }
        }
    }

    static public ArrayList getAll(){
        return states ;
    }

    public State getParent(){
        return this.parent ;
    }

    public Board getBoard(){
        return this.board ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return board.equals(state.board);
    }


    @Override
    public int compareTo(State state) {
        if (this.equals(state))
            return 0;
        return 1;
    }
}
