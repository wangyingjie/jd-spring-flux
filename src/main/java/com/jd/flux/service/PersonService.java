package com.jd.flux.service;

import com.jd.flux.bean.Person;

/**
 * @author: wangyingjie1
 * @version: 1.0
 * @createdate: 2017-12-06 18:43
 */
public interface PersonService {

    Person getById(Integer id);

    void add(Person person);
}
