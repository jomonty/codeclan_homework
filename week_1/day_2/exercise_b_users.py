users = {
  "Jonathan": {
    "twitter": "jonnyt",
    "lottery_numbers": [6, 12, 49, 33, 45, 20],
    "home_town": "Stirling",
    "pets": [
    {
      "name": "fluffy",
      "species": "cat"
    },
    {
      "name": "fido",
      "species": "dog"
    },
    {
      "name": "spike",
      "species": "dog"
    }
  ]
  },
  "Erik": {
    "twitter": "eriksf",
    "lottery_numbers": [18, 34, 8, 11, 24],
    "home_town": "Linlithgow",
    "pets": [
    {
      "name": "nemo",
      "species": "fish"
    },
    {
      "name": "kevin",
      "species": "fish"
    },
    {
      "name": "spike",
      "species": "dog"
    },
    {
      "name": "rupert",
      "species": "parrot"
    }
  ]
  },
  "Avril": {
    "twitter": "bridgpally",
    "lottery_numbers": [12, 14, 33, 38, 9, 25],
    "home_town": "Dunbar",
    "pets": [
      {
        "name": "monty",
        "species": "snake"
      }
    ]
  }
}

# 1. Get Jonathan's Twitter handle (i.e. the string `"jonnyt"`)
jonathan_twitter = users['Jonathan']['twitter']
#print(jonathan_twitter)

# 2. Get Erik's hometown
erik_hometown = users['Erik']['home_town']
#print(erik_hometown)

# 3. Get the list of Erik's lottery numbers
erik_lottery_nums = users['Erik']['lottery_numbers']
#print(erik_lottery_nums)

# 4. Get the species of Avril's pet Monty
avril_monty_species = users['Avril']['pets'][0]['species']
#print(avril_monty_species)

# 5. Get the smallest of Erik's lottery numbers
erik_smallest_lottery_num = min(users['Erik']['lottery_numbers'])
#print(erik_smallest_lottery_num)

# 6. Return an list of Avril's lottery numbers that are even
avril_even_lottery_nums = [num for num in users['Avril']['lottery_numbers'] if num%2 == 0]
print(avril_even_lottery_nums)

# 6. Without list comprehension
avril_even_lottery_nums_2 = []
for num in users['Avril']['lottery_numbers']:
  if num % 2 == 0: avril_even_lottery_nums_2.append(num)
#print(avril_even_lottery_nums_2)

# 7. Erik is one lottery number short! Add the number `7` to be included in his lottery numbers
users['Erik']['lottery_numbers'].append(7)
#print(users['Erik']['lottery_numbers'])

# 8. Change Erik's hometown to Edinburgh
users['Erik']['home_town'] = 'Edinburgh'
#print(users['Erik']['home_town'])

# 9. Add a pet dog to Erik called "fluffy"
users['Erik']['pets'].append(
  {
    'name': 'fluffy',
    'species': 'dog'
  }
)
#print(users['Erik']['pets'])

# 10. Add another person to the users dictionary
users['Josh'] = {
  'twitter': 'jomonty',
  'lottery_numbers': [1, 2, 3, 4, 5],
  'home_town': 'Ballyclare',
  'pets': [
    {
      'name': 'Sam',
      'species': 'Rabbit'
    }
  ]
  
}
#print(users['Josh'])