class Person(object):

    def __init__(self, name, age):
        self.name = name
        self.age = age

    def print(self):
        print("name", self.name)
        print("age", self.age)

    def test01(self, p):
        print(p.name)
        print(p.age)


person01 = Person("zs", 18)
person02 = Person("ls", 88)
person03 = Person("ww", 20)
person01.print()
person02.print()
person03.print()
person03.test01(person01)
