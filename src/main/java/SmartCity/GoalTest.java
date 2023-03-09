package SmartCity;

public class GoalTest {
    Users users;

    public boolean isGoalState(Object state) {
        Users = (Users) state;
        return allUsersAtWork() && !timeIsOut();
    }

    private boolean allUsersAtWork() {
        for(User user: users) {
            if(user.getCoordX() != user.getCoordDestinationX() || user.getCoordY() != user.getCoordDestinationY()) {
                return false;
            }
        }
        return true;
    }

    boolean timeIsOut() {
        return time > 60;
    }
}
