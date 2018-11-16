package edu.sdu.woz;

import edu.sdu.woz.room.Room;

public interface IFacade {
    public void onRoomEnter(Room room);

    public void onGameOver();
}
