package com.qa.todo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.todo.domain.Friend;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {
	
}
