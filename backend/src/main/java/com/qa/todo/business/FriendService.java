package com.qa.todo.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.todo.domain.Friend;
import com.qa.todo.persistence.FriendRepository;

@Service
public class FriendService implements IFriendService {
	
	@Autowired
	private FriendRepository friendRepository;
	
	public List<Friend> getFriend() {
		return friendRepository.findAll();
	}

	public void deleteFriend(Long id) {
		friendRepository.deleteById(id);
		
	}

	public Friend addFriend(Friend friend) {
		return friendRepository.save(friend);
	}

	public Optional<Friend> findById(long id) {
		return friendRepository.findById(id);
	}
}
