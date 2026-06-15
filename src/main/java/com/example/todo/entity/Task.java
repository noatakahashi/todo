package com.example.todo.entity;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    private Long id;

    private String title;

    private String description;

    /**
     * 優先度:
     * A = 高, B = 中, C = 低
     */
    private String priority;

    /**
     * ステータス:
     * 未着手 / 進行中 / 完了
     */
    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}