from flask import Flask, render_template

app = Flask(__name__)

from controllers.library_controller import book_blueprint

app.register_blueprint(book_blueprint)

@app.route('/')
def home():
    return render_template('index.html')

if __name__ == '__main__':
    app.run(debug=True)
