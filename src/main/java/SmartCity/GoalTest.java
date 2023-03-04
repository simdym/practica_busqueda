package SmartCity;

public class GoalTest {
    Usarios usarios;

    public boolean isGoalState(Object state) {
        usarios = state;
        return allUsersAtWork() || !timeIsOut();
    }

    private boolean allUsersAtWork() {
        for(Usario usario: Usarios) {
            // if(!usario.isAtWork()) {return false}
            if(usario.getCoordX() != usario.getCoordDestinoX() || usario.getCoordY() != usario.getCoordDestinoY()) {
                return false;
            }
        }
        return true;
    }

    boolean timeIsOut() {
        return time > 60;
    }
}
