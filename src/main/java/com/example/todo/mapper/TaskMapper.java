package com.example.todo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import com.example.todo.entity.Task;

@Mapper
public interface TaskMapper {

    // 作成日の昇順で全件取得
    @Select("SELECT * FROM task ORDER BY created_at ASC")
    List<Task> findAll();

    
    @Insert("INSERT INTO task (title, description, priority, status, created_at, updated_at) " +
            "VALUES (#{title}, #{description}, #{priority}, '未着手', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)")
    void insert(Task task);

    @Select("SELECT * FROM task WHERE id = #{id}")
    Task findById(Long id);


    @Update("UPDATE task SET title = #{title}, description = #{description}, priority = #{priority}, status = #{status}, updated_at = CURRENT_TIMESTAMP WHERE id = #{id}")
    void update(Task task);

    @Update("UPDATE task SET status = #{status}, updated_at = CURRENT_TIMESTAMP WHERE id = #{id}")
    void updateStatus(@Param("id") Long id, @Param("status") String status);

    @Delete("DELETE FROM task WHERE id = #{id}")
    void delete(Long id);

}

