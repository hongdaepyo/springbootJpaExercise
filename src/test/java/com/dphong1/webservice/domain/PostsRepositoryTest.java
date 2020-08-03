package com.dphong1.webservice.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostsRepositoryTest {
	
	@Autowired
	PostsRepository postRepository;
	
	@After
	public void cleanup() {
		postRepository.deleteAll();
	}
	
	@Test
	public void 게시글저장_불러오기() {
		
		postRepository.save(Posts.builder()
				.title("테스트 게시글")
				.content("테스트 본문")
				.author("dphong@kakao.com").build());
		
		List<Posts> postsList = postRepository.findAll();
		
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle(), is("테스트 게시글"));
		assertThat(posts.getContent(), is("테스트 본문"));
		
	}
}
