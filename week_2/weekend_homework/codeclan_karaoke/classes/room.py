class Room:
    def __init__(self, name, playlist, guest_limit):
        self.name = name
        self.playlist = playlist
        self.guest_limit = guest_limit
        self.guests = []
    
    def is_room_full(self):
        return True if len(self.guests) >= self.guest_limit else False
    
    def is_guest_in_room(self, guest):
        return True if guest in self.guests else False
    
    def add_guest(self, guest):
        if not self.is_room_full() and not self.is_guest_in_room(guest):
            self.guests.append(guest)
            
    def remove_guest(self, guest):
        if self.is_guest_in_room(guest):
            self.guests.remove(guest)