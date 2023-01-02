
from abc import ABC, abstractmethod
from datetime import datetime

app_url = "https://s.it/"
url_mapping = {}

class Hash(ABC):
    @abstractmethod
    def generateHash(self, string):
        pass

    @staticmethod
    def toBase62(num):
        text_mapping = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
        encoded = ""
        base = 62
        while num: 
            r = num % base
            num //= base
            encoded = str(text_mapping[r]) + encoded
            print(encoded)
        return encoded

class AdditionHash(Hash):
    def generateHash(self, string):
        hash = 0
        for c in string: 
            hash += ord(c)
        return hash

class CRC32Hash(Hash):
    def generateHash(self, string):
        pass



class Algorithm(ABC):
    def __init__(self, url) -> None:
        self.url = url

    @abstractmethod
    def convert(self):
        pass


class Base62Conversion(Algorithm):
    def __init__(self, url) -> None:
        self.hash_algorithm = AdditionHash()
        super().__init__(url)
    
    def convert(self):
        key = Hash.toBase62(self.hash_algorithm.generateHash(self.url))
    
        while key in url_mapping:
            key = Hash.toBase62(self.hash_algorithm.generateHash(self.url +
             str(RandomStringGenerator.getRandomString())))
        
        url_mapping[key] = self.url
        return key

class CRC32HashingMethod(Algorithm):
    def __init__(self, url) -> None:
        super().__init__(url)

    def convert(self):
        pass

class RandomStringGenerator:
    @staticmethod
    def getRandomString(self):
        return str(datetime.now())


class AlgorithmStrategy:
    def __init__(self, algorithm) -> None:
        self.algorithm = algorithm
    
    def execute(self):
        return self.algorithm.convert()


class UrlShortener:
    def __init__(self) -> None:
        pass

    def visit(self, short_url):
        if short_url in url_mapping:
            return url_mapping[short_url]
        return 'Not Found!'
    
    def short(self, url, algorithm):
        if algorithm == "base62":
            return AlgorithmStrategy(Base62Conversion(url)).execute()
        elif algorithm == "crc32":
            return AlgorithmStrategy(CRC32HashingMethod(url)).execute()
        
        return 'No Such Algorithm'
    

shortener = UrlShortener()
short_url = shortener.short("www.google.com", "base62")
print(app_url, short_url, shortener.visit(short_url), url_mapping)