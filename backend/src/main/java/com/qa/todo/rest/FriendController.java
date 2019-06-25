package com.qa.todo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.todo.business.ITodoService;
import com.qa.todo.constants.Constants;
import com.qa.todo.domain.Todo;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FriendController {

	@Autowired
	private IFriendService friendService;

	@GetMapping(path = Constants.FRIEND)
	public ResponseEntity<List<Friend>> getFriend() {
		return ResponseEntity.ok(friendService.getFriend());
	}
	
	@RequestMapping(value = Constants.FRIEND, method = RequestMethod.POST)
	public ResponseEntity<Friend> postFriend(@RequestBody Friend friend) {
		return ResponseEntity.ok(friendService.addFriend(friend));
	}

	@RequestMapping(value = Constants.FRIEND_WITH_PARAM, method = RequestMethod.DELETE)
	public ResponseEntity<List<Friend>> deleteFriend(@PathVariable("id") long id) {
		if (!friendService.findById(id).isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		friendService.deleteFriend(id);
		return ResponseEntity.ok(friendService.getFriend());
	}



}