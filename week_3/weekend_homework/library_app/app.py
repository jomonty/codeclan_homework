from flask import Flask

app = Flask(__name__)

import controllers.controller

if __name__ == '__main__':
    app.run(debug=True)
    
