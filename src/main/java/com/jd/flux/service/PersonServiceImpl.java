package com.jd.flux.service;

import com.jd.flux.bean.Person;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangyingjie1
 * @version: 1.0
 * @createdate: 2017-12-06 18:43
 */
@Service
public class PersonServiceImpl implements PersonService {

    private static Map<Integer, Person>  map = new HashMap<>();

    static {
        for (int i = 0; i < 5; i++) {
            map.put(i, new Person(i, "name" + i));
        }
    }


    @Override
    public Person getById(Integer id) {
        return map.get(id);
    }

    @Override
    public void add(Person person) {
        map.put(person.getId(), person);
    }
}
