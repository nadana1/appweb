from flask import Flask, render_template

app = Flask(__name__)

@app.route("http://localhost:4200/welcome")
def hello_world():
    return '<p>hello fatouma</p>'
if __name__ == '__main__':
    app.run(debug=True)
app.run()