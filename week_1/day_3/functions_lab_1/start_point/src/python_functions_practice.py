def return_10():
    return 10

def add(num_1, num_2):
    return num_1 + num_2

def subtract(num_1, num_2):
    return num_1 - num_2

def multiply(num_1, num_2):
    return num_1 * num_2

def divide(num_1, num_2):
    return num_1 / num_2

def length_of_string(test_str):
    return len(test_str)

def join_string(string_1, string_2):
    return string_1 + string_2

def add_string_as_number(str_1, str_2):
    int_1 = int(str_1)
    int_2 = int(str_2)
    return int_1 + int_2

def number_to_full_month_name(month_num):
    month_map = {
        1: 'January',
        2: 'February',
        3: 'March',
        4: 'April',
        5: 'May',
        6: 'June',
        7: 'July',
        8: 'August',
        9: 'September',
        10: 'October',
        11: 'November',
        12: 'December'
    }
    return month_map[month_num]

def number_to_short_month_name(month_num):
    return number_to_full_month_name(month_num)[:3]

def volume_of_cube(side_length):
    return side_length ** 3

def reverse_string(str):
    return str[::-1]

def fahrenheit_to_celsius(fah_temp):
    # Subtract 32
    # Multiply by 5
    # Divide by Nine
    # Floored to preserve int
    cel_temp = ((fah_temp - 32) * 5) // 9
    return cel_temp