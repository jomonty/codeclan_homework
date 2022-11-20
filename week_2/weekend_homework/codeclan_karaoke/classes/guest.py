class Guest:
    def __init__(self, name, wallet, favourite_song):
        self.name = name
        self.wallet = wallet
        self.favourite_song = favourite_song
        
    def reduce_wallet(self, amount):
        self.wallet -= amount
        
    def can_afford(self, amount):
        return True if amount <= self.wallet else False
    
    def is_favourite_song(self, playlist):
        for song in playlist:
            if song.name == self.favourite_song:
                return 'Whoo!'
        return None
