package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Решить задачу
     * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1439">https://acm.timus.ru/problem.aspx?space=1&num=1439</a>
     */
    public List<Integer> getOriginalDoorNumbers(int maxDoors, List<Action> actionList) {
        TreeSet<Integer> doors = new TreeSet<>();
        for (int i = 1; i <= maxDoors; i++) {
            doors.add(i);
        }
    
        List<Integer> result = new ArrayList<>();
        for (Action action : actionList) {
            if (action.isLook()) {
                Integer door = doors.ceiling(action.getDoorNumber());
                if (door == null) {
                    throw new IllegalStateException("No available doors for action: " + action);
                }
                result.add(door);
            } else {
                Integer door = doors.ceiling(action.getDoorNumber());
                if (door != null) {
                    doors.remove(door);
                }
            }
        }
        return result;
    }
    
    /**
     * <h1>Задание 2.</h1>
     * Решить задачу <br/>
     * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1521">https://acm.timus.ru/problem.aspx?space=1&num=1521</a><br/>
     * <h2>Пошагово</h2>
     * Для 5 3 входных данных:<br/>
     * _ -> 3 позиции<br/>
     * _ 1 2 <b>3</b> 4 5 => 3 <br/>
     * <b>1</b> 2 _ 4 5 => 1 <br/>
     * _ 2 4 <b>5</b> => 5 <br/>
     * <b>2</b> 4 _ => 2 <br/>
     * _ <b>4</b> => 4
     */
    public List<Integer> getLeaveOrder(int maxUnits, int leaveInterval) {
        List<Integer> units = new ArrayList<>();
        for (int i = 1; i <= maxUnits; i++) {
            units.add(i);
        }
    
        List<Integer> result = new ArrayList<>();
        int currentIndex = 0;
    
        while (!units.isEmpty()) {
            currentIndex = (currentIndex + leaveInterval - 1) % units.size();
            result.add(units.remove(currentIndex));
        }
    
        return result;
    }

}
