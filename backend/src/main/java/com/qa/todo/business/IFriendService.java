package com.qa.todo.business;

import java.util.List;
import java.util.Optional;

import com.qa.todo.domain.Friend;

public interface IFriendService {

	List<Friend> getFriend();

	void deleteFriend(Long id);

	Friend addFriend(Friend friend);

	Optional<Friend> findById(long id);

}