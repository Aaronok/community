package com.example.community;

import com.example.community.dao.DiscussPostMapper;
import com.example.community.dao.UserMapper;
import com.example.community.entity.DiscussPost;
import com.example.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;


@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;


    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);
        User user1 = userMapper.selectByName("liubei");
        System.out.println(user1);
        User user2 = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user2);



    }
    @Test
    public void testInsertUser(){
        User user = new User();
        user.setCreateTime(new Date());
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.nowcode.com/101.png");
        user.setPassword("123456");
        user.setUsername("test");
        user.setSalt("abc");

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdate(){
        int rows = userMapper.updateStatus(150,1);
        System.out.println(rows);

        rows = userMapper.updateHeader(150,"http://www.cowcode.com/102.png");
        System.out.println(rows);

        rows = userMapper.updatePassword(150,"hulinhao");
        System.out.println(rows
        );
    }

    @Test
    public void testSelectDiscussPosts(){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(149, 0, 10);
        for(DiscussPost discussPost:discussPosts){
            System.out.println(discussPost);
        }
        int rows = discussPostMapper.selectDiscussPostsRows(149);
        System.out.println(rows);
    }

}
