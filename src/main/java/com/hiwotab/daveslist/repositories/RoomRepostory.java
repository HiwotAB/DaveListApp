package com.hiwotab.daveslist.repositories;
import com.hiwotab.daveslist.Model.Room;
import org.springframework.data.repository.CrudRepository;


public interface RoomRepostory extends CrudRepository<Room,Long> {
    Iterable<Room> findAllByAvailability(boolean partialBoolean);
}

