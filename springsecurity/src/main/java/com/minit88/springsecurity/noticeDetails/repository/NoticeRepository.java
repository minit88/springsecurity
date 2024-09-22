package com.minit88.springsecurity.noticeDetails.repository;

import com.minit88.springsecurity.noticeDetails.entity.Notice;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends CrudRepository<Notice, Long> {

    @Query("select n from Notice n where CURDATE() BETWEEN n.noticeBegAt AND n.noticeEndAt")
    List<Notice> findAllActiveNotices();

}