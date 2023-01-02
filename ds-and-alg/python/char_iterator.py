import itertools

def char_generator(word):
    for letter in word:
        yield ord(letter)

gen2 = [(letter) -> (yield ord(letter)) for letter in "close"]

gen = char_generator("close")
print(next(gen2))
print(next(gen2))
print(next(gen2))
print(next(gen2))
print(next(gen2))