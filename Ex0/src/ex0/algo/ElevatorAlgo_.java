package ex0.algo;


import ex0.Building;
import ex0.CallForElevator;
import ex0.Elevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class ElevatorAlgo_ implements ElevatorAlgo {

    Building building_;

    Elevator el;
    ArrayList<Elevator> all_elevators;

    CallForElevator call;
    ArrayList<CallForElevator> all_calls;

    HashMap<Integer, Double> elevator_time_map;

    public double Elevator_time_to_dest(CallForElevator c, int id) {
        el = building_.getElevetor(id);
        double time_to_dest =((c.getSrc() + c.getDest()) / el.getSpeed());
        double time_to_src = ((el.getPos() + c.getSrc()) / el.getSpeed());
        double o_time = el.getTimeForClose();
        double c_time = el.getTimeForClose();
        double s_time = el.getStartTime();
        double st_time = el.getStopTime();

        double t;
        if (el.getPos() == c.getSrc()) {
            t = 0;
        }
        else {
            t = time_to_src +  o_time + c_time + s_time + st_time;
        }

        double T = time_to_dest + o_time + c_time + s_time + st_time + t;
        return T;
    }

    @Override
    public Building getBuilding() {
        return building_;
    }

    @Override
    public String algoName() {
        return null;
    }

    @Override
    public int allocateAnElevator(CallForElevator c) {
        int c_type = c.getType();
        for (Elevator e : all_elevators) {
            int e_type = e.getState();
            int id = e.getID();
            if (c_type == e_type || e_type == 0) {
                if(c_type == 1 && e.getPos() < c.getSrc()) {
                    int dest =
                }
                if(c_type == -1 && e.getPos() > c.getSrc()) {

                }
            }
            double time = Elevator_time_to_dest(c, id);
            elevator_time_map.put(id, time);
        }
    }

    @Override
    public void cmdElevator(int elev) {

    }
}
