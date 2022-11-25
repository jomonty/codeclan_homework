from flask import Flask, render_template, request, redirect
from models.library import Book, library
from app import app

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/books')
def show_all_books():
    return render_template('books.html', library=library)