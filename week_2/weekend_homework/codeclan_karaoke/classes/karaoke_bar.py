from classes.guest import Guest
from classes.room import Room
from classes.song import Song

class KaraokeBar:
    def __init__(self, name, rooms, float):
        self.name = name
        self.rooms = rooms
        self.float = float
        self.room_charge = 5
        
    def check_total_float(self):
        return sum([value for value in self.float.values()])
    
    def check_room_float(self, room):
        return self.float[room]
    
    def find_room_by_name(self, name):
        for room in self.rooms:
            if room.name == name:
                return room
        return None
    
    def add_to_room_float(self, room, amount):
        self.float[room] += amount
    
    def add_guest_to_room(self, guest, room):
        if not room.is_room_full() and not room.is_guest_in_room(guest):
            if guest.can_afford(self.room_charge):
                room.add_guest(guest)
                guest.reduce_wallet(self.room_charge)
                self.add_to_room_float(room, self.room_charge)
                return guest.is_favourite_song(room.playlist)
    
    def remove_guest_from_room(self, guest, room):
        if room.is_guest_in_room(guest):
            room.remove_guest(guest)