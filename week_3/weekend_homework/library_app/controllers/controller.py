from flask import Flask, render_template, request, redirect
from models.library import Book, library
from models.library import get_single_book_by_index, get_single_book_by_title
from models.library import add_book_to_library, delete_book_from_library
from app import app


@app.route('/')
def index():
    return render_template('index.html')

@app.route('/books')
def show_all_books():
    return render_template('books.html', library=library)

@app.route('/books/add', methods=['POST'])
def add_book():
    form_data = request.form
    title = form_data['book_title']
    author = form_data['book_author']
    genre = form_data['book_genre']
    status = form_data['book_status']
    status_bool = True if status == 'book_checked_out' else False
    new_book = Book(title, author, genre, status_bool)
    add_book_to_library(library, new_book)
    return redirect('/books')

@app.route('/books/remove', methods=['POST'])
def remove_book():
    form_data = request.form
    title = form_data['book_title']
    book_to_remove = get_single_book_by_title(library, title)
    delete_book_from_library(library, book_to_remove)
    return redirect('/books')

@app.route('/books/<int:book_index>', methods=['GET'])
def show_single_book(book_index):
    display_book = get_single_book_by_index(library, book_index)
    return render_template('/book.html', book=display_book)

@app.route('/books/<int:book_index>', methods=['POST'])
def update_book_status(book_index):
    form_data = request.form
    book = get_single_book_by_index(library, book_index)
    if 'check_in' in form_data:
        book.check_in()
    elif 'check_out' in form_data:
        book.check_out()
    return redirect(request.referrer)

