class Book:
    def __init__(self, title, author, genre, checked_out=False):
        self.title = title
        self.author = author
        self.genre = genre
        self.checked_out = checked_out
        
    def check_out(self):
        self.checked_out = True
        
    def check_in(self):
        self.checked_out = False
    