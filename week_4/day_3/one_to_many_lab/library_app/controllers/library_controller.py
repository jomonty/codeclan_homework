from flask import render_template, Blueprint, redirect, request
from models.author import Author
from models.book import Book
import repositories.author_repo as author_repo
import repositories.book_repo as book_repo
from app import app

book_blueprint = Blueprint('books',__name__)

# INDEX
# GET books
@book_blueprint.route('/books')
def books():
    library = book_repo.select_all()
    return render_template('books/index.html', all_books = library)

# NEW (display form)
# GET '/books/new'
@book_blueprint.route('/books/new')
def new_book():
    authors = author_repo.select_all()
    return render_template('books/new.html', authors = authors)

# CREATE book (save)
# POST '/books/new-book'
@book_blueprint.route('/books/new-book', methods=['POST'])
def new_book_save():
    title = request.form['title']
    genre = request.form['genre']
    author = author_repo.select(request.form['author_id'])
    new_book = Book(title, genre, author)
    new_book = book_repo.save(new_book)
    return redirect('/books/new')

# CREATE author (save)
# POST '/books/new-author'
@book_blueprint.route('/books/new-author', methods=['POST'])
def new_author_save():
    name = request.form['name']
    new_author = Author(name)
    new_author = author_repo.save(new_author)
    return redirect('/books/new')

# SHOW
# GET '/books/<int:book_id>'
@book_blueprint.route('/books/<int:book_id>')
def show_book(book_id):
    book = book_repo.select(book_id)
    return render_template('books/show.html', book=book)

# EDIT (display form)
# GET '/books/<int:book_id>/edit'
@book_blueprint.route('/books/<int:book_id>/edit')
def edit_book(book_id):
    book = book_repo.select(book_id)
    authors = author_repo.select_all()
    return render_template('books/edit.html', book = book, authors = authors)

# UPDATE
# POST '/books/<int:book_id>/edit'
@book_blueprint.route('/books/<int:book_id>/edit', methods=['POST'])
def edit_book_save(book_id):
    title = request.form['title']
    genre = request.form['genre']
    author = author_repo.select(request.form['author_id'])
    id = book_id
    edited_book = Book(title, genre, author, id)
    book_repo.update(edited_book)
    return redirect(f'/books/{book_id}')

# DELETE
# POST '/books/<int:book_id>/delete'
@book_blueprint.route('/books/<int:book_id>/delete', methods=['POST'])
def delete_book(book_id):
    book_repo.delete(book_id)
    return redirect('/books')