package com.jacky.dao.test;

import com.jacky.dao.dao.ActorDao;
import com.jacky.dao.domain.Actor;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 2022/1/27
 */
public class TestDao {
    @Test
    public void testActorDao(){

        ActorDao actorDao = new ActorDao();
        List<Actor> actors = actorDao.queryMulti("select * from actor where id >=?", Actor.class, 2);
        System.out.println("search result:  ");
        for (Actor actor:actors){
            System.out.print(actor);
        }

        Actor actor = actorDao.querySingle("select * from actor where id =?", Actor.class,10);
        System.out.println("------");
        System.out.println(actor);

    }

}
