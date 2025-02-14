from flask import Flask

# Create an instance of the Flask class
app = Flask(__name__)

# Define a route for the root URL
@app.route('/')
def hello_world():
    return 'Hello, World!'
@app.route('/objective') #objective page 
def objective():
    return 'We are going to remake the Cal Poly Pomona Map Website'

if __name__ == '__main__':
    # Run the app on localhost, port 5000
    app.run(debug=True)
