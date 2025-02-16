from flask import Flask

app = Flask(__name__)

@app.route('/Alex', methods=['GET'])
def Alex():
    return "Hello World, My name is Alex.", 200

if __name__ == '__main__':
    app.run(debug=True)