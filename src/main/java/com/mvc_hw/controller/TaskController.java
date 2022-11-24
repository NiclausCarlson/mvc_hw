package com.mvc_hw.controller;

import com.mvc_hw.dao.TaskDao;
import com.mvc_hw.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TaskController {
    final TaskDao taskDao;

    public TaskController(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @GetMapping("/")
    public String getMapping() {
        return "redirect:/get-tasks";
    }

    @RequestMapping(value = "/add-task", method = RequestMethod.POST)
    public String addTask(@ModelAttribute("task") Task task) {
        taskDao.addTask(task);
        return "redirect:/get-tasks";
    }

    @RequestMapping(value = "/get-tasks", method = RequestMethod.GET)
    public String getTasks(ModelMap map) {
        prepareModelMap(map, taskDao.getTasks());
        return "index";
    }

    private void prepareModelMap(ModelMap map, List<Task> tasks) {
        map.addAttribute("tasks", tasks);
        map.addAttribute("task", new Task());
    }
}
