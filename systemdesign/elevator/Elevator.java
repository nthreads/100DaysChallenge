package elevator;

import java.util.TreeSet;

public class Elevator {
    Direction currDirection = Direction.UP;
    State currState = State.IDLE;
    int currFloor = 0;

    TreeSet<Request> currentJobs = new TreeSet<>();
    TreeSet<Request> pendingUpJobs = new TreeSet<>();
    TreeSet<Request> pendingDownJobs = new TreeSet<>();

    public void startElevator() {
        System.out.println("The Elevator has started");
        while(true) {
            if(!currentJobs.isEmpty()) {
                if(currDirection == Direction.UP) {
                    Request request = currentJobs.pollFirst();
                    processUpRequest(request);
                    if(currentJobs.isEmpty()) {
                        addPendingDownJobsToCurrJobs();
                    }
                }

                if(currDirection == Direction.DOWN) {
                    Request request = currentJobs.pollLast();
                    processDownRequest(request);

                    if(currentJobs.isEmpty()) {
                        addPendingUpJobsToCurrentJobs();
                    }
                }
            }
        }
    }

    private void addPendingUpJobsToCurrentJobs() {
        if(!pendingUpJobs.isEmpty()) {
            currentJobs = pendingUpJobs;
            currDirection = Direction.UP;
        } else  {
            currState = State.IDLE;
        }

    }

    private void processDownRequest(Request request) {

    }

    private void addPendingDownJobsToCurrJobs() {
        if(!pendingDownJobs.isEmpty()) {
            currentJobs = pendingDownJobs;
            currDirection = Direction.UP;
        } else  {
            currState = State.IDLE;
        }
    }

    private void processUpRequest(Request request) {

    }
}
