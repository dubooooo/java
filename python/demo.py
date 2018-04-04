# import redis

# r = redis.Redis("localhost", 6379, 0, "redis")
# # r.append("demo01", "demo01_value")
# # str = r.get("demo01")
# # print(str)
L = [
    ['Apple', 'Google', 'Microsoft'],
    ['Java', 'Python', 'Ruby', 'PHP'],
    ['Adam', 'Bart', 'Lisa']
]
print(L[0][0])
print(L[1][1])
print(L[2][2])

age = 16
if age >= 18:
    print("you age is", age)
    print("adlute")
else:
    print("you age is", age)
    print("some")
# birth = int(input("birthday:"))
birth = 10
if (birth > 18):
    print("you are 18 later", birth)
else:
    print("you are 18 before", birth)
names = ["zs", "ls", "ww", "zmz"]
for name in names:
    print(name)


