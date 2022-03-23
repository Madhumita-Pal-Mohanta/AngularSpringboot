package com.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.models.BookInfoModel;
import com.models.OrderInfoModel;

@Repository
public interface OrderRepository extends CrudRepository<OrderInfoModel, Integer>
{
	List<OrderInfoModel> findByBuyeruserid(Integer buyeruserid);
	List<OrderInfoModel> findBySelleruserid(Integer selleruserid);
}
