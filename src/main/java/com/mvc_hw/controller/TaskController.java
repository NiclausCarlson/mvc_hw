package com.mvc_hw.controller;

import com.mvc_hw.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {
    List<Task> list = new ArrayList<Task>();

    @GetMapping("/")
    public String getMapping() {
        return "index";
    }

    @RequestMapping(value = "/add-task", method = RequestMethod.POST)
    public String addQuestion(@ModelAttribute("task") Task task) {
        list.add(task);
        return "redirect:/get-tasks";
    }

    @RequestMapping(value = "/get-tasks", method = RequestMethod.GET)
    public String getTasks(ModelMap map) {
        prepareModelMap(map, list);
        return "index";
    }

    private void prepareModelMap(ModelMap map, List<Task> tasks) {
        map.addAttribute("tasks", tasks);
        map.addAttribute("task", new Task());
    }
}
