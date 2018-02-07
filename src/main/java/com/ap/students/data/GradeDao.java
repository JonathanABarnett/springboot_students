package com.ap.students.data;

import com.ap.students.models.Grade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface GradeDao extends CrudRepository<Grade, Integer>{
}
