
# Functions to complete:

## Get a list of uncompleted tasks
def get_uncompleted_tasks(list):
    # [task for task in tasks if task['completed' == False]]
    uncompleted_tasks = []
    for task in list:
        if task['completed'] == False:
            uncompleted_tasks.append(task)
    return uncompleted_tasks

## Get a list of completed tasks
def get_completed_tasks(list):
     # [task for task in tasks if task['completed' == True]]
    completed_tasks = []
    for task in list:
        if task['completed'] == True:
            completed_tasks.append(task)
    return completed_tasks   

## Get tasks where time_taken is at least a given time
def get_tasks_taking_at_least(list, time):
    tasks_longer_than_time = []
    for task in list:
        if task['time_taken'] >= time:
            tasks_longer_than_time.append(task)
    return tasks_longer_than_time

## Find a task with a given description
def get_task_with_description(list, description):
    tasks_with_description = []
    for task in list:
        if task['description'] == description:
            tasks_with_description.append(task)
    return tasks_with_description    

# Extention (Function): 

## Get a list of tasks by status
def get_tasks_by_status(list, status):
    tasks = []
    for task in list:
        if task['completed'] == status:
            tasks.append(task)
    return tasks


def mark_task_complete(task):
    task["completed"] = True

def create_task(description, time_taken):
    task = {}
    task["description"] = description
    task["completed"] = False
    task["time_taken"] = time_taken

    return task

def add_to_list(list, task):
    list.append(task)
