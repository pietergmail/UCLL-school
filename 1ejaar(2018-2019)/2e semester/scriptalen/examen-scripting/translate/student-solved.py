'''
    Vertaal de code in LinkedList.java naar Python.

    We vragen niet om een letterlijke vertaling:
    de Python code moet idiomatisch zijn en gebruik
    maken van properties, operator overloading, etc.


    === ENGLISH ===

    Translate the code in LinkedList.java into Python.

    We are not interested in a literal translation,
    but instead want idiomatic Python code.
    This means you will need to make use of properties,
    operator overloading, etc.

'''
class  LinkedList(object):
    def __init__(self, value= None, next = None):
        self.__value = value
        self.__next = next
    
    @property
    def value(self):
        return self.__value
    
    @value.setter
    def value(self, value):
        self.__value = value

    @property
    def next(self):
        return self.__next
    
    def __len__(self):
        if self.__next == None:
            return 1
        else:
            return 1 + len(self.__next)

    def __add__(self, lst):
        if self.next == None:
            return LinkedList(self.__value, lst)
        else:
            return LinkedList(self.__value, self.__next + lst)

    def __contains__(self, value):
        return self.__value == value or (self.__next != None and value in self.__next)
