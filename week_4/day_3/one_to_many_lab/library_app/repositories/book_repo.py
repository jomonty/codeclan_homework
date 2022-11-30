from db.run_sql import run_sql
from models.book import Book
from models.author import Author
import repositories.author_repo as author_repo

def save(book):
    sql = """
            INSERT INTO books (title, genre, author_id)
            VALUES
            (%s, %s, %s)
            RETURNING *
            """
    values = (book.title, book.genre, book.author.id)
    result = run_sql(sql, values)[0]
    book.id = result['id']
    return book

def select(id):
    sql = """ 
            SELECT *
            FROM books
            WHERE id = %s
            """
    values = [id]
    results = run_sql(sql, values)
    if results:
        result = results[0]
        author = author_repo.select(result['author_id'])
        book = Book(result['title'], result['genre'], author, result['id'])
        return book

def select_all():
    sql = """
            SELECT *
            FROM books
            """
    results = run_sql(sql)
    books = []
    if results:
        for result in results:
            author = author_repo.select(result['author_id'])
            book = Book(result['title'], result['genre'], author, result['id'])
            books.append(book)
    return books
    
def update(book):
    sql = """
            UPDATE books
            SET (title, genre, author_id) = (%s, %s, %s)
            WHERE id = %s
            """
    values = [book.title, book.genre, book.author.id, book.id]
    run_sql(sql, values)

def delete(id):
    sql = """
            DELETE
            FROM books
            WHERE id = %s
            """
    values = [id]
    run_sql(sql, values)

def delete_all():
    sql = """
            DELETE
            FROM books
            """
    run_sql(sql)
