# For the following list of numbers:

numbers = [1, 6, 2, 2, 7, 1, 6, 13, 99, 7]

# 1. Print out a list of the even integers:
print([num for num in numbers if num % 2 == 0])

# 1. Without list comprehension
even_nums = []
for num in numbers:
    if num%2 == 0: even_nums.append(num)
#print(even_nums)


# 2. Print the difference between the largest and smallest value:
print(max(numbers) - min(numbers))

# 2. Without min/max functions
numbers_min = numbers[0]
numbers_max = numbers[0]
for num in numbers:
    if num < numbers_min: numbers_min = num
    elif num > numbers_max: numbers_max = num
#print(numbers_max - numbers_min)

# 3. Print True if the list contains a 2 next to a 2 somewhere.
for index, num in enumerate(numbers):
    if index == 0: continue
    elif numbers[index] == numbers[index - 1]:
        print(True)

# 3. Without enumerate
prev_num = None
for num in numbers:
    if prev_num == num:
        #print(True)
        break
    prev_num = num
 

# 4. Print the sum of the numbers, 
#    BUT ignore any section of numbers starting with a 6 and extending to the next 7.
#    
#    So [11, 6, 4, 99, 7, 11] would have sum of 22
skip_num = False
q4_sum = 0
for num in numbers:
    if num == 6: skip_num = True
    elif num == 7: skip_num = False
    elif skip_num == True: continue
    else: q4_sum += num
        
print(q4_sum)

# 5. HARD! Print the sum of the numbers. 
#    Except the number 13 is very unlucky, so it does not count.
#    And numbers that come immediately after a 13 also do not count.
#    HINT - You will need to track the index throughout the loop.
#
#    So [5, 13, 2] would have sum of 5. 
q5_sum = 0
indices_of_13 = []
for index, num in enumerate(numbers):
    if num == 13:
        indices_of_13.append(index)
        continue
    elif len(indices_of_13) != 0 and indices_of_13[-1] == index - 1:
        continue
    else:
        q5_sum += num

print(q5_sum)

# Without enumerate I would just create a counter variable and
# add one each loop to serve as the index.





