package com.mvc_hw.controller;

import com.mvc_hw.dao.TaskDao;
import com.mvc_hw.logic.TaskFilter;
import com.mvc_hw.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @RequestMapping(value = "/delete-task", method = RequestMethod.POST)
    public String deleteTask(@RequestParam(name = "taskId") Integer taskId, Model model) {
        model.addAttribute("taskId", taskId);
        taskDao.deleteTask(taskId);
        return "redirect:/get-tasks";
    }

    @RequestMapping(value = "/set-is-done", method = RequestMethod.POST)
    public String setIsDone(@RequestParam(name = "taskId") Integer taskId,
                            @RequestParam(name = "isDone") Boolean isDone,
                            Model model) {
        model.addAttribute("taskId", taskId);
        model.addAttribute("isDone", isDone);
        taskDao.updateTask(taskId,
                Optional.empty(),
                Optional.ofNullable(isDone),
                Optional.empty(),
                Optional.empty());
        return "redirect:/get-tasks";
    }

    @RequestMapping(value = "/set-priority", method = RequestMethod.POST)
    public String setPriority(@RequestParam(name = "taskId") Integer taskId,
                              @RequestParam(name = "priority") Integer priority,
                              Model model) {
        model.addAttribute("taskId", taskId);
        model.addAttribute("priority", priority);
        taskDao.updateTask(taskId,
                Optional.ofNullable(priority),
                Optional.empty(),
                Optional.empty(),
                Optional.empty());
        return "redirect:/get-tasks";
    }

    @RequestMapping(value = "/change-name", method = RequestMethod.POST)
    public String changeName(@RequestParam(name = "taskId") Integer taskId,
                             @RequestParam(name = "new_name") String new_name,
                             Model model) {
        model.addAttribute("taskId", taskId);
        model.addAttribute("new_name", new_name);
        taskDao.updateTask(taskId,
                Optional.empty(),
                Optional.empty(),
                Optional.ofNullable(new_name),
                Optional.empty());
        return "redirect:/get-tasks";
    }

    @RequestMapping(value = "/change-description", method = RequestMethod.POST)
    public String changeDescription(@RequestParam(name = "taskId") Integer taskId,
                                    @RequestParam(name = "new_description") String new_description,
                                    Model model) {
        model.addAttribute("taskId", taskId);
        model.addAttribute("new_description", new_description);
        taskDao.updateTask(taskId,
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.ofNullable(new_description));
        return "redirect:/get-tasks";
    }

    @RequestMapping(value = "/get-tasks", method = RequestMethod.GET)
    public String getTasks(Model map) {
        prepareModelMap(map, taskDao.getTasks());
        return "index";
    }

    private void prepareModelMap(Model map, List<Task> tasks) {
        map.addAttribute("tasks", tasks);
        map.addAttribute("task", new Task());
    }
}
