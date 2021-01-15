package globals;

public enum DirectionType {

    NORTH,
    SOUTH,
    EAST,
    WEST,
    UP,
    DOWN;
    /*
        NOEXIT has an integer value which is convenient when initializing the
        'Exit' fields in Room objects. All valid exits indicate a Room number
        whereas NOEXIT is -1.
    */
    public static final int NOEXIT = -1;


}
