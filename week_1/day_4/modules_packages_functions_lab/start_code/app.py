from modules.task_list import *
from modules.output import *
import data.task_list as task_list
from modules.input import *


load_task = load_tasks()
if load_task == "Y":
    # from data.task_list import *
    tasks = task_list.initial_tasks
    print("data loaded")
       
else:
    tasks = []
    print("Data not loaded")

while (True):
    print_menu()
    option = get_input_option()
    if (option.lower() == 'q'):
        break
    if option == '1':
        print_list(tasks)
    elif option == '2':
        print_list(get_tasks_by_status(tasks, False))
    elif option == '3':
        print_list(get_tasks_by_status(tasks, True))
    elif option == '4':
        description = get_input_description_1()
        task = get_task_with_description(tasks, description)
        if task is not None:
            mark_task_complete(task)
            print("Task marked complete")
        else:
            print("Task not found")
    elif option == '5':
        time = get_input_time()
        print_list(get_tasks_taking_at_least(tasks, time))
    elif option == '6':
        description = get_input_description_2()
        print(get_task_with_description(tasks, description))
    elif option == '7':
        description = get_input_description_3()
        time_taken = get_input_time_taken()
        task = create_task(description, time_taken)
        tasks.append(task)
    else:
        print("Invalid Input - choose another option")