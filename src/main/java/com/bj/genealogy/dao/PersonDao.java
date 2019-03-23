package com.bj.genealogy.dao;

import com.bj.genealogy.bean.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDao extends JpaRepository<Person, Integer> {
}
