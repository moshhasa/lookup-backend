package com.lookup.lookup.task;

import com.lookup.lookup.BaseCrudController;
import com.lookup.lookup.BaseResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskResource extends BaseCrudController<TaskResource.Task> {

    @Override
    public void init() {
        setItems(Arrays.asList(
                new Task(1, "Doctors Appointment", "Feb 5th at 2:30pm", true),
                new Task(2, "Meeting at School", "Feb 6th at 2:30pm", false),
                new Task(3, "Food Shopping", "Feb 7th at 2:30pm", true)
        ));
    }


    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Task> getTasks() {
        return getItems();
    }

    @GetMapping(path = "/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Task getTask(@PathVariable("taskId") long taskId) {
        return getItem(taskId);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Task addTasks(@RequestBody Task task) {
        return addItem(task);
    }

    @DeleteMapping("/{taskId}")
    public List<Task> getTasks(@PathVariable("taskId") int taskId) {
        return deleteItem(taskId);
    }

    @PutMapping(value = "/{taskId}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Task updateTask(@PathVariable("taskId") int taskId, @RequestBody Task task) {
        return merge(taskId, task);
    }


    static class Task extends BaseResponse<Task> {
        String text;
        String day;
        boolean reminder;

        public Task() {

        }

        public Task(long id, String text, String day, boolean reminder) {
           setId(id);
            this.text = text;
            this.day = day;
            this.reminder = reminder;
        }

        @Override
        public Task copy(Task task) {
            this.text = task.text;
            this.day = task.day;
            this.reminder = task.reminder;
            return this;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public boolean isReminder() {
            return reminder;
        }

        public void setReminder(boolean reminder) {
            this.reminder = reminder;
        }
    }
}
