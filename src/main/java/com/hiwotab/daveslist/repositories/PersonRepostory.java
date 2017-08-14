package com.hiwotab.daveslist.repositories;

import com.hiwotab.daveslist.Model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepostory extends CrudRepository<Person,Long> {
}
