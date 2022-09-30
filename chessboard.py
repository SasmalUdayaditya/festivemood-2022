import random
import sys

alpha = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h']

while 1:
    ranchoice = random.choice(alpha)
    ranint = random.randint(1, 8)
    try:
        user = input("{}{}: ".format(ranchoice, ranint))
    except:
        print("Come back and practice again!")
        sys.exit(0)
    if abs(ord(ranchoice) - ranint) % 2 == 0 and (user[0] == "l" or user[0] == "L"):
        print("Wrong!")
    else:
        print("Correct!")
