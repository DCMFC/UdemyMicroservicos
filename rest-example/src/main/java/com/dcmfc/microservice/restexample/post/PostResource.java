package com.dcmfc.microservice.restexample.post;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class PostResource {
	
	@Autowired
	private PostDaoService service;
	
	@GetMapping("users/{id}/posts")
	public List<Post> retrieveAllPosts(@PathVariable Integer id)
	{
		return service.findAll(id);
	}
	
	@PostMapping("users/{id}/posts")
	public ResponseEntity<Object> createPost(@RequestBody Post post)
	{
		Post savedPost = service.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{post_id}").buildAndExpand(savedPost.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("users/{id}/posts/{post_id}")
	public Post retrieveOnePost(@PathVariable Integer id, @PathVariable Integer post_id)
	{
		Post post = service.findOnePost(id, post_id);
		
		return post;
	}

}
