package com.capco.challenge.repository;

import com.capco.challenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("peopleRepository")
public interface PeopleRepository extends JpaRepository<User, Long> {
}
