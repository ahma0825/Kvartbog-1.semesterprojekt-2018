package edu.sdu.woz;

import edu.sdu.woz.room.Room;

public interface IFacade {
    void onRoomEnter(Room room);

    void onGameOver(boolean won);
}
