package com.cms.app.service;

import com.cms.app.dao.PostDao;
import com.cms.app.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by burusothman on 8/31/16.
 */
@Service(value = "postService")
public class PostService {
    @Autowired
    PostDao postDao;

    public void createPost(Post post) {
        postDao.saveOrUpdate(post);
    }

    public List<Post> getAll() {
        return null;
    }

}
