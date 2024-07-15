package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.model.Post;
import com.aluracursos.forohub.repository.PostRepository;
import com.aluracursos.forohub.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post postDetails) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {
            post.setTitle(postDetails.getTitle());
            post.setContent(postDetails.getContent());
            return postRepository.save(post);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
    }

    @GetMapping("/movies")
    public Map<String, Object> getMovieDetails(@RequestParam String title) {
        return movieService.getMovieDetails(title);
    }
}