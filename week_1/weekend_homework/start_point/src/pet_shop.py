# WRITE YOUR FUNCTIONS HERE
def get_pet_shop_name(pet_shop: dict) -> str:
    return pet_shop['name']

def get_total_cash(pet_shop: dict) -> int:
    return pet_shop['admin']['total_cash']

def add_or_remove_cash(pet_shop: dict, cash: int) -> None:
    pet_shop['admin']['total_cash'] += cash
    return None

def get_pets_sold(pet_shop: dict) -> int:
    return pet_shop['admin']['pets_sold']

def increase_pets_sold(pet_shop: dict, pets_sold: int) -> None:
    pet_shop['admin']['pets_sold'] += pets_sold
    return None

def get_stock_count(pet_shop: dict) -> int:
    return len(pet_shop['pets'])

def get_pets_by_breed(pet_shop: dict, breed: str) -> list:
    return [pets for pets in pet_shop['pets'] if pets['breed'] == breed]
    # Longer form solution as follows:
    # pets = []
    # for pet in pet_shop['pets']:
    #     if pet['breed'] == breed:
    #         pets.append(pet)
    # return pets
    

def find_pet_by_name(pet_shop: dict, name: str) -> dict:
    for pet in pet_shop['pets']:
        if pet['name'] == name: return pet
    return None
    # List comprehension solution, uses a list index
    # return [pets for pets in pet_shop['pets'] if pets['name'] == name][0]

def remove_pet_by_name(pet_shop: dict, name: str) -> None:
    pet = find_pet_by_name(pet_shop, name)
    pet_shop['pets'].remove(pet)
    return None
    # Original attempt below, I think using existing function
    # and list.remove() is neater
    # for index, pet in enumerate(pet_shop['pets']):
    #     if pet['name'] == name:
    #         pet_shop['pets'].pop(index)

def add_pet_to_stock(pet_shop: dict, pet: dict) -> None:
    pet_shop['pets'].append(pet)
    return None

def get_customer_cash(customer: dict) -> int:
    return customer['cash']

def remove_customer_cash(customer: dict, cash: int) -> None:
    customer['cash'] -= cash
    return None

def get_customer_pet_count(customer: dict) -> int:
    return len(customer['pets'])

def add_pet_to_customer(customer: dict, new_pet: dict) -> None:
    customer['pets'].append(new_pet)
    return None

def customer_can_afford_pet(customer: dict, new_pet: dict) -> bool:
    # return True if customer['cash'] >= new_pet['price'] else False
    if customer['cash'] >= new_pet['price']:
        return True
    else: return False

def sell_pet_to_customer(pet_shop: dict, pet: dict, customer: dict) -> None:
    # Append new pet to customer['pets']
    # Increment pet_shop['admin']['pets_sold'] by 1
    # Decrease customer['cash'] by pet price
    # Increase pet_shop['admin']['cash'] by pet price
    
    # Check if pet is in stock
    if pet is None or find_pet_by_name(pet_shop, pet['name']) == None:
        return None
    # Check if customer can afford pet
    elif not customer_can_afford_pet(customer, pet):
        return None
    # Flow through required actions 
    else:
        add_pet_to_customer(customer, pet)
        increase_pets_sold(pet_shop, 1)
        pet_price = pet['price']
        remove_customer_cash(customer, pet_price)
        add_or_remove_cash(pet_shop, pet_price)
        return None