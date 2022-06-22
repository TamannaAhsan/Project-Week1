

import java.util.*;
public enum Availability {

    InStock("Items are available"),
    OutComing("Items will be available in few days"),
    OutofStock("Items are not available");
    public final String stored;

    Availability(String stored) {
        this.stored = stored;
    }

    public String getStored() {
        return stored;
    }
}


