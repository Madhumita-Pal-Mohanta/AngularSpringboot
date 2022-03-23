package com.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.models.StudentUserInfoModel;

@Repository
public interface AdminRepository extends CrudRepository<StudentUserInfoModel, Integer>
{
	StudentUserInfoModel findByEmailid(String emailid);
}
