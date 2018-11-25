package tutorial.junit.user;

public enum State {

    ENABLED("Enabled"), DISABLED("Disabled"), REGISTERED("Registered") ;

    State(String name) {
        this.name = name;
    }

    private String name;

    public String getName(){
        return name;
    }

    public static State getByName(String name){
        for (State state : State.values()) {
            if(state.name.equals(name))
                return state;
        }
        throw new IllegalArgumentException();
    }
}
