from db.run_sql import run_sql
from models.author import Author

def save(author):
    sql = """
            INSERT INTO authors (name)
            VALUES (%s)
            RETURNING *
            """
    values = [author.name]
    result = run_sql(sql, values)[0]
    author.id = result['id']
    return author

def select(id):
    sql = """
            SELECT *
            FROM authors
            WHERE id = %s
            """
    values = [id]
    results = run_sql(sql, values)
    if results:
        result = results[0]
        author = Author(result['name'], result['id'])
        return author

def select_all():
    sql = """
            SELECT *
            FROM authors
            """
    authors = []
    results = run_sql(sql)
    if results:
        for result in results:
            author = Author(result['name'], result['id'])
            authors.append(author)
    return authors

def update(author):
    sql = """
            UPDATE authors
            SET (name) = (%s)
            WHERE id = %s
            """
    values = [author.name, author.id]
    run_sql(sql, values)
    
def delete(id):
    sql = """
            DELETE
            FROM authors
            WHERE id = %s
            """ 
    values = [id]
    run_sql(sql, values)

def delete_all():
    sql = """
            DELETE
            FROM authors
            """
    run_sql(sql)


def get_all_books(author):
    pass