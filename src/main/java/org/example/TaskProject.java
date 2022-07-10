package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaskProject {
    /*
    Написать метод, принимающий аргументом список содержащий в себе структуры HashMap<String,String>, описывающие объекты типа "Задача проекта".
    Каждая HashMap<String,String> содержит в себе:
            "task_id" - строка с идентификатором задач: уникальное значение, повторяющихся задач в списке нет. Не может быть пустой.
            "assignee_id" - строка с идентификатором назначенного на задачу сотрудника: один сотрудник может быть назначен на несколько задач из списка. Может быть пустой строкой.
            "task_state" - строка с названием статуса задачи: принимает одно из двух значений (active|disabled). Не может быть пустой.

    Метод должен вернуть целочисленное значение - количество уникальных сотрудников, назначенных на активные задачи из списка.

    Пример:

    Список, переданный как аргумент:
            [
    {task_id = 1, assignee_id = 001, task_state = active},
    {task_id = 2, assignee_id = 002, task_state = active},
    {task_id = 3, assignee_id = 001, task_state = active}},
        {task_id = 4, assignee_id = 007, task_state = disabled}
        ];

        Ожидаемое значение:
        2
        */

public static void main(String[] args){
        List<HashMap<String, String>> sampleInputData = new ArrayList<HashMap<String, String>>() {{
        add(new HashMap<String, String>() {{
        put("task_id", "1");
        put("assignee_id", "001");
        put("task_state", "active");
        }});
        add(new HashMap<String, String>() {{
        put("task_id", "2");
        put("assignee_id", "002");
        put("task_state", "active");
        }});
        add(new HashMap<String, String>() {{
        put("task_id", "3");
        put("assignee_id", "001");
        put("task_state", "active");
        }});
        add(new HashMap<String, String>() {{
        put("task_id", "4");
        put("assignee_id", "007");
        put("task_state", "disabled");
        }});
        }};
        System.out.println(getUniqueEmployeesCount(sampleInputData));

        }

public static long getUniqueEmployeesCount(List<HashMap<String, String>> projectTaskList){
        return projectTaskList.stream()
        .filter(pt->pt.get("task_state") == "active")
        .map(pt-> pt.get("assignee_id"))
        .distinct()
        .count();
        }
}
