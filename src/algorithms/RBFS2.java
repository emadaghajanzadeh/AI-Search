//
//package algorithms;
//
//import static java.lang.Integer.max;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.PriorityQueue;
//import java.util.Scanner;
//import java.util.Set;
//import java.util.TreeSet;
//import models.State;
//
//public class RBFS {
//    static int count = 0;
//    public static State solve(State start) {
//
//        if (start.isFinal()) {
//            start.print();
//            return start;
//        }
//
//        Find(start , 0);
//
//        return null;
//    }
//
//    private static boolean Find(State start , int limit){
//
//        PriorityQueue<State> fringe = new PriorityQueue<>(new Comparator<State> () {
//            @Override
//            public int compare(State o1, State o2) {
//                if(o1.get_hirostice()<o2.get_hirostice())return 1;
//                else return -1;
//            }
//        });
//        for (State child : start.makeChild())
//            fringe.add(child);
//
////        System.out.println(start.getBoard().getCube().getX()+" "+start.getBoard().getCube().getY());
//
//        start.best_child_score = fringe.peek().get_hirostice();
//
//        while(!fringe.isEmpty()) {
//
//            State first = fringe.poll();
//            count++;
//            if (first.isFinal()) {
//                first.print();
//                System.out.println("node count = " + count);
//                return true;
//            }
//            int new_limit=0;
//            if(first.get_hirostice()>limit){
//                if(fringe.peek()!=null)new_limit= fringe.peek().get_hirostice();
//
//                if(!Find(first , max(limit ,new_limit ))){
//                    first.called++;
//                    fringe.add(first);
//                }else{
//                    return true;
//                }
//            }else{
//                return false;
//            }
//
//        }
//        return false;
//    }
//}
