from models.book import Book

book_1 = Book ('Dune', 'Herbert', 'Science Fiction', False)
book_2 = Book('Children of Dune', 'Herbert', 'Science Fiction', True)
book_3 = Book('Return of the King', 'Tolkien', 'Fantasy', False)
book_4 = Book('Thinking Fast and Slow', 'Cahnman', 'Economics', True)
book_5 = Book('War of the Worlds', 'HG Wells', 'Science Fiction', False)
book_6 = Book('1984', 'Orwell', 'Novel', True)
book_7 = Book('Rouge Heroes', 'McKintrye', 'Historical Ficiton', False)
book_8 = Book('War and Piece', 'Tolstoy', 'Literary Fiction', True)


library = [book_1, book_2, book_3, book_4, book_5, book_6, book_7, book_8]


def get_index_by_book_title(library, title):
    for index, book in enumerate(library):
        if book.title == title:
            return index
    return None

def get_single_book_by_index(library, index):
    if index > len(library) - 1:
        return None
    return library[index]

def get_single_book_by_title(library, title):
    index = get_index_by_book_title(library, title)
    book = get_single_book_by_index(library, index)
    return book

def add_book_to_library(library, book):
    if book not in library:
        library.append(book)
        
def delete_book_from_library(library, book):
    if book in library:
        library.remove(book)
        
