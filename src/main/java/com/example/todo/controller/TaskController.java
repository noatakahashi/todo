package com.example.todo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.todo.entity.Task;
import com.example.todo.mapper.TaskMapper;

@Controller
public class TaskController {

    private final TaskMapper taskMapper;

    
    // コンストラクタインジェクション
    public TaskController(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @GetMapping("/tasks")
    public String tasks(Model model) {

        // DBから全件取得
        List<Task> tasks = taskMapper.findAll();

        // 画面に渡す
        model.addAttribute("tasks", tasks);

        // templates/task/task-list.html を表示
        return "task/task-list";
    }

    @GetMapping("/tasks/create")
    public String newTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "task/task-new";
    }

    @PostMapping("/tasks/create")
    public String createTask(@ModelAttribute Task task) {
        taskMapper.insert(task);
        return "redirect:/tasks";
    }

    // タスク詳細表示
    @GetMapping("/tasks/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Task task = taskMapper.findById(id);
        model.addAttribute("task", task);
        return "task/task-detail";
    }

    // タスク編集フォーム表示
    @GetMapping("/tasks/{id}/edit")
    public String editTaskForm(@PathVariable Long id, Model model) {
        Task task = taskMapper.findById(id);
        model.addAttribute("task", task);
        return "task/task-edit";
    }

    // タスク更新
    @PostMapping("/tasks/{id}/edit")
    public String editTask(@PathVariable Long id, @ModelAttribute Task task) {
        task.setId(id);
        taskMapper.update(task);
        return "redirect:/tasks";
    }

    // ステータス更新
    @PostMapping("/tasks/{id}/update-status")
    public String updateTaskStatus(@PathVariable Long id, @RequestParam("status") String status) {
        taskMapper.updateStatus(id, status);
        return "redirect:/tasks";
    }

    // タスク削除
    @PostMapping("/tasks/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        taskMapper.delete(id);
        return "redirect:/tasks";
    }

}