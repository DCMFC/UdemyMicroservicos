package com.dcmfc.microservice.restexample.post;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class PostDaoService {
	
	private static List<Post> posts = new ArrayList<>();
	private static int countPosts = 3;
	
	static{
		posts.add(new Post(1,1,"Post 1"));
		posts.add(new Post(2,1,"Post 2"));
		posts.add(new Post(3,1,"Post 3"));
	}
	
	public List<Post> findAll(Integer id)
	{
		return posts.stream().filter(p -> p.getUserId().equals(id)).collect(Collectors.toList());
	}
	
	public Post save(Post post)
	{
		if(post.getId()==null)
			post.setId(++countPosts);
		
		posts.add(post);
		return post;
	}
	
	public Post findOnePost(Integer id, Integer userId)
	{
		for(Post post : posts)
			if(post.getId() == id && post.getUserId() == userId)
				return post;
		
		return null;
	}
	
	

}
