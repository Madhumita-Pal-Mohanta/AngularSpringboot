package com.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.models.BookInfoModel;
import com.models.StudentUserInfoModel;

@Repository
public interface BookRepository extends CrudRepository<BookInfoModel, Integer>
{
	List<BookInfoModel> findByStuuserid(Integer stuuserid);
	List<BookInfoModel> findByAuthor1(String author1);
	List<BookInfoModel> findByBooktitle(String booktitle);
}
