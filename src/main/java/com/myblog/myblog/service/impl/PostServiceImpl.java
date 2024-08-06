package com.myblog.myblog.service.impl;


import com.myblog.myblog.entity.Post;
import com.myblog.myblog.payload.PostDto;
import com.myblog.myblog.repository.PostRepository;
import com.myblog.myblog.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post=new Post();
        post.setTittle(postDto.getTittle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        Post savedPost = postRepository.save(post);

        PostDto dto=new PostDto();
        dto.setTittle(savedPost.getTittle());
        dto.setContent(savedPost.getContent());
        dto.setDescription(savedPost.getDescription());
        return dto;
    }
}
