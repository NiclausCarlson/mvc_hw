package com.mvc_hw.controller;

import com.mvc_hw.dao.TaskDao;
import com.mvc_hw.dao.TaskListsDao;
import com.mvc_hw.model.Task;
import com.mvc_hw.model.TasksList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskListsController {
    final TaskListsDao taskListsDao;

    public TaskListsController(TaskListsDao taskListsDao) {
        this.taskListsDao = taskListsDao;
    }

    @GetMapping("/")
    public String getMapping() {
        return "redirect:/lists";
    }

    @RequestMapping(value = "/add-list", method = RequestMethod.POST)
    public String addList(@ModelAttribute("list") TasksList list) {
        taskListsDao.addList(list);
        return "redirect:/lists";
    }

    @RequestMapping(value = "/delete-list", method = RequestMethod.POST)
    public String deleteList(@RequestParam(name = "listId") Integer listId, Model model) {
        model.addAttribute("listId", listId);
        taskListsDao.deleteList(listId);
        return "redirect:/lists";
    }

    @GetMapping("/lists")
    public String getLists(Model map) {
        prepareModelMap(map, taskListsDao.getLists());
        return "index";
    }

    @GetMapping("/get-list")
    public String getList(@RequestParam(name = "listId") Integer listId, Model map) {
        map.addAttribute("listId", listId);
        return "redirect:/get-tasks?listId=" + listId.toString();
    }

    private void prepareModelMap(Model map, List<TasksList> lists) {
        map.addAttribute("lists", lists);
        map.addAttribute("list", new TasksList());
    }

}
