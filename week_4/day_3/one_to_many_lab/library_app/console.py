from models.author import Author
from models.book import Book
import repositories.author_repo as author_repo
import repositories.book_repo as book_repo

book_repo.delete_all()
author_repo.delete_all()

author_1 = Author('Frank Herbert')
author_2 = Author('Andy Weir')
author_3 = Author('Tolkien')
author_1 = author_repo.save(author_1)
author_2 = author_repo.save(author_2)
author_3 = author_repo.save(author_3)

book_1 = Book('Dune','Fiction',author_1)
book_2 = Book('Children of Dune', 'Fiction', author_1)
book_3 = Book('The Martian', 'Science Fiction', author_2)
book_4 = Book('Project Hail Mary', 'Science Fiction', author_2)
book_5 = Book('Fellowship of the Ring', 'Fantasy', author_3)
book_6 = Book('The Return of the King', 'Fantasy', author_3)
book_1 = book_repo.save(book_1)
book_2 = book_repo.save(book_2)
book_3 = book_repo.save(book_3)
book_4 = book_repo.save(book_4)
book_5 = book_repo.save(book_5)
book_6 = book_repo.save(book_6)

