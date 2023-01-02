import turtle

t = turtle.Turtle()

def drawCircle(x, y, r):
    t.pu()
    t.goto(x, y -r)
    t.pd()
    t.circle(r)


drawCircle(50,30,50)