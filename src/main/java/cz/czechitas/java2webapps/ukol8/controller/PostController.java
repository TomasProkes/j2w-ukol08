package cz.czechitas.java2webapps.ukol8.controller;

import cz.czechitas.java2webapps.ukol8.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for displaying blog posts
 */
@Controller
public class PostController {
    private final PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView baseList() {
        Pageable pageable = PageRequest.of(0, 20, Sort.by("published").descending());
        return new ModelAndView("posts")
                .addObject("posts", service.list(pageable));
    }

    @GetMapping("/post/{slug}")
    public ModelAndView blogPost(@PathVariable String slug) {
        return new ModelAndView("post")
                .addObject("post", service.singlePost(slug));
    }
}
