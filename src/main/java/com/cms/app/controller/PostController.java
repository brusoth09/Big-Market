package com.cms.app.controller;

import com.cms.app.model.Post;
import com.cms.app.model.User;
import com.cms.app.service.PostService;
import com.cms.app.utils.PostStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by burusothman on 8/31/16.
 */
@Controller
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping(value = "/post/create", method = RequestMethod.POST)
    public String createPost(@ModelAttribute("postForm") Post post, @RequestParam String action,
                           BindingResult result, Model model, final RedirectAttributes redirectAttributes){
        if( action.equals("preview") ){
            model.addAttribute("post",post);
            return "page";
        }else if(action.equals("draft")){
            post.setStatus(PostStatus.Draft);
            postService.createPost(post);
            model.addAttribute("post",post);
            return  "home";

        }else if( action.equals("publish") ){
            post.setStatus(PostStatus.ReadyPublish);
            postService.createPost(post);

            return  "page";
        }

        return "post";
    }

    @RequestMapping(value = "/post/preview", method = RequestMethod.POST)
    public String showPreview(@ModelAttribute("postForm") Post post,
                           BindingResult result, Model model, final RedirectAttributes redirectAttributes){
        model.addAttribute("post",post);
        return "page";
    }

    @RequestMapping(value = "/post/add", method = RequestMethod.POST)
    @ResponseBody
    public String addPostToDraft(@RequestParam(value = "title") String title, @RequestParam(value = "content") String content){
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setStatus(PostStatus.Draft);
        post.setCreated(new Date());
        post.setModified(new Date());
        postService.createPost(post);
        return "post";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.POST)
    @ResponseBody
    public String getAll(Model model,HttpServletRequest request, HttpServletResponse responce){
//        if(!StringUtils.isEmpty(SecurityContextHolder.getContext().getAuthentication().getPrincipal())){
          List<Post> posts = PostService.getByUser("brusoth");
//        }
          model.addAttribute("posts", posts);
          return "postview";

    }

    @RequestMapping(value = "/getAllPost", method = RequestMethod.POST)
    @ResponseBody
    public String getAll(Model model,HttpServletRequest request, HttpServletResponse responce){
        List<Post> posts = PostService.getAll();
        model.addAttribute("posts", posts);
        return "postview";

    }


}
