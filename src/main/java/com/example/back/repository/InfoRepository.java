package com.example.back.repository;

import com.example.back.model.dto_data.Info;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.time.ZonedDateTime;
import java.util.List;

public interface InfoRepository extends PagingAndSortingRepository<Info, Long>, JpaRepository<Info, Long>, JpaSpecificationExecutor<Info> {

    @Query("SELECT i FROM Info i WHERE i.category = :category")
    Page<Info> findInfoByCategory(
            @Param("category")String category,
            Pageable pageable
    );

    @Query("SELECT i FROM Info i WHERE i.category = :category AND i.date > :date")
    List<Info> findInfoByCategoryAndDate(
            @Param("category")String category,
            @Param("date")ZonedDateTime date
            );
}
